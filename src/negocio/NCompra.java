/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio;

import accesodato.Compra;
import accesodato.Detallecompra;
import accesodato.HibernateUtil;
import accesodato.Producto;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import java.util.Vector;
import org.hibernate.HibernateException;
import org.hibernate.Transaction;
import org.hibernate.classic.Session;

/**
 *
 * @author Personal
 */
public class NCompra {

    private HibernateUtil hibernate; 
    private NProducto nProducto;
    public NCompra() {
        inicializar();
    }
    
    
    private void inicializar(){
    
        hibernate = new HibernateUtil();
        nProducto = new NProducto();
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
}
