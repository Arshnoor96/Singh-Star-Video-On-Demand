
import java.awt.Image;
import java.io.File;
import java.sql.*;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;

public class Admin1 extends javax.swing.JFrame {

    public Admin1() {
        initComponents();

        try {

//            Image scaledimage = ImageIO.read(new File("C:\\Users\\Arshnoor Singh\\Desktop\\New folder\\login-button-png-8.png ")).getScaledInstance(lblogin.getWidth(), lblogin.getHeight(), Image.SCALE_SMOOTH);
//            ImageIcon img = new ImageIcon(scaledimage);
//            lblogin.setIcon(img);
//            Image scaledimage1 = ImageIO.read(new File("C:\\Users\\Arshnoor Singh\\Desktop\\New folder\\forgot password.png ")).getScaledInstance(forgetlb.getWidth(), forgetlb.getHeight(), Image.SCALE_SMOOTH);
//            ImageIcon img1 = new ImageIcon(scaledimage1);
//            forgetlb.setIcon(img1);
 try {
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
            SwingUtilities.updateComponentTreeUI(this);
        } catch (Exception ex) {
            ex.printStackTrace();
        }  
            Image scaledimage2 = ImageIO.read(new File("C:\\Users\\Arshnoor Singh\\Desktop\\New folder\\singh.jpg ")).getScaledInstance(lbicon.getWidth(), lbicon.getHeight(), Image.SCALE_SMOOTH);
            ImageIcon img2 = new ImageIcon(scaledimage2);
            lbicon.setIcon(img2);
            Image scaledimage3 = ImageIO.read(new File("C:\\Users\\Arshnoor Singh\\Desktop\\New folder\\back.jpg  ")).getScaledInstance(lbback.getWidth(), lbback.getHeight(), Image.SCALE_SMOOTH);
            ImageIcon img3 = new ImageIcon(scaledimage3);
            lbback.setIcon(img3);
        } catch (Exception e) {
        }
        this.setTitle("ADMIN LOGIN");
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        this.setSize(767,528);
        this.setLocation(60, 30);
        this.setResizable(false);
        this.setVisible(true);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lb1 = new javax.swing.JLabel();
        tfemail = new javax.swing.JTextField();
        lb2 = new javax.swing.JLabel();
        tfpassword = new javax.swing.JPasswordField();
        forgetlb = new javax.swing.JLabel();
        lb3 = new javax.swing.JLabel();
        lbicon1 = new javax.swing.JLabel();
        lbicon = new javax.swing.JLabel();
        lblogin = new javax.swing.JLabel();
        lbback = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        lb1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lb1.setForeground(new java.awt.Color(255, 153, 0));
        lb1.setText("E-Mail :");
        getContentPane().add(lb1);
        lb1.setBounds(150, 240, 130, 20);

        tfemail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfemailActionPerformed(evt);
            }
        });
        getContentPane().add(tfemail);
        tfemail.setBounds(260, 220, 330, 40);

        lb2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lb2.setForeground(new java.awt.Color(255, 153, 51));
        lb2.setText("Password :");
        getContentPane().add(lb2);
        lb2.setBounds(120, 320, 100, 20);
        getContentPane().add(tfpassword);
        tfpassword.setBounds(260, 310, 330, 40);

        forgetlb.setFont(new java.awt.Font("Tahoma", 1, 32)); // NOI18N
        forgetlb.setForeground(new java.awt.Color(255, 153, 0));
        forgetlb.setText("Forgot Password");
        forgetlb.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                forgetlbMouseClicked(evt);
            }
        });
        getContentPane().add(forgetlb);
        forgetlb.setBounds(420, 420, 270, 50);

        lb3.setFont(new java.awt.Font("Tahoma", 3, 54)); // NOI18N
        lb3.setForeground(new java.awt.Color(255, 153, 0));
        lb3.setText("SinghStar");
        getContentPane().add(lb3);
        lb3.setBounds(320, 0, 280, 130);

        lbicon1.setFont(new java.awt.Font("Tahoma", 3, 54)); // NOI18N
        lbicon1.setForeground(new java.awt.Color(255, 153, 0));
        lbicon1.setText("VOD");
        getContentPane().add(lbicon1);
        lbicon1.setBounds(390, 100, 200, 90);
        getContentPane().add(lbicon);
        lbicon.setBounds(100, 10, 200, 170);

        lblogin.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        lblogin.setForeground(new java.awt.Color(255, 153, 0));
        lblogin.setText("Login");
        lblogin.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbloginMouseClicked(evt);
            }
        });
        getContentPane().add(lblogin);
        lblogin.setBounds(250, 420, 130, 50);
        getContentPane().add(lbback);
        lbback.setBounds(0, 0, 770, 540);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void forgetlbMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_forgetlbMouseClicked
        String email = JOptionPane.showInputDialog(this, "enter your email id ");
        if (email.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Enter the email id");

        } else {
            try {
                Class.forName("com.mysql.jdbc.Driver");

                Connection conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/test", "root", "hello");

                Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);

                ResultSet rs = stmt.executeQuery("select * from Admin_login where email= '" + email + "'");
                System.out.println("ResultSet created");
    
                if (rs.next()) {
                    String sec_ques = rs.getString("securityquestion");
                    String ans = JOptionPane.showInputDialog(this, sec_ques);

                    if (ans.isEmpty()) {
                        JOptionPane.showMessageDialog(this, "Enter the security answer");
                    } else {
                        ResultSet rs1 = stmt.executeQuery("select * from Admin_login where email= '" + email + "' and securityanswer= '" + ans + "'");
                        if (rs1.next()) {
                            String pass = rs1.getString("password");
                            JOptionPane.showMessageDialog(this, "Your password is :    " + pass);
                        } else {
                            JOptionPane.showMessageDialog(this, "wrong answer");
                        }
                    }

                } else {

                    JOptionPane.showMessageDialog(this, "invalid email id");

                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }//GEN-LAST:event_forgetlbMouseClicked

    private void tfemailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfemailActionPerformed
 
    }//GEN-LAST:event_tfemailActionPerformed

    private void lbloginMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbloginMouseClicked
        String email = tfemail.getText();
        String password = tfpassword.getText();
        if (email.isEmpty()||password.isEmpty()) {
            JOptionPane.showMessageDialog(this, " Fill all fields are required !!");

        } else {
            try {
                Class.forName("com.mysql.jdbc.Driver");

                Connection conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/test", "root", "hello");

                Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);

                ResultSet rs = stmt.executeQuery("select * from Admin_login where email= '" + email + "'and password = '"+password+"'");
 
                if (rs.next()) {
                    JOptionPane.showMessageDialog(rootPane, "Login succesfull !!");
                    adminhome ah=new adminhome(email);
                    dispose();
                }
                else 
                    JOptionPane.showMessageDialog(rootPane, "Incorrect email or password !!");
                    
            } catch (Exception ex) {
                ex.printStackTrace();
            } }
    }//GEN-LAST:event_lbloginMouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Admin1().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel forgetlb;
    private javax.swing.JLabel lb1;
    private javax.swing.JLabel lb2;
    private javax.swing.JLabel lb3;
    private javax.swing.JLabel lbback;
    private javax.swing.JLabel lbicon;
    private javax.swing.JLabel lbicon1;
    private javax.swing.JLabel lblogin;
    private javax.swing.JTextField tfemail;
    private javax.swing.JPasswordField tfpassword;
    // End of variables declaration//GEN-END:variables
}
