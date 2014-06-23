/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package presentacion;

import accesodato.Compra;
import accesodato.Producto;
import java.awt.event.ActionEvent;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JPopupMenu;
import javax.swing.SwingWorker;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import negocio.NCompra;
import negocio.NProducto;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author Personal
 */
public class JdCompra extends javax.swing.JDialog {

    private JdNuevaCompra frmNuevaCompra;
    private static final String BUSCAR_POR_CODIGO="BUSCAR POR CODIGO";
    private static final String BUSCAR_POR_FECHA="BUSCAR POR FECHA";
    private static final String BUSCAR_POR_PRODUCTO="BUSCAR POR PRODUCTO";
    private String opciones[] ={BUSCAR_POR_CODIGO,
        BUSCAR_POR_FECHA ,BUSCAR_POR_PRODUCTO};
    
    private NCompra nCompra;
    private DefaultTableModel tableModelCompra;
    private NProducto nProducto;
    private JPopupMenu jPopupMenu;
    /**
     * Creates new form FrmCompra
     */
    public JdCompra(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        this.setLocationRelativeTo(parent);
        initicializar();
    }
    private void initicializar(){
       frmNuevaCompra = new JdNuevaCompra(this,true);
       nCompra = new NCompra();
       nProducto = new NProducto();
       tableModelCompra = (DefaultTableModel)tblNotaCompra.getModel();
       tblNotaCompra.setDefaultRenderer(Date.class,new DateCellRenderer());
        jPopupMenu = new JPopupMenu();
        Action action = new AbstractAction("Ver reporte") {

            @Override
            public void actionPerformed(ActionEvent e) {
              // &// throw new UnsupportedOperationException("Not supported yet.");
               
                mostrarReporteCompleto();
            }

            
        };
        jPopupMenu.add( action);
        tblNotaCompra.setComponentPopupMenu(jPopupMenu);
    }
    private void mostrarReporteCompleto() {
               
        if ( tblNotaCompra.getSelectedRow() != -1)
        {
             int fila = tblNotaCompra.getSelectedRow();
             Integer codigoCompra = (Integer)tableModelCompra.getValueAt(fila,0);
             if ( codigoCompra != null)
             {
               HiloReporte hiloReporte = new HiloReporte(this);
               hiloReporte.codigoCompra = codigoCompra;
               hiloReporte.execute();
             }    
        }   
    }
    private Object selectionarTipoBusqueda(){
    
       Object selecion = JOptionPane.showInputDialog(this,"Selecione un criterio de busqueda","Buscar nota de compra",
               JOptionPane.INFORMATION_MESSAGE,null,opciones,null);
           
       return  selecion;
    }
     private void agregarItemTablaNotaCompra(int codigoCompra,Date date, String nombreProveedor){
        if ( nombreProveedor == null || "".equals(nombreProveedor))
             nombreProveedor="NO ESPECIFICICADO";   
        SimpleDateFormat format = new SimpleDateFormat("yyyy/MM/dd");
        String strDate = format.format(date);
        Object data[] = {codigoCompra,strDate,nombreProveedor,};
        tableModelCompra.addRow(data);
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        btnNuevo = new javax.swing.JButton();
        btnBuscar = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblNotaCompra = new javax.swing.JTable();

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 422, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 274, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel1.setLayout(new javax.swing.BoxLayout(jPanel1, javax.swing.BoxLayout.Y_AXIS));

        jLabel1.setText("Compra");
        jPanel1.add(jLabel1);

        jPanel4.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT));

        btnNuevo.setText("Nuevo");
        btnNuevo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btnNuevoMousePressed(evt);
            }
        });
        jPanel4.add(btnNuevo);

        btnBuscar.setText("Buscar");
        btnBuscar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btnBuscarMousePressed(evt);
            }
        });
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });
        jPanel4.add(btnBuscar);

        jPanel1.add(jPanel4);

        getContentPane().add(jPanel1, java.awt.BorderLayout.PAGE_START);
        jPanel1.setLayout(new javax.swing.BoxLayout(jPanel1, javax.swing.BoxLayout.Y_AXIS));

        tblNotaCompra.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Codigo", "Fecha", "Nombre Proveedor"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.Object.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tblNotaCompra);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 424, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 251, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 30, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel3, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnNuevoMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnNuevoMousePressed
        // TODO add your handling code here:
        frmNuevaCompra.setVisible(true);
    }//GEN-LAST:event_btnNuevoMousePressed

    private void btnBuscarMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnBuscarMousePressed
        // TODO add your handling code here:
         Object tipoBusqueda = selectionarTipoBusqueda();
         if ( tipoBusqueda == null)
             return ;
         if (BUSCAR_POR_CODIGO.equals(tipoBusqueda)){
             buscarNotaCompraPorCodigo();
         }
         if (BUSCAR_POR_FECHA.equals(tipoBusqueda)){
            buscarNotaCompraPorFecha(); 
         }
         if (BUSCAR_POR_PRODUCTO.equals(tipoBusqueda)){
             buscarNotaCompraPorProducto();
         }
    }//GEN-LAST:event_btnBuscarMousePressed

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnBuscarActionPerformed
    private void buscarNotaCompraPorCodigo(){
         String valor = JOptionPane.showInputDialog(this,"Ingrese el codigo de la nota "
                  + " de compra", 0);
         if ( valor == null)
             return;
         Integer codigoNotaCompra = null;
         try {
             codigoNotaCompra = Integer.parseInt(valor);
         }catch (Exception e) 
         {
             e.printStackTrace();
            JOptionPane.showConfirmDialog(this,"Valor invalido");
         }
         if ( codigoNotaCompra < 0){
            JOptionPane.showMessageDialog(this,"El codigo de nota de compra es un entero positivo");
         }
         Compra objectoCompra = nCompra.buscarCompraPorCodigo(codigoNotaCompra);
         resetear();   
         if ( objectoCompra != null)
         {
           
           String nombre = objectoCompra.getNombreProveedor();
           Date fecha = objectoCompra.getFecha();
           agregarItemTablaNotaCompra(codigoNotaCompra,fecha, nombre);
         }
       
    }
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
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(JdCompra.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JdCompra.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JdCompra.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JdCompra.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                JdCompra dialog = new JdCompra(new javax.swing.JFrame(), true);
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
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnNuevo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblNotaCompra;
    // End of variables declaration//GEN-END:variables

    private void resetear() {
        /*throw new UnsupportedOperationException("Not yet implemented");*/
        while ( tableModelCompra.getRowCount() > 0){
           tableModelCompra.removeRow(tableModelCompra.getRowCount()-1);
        }
    }

    private void buscarNotaCompraPorFecha() {
        SimpleDateFormat format = new SimpleDateFormat("yyyy/MM/dd");
        String valorPorDefecto = format.format(new Date(System.currentTimeMillis())); 
        String valor = JOptionPane.showInputDialog(this,"Ingrese la fecha de la compra "
                   ,valorPorDefecto);
            if ( valor == null)
                 return;
            Date fecha = null;
            try {
                 fecha =format.parse(valor);
            } catch (Exception e) {
                  e.printStackTrace();
                JOptionPane.showConfirmDialog(this,"Valor invalido");
            }
            String strFecha = format.format(fecha);
            List<Object> resultados = nCompra.buscarCompraPorFecha(strFecha);
            System.out.println(resultados);
            resetear();   
            if ( resultados != null){
                for (Iterator<Object> it = resultados.iterator(); it.hasNext();) {
                    Object object = it.next(); 
                    Compra objectoCompra = (Compra)object;
                    String nombre = objectoCompra.getNombreProveedor();
                    Integer codigoNotaCompra = objectoCompra.getId();
                    agregarItemTablaNotaCompra(codigoNotaCompra,fecha, nombre);
                }
              
            }
    }

    private void buscarNotaCompraPorProducto() {
        LinkedList<Producto> datos = nProducto.listar();
        if ( datos == null)
            return;
        Object productos[] = new Object[datos.size()];
        for (int i = 0; i < datos.size(); i++) {
            productos[i]= datos.get(i);
        }
      
         Object selecion = JOptionPane.showInputDialog(this,"Selecione un producto","Buscar nota de compra "
                 + " relacionados con el producto",
               JOptionPane.INFORMATION_MESSAGE,null,productos,null);
         if ( selecion != null){
             Producto objectoProducto = (Producto)selecion;
             int codigoProducto =objectoProducto.getId(); 
             List<Object> resultados  =nCompra.buscarCompraPorProducto(codigoProducto);
             resetear();
            for (Iterator<Object> it = resultados.iterator(); it.hasNext();) {
                Object object = it.next(); 
                Compra objectoCompra = (Compra)object;
                String nombre = objectoCompra.getNombreProveedor();
                Integer codigoNotaCompra = objectoCompra.getId();
                Date fecha = objectoCompra.getFecha();
                agregarItemTablaNotaCompra(codigoNotaCompra,fecha, nombre);
            }     
         }

    }
    private class DateCellRenderer extends DefaultTableCellRenderer {
        public DateCellRenderer() { super(); }

      
        
        @Override
        public void setValue(Object value) {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
            if ( value instanceof Date)
            setText((value == null) ? "" : sdf.format(value));
            if  ( value instanceof String)
            {    
                try
                {
                    String source =(String)value; 
                    Date date = sdf.parse(source);
                    setText((value == null) ? "" : sdf.format(date));
                } catch (ParseException ex) {
                   ex.printStackTrace();;
                }
             
            }
        }
    }
    private class HiloReporte extends SwingWorker<Boolean, Object>{

        private Integer codigoCompra;
        private JasperViewer componenteReporte;
        private JdReporte  jdReporte;

        public HiloReporte(JDialog parent) {
            jdReporte= new JdReporte(parent,true);
        }
        

        @Override
        protected Boolean doInBackground() throws Exception {
             componenteReporte =  nCompra.obtenerReporteNotaCompra(codigoCompra);  
             return componenteReporte != null ? true : false;
        }

    

       
     

        @Override
        protected void process(List<Object> chunks) {
            super.process(chunks);
        }

        @Override
        protected void done() {
            if ( componenteReporte != null)
            {
                jdReporte.setComponenteReporte(componenteReporte);
                jdReporte.setVisible(true);           
            }    
        }
        
        
        
    }
    
}
