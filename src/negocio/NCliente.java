/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio;

import accesodato.Cliente;
import accesodato.DataAccesObject;
import java.util.LinkedList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author vehimar
 */
public class NCliente {

    private DataAccesObject DAO;
    private Cliente cliente;

    /**
     * Inicializa la clase NCliente
     */
    public NCliente() {
        this.DAO = new DataAccesObject();
        this.cliente = new Cliente();
    }

    /**
     * agrea un nuevo cliente al catalago de cliente
     *
     * @param nombre
     */
    public void agregar(String nombre, String nit, String telefono) {
        if (!nombre.isEmpty()) {
            cliente.setId(null);
            cliente.setNombre(nombre);
            cliente.setNit(nit);
            cliente.setTelefono(telefono);
            DAO.insertarObject(cliente);
        } else {
            JOptionPane.showConfirmDialog(null, "EL NOMBRE DEL CLIENTE ESTA VACIO");
        }
    }

    /**
     * retorna un cliente,buscandolo por el nombre
     *
     * @param nombre
     * @return
     */
    public Object obtener(String nombre) {
        String sql = "from Cliente where nombre like '%" + nombre + "%'";
        return DAO.getObject(sql);
    }

    /**
     * retorna un cliente, buscando por el id
     *
     * @param id
     * @return
     */
    public Object obtener(Integer id) {
        String sql = "from Cliente where id = " + id;
        return DAO.getObject(sql);
    }

    /**
     * retorna un cliente, buscado por su nit
     *
     * @param nit
     * @return
     */
    public Object obtenerNit(String nit) {
        String sql = "from Cliente where nit like '%" + nit + "%'";
        return DAO.getObject(sql);
    }

    /**
     * retorna un cliente, buscado por su telefono
     *
     * @param telefono
     * @return
     */
    public Object obtenerTelefono(String telefono) {
        String sql = "from Cliente where telefono like '%" + telefono + "%'";
        return DAO.getObject(sql);
    }

    /**
     * retorna una LinkdedList de todos los clientes
     *
     * @return
     */
    public LinkedList<Cliente> listar() {
        LinkedList<Cliente> result = new LinkedList<>();
        List<Object> lista = DAO.listarObject("Cliente");
        for (int i = 0; i < lista.size(); i++) {
            Cliente auxLugar = (Cliente) lista.get(i);
            result.add(auxLugar);
        }
        return result;
    }

    /**
     * modifica, un cliente
     *
     * @param id
     * @param nombre
     */
    public void modificar(Integer id, String nombre, String nit, String telefono) {
        if (id > 0 && !nombre.isEmpty()) {
            cliente.setId(id);
            cliente.setNombre(nombre);
            cliente.setNit(nit);
            cliente.setTelefono(telefono);
            DAO.modificarObject(cliente);
        } else {
            JOptionPane.showConfirmDialog(null, "EL NOMBRE DEL CLIENTE ESTA VACIO");
        }
    }

    public int codigoSiguiente() {
        LinkedList<Cliente> lista = listar();
        if (!lista.isEmpty()) {
            return lista.get(lista.size() - 1).getId() + 1;
        }
        return 1;
    }

    public static void main(String[] args) {
        NCliente ncliente = new NCliente();
        LinkedList<Cliente> lista = ncliente.listar();
        System.out.println(lista.size());
    }
}
