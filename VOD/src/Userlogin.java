
import java.awt.Image;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.net.Socket;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.imageio.ImageIO;
import javax.swing.JOptionPane;
import javax.swing.*;
import static javax.swing.WindowConstants.DISPOSE_ON_CLOSE;

public class Userlogin extends javax.swing.JFrame {

    Socket socket;
    DataInputStream dis;
    DataOutputStream dos;
    String email;

    public Userlogin(Socket socket) {
        initComponents();
        this.socket = socket;
        try {
            dos = new DataOutputStream((socket.getOutputStream()));
            dis = new DataInputStream((socket.getInputStream()));
        } catch (Exception e) {
            e.printStackTrace();
        }

     
        try {
            
//            Image scaledimage = ImageIO.read(new File("E:\\Movies\\Buttons\\login button.png")).getScaledInstance(loginlb.getWidth(), loginlb.getHeight(), Image.SCALE_SMOOTH);
//            ImageIcon img = new ImageIcon(scaledimage);
//            loginlb.setIcon(img);
//            Image scaledimage1 = ImageIO.read(new File("E:\\Movies\\Buttons\\Forgot password button.png")).getScaledInstance(forgetlb.getWidth(), forgetlb.getHeight(), Image.SCALE_SMOOTH);
//            ImageIcon img1 = new ImageIcon(scaledimage1);
//            forgetlb.setIcon(img1);
            Image scaledimage2 = ImageIO.read(new File("C:\\Users\\Arshnoor Singh\\Desktop\\New folder\\back.jpg ")).getScaledInstance(lbback.getWidth(), lbback.getHeight(), Image.SCALE_SMOOTH);
            ImageIcon img2 = new ImageIcon(scaledimage2);
            lbback.setIcon(img2);
            Image scaledimage3 = ImageIO.read(new File("C:\\Users\\Arshnoor Singh\\Desktop\\New folder\\singh.jpg ")).getScaledInstance(lbicon.getWidth(), lbicon.getHeight(), Image.SCALE_SMOOTH);
            ImageIcon img3 = new ImageIcon(scaledimage3);
            lbicon.setIcon(img3);
        } catch (Exception e) {
        }
        this.setTitle("USER LOGIN");
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        this.setSize(600, 500);
        this.setVisible(true);

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        emailtf = new javax.swing.JTextField();
        passwordtf = new javax.swing.JPasswordField();
        loginlb = new javax.swing.JLabel();
        forgetlb = new javax.swing.JLabel();
        lbicon = new javax.swing.JLabel();
        lb3 = new javax.swing.JLabel();
        lbicon1 = new javax.swing.JLabel();
        lbback = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 153, 0));
        jLabel1.setText("Password :");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(60, 240, 120, 40);

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 153, 0));
        jLabel2.setText("E-mail :");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(90, 180, 90, 40);
        getContentPane().add(emailtf);
        emailtf.setBounds(180, 180, 290, 40);

        passwordtf.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                passwordtfActionPerformed(evt);
            }
        });
        getContentPane().add(passwordtf);
        passwordtf.setBounds(180, 240, 290, 40);

        loginlb.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        loginlb.setForeground(new java.awt.Color(255, 153, 0));
        loginlb.setText("Login");
        loginlb.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                loginlbMouseClicked(evt);
            }
        });
        getContentPane().add(loginlb);
        loginlb.setBounds(190, 310, 110, 60);

        forgetlb.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        forgetlb.setForeground(new java.awt.Color(255, 153, 0));
        forgetlb.setText("Forgot Password");
        forgetlb.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                forgetlbMouseClicked(evt);
            }
        });
        getContentPane().add(forgetlb);
        forgetlb.setBounds(320, 310, 150, 60);
        getContentPane().add(lbicon);
        lbicon.setBounds(30, 10, 200, 150);

        lb3.setFont(new java.awt.Font("Tahoma", 3, 54)); // NOI18N
        lb3.setForeground(new java.awt.Color(255, 153, 0));
        lb3.setText("Welcome");
        getContentPane().add(lb3);
        lb3.setBounds(250, 0, 280, 120);

        lbicon1.setFont(new java.awt.Font("Tahoma", 3, 54)); // NOI18N
        lbicon1.setForeground(new java.awt.Color(255, 153, 0));
        lbicon1.setText("User");
        getContentPane().add(lbicon1);
        lbicon1.setBounds(320, 70, 200, 90);
        getContentPane().add(lbback);
        lbback.setBounds(0, 0, 670, 430);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void loginlbMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_loginlbMouseClicked
 
        try {
            email = emailtf.getText();
            String password = passwordtf.getText();
            if (email.isEmpty() || password.isEmpty()) {
                JOptionPane.showMessageDialog(this, "enter the email and password");
            } else {
                dos.writeBytes("login\r\n");
                dos.writeBytes(email + "\r\n");
                dos.writeBytes(password + "\r\n");
                System.out.println("request sent");
                String message = dis.readLine();
                System.out.println(message);
                if (message.equals("success")) {
                    Userhome uh = new Userhome(socket, email);
                    uh.setVisible(true);
                    dispose();
                } else if (message.equals("fail")) {
                    JOptionPane.showMessageDialog(this, "Login fail");
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_loginlbMouseClicked

    private void forgetlbMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_forgetlbMouseClicked
String email = JOptionPane.showInputDialog(this, "enter your email id ");
        try {
            if (email.isEmpty()) {
                JOptionPane.showMessageDialog(this, "enter the email first");
            } else {
                dos.writeBytes("forgetpassword\r\n");
                dos.writeBytes(email + "\r\n");
                String message = dis.readLine();
                if (message.equals("emailsuccess")) {
                    String sec_ques = dis.readLine();
                    String sec_ans = JOptionPane.showInputDialog(this, sec_ques);
                    dos.writeBytes(sec_ans + "\r\n");
                    String response = dis.readLine();
                    if (response.equals("answercorrect")) {
                        JOptionPane.showMessageDialog(rootPane, "your password is " + dis.readLine());

                    } else if (response.equals("wronganswer")) {
                        JOptionPane.showMessageDialog(rootPane, "wrong answer for password");
                    }
                } else if (message.equals("wrongemail")) {
                    JOptionPane.showMessageDialog(rootPane, "wrong Email");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

       
    }//GEN-LAST:event_forgetlbMouseClicked

    private void passwordtfActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_passwordtfActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_passwordtfActionPerformed
  
    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField emailtf;
    private javax.swing.JLabel forgetlb;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel lb3;
    private javax.swing.JLabel lbback;
    private javax.swing.JLabel lbicon;
    private javax.swing.JLabel lbicon1;
    private javax.swing.JLabel loginlb;
    private javax.swing.JPasswordField passwordtf;
    // End of variables declaration//GEN-END:variables
}
