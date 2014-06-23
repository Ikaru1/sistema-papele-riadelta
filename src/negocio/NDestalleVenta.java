/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio;

import accesodato.DataAccesObject;
import accesodato.Detalleventa;
import accesodato.Producto;
import accesodato.Venta;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author Fredy
 */
public class NDestalleVenta {

    private DataAccesObject DAO;
    private Detalleventa detalleventa;

    public NDestalleVenta() {
        this.DAO = new DataAccesObject();
        this.detalleventa = new Detalleventa();
    }

    public void Agregar(float preciounidad, int cantidad, Producto producto, Venta venta) {
        detalleventa.setId(null);
        detalleventa.setPreciounidad(preciounidad);
        detalleventa.setCantidad(cantidad);
        detalleventa.setProducto(producto);
        detalleventa.setVenta(venta);
        DAO.insertarObject(detalleventa);
    }

    public List<Detalleventa> listarDetallePVenta(Integer idv) {

        return DataAccesObject.getObjects("from Detalleventa where idventa = " + idv);

    }
}
