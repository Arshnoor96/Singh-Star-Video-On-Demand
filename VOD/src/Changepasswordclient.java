
import java.awt.Color;
import java.io.DataInput;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class Changepasswordclient extends javax.swing.JFrame {
    
    Socket socket;
    DataInputStream dis;
    DataOutputStream dos;
    String email;
    
    public Changepasswordclient(Socket socket, String email) {
        initComponents();
        this.socket = socket;
        this.email = email;
        setTitle("Change Password " + email);
        try {
            dis = new DataInputStream((socket.getInputStream()));
            dos = new DataOutputStream((socket.getOutputStream()));
        } catch (Exception e) {
            e.printStackTrace();
        }
        this.setTitle("USER CHANGE PASSWORD");
        getContentPane().setBackground(Color.PINK);
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        this.setVisible(true);
        this.setSize(600, 500);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel4 = new javax.swing.JLabel();
        emailTF = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        newpasswordTF = new javax.swing.JTextField();
        confirmpasswordTF = new javax.swing.JTextField();
        oldpasswordTF = new javax.swing.JTextField();

        jLabel4.setText("Email");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        jLabel1.setText("New Password");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(0, 170, 110, 14);

        jLabel2.setText("Confirnm Password");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(0, 240, 110, 14);

        jLabel3.setText("Old Password");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(0, 110, 110, 14);

        jButton1.setBackground(new java.awt.Color(204, 255, 153));
        jButton1.setFont(new java.awt.Font("Verdana", 3, 12)); // NOI18N
        jButton1.setText("Change Password");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1);
        jButton1.setBounds(260, 310, 190, 70);
        getContentPane().add(newpasswordTF);
        newpasswordTF.setBounds(220, 160, 270, 30);
        getContentPane().add(confirmpasswordTF);
        confirmpasswordTF.setBounds(220, 230, 270, 30);
        getContentPane().add(oldpasswordTF);
        oldpasswordTF.setBounds(220, 100, 270, 30);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        
        String oldpassword = oldpasswordTF.getText();
        String newpassword = newpasswordTF.getText();
        String confirmpassword = confirmpasswordTF.getText();
        
        if (oldpassword.isEmpty() || newpassword.isEmpty() || confirmpassword.isEmpty()) {
            JOptionPane.showMessageDialog(this, "enter the above all fields");
        }
        if ((confirmpassword.equals(newpassword))) {
            try {
                dos.writeBytes("changepassword\r\n");
                dos.writeBytes(oldpassword + "\r\n");
                dos.writeBytes(newpassword + "\r\n");
                dos.writeBytes(email + "\r\n");
                String s = dis.readLine();
                if (s.equals("success")) {
                    JOptionPane.showMessageDialog(this, "password change success . . !!!");
                } else {
                    JOptionPane.showMessageDialog(this, "Password does not changed");
                }
            } catch (IOException ex) {
                ex.printStackTrace();
                
            }
        } else if (!(confirmpassword.equals(newpassword))) {
            
            JOptionPane.showMessageDialog(this, "new password and confirm password not match");
            
        }
    }//GEN-LAST:event_jButton1ActionPerformed
    
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
            java.util.logging.Logger.getLogger(Changepasswordclient.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Changepasswordclient.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Changepasswordclient.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Changepasswordclient.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
//                new Changepasswordclient().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField confirmpasswordTF;
    private javax.swing.JTextField emailTF;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JTextField newpasswordTF;
    private javax.swing.JTextField oldpasswordTF;
    // End of variables declaration//GEN-END:variables
}
