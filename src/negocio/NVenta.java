/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio;

import accesodato.Cliente;
import accesodato.DataAccesObject;
import accesodato.Venta;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author Fredy
 */
public class NVenta {

    private DataAccesObject DAO;
    private Venta venta;

    public NVenta() {
        super();
        DAO = new DataAccesObject();
        venta = new Venta();        
    }

    public void agregar(Date fecha, Cliente cliente) {
        venta.setFecha(fecha);
        venta.setCliente(cliente);
        DAO.insertarObject(venta);
    }

    public Venta obtenerUltimo() {
        List<Object> lista = DAO.listarObject("Venta");
        Venta vent = (Venta) lista.get(lista.size() - 1);
        return vent;
    }

    public int ultimoCodigo() {
        List<Object> lista = DAO.listarObject("Venta");
        if (!lista.isEmpty()) {
            Venta vent = (Venta) lista.get(lista.size() - 1);
            return vent.getId()+1;
        }
        return 1;

    }

    public Venta obtener(Integer id) {
        String sql = "from Venta where id = " + id;
        return (Venta) DAO.getObject(sql);
    }
    
    public LinkedList<Venta> listar() {
        LinkedList<Venta> result = new LinkedList<>();
        List<Object> lista = DAO.listarObject("Venta");
        for (int i = 0; i < lista.size(); i++) {
            Venta auxLugar = (Venta) lista.get(i);
            result.add(auxLugar);
        }
        return result;
    }
    

    public static void main(String[] args) {
//        HashSet<Detalleventa> Hatsdetalleventa = new HashSet<Detalleventa>();
//        Detalleventa dv = new Detalleventa();
//        NProducto np = new NProducto();
//        NCliente nc = new NCliente();
//        NVenta nv = new NVenta();
//        dv.setCantidad(10);
//        dv.setPreciounidad(15);
//        dv.setProducto(np.obtener(2));
//        dv.setVenta(nv.obtener(2));
//        Hatsdetalleventa.add(dv);
//        java.util.Date utilDate = new java.util.Date();
//        java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
//        //  nv.agregar(sqlDate, nc.obtener(2), atsdetalleventa);        
    }
}
