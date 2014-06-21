/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package presentacion;

import accesodato.Cliente;
import accesodato.Detalleventa;
import accesodato.Producto;
import accesodato.Venta;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import negocio.NCliente;
import negocio.NDestalleVenta;
import negocio.NProducto;
import negocio.NVenta;

/**
 *
 * @author Fredy
 */
public class JdVenta extends javax.swing.JDialog {

    /**
     * Creates new form JDVenta
     */
    private NProducto nproducto;
    private NVenta nventa;
    private NDestalleVenta ndetalleventa;
    private NCliente ncliente;
    private List<Detalleventa> listDetalleventa;

    public JdVenta(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        ncliente = new NCliente();
        nproducto = new NProducto();
        nventa = new NVenta();
        ndetalleventa = new NDestalleVenta();
        listDetalleventa = new ArrayList<>();
        this.setLocationRelativeTo(null);
        cargarComboCliente();
        cargarComboProducto();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jTextCodigo = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jComboBoxCliente = new javax.swing.JComboBox();
        jButtonNuevoCliente = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jComboBoxProducto = new javax.swing.JComboBox();
        jLabel5 = new javax.swing.JLabel();
        jTextFieldCantidad = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jTextFieldPrecioDeReferencia = new javax.swing.JTextField();
        jButtonAgregar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableDetalleVenta = new javax.swing.JTable();
        jButtonGuardar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setText("Venta de Producto");

        jLabel2.setText("Codigo");

        jLabel3.setText("Cliente");

        jButtonNuevoCliente.setText("Nuevo Cliente");

        jLabel4.setText("Producto");

        jLabel5.setText("Cantidad");

        jLabel6.setText("Precio de Referencia");

        jButtonAgregar.setText("Agregar");
        jButtonAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAgregarActionPerformed(evt);
            }
        });

        jTableDetalleVenta.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "CODIGO PRODUCTO", "NOMBRE", "CANTIDAD", "PRECIO UNITARIO", "TOTAL"
            }
        ));
        jTableDetalleVenta.setToolTipText("");
        jScrollPane1.setViewportView(jTableDetalleVenta);

        jButtonGuardar.setText("Guardar");
        jButtonGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonGuardarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(23, 23, 23)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(jLabel2)
                                                .addGap(77, 77, 77)
                                                .addComponent(jTextCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                                .addGroup(layout.createSequentialGroup()
                                                    .addComponent(jLabel6)
                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                    .addComponent(jTextFieldPrecioDeReferencia))
                                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                                    .addComponent(jLabel5)
                                                    .addGap(67, 67, 67)
                                                    .addComponent(jTextFieldCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                            .addComponent(jButtonAgregar, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(156, 156, 156))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(jLabel4)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(jComboBoxProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 295, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                                .addComponent(jLabel3)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(jComboBoxCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 295, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
                                .addComponent(jButtonNuevoCliente))))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 708, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addComponent(jButtonGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(31, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(22, 22, 22)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jTextCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jComboBoxCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButtonNuevoCliente)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jComboBoxProducto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jTextFieldCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6)
                    .addComponent(jTextFieldPrecioDeReferencia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 8, Short.MAX_VALUE)
                .addComponent(jButtonAgregar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 11, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButtonGuardar)
                .addGap(4, 4, 4))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAgregarActionPerformed
        Producto p = (Producto) jComboBoxProducto.getSelectedItem();

        Detalleventa detalleventa = new Detalleventa();
        detalleventa.setCantidad(Integer.valueOf(jTextFieldCantidad.getText()));
        detalleventa.setPreciounidad(Integer.valueOf(jTextFieldPrecioDeReferencia.getText()));
        detalleventa.setProducto(p);
        listDetalleventa.add(detalleventa);

        listarDetalleVenta(jTableDetalleVenta);
    }//GEN-LAST:event_jButtonAgregarActionPerformed

    private void jButtonGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonGuardarActionPerformed

        Date fecha = Calendar.getInstance().getTime();

        Cliente cliente = (Cliente) jComboBoxCliente.getSelectedItem();

        nventa.agregar(fecha, cliente);

        Venta venta = nventa.obtenerUltimo();
        System.out.println(listDetalleventa.size());

        for (int i = 0; i < listDetalleventa.size(); i++) {
            Detalleventa detalle = listDetalleventa.get(i);

            ndetalleventa.Agregar(detalle.getPreciounidad(),
                    detalle.getCantidad(),
                    detalle.getProducto(),
                    venta);
        }
    }//GEN-LAST:event_jButtonGuardarActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JdVenta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                JdVenta dialog = new JdVenta(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonAgregar;
    private javax.swing.JButton jButtonGuardar;
    private javax.swing.JButton jButtonNuevoCliente;
    private javax.swing.JComboBox jComboBoxCliente;
    private javax.swing.JComboBox jComboBoxProducto;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableDetalleVenta;
    private javax.swing.JTextField jTextCodigo;
    private javax.swing.JTextField jTextFieldCantidad;
    private javax.swing.JTextField jTextFieldPrecioDeReferencia;
    // End of variables declaration//GEN-END:variables

    private void cargarComboCliente() {
        List<Cliente> Listcliente = new ArrayList<>();
        Listcliente = ncliente.listar();
        for (int i = 0; i < Listcliente.size(); i++) {
            jComboBoxCliente.addItem(Listcliente.get(i));
        }

    }

    private void cargarComboProducto() {
        List<Producto> Listproducto = new ArrayList<>();
        Listproducto = nproducto.listar();
        for (int i = 0; i < Listproducto.size(); i++) {
            jComboBoxProducto.addItem(Listproducto.get(i));
        }

    }

    private void limpiarTabla(JTable tabla) {
        DefaultTableModel model = (DefaultTableModel) tabla.getModel();
        for (int i = model.getRowCount(); i != 0; i--) {
            model.removeRow(i - 1);
        }
        tabla.setModel(model);
    }

    private void listarDetalleVenta(JTable tabla) {
        limpiarTabla(tabla);
        DefaultTableModel modelo = (DefaultTableModel) tabla.getModel();
        if (listDetalleventa != null) {
            for (int i = 0; i < listDetalleventa.size(); i++) {
                Detalleventa detalleVenta = (Detalleventa) listDetalleventa.get(i);
                Object[] datos = {
                    detalleVenta.getProducto().getId(),
                    detalleVenta.getProducto().getNombre(),
                    detalleVenta.getCantidad(),
                    detalleVenta.getPreciounidad(),};
                modelo.addRow(datos);
            }
        }
        tabla.setModel(modelo);
    }
}
