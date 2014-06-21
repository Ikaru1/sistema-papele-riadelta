package accesodato;
// Generated 21-jun-2014 16:32:35 by Hibernate Tools 3.2.1.GA


import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Venta generated by hbm2java
 */
public class Venta  implements java.io.Serializable {


     private Integer id;
     private Cliente cliente;
     private Date fecha;
     private Set<Detalleventa> detalleventas = new HashSet<Detalleventa>(0);

    public Venta() {
    }

	
    public Venta(Date fecha) {
        this.fecha = fecha;
    }
    public Venta(Cliente cliente, Date fecha, Set<Detalleventa> detalleventas) {
       this.cliente = cliente;
       this.fecha = fecha;
       this.detalleventas = detalleventas;
    }
   
    public Integer getId() {
        return this.id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }
    public Cliente getCliente() {
        return this.cliente;
    }
    
    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
    public Date getFecha() {
        return this.fecha;
    }
    
    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }
    public Set<Detalleventa> getDetalleventas() {
        return this.detalleventas;
    }
    
    public void setDetalleventas(Set<Detalleventa> detalleventas) {
        this.detalleventas = detalleventas;
    }




}


