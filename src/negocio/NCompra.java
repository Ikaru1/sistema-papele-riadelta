/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio;

import accesodato.Compra;
import accesodato.DataAccesObject;
import accesodato.Detallecompra;
import accesodato.HibernateUtil;
import accesodato.Producto;
import java.io.Serializable;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Vector;
import javax.swing.JOptionPane;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Transaction;
import org.hibernate.classic.Session;

/**
 *
 * @author Personal
 */
public class NCompra {

    private HibernateUtil hibernate; 
    private NProducto nProducto;
    private DataAccesObject dao;
    public NCompra() {
        inicializar();
    }
    
    
    private void inicializar(){
    
        hibernate = new HibernateUtil();
        nProducto = new NProducto();
        dao = new DataAccesObject();
    }
    public Compra buscarCompraPorCodigo(int codigo){
        String sql = "from Compra where id = "+codigo;
        Object value = dao.getObject(sql);
        Compra compra = null;
        if ( value != null)
            compra = (Compra)value;
        return compra;
    }
    /**
     * @param nombreProveedor
     * @param fecha
     */
    public boolean nuevaCompra(String nombre, Date date, ArrayList<Object[]> items) {  
        Vector<Detallecompra> lista = new Vector<>();
        Compra compra = new Compra(date);
        compra.setNombreProveedor(nombre);
        for (int indiceItems =0; indiceItems < items.size(); indiceItems++){
             Object data [] = items.get(indiceItems);;
             int codigoProducto =(Integer)data[0];
             int cantidad =(Integer)data[1];
             float precio =(Float)data[2];
             Detallecompra detallecompra = new Detallecompra();
             Producto p = new Producto();
             p.setId(codigoProducto);
             detallecompra.setPreciounidad(precio);
             detallecompra.setCantidad(cantidad);
             detallecompra.setProducto(p);
             lista.add(detallecompra);
        }
        Transaction transaction = null;
        try {
            Session session = (Session) hibernate.currentSession();
            transaction = session.beginTransaction();
            transaction.begin();
            Serializable value = session.save(compra);
            if ( value instanceof  Integer){
                int codigoCompra = (Integer)value;
                compra.setId(codigoCompra);
                System.out.println("codigo compra "+codigoCompra);
                System.out.println("lista tam"+lista.size());
                for (int i = 0; i < lista.size(); i++) {
                   Detallecompra tupla =  lista.get(i);
                   tupla.setCompra(compra);
                   session.save(tupla);
                }
            }
            transaction.commit();        
            hibernate.closeSession();
            for (int i = 0; i < lista.size(); i++){
              Detallecompra tupla =  lista.get(i);
              int  codigoProducto = tupla.getProducto().getId();
              int  cantidad = tupla.getCantidad();;
              nProducto.incrementarStock(codigoProducto,cantidad);
            }
            return true;
        } catch (HibernateException e) {
            e.printStackTrace();
            transaction.rollback();
        }
    
        return false;
    }
    public List<Object> buscarCompraPorFecha(String fecha) {
        
        String sql = "from Compra where fecha = "+"\""+fecha+"\"";
        List<Object> resultados = dao.listaObject(sql);
        return resultados;
    }

    public List<Object> buscarCompraPorProducto(int codigoProducto) {
        Transaction transaction = null;
        String sql ="select c.* from compra c , producto p , detallecompra d "+ 
        " where d.idcompra = c.id and d.idproducto = p.id and p.id = "+codigoProducto;
         List<Object> resultado = null;
        try {
            Session session = (Session) hibernate.currentSession();
  
            Query query = session.createSQLQuery(sql).
                    addEntity(Compra.class);
            resultado = query.list();  
        }
        catch (HibernateException e) {
            e.printStackTrace();
            transaction.rollback();
        }
        return resultado;
    }
  
    public JasperViewer obtenerReporteNotaCompra(int codigo) {
        
        Compra compra = buscarCompraPorCodigo(codigo);
        if ( compra == null)
        {
        
           JOptionPane.showMessageDialog(null,"No se encontro el objeto "
                   + " con codigo "+codigo);
            return null;
        }
        
        URL url= getRecurso("reporte/report3.jasper");
        JasperViewer  view= null;
        String nombreServidor = "localhost";
        int port = 3306;
        String database="papeleriadelta";
        String usuario = "root";
        String password="izzq74ji";
        if ( url != null)
        {           
           try {
                String strConection = createUrlconnection
                    (nombreServidor, port, database, usuario, password);   
                Connection connection = createConeccion(strConection);
                JasperReport report = (JasperReport) JRLoader.loadObject(url) ; 
                HashMap<String,Object> parameters = new HashMap<>();
                String proveedor = compra.getNombreProveedor();
                Date fecha = compra.getFecha();
                parameters.put("codigocompra",codigo);
                parameters.put("proveedor",proveedor);
                parameters.put("fechacompra",fecha);
                JasperPrint printer = JasperFillManager.fillReport(report,parameters,connection);
                view = new JasperViewer(printer);
            } catch (JRException ex) {
                ex.printStackTrace();
            }
            catch (SQLException ex)
            {
      
                ex.printStackTrace();
            } catch (ClassNotFoundException ex) {
                ex.printStackTrace();
            }
        }    
        return view;
        
    }  
    private static String createUrlconnection(String nombreServidor , int port ,String database , String user , String password)
    {
         return "jdbc:mysql://"+nombreServidor+":"+port+"/"+database+"?user="+user+"&password="+password;
    }
     private static  Connection createConeccion(String strConeccion)throws SQLException , ClassNotFoundException
    { 
         Class.forName("com.mysql.jdbc.Driver");
         Connection com = DriverManager.getConnection(strConeccion);	
         return com;	 
    }
    private URL getRecurso(String path) {
       java.net.URL url = NCompra.class.getClassLoader().getResource(path);
       if ( url != null)
           return url;
       else{
           System.err.println("Couldn't find file: " + path);
       }
       return url;
    }
}
