package patitas_vet;

import javax.swing.table.DefaultTableModel;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class bd_Estetica extends javax.swing.JFrame {
    
    ConnectToServer conexion = new ConnectToServer();
    
    public bd_Estetica() {
        initComponents();
        
        try {
            conexion.conectaSql();
            cargarEsteticaEnTabla();
            cargarConceptoEnTabla();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error al conectar o cargar clientes: " + e.getMessage());
        }      
        
    }
    
    private void cargarEsteticaEnTabla(){
        
        String consulta = "SELECT * FROM Estetica";
        try{
            ResultSet rs = conexion.querySql(consulta);
            ResultSetMetaData metaData = rs.getMetaData();
            int columnas = metaData.getColumnCount();
            
            //No es editable
            DefaultTableModel modelo = new DefaultTableModel() {
                @Override
                public boolean isCellEditable(int row, int column) {
                    return false;
                }
            };
            
            //Agregar nombres columnas
            for (int i = 1; i <= columnas; i++) {
                modelo.addColumn(metaData.getColumnLabel(i));
            }
            
            //agregar filas
            while (rs.next()) {
                Object[] fila = new Object[columnas];
                for (int i = 0; i < columnas; i++) {
                    fila[i] = rs.getObject(i + 1);
                }
                modelo.addRow(fila);
            }

            tablaEstetica.setModel(modelo);
            
            // Bloquear movimiento de columnas
            tablaEstetica.getTableHeader().setReorderingAllowed(false);
        }catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Error al cargar la tabla de clientes: " + ex.getMessage());
        }
        
        
    }
    
    private void cargarConceptoEnTabla() {
    String consulta = "SELECT * FROM Concepto";

    try {
        ResultSet rs = conexion.querySql(consulta);
        ResultSetMetaData metaData = rs.getMetaData();
        int columnas = metaData.getColumnCount();

        DefaultTableModel modelo = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };

        // Agregar nombres de columnas
        for (int i = 1; i <= columnas; i++) {
            modelo.addColumn(metaData.getColumnLabel(i));
        }

        // Agregar filas
        while (rs.next()) {
            Object[] fila = new Object[columnas];
            for (int i = 0; i < columnas; i++) {
                fila[i] = rs.getObject(i + 1);
            }
            modelo.addRow(fila);
        }

        // Asignar el modelo a la tablaConcepto
        tablaConcepto.setModel(modelo);
        tablaConcepto.getTableHeader().setReorderingAllowed(false);

    } catch (SQLException ex) {
        JOptionPane.showMessageDialog(this, "Error al cargar la tabla de concepto: " + ex.getMessage());
    }
}

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        btnSeleccionar = new javax.swing.JButton();
        btnCerrar2 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaEstetica = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tablaConcepto = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(966, 654));
        setSize(new java.awt.Dimension(0, 0));
        getContentPane().setLayout(null);

        jPanel1.setBackground(new java.awt.Color(109, 151, 115));

        jLabel2.setBackground(new java.awt.Color(255, 255, 255));
        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Base de Datos Estetica");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 920, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addGap(16, 16, 16)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 364, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(540, Short.MAX_VALUE)))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 52, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap()))
        );

        getContentPane().add(jPanel1);
        jPanel1.setBounds(20, 20, 920, 52);

        btnSeleccionar.setBackground(new java.awt.Color(250, 230, 200));
        btnSeleccionar.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 18)); // NOI18N
        btnSeleccionar.setForeground(new java.awt.Color(110, 150, 115));
        btnSeleccionar.setText("Seleccionar");
        btnSeleccionar.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        btnSeleccionar.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);
        btnSeleccionar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSeleccionarActionPerformed(evt);
            }
        });
        getContentPane().add(btnSeleccionar);
        btnSeleccionar.setBounds(580, 560, 170, 40);

        btnCerrar2.setBackground(new java.awt.Color(250, 230, 200));
        btnCerrar2.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 18)); // NOI18N
        btnCerrar2.setForeground(new java.awt.Color(110, 150, 115));
        btnCerrar2.setText("Cerrar");
        btnCerrar2.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        btnCerrar2.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);
        btnCerrar2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCerrar2ActionPerformed(evt);
            }
        });
        getContentPane().add(btnCerrar2);
        btnCerrar2.setBounds(770, 560, 170, 40);

        tablaEstetica.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(tablaEstetica);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(30, 130, 410, 380);

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setText("Concepto");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(540, 90, 364, 40);

        jLabel3.setBackground(new java.awt.Color(255, 255, 255));
        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel3.setText("Estetica:");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(30, 90, 364, 40);

        tablaConcepto.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane2.setViewportView(tablaConcepto);

        getContentPane().add(jScrollPane2);
        jScrollPane2.setBounds(540, 130, 390, 380);

        pack();
    }// </editor-fold>//GEN-END:initComponents
    public String[] getTableDataA(){
        int index = tablaEstetica.getSelectedRow();
        if (index == -1){
            JOptionPane.showMessageDialog(rootPane, "No hay fila seleccionada");
            
        }else{
            int rowLen = tablaEstetica.getColumnCount();
            String[] a = new String[rowLen];
            for (int i = 0; i < rowLen; i++){
                Object dato = tablaEstetica.getValueAt(index, i);
                a[i] = (dato != null)? dato.toString() : "";
            }
            return a;
        }
        return null;
    }
    private void btnSeleccionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSeleccionarActionPerformed
        String[] tableDataA = getTableDataA();
        registro NEWREGISTRO = new registro(tableDataA, null);
        NEWREGISTRO.setVisible(true);
        this.dispose();
       

    }//GEN-LAST:event_btnSeleccionarActionPerformed

    private void btnCerrar2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCerrar2ActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnCerrar2ActionPerformed

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
            java.util.logging.Logger.getLogger(bd_Estetica.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(bd_Estetica.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(bd_Estetica.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(bd_Estetica.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new bd_Estetica().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCerrar2;
    private javax.swing.JButton btnSeleccionar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tablaConcepto;
    private javax.swing.JTable tablaEstetica;
    // End of variables declaration//GEN-END:variables
}
