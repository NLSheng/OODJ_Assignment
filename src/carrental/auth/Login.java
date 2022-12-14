/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package carrental.auth;

import carrental.User;
import javax.swing.JFrame;

/**
 *
 * @author user
 */
public class Login extends javax.swing.JFrame {

    /**
     * Creates new form Login
     */
    public Login() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        customerEmailField = new javax.swing.JTextField();
        customerPasswordField = new javax.swing.JTextField();
        RegisterText = new javax.swing.JLabel();
        LoginText = new javax.swing.JLabel();
        passwordText = new javax.swing.JLabel();
        loginBtn = new javax.swing.JButton();
        loginBtn1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(1050, 650));
        setPreferredSize(new java.awt.Dimension(1050, 650));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        getContentPane().add(customerEmailField, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 250, 176, 36));
        getContentPane().add(customerPasswordField, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 320, 176, 36));

        RegisterText.setText("Email");
        getContentPane().add(RegisterText, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 210, 39, 24));

        LoginText.setText("Login");
        getContentPane().add(LoginText, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 160, 54, 35));

        passwordText.setText("Password");
        getContentPane().add(passwordText, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 290, 58, 24));

        loginBtn.setText("Login");
        loginBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loginBtnActionPerformed(evt);
            }
        });
        getContentPane().add(loginBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 390, -1, -1));

        loginBtn1.setText("Register");
        loginBtn1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loginBtn1ActionPerformed(evt);
            }
        });
        getContentPane().add(loginBtn1, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 390, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void loginBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loginBtnActionPerformed
        String email, password;
        email = customerEmailField.getText();
        password = customerPasswordField.getText();
        
        User user = new User();
        user.login(email, password);
        dispose();
    }//GEN-LAST:event_loginBtnActionPerformed

    private void loginBtn1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loginBtn1ActionPerformed
        Register register = new Register();
        register.setVisible(true);
        register.setLocationRelativeTo(null);
        dispose();
    }//GEN-LAST:event_loginBtn1ActionPerformed

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
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Login().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel LoginText;
    private javax.swing.JLabel RegisterText;
    private javax.swing.JTextField customerEmailField;
    private javax.swing.JTextField customerPasswordField;
    private javax.swing.JButton loginBtn;
    private javax.swing.JButton loginBtn1;
    private javax.swing.JLabel passwordText;
    // End of variables declaration//GEN-END:variables
}
