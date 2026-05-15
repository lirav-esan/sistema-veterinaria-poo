package patitas_vet;

import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.SwingUtilities;
import java.awt.Image;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import pooveterinaria.VET_Library;
import pooveterinaria.VET_Library;
import java.awt.Toolkit;

public class main_page extends javax.swing.JFrame {

    public main_page() {
        initComponents();
        getContentPane().setBackground(new Color(250, 230, 198));
        this.setExtendedState(this.MAXIMIZED_BOTH);
        this.setLayout(null);

        int altoPantalla = Toolkit.getDefaultToolkit().getScreenSize().height;

        db_fondo.setBounds(0, 0, 250, altoPantalla);
        this.add(db_fondo);

        welcome_panel.setBounds(275, 25, 900, 300);
        this.add(welcome_panel);
       
        
    }   

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        db_fondo = new javax.swing.JPanel();
        btnDashboard = new javax.swing.JButton();
        logo_image = new javax.swing.JPanel();
        jLOGO = new javax.swing.JLabel();
        btnVolver = new javax.swing.JButton();
        btnCerrarSesion = new javax.swing.JButton();
        welcome_panel = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        registro = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        btnClientes = new javax.swing.JButton();
        btnPacientes = new javax.swing.JButton();
        btnRegistro = new javax.swing.JButton();
        btnBusquedaGen = new javax.swing.JButton();
        btnRegistro2 = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        db_fondo.setBackground(new java.awt.Color(109, 151, 115));

        btnDashboard.setBackground(new java.awt.Color(255, 185, 2));
        btnDashboard.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 24)); // NOI18N
        btnDashboard.setForeground(new java.awt.Color(255, 255, 255));
        btnDashboard.setText("Dashboard");
        btnDashboard.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        btnDashboard.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);
        btnDashboard.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDashboardActionPerformed(evt);
            }
        });

        logo_image.setBackground(new java.awt.Color(12, 58, 45));

        jLOGO.setText(".");

        javax.swing.GroupLayout logo_imageLayout = new javax.swing.GroupLayout(logo_image);
        logo_image.setLayout(logo_imageLayout);
        logo_imageLayout.setHorizontalGroup(
            logo_imageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(logo_imageLayout.createSequentialGroup()
                .addGap(111, 111, 111)
                .addComponent(jLOGO, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(32, Short.MAX_VALUE))
        );
        logo_imageLayout.setVerticalGroup(
            logo_imageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(logo_imageLayout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addComponent(jLOGO, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(17, Short.MAX_VALUE))
        );

        btnVolver.setBackground(new java.awt.Color(255, 185, 2));
        btnVolver.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 18)); // NOI18N
        btnVolver.setForeground(new java.awt.Color(255, 255, 255));
        btnVolver.setText("Volver");
        btnVolver.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        btnVolver.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);
        btnVolver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVolverActionPerformed(evt);
            }
        });

        btnCerrarSesion.setBackground(new java.awt.Color(255, 185, 2));
        btnCerrarSesion.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 18)); // NOI18N
        btnCerrarSesion.setForeground(new java.awt.Color(255, 255, 255));
        btnCerrarSesion.setText("Cerrar Sesión");
        btnCerrarSesion.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        btnCerrarSesion.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);
        btnCerrarSesion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCerrarSesionActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout db_fondoLayout = new javax.swing.GroupLayout(db_fondo);
        db_fondo.setLayout(db_fondoLayout);
        db_fondoLayout.setHorizontalGroup(
            db_fondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, db_fondoLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(db_fondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnCerrarSesion, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnVolver, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnDashboard, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(24, 24, 24))
            .addComponent(logo_image, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        db_fondoLayout.setVerticalGroup(
            db_fondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(db_fondoLayout.createSequentialGroup()
                .addComponent(logo_image, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(461, 461, 461)
                .addComponent(btnDashboard, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31)
                .addComponent(btnVolver)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnCerrarSesion)
                .addContainerGap(209, Short.MAX_VALUE))
        );

        getContentPane().add(db_fondo);
        db_fondo.setBounds(0, 0, 260, 910);

        welcome_panel.setBackground(new java.awt.Color(109, 151, 115));

        jLabel2.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 36)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("¡Buen día, Dr(a)!");

        jLabel6.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 24)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("¡Tenga un excelente día!");

        javax.swing.GroupLayout welcome_panelLayout = new javax.swing.GroupLayout(welcome_panel);
        welcome_panel.setLayout(welcome_panelLayout);
        welcome_panelLayout.setHorizontalGroup(
            welcome_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(welcome_panelLayout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addGroup(welcome_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 508, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addContainerGap(579, Short.MAX_VALUE))
        );
        welcome_panelLayout.setVerticalGroup(
            welcome_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(welcome_panelLayout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(40, Short.MAX_VALUE))
        );

        getContentPane().add(welcome_panel);
        welcome_panel.setBounds(290, 20, 1120, 190);

        jPanel2.setBackground(new java.awt.Color(109, 151, 115));

        registro.setBackground(new java.awt.Color(255, 185, 2));

        jLabel5.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 24)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Base de Datos");

        btnClientes.setBackground(new java.awt.Color(250, 230, 200));
        btnClientes.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 24)); // NOI18N
        btnClientes.setForeground(new java.awt.Color(110, 150, 115));
        btnClientes.setText("Registrar Clientes");
        btnClientes.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        btnClientes.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);
        btnClientes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClientesActionPerformed(evt);
            }
        });

        btnPacientes.setBackground(new java.awt.Color(250, 230, 200));
        btnPacientes.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 24)); // NOI18N
        btnPacientes.setForeground(new java.awt.Color(110, 150, 115));
        btnPacientes.setText("Registrar Pacientes");
        btnPacientes.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        btnPacientes.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);
        btnPacientes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPacientesActionPerformed(evt);
            }
        });

        btnRegistro.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 18)); // NOI18N
        btnRegistro.setText("Registro");
        btnRegistro.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        btnRegistro.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);
        btnRegistro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistroActionPerformed(evt);
            }
        });

        btnBusquedaGen.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 18)); // NOI18N
        btnBusquedaGen.setText("Busqueda General");
        btnBusquedaGen.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        btnBusquedaGen.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);
        btnBusquedaGen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBusquedaGenActionPerformed(evt);
            }
        });

        btnRegistro2.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 18)); // NOI18N
        btnRegistro2.setText("Vacunas");
        btnRegistro2.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        btnRegistro2.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);
        btnRegistro2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistro2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout registroLayout = new javax.swing.GroupLayout(registro);
        registro.setLayout(registroLayout);
        registroLayout.setHorizontalGroup(
            registroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(registroLayout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(registroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addGroup(registroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(btnBusquedaGen, javax.swing.GroupLayout.PREFERRED_SIZE, 211, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(registroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(btnRegistro, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnClientes, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnPacientes, javax.swing.GroupLayout.DEFAULT_SIZE, 627, Short.MAX_VALUE))
                        .addComponent(btnRegistro2, javax.swing.GroupLayout.DEFAULT_SIZE, 627, Short.MAX_VALUE)))
                .addContainerGap(24, Short.MAX_VALUE))
        );
        registroLayout.setVerticalGroup(
            registroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(registroLayout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(jLabel5)
                .addGap(18, 18, 18)
                .addComponent(btnClientes, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 52, Short.MAX_VALUE)
                .addComponent(btnPacientes, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addComponent(btnRegistro, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnRegistro2, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnBusquedaGen, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jLabel4.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 24)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Seleccione una opción para proseguir:");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(422, 422, 422)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 508, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(registro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(20, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(registro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(83, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel2);
        jPanel2.setBounds(290, 230, 1120, 580);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnDashboardActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDashboardActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnDashboardActionPerformed

    private void btnVolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVolverActionPerformed
        LOG_IN LOGIN = new LOG_IN();
        LOGIN.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnVolverActionPerformed

    private void btnCerrarSesionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCerrarSesionActionPerformed
        LOG_IN LOGIN = new LOG_IN();
        LOGIN.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnCerrarSesionActionPerformed

    private void btnClientesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClientesActionPerformed
        registro_clientes registroClientes = new registro_clientes(null);
        registroClientes.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnClientesActionPerformed

    private void btnPacientesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPacientesActionPerformed
        registros_pacientes registrosPacientes = new registros_pacientes(null);
        registrosPacientes.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnPacientesActionPerformed

    private void btnRegistroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistroActionPerformed
        registro REGISTRO = new registro(null,null);
        REGISTRO.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnRegistroActionPerformed

    private void btnBusquedaGenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBusquedaGenActionPerformed
        Busqueda busqueda = new Busqueda();
        busqueda.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnBusquedaGenActionPerformed

    private void btnRegistro2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistro2ActionPerformed
        vacunas VACUNAS = new vacunas();
        VACUNAS.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnRegistro2ActionPerformed

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
            java.util.logging.Logger.getLogger(main_page.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(main_page.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(main_page.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(main_page.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new main_page().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBusquedaGen;
    private javax.swing.JButton btnCerrarSesion;
    private javax.swing.JButton btnClientes;
    private javax.swing.JButton btnDashboard;
    private javax.swing.JButton btnPacientes;
    private javax.swing.JButton btnRegistro;
    private javax.swing.JButton btnRegistro2;
    private javax.swing.JButton btnVolver;
    private javax.swing.JPanel db_fondo;
    private javax.swing.JLabel jLOGO;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel logo_image;
    private javax.swing.JPanel registro;
    private javax.swing.JPanel welcome_panel;
    // End of variables declaration//GEN-END:variables
}
