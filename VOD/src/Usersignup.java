
import java.awt.Color;
import java.awt.Image;
import java.io.*;
import java.util.*;
import javax.swing.*;
import java.net.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.imageio.ImageIO;

public class Usersignup extends javax.swing.JFrame {

    Socket socket;
    DataInputStream dis;
    DataOutputStream dos;
    String email;
    String password;
    String sec_ques;
    String sec_ans;
    String contact;

    public Usersignup(Socket socket) {
        initComponents();

        this.socket = socket;
        try {
            dos = new DataOutputStream(this.socket.getOutputStream());
            dis = new DataInputStream(this.socket.getInputStream());
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {

            jCBsecurityquestion.addItem("--select category--");
            jCBsecurityquestion.addItem("What is your fav color?");
            jCBsecurityquestion.addItem("What is your fav food?");
            jCBsecurityquestion.addItem("What is your fav place?");

            Image scaledimage = ImageIO.read(new File("E:\\Movies\\Buttons\\Sign up button.png")).getScaledInstance(signuplb.getWidth(), signuplb.getHeight(), Image.SCALE_SMOOTH);
            ImageIcon img = new ImageIcon(scaledimage);
            signuplb.setIcon(img);

        } catch (Exception e) {
            e.printStackTrace();
        }
        this.setTitle("USER SIGNUP");
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        getContentPane().setBackground(Color.pink);
        this.setVisible(true);
        this.setSize(600, 700);

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTFsecurityquestion = new javax.swing.JTextField();
        jTFconfirmpassword = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jTFemail1 = new javax.swing.JTextField();
        jTFcontactnumber = new javax.swing.JTextField();
        jPasswordField1 = new javax.swing.JPasswordField();
        jLabel7 = new javax.swing.JLabel();
        jTFsecurityanswer = new javax.swing.JTextField();
        jCBsecurityquestion = new javax.swing.JComboBox<>();
        jPasswordconfirm = new javax.swing.JPasswordField();
        signuplb = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        jLabel1.setText("User Sign up");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(270, 20, 170, 20);

        jLabel2.setText("Security Question");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(30, 240, 110, 14);

        jLabel3.setText("E-mail");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(40, 90, 50, 14);

        jLabel4.setText("Password");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(40, 140, 50, 14);

        jLabel5.setText("Contact Number");
        getContentPane().add(jLabel5);
        jLabel5.setBounds(30, 350, 100, 14);

        jLabel6.setText("Confirm Password");
        getContentPane().add(jLabel6);
        jLabel6.setBounds(30, 190, 110, 14);
        getContentPane().add(jTFemail1);
        jTFemail1.setBounds(160, 80, 340, 30);
        getContentPane().add(jTFcontactnumber);
        jTFcontactnumber.setBounds(160, 350, 340, 30);
        getContentPane().add(jPasswordField1);
        jPasswordField1.setBounds(160, 140, 340, 30);

        jLabel7.setText("Security Answer");
        getContentPane().add(jLabel7);
        jLabel7.setBounds(30, 300, 100, 14);
        getContentPane().add(jTFsecurityanswer);
        jTFsecurityanswer.setBounds(160, 300, 340, 30);

        jCBsecurityquestion.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] {}));
        jCBsecurityquestion.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jCBsecurityquestionItemStateChanged(evt);
            }
        });
        getContentPane().add(jCBsecurityquestion);
        jCBsecurityquestion.setBounds(160, 240, 340, 30);
        getContentPane().add(jPasswordconfirm);
        jPasswordconfirm.setBounds(160, 190, 340, 30);

        signuplb.setText("jLabel8");
        signuplb.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                signuplbMouseClicked(evt);
            }
        });
        getContentPane().add(signuplb);
        signuplb.setBounds(250, 410, 100, 40);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jCBsecurityquestionItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jCBsecurityquestionItemStateChanged
        sec_ques = jCBsecurityquestion.getSelectedItem().toString();

    }//GEN-LAST:event_jCBsecurityquestionItemStateChanged

    private void signuplbMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_signuplbMouseClicked
        try {
            email = jTFemail1.getText();
            password = jPasswordField1.getText();
            sec_ans = jTFsecurityanswer.getText();
            contact = jTFcontactnumber.getText();
            String password = jPasswordField1.getText();
            String confirmpassword = jPasswordconfirm.getText();
            if (!(confirmpassword.equals(password))) {
                JOptionPane.showMessageDialog(this, "new password and confirm password not match");
            } else {
//                JOptionPane.showMessageDialog(this, "Passwordmatch");
                dos.writeBytes("Signup\r\n");
                dos.writeBytes(email + "\r\n");
                dos.writeBytes(password + "\r\n");
                dos.writeBytes(sec_ques + "\r\n");
                dos.writeBytes(sec_ans + "\r\n");
                dos.writeBytes(contact + "\r\n");
                String message = dis.readLine();
                if (message.equals("sameuseralreadyexist")) {
                    JOptionPane.showMessageDialog(this, "same Email user alrady registered");

                } else if (message.equals("signupsuccess")) {
                    JOptionPane.showMessageDialog(this, "Sign up successfull .. !!!");
                }
                jTFemail1.setText("");
                jPasswordField1.setText("");
                jPasswordconfirm.setText("");
                jTFcontactnumber.setText("");
                jTFsecurityanswer.setText("");
                jCBsecurityquestion.setSelectedIndex(0);
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }//GEN-LAST:event_signuplbMouseClicked

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
            java.util.logging.Logger.getLogger(Usersignup.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Usersignup.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Usersignup.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Usersignup.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
//                new Usersignup().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> jCBsecurityquestion;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPasswordField jPasswordField1;
    private javax.swing.JPasswordField jPasswordconfirm;
    private javax.swing.JTextField jTFconfirmpassword;
    private javax.swing.JTextField jTFcontactnumber;
    private javax.swing.JTextField jTFemail1;
    private javax.swing.JTextField jTFsecurityanswer;
    private javax.swing.JTextField jTFsecurityquestion;
    private javax.swing.JLabel signuplb;
    // End of variables declaration//GEN-END:variables

}
