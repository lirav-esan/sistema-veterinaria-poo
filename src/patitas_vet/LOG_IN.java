package patitas_vet;

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

/**
 *
 * @author Usuario
 */

public class LOG_IN extends javax.swing.JFrame {

    
    public LOG_IN() {
        initComponents();
        
        getContentPane().setBackground(new java.awt.Color(250, 230, 198));
        this.setExtendedState(this.MAXIMIZED_BOTH);
                             
             
        //Imagen
        SwingUtilities.invokeLater(() -> {
            
            //jLogin
            int anchoDeseado = 700;
            int alturaVentana = getContentPane().getHeight();   
            ImageIcon original = new ImageIcon(getClass().getResource("/images/LOGIN_IMAGE.jpg"));
            Image imagenEscalada = original.getImage().getScaledInstance(anchoDeseado, alturaVentana, Image.SCALE_SMOOTH);
            jLogin.setIcon(new ImageIcon(imagenEscalada));
            jLogin.setSize(anchoDeseado, alturaVentana);
            
            //jUser
            int anchoUser = jUser.getWidth();
            int altoUser = jUser.getHeight();

            ImageIcon originalUser = new ImageIcon(getClass().getResource("/images/FONDO_LOGIN.png"));
            Image imagenUser = originalUser.getImage().getScaledInstance(anchoUser, altoUser, Image.SCALE_SMOOTH);

            jUser.setIcon(new ImageIcon(imagenUser));    
            
            //jIcon
            int anchoLogo = jIcon.getWidth();
            int altoLogo = jIcon.getHeight();

            ImageIcon originalLogo = new ImageIcon(getClass().getResource("/images/LOGO_LOGIN.jpg"));
            Image imagenLogo = originalLogo.getImage().getScaledInstance(anchoLogo, altoLogo, Image.SCALE_SMOOTH);

            jIcon.setIcon(new ImageIcon(imagenLogo)); 
           
            
        
          }
        
        );
        
        
              
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnLogin = new javax.swing.JButton();
        txtContraseña = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtUser = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jIcon = new javax.swing.JLabel();
        jUser = new javax.swing.JLabel();
        jLogin = new javax.swing.JLabel();
        btnSalir = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        btnLogin.setBackground(new java.awt.Color(255, 185, 2));
        btnLogin.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnLogin.setForeground(new java.awt.Color(255, 255, 255));
        btnLogin.setText("LOGIN");
        btnLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLoginActionPerformed(evt);
            }
        });
        getContentPane().add(btnLogin);
        btnLogin.setBounds(340, 630, 140, 40);

        txtContraseña.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        getContentPane().add(txtContraseña);
        txtContraseña.setBounds(230, 430, 340, 30);

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel2.setText("Contraseña");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(230, 410, 80, 20);

        txtUser.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        getContentPane().add(txtUser);
        txtUser.setBounds(230, 350, 340, 30);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel1.setText("Usuario");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(230, 330, 50, 20);
        getContentPane().add(jIcon);
        jIcon.setBounds(320, 90, 160, 150);
        getContentPane().add(jUser);
        jUser.setBounds(170, 60, 470, 680);
        getContentPane().add(jLogin);
        jLogin.setBounds(880, 0, 540, 420);

        btnSalir.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnSalir.setText("Salir");
        btnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirActionPerformed(evt);
            }
        });
        getContentPane().add(btnSalir);
        btnSalir.setBounds(20, 733, 120, 40);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLoginActionPerformed
        try {
            ConnectToServer bd = new ConnectToServer();
            bd.conectaSql();
            if (bd.verifLogin(txtUser.getText(), txtContraseña.getText())){
                main_page paginaPrincipal = new main_page();
                paginaPrincipal.setVisible(true);
                this.dispose();
            }else{
                JOptionPane.showMessageDialog(rootPane, "Credenciales incorrectas");
            }
        } catch (ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(rootPane, ex);
            System.out.print(ex);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(rootPane, ex);
            System.out.print(ex);
        }
        
    }//GEN-LAST:event_btnLoginActionPerformed

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
        int confirm = JOptionPane.showConfirmDialog(
        this, // JFrame actual 
              
        "¿Estás seguro de que quieres salir de la aplicación?",
        "Confirmar Salida",
        JOptionPane.YES_NO_OPTION
    );

    if (confirm == JOptionPane.YES_OPTION) {
        System.exit(0); // Cierra la aplicación si el usuario confirma
    }
    }//GEN-LAST:event_btnSalirActionPerformed

    
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
            java.util.logging.Logger.getLogger(LOG_IN.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(LOG_IN.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(LOG_IN.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(LOG_IN.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new LOG_IN().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnLogin;
    private javax.swing.JButton btnSalir;
    private javax.swing.JLabel jIcon;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLogin;
    private javax.swing.JLabel jUser;
    private javax.swing.JTextField txtContraseña;
    private javax.swing.JTextField txtUser;
    // End of variables declaration//GEN-END:variables
}
