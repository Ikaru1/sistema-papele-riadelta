/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio;

import accesodato.DataAccesObject;
import accesodato.Producto;
import java.util.LinkedList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author Sinai
 */
public class NProducto {

    private DataAccesObject DAO;
    private Producto producto;

    public NProducto() {
        this.DAO = new DataAccesObject();
        this.producto = new Producto();
        System.out.println("prudoct nuevo");
    }

    /**
     * agrega un producto al catalogo de productos
     *
     * @param nombre
     * @param stock
     * @param observacion
     * @param precioReferencia
     */
    public void agregar(String nombre, int stock, String observacion, Float precioReferencia) {
        if (!nombre.isEmpty()) {
            producto = new Producto();
            producto.setId(null);
            producto.setNombre(nombre.toUpperCase());
            producto.setObservacion(observacion.toUpperCase());
            producto.setPrecioreferencia(precioReferencia);
            producto.setStock(stock);
            DAO.insertarObject(producto);
        } else {
            JOptionPane.showConfirmDialog(null, "EL NOMBRE DEL PRODUCTO ESTA VACIO");
        }
    }

    /**
     * retorna un producto que contenga el parametro de entrada nombre
     *
     * @param nombre
     * @return object
     */
    public Object obtener(String nombre) {
        String sql = "from Producto where nombre like '%" + nombre + "%'";
        return DAO.getObject(sql);
    }

    /**
     * retorna un producto que contenga el parametro de entrada nombre
     *
     * @param nombre
     * @return object
     */
    public Object obtenerProducotPorNombre(String nombre) {
        String sql = "from Producto where nombre = '" + nombre + "'";

        LinkedList<Producto> result = new LinkedList<>();
        List<Object> lista = DAO.listaObject(sql);
        for (int i = 0; i < lista.size(); i++) {
            Producto auxLugar = (Producto) lista.get(i);
            result.add(auxLugar);
        }

        return result;
    }

    /**
     * retorna un el producto que tenga como id el parametro de entrada id
     *
     * @param id
     * @return object
     */
    public Object obtener(Integer id) {
        String sql = "from Producto where id = " + id;
        return DAO.getObject(sql);
    }

    /**
     * retorna una lista de todos los productos
     *
     * @return LinkedList<Producto>
     */
    public LinkedList<Producto> listar() {
        LinkedList<Producto> result = new LinkedList<>();
        List<Object> lista = DAO.listarObject("Producto");
        for (int i = 0; i < lista.size(); i++) {
            Producto auxLugar = (Producto) lista.get(i);
            result.add(auxLugar);
        }
        return result;
    }

    /**
     * modifica la informacion de un producto
     *
     * @param id
     * @param nombre
     * @param stock
     * @param observacion
     * @param precioReferencia
     */
    public void modificar(Integer id, String nombre, int stock,
            String observacion, float precioReferencia) {
        if (id > 0 && !nombre.isEmpty()) {
            producto.setId(id);
            producto.setNombre(nombre.toUpperCase());
            producto.setStock(stock);
            producto.setObservacion(observacion.toUpperCase());
            producto.setPrecioreferencia(precioReferencia);
            DAO.modificarObject(producto);
        } else {
            JOptionPane.showConfirmDialog(null, "EL NOMBRE DEL PRODUCTO ESTA VACIO");
        }
    }

    public int stockDisponible(int cod) {
        producto = (Producto) obtener(cod);
        return producto.getStock();
    }

    public void incrementarStock(int cod, int cantidad) {
        producto = (Producto) obtener(cod);
        int stockActual = producto.getStock();

        if (cantidad > 0) {
            producto.setStock(stockActual + cantidad);
            DAO.modificarObject(producto);
        } else {
            JOptionPane.showMessageDialog(null, "La cantidad no puede ser negativo");
        }

    }

    public void decrementarStock(int cod, int cantidad) {
        producto = (Producto) obtener(cod);
        int stockActual = producto.getStock();

        int valorActual = stockActual - cantidad;

        if (valorActual >= 0) {
            producto.setStock(valorActual);
            DAO.modificarObject(producto);
        } else {
            JOptionPane.showMessageDialog(null, "el stock no puede ser negativo");
        }

    }

    /**
     *
     * @return
     */
    public int codigoSiguiente() {
        LinkedList<Producto> lista = listar();
        if (!lista.isEmpty()) {
            return lista.get(lista.size() - 1).getId() + 1;
        }
        return 1;
    }

    public boolean esProductoNuevo(String nombre, String marca) {
        boolean resultado = true;

        List<Producto> lista = (List<Producto>) obtenerProducotPorNombre(nombre);

        for (int index = 0; index < lista.size(); index++) {
            Producto producto1 = lista.get(index);
            if (producto1 != null) {
                String marcaActual = producto1.getObservacion();
                resultado = !marcaActual.equalsIgnoreCase(marca);
            }

            if (!resultado) {
                JOptionPane.showMessageDialog(null, "el producto ya se encuentra registrado");
                return false;
            }
        }

        return resultado;
    }

    public static void main(String[] args) {
        NProducto nProducto = new NProducto();
        //LinkedList<Producto> lista = nProducto.listar();
        //System.out.println(lista.size());
        //nProducto.agregar("producto 2", 20, "ninguna", 20.98f);
        nProducto.decrementarStock(1, 100);
    }
}
