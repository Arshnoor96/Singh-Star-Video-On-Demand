
import java.awt.Color;
import java.awt.Image;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.net.Socket;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

public class Client extends javax.swing.JFrame {

    Socket socket;
    DataInputStream dis;
    DataOutputStream dos;

    public Client() {
        initComponents();
        btsignup.setVisible(false);
        btlogin.setVisible(false);
        try {

            Image scaledimage4 = ImageIO.read(new File("C:\\Users\\Arshnoor Singh\\Desktop\\New folder\\5fa3c5af3918f6ac8dc699d16e52f528--material-design-diagonal (1).jpg   ")).getScaledInstance(lbback.getWidth(), lbback.getHeight(), Image.SCALE_SMOOTH);
            ImageIcon img4 = new ImageIcon(scaledimage4);
            lbback.setIcon(img4);
//    Image scaledimage5 = ImageIO.read(new File("C:\\Users\\Arshnoor Singh\\Desktop\\New folder\\singh.jpg  ")).getScaledInstance(lbicon.getWidth(), lbicon.getHeight(), Image.SCALE_SMOOTH);
//            ImageIcon img5 = new ImageIcon(scaledimage5);
//            lbicon.setIcon(img5);
//       

//            Image scaledimage1 = ImageIO.read(new File("E:\\Movies\\Buttons\\Connect button.png")).getScaledInstance(connectlb.getWidth(), connectlb.getHeight(), Image.SCALE_SMOOTH);
//            ImageIcon img1 = new ImageIcon(scaledimage1);
//            connectlb.setIcon(img1);
//            Image scaledimage2 = ImageIO.read(new File("E:\\Movies\\Buttons\\Sign up button.png")).getScaledInstance(signuplb.getWidth(), signuplb.getHeight(), Image.SCALE_SMOOTH);
//            ImageIcon img2 = new ImageIcon(scaledimage2);
//            signuplb.setIcon(img2);
//            Image scaledimage3 = ImageIO.read(new File("E:\\Movies\\Buttons\\login button.png")).getScaledInstance(loginlb.getWidth(), loginlb.getHeight(), Image.SCALE_SMOOTH);
//            ImageIcon img3 = new ImageIcon(scaledimage3);
//            loginlb.setIcon(img3);

        } catch (Exception e) {
            e.printStackTrace();
        }
        this.setTitle("USER HOME");
        getContentPane().setBackground(Color.PINK);
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        this.setVisible(true);
        this.setSize(650, 525);
        this.setLocation(150, 120);
        this.setLocation(150, 100);

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        btsignup = new javax.swing.JButton();
        btlogin = new javax.swing.JButton();
        btconnect = new javax.swing.JButton();
        lbback = new javax.swing.JLabel();

        jLabel1.setText("jLabel1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        btsignup.setFont(new java.awt.Font("Tahoma", 1, 30)); // NOI18N
        btsignup.setText("Sign Up");
        btsignup.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btsignupActionPerformed(evt);
            }
        });
        getContentPane().add(btsignup);
        btsignup.setBounds(140, 200, 290, 70);

        btlogin.setFont(new java.awt.Font("Tahoma", 1, 30)); // NOI18N
        btlogin.setText("LOGIN");
        btlogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btloginActionPerformed(evt);
            }
        });
        getContentPane().add(btlogin);
        btlogin.setBounds(140, 320, 290, 70);

        btconnect.setFont(new java.awt.Font("Tahoma", 1, 30)); // NOI18N
        btconnect.setText("Connect Server");
        btconnect.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btconnectActionPerformed(evt);
            }
        });
        getContentPane().add(btconnect);
        btconnect.setBounds(140, 80, 290, 70);
        getContentPane().add(lbback);
        lbback.setBounds(0, 0, 600, 490);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btsignupActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btsignupActionPerformed
        Usersignup us = new Usersignup(socket);
        us.setVisible(true);
        dispose();
    }//GEN-LAST:event_btsignupActionPerformed

    private void btconnectActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btconnectActionPerformed
        try {
            socket = new Socket("127.0.0.1", 9000);
            dis = new DataInputStream(socket.getInputStream());
            dos = new DataOutputStream(socket.getOutputStream());
            btconnect.setVisible(false);
            btsignup.setVisible(true);
            btlogin.setVisible(true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_btconnectActionPerformed

    private void btloginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btloginActionPerformed
        Userlogin ul = new Userlogin(socket);
        ul.setVisible(true);
        dispose();
    }//GEN-LAST:event_btloginActionPerformed

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
            java.util.logging.Logger.getLogger(Client.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Client.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Client.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Client.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Client().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btconnect;
    private javax.swing.JButton btlogin;
    private javax.swing.JButton btsignup;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel lbback;
    // End of variables declaration//GEN-END:variables
}
