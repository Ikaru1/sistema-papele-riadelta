/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package presentacion;

import accesodato.Producto;
import java.awt.Point;
import java.util.Iterator;
import java.util.List;
import negocio.NProducto;

/**
 *
 * @author Sinai
 */
public class JdProducto extends javax.swing.JDialog {

    /**
     * Creates new form JDProducto
     */
    public JdProducto(java.awt.Dialog parent, boolean modal) {
        super(parent, modal);
        initComponents();
        this.setLocationRelativeTo(parent);
        nProducto = new NProducto();
    }

    JdProducto(JfPrincipal padre, boolean b) {
        super(padre, b);
        initComponents();
        this.setLocationRelativeTo(padre);
        nProducto = new NProducto();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        btnNuevo = new javax.swing.JButton();
        btnCatalogo = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tablaProducto = new javax.swing.JTable();
        btnModificar = new javax.swing.JButton();

        jButton1.setText("jButton1");

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                formComponentShown(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(204, 204, 204));
        jPanel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jPanel1MouseEntered(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setText("Registrar  Producto");

        btnNuevo.setText("Nuevo");
        btnNuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevoActionPerformed(evt);
            }
        });

        btnCatalogo.setText("Catalogo del Producto");
        btnCatalogo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCatalogoActionPerformed(evt);
            }
        });

        tablaProducto.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Cod", "Stock", "Nombre", "Precio Referencia", "Marca"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tablaProducto.setEnabled(false);
        tablaProducto.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablaProductoMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                tablaProductoMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                tablaProductoMouseReleased(evt);
            }
        });
        jScrollPane2.setViewportView(tablaProducto);
        tablaProducto.getColumnModel().getColumn(0).setMinWidth(20);
        tablaProducto.getColumnModel().getColumn(0).setMaxWidth(50);
        tablaProducto.getColumnModel().getColumn(1).setMinWidth(20);
        tablaProducto.getColumnModel().getColumn(1).setMaxWidth(60);
        tablaProducto.getColumnModel().getColumn(3).setMinWidth(100);
        tablaProducto.getColumnModel().getColumn(3).setMaxWidth(100);

        btnModificar.setText("Modificar");
        btnModificar.setEnabled(false);
        btnModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarActionPerformed(evt);
            }
        });

        org.jdesktop.layout.GroupLayout jPanel1Layout = new org.jdesktop.layout.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(jPanel1Layout.createSequentialGroup()
                        .add(jScrollPane2)
                        .addContainerGap())
                    .add(jPanel1Layout.createSequentialGroup()
                        .add(btnNuevo, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 92, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .add(37, 37, 37)
                        .add(btnModificar, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 146, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED, 42, Short.MAX_VALUE)
                        .add(btnCatalogo)
                        .add(59, 59, 59))))
            .add(jPanel1Layout.createSequentialGroup()
                .add(208, 208, 208)
                .add(jLabel1)
                .addContainerGap())
        );

        jPanel1Layout.linkSize(new java.awt.Component[] {btnCatalogo, btnNuevo}, org.jdesktop.layout.GroupLayout.HORIZONTAL);

        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel1Layout.createSequentialGroup()
                .add(21, 21, 21)
                .add(jLabel1)
                .add(18, 18, 18)
                .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING, false)
                    .add(btnCatalogo, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 33, Short.MAX_VALUE)
                    .add(btnNuevo, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .add(btnModificar, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                .add(jScrollPane2, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 312, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel1Layout.linkSize(new java.awt.Component[] {btnCatalogo, btnNuevo}, org.jdesktop.layout.GroupLayout.VERTICAL);

        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .addContainerGap()
                .add(jPanel1, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .addContainerGap()
                .add(jPanel1, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoActionPerformed
        jDProductoNuevo = new JdProductoNuevo(this, true);
        jDProductoNuevo.setVisible(true);
        llenarTablaProductos();
    }//GEN-LAST:event_btnNuevoActionPerformed
    
    private void formComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_formComponentShown
        llenarTablaProductos();
    }//GEN-LAST:event_formComponentShown
    
    private void btnCatalogoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCatalogoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnCatalogoActionPerformed
    
    private void btnModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarActionPerformed
        String[] datos = new String[5];
        
        datos[0] = tablaProducto.getValueAt(row, 0).toString();
        datos[1] = tablaProducto.getValueAt(row, 1).toString();
        datos[2] = tablaProducto.getValueAt(row, 2).toString();
        datos[3] = tablaProducto.getValueAt(row, 3).toString();
        datos[4] = tablaProducto.getValueAt(row, 4).toString();
        
        jDProductoNuevo = new JdProductoNuevo(this, true, datos);
        jDProductoNuevo.setVisible(true);
        btnModificar.setEnabled(false);
        llenarTablaProductos();
    }//GEN-LAST:event_btnModificarActionPerformed
    
    private void tablaProductoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaProductoMouseClicked
        
    }//GEN-LAST:event_tablaProductoMouseClicked
    
    private void tablaProductoMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaProductoMouseReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_tablaProductoMouseReleased
    
    private void tablaProductoMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaProductoMousePressed
        Point punto = evt.getPoint();
        row = tablaProducto.rowAtPoint(punto);
        System.out.println("row " + row);
        btnModificar.setEnabled(true);
        
    }//GEN-LAST:event_tablaProductoMousePressed
    
    private void jPanel1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel1MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_jPanel1MouseEntered

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
            java.util.logging.Logger.getLogger(JdProducto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                JdProducto dialog = new JdProducto(new javax.swing.JDialog(), true);
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
    private javax.swing.JButton btnCatalogo;
    private javax.swing.JButton btnModificar;
    private javax.swing.JButton btnNuevo;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable tablaProducto;
    // End of variables declaration//GEN-END:variables
    private NProducto nProducto;
    private JdProductoNuevo jDProductoNuevo;
    private int row = -1;
    
    private void llenarTablaProductos() {
        Producto producto;
        try {
            String[] columnas = {"cod", "Stock", "Nombre", "Precio Referencia", "Marca"};
            List lista;
            int fila = -1;
            
            lista = nProducto.listar();
            
            Iterator it = lista.iterator();
            Object[][] data = new Object[lista.size()][5];
            
            while (it.hasNext()) {
                producto = (Producto) it.next();
                fila++;
                
                data[fila][0] = producto.getId();
                data[fila][1] = producto.getStock();
                data[fila][2] = producto.getNombre();
                data[fila][3] = producto.getPrecioreferencia();
                data[fila][4] = producto.getObservacion();
            }
            tablaProducto.setModel(new javax.swing.table.DefaultTableModel(data, columnas));
        } catch (Exception ex) {
            
        }
    }
}
