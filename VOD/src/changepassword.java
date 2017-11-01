
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;

public class changepassword extends javax.swing.JInternalFrame {

    String email;

    public changepassword(String email) {
        initComponents();
        this.setVisible(true);
        this.setSize(700, 800);
        this.email = email;

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTFnewpassword = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        psf = new javax.swing.JPasswordField();
        osf = new javax.swing.JPasswordField();
        csf = new javax.swing.JPasswordField();

        getContentPane().setLayout(null);

        jLabel1.setText("Old Password");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(30, 40, 160, 50);

        jLabel2.setText("New password");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(30, 100, 110, 50);

        jLabel3.setText("Confirm Password");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(30, 160, 140, 50);

        jButton1.setText("Change Password");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1);
        jButton1.setBounds(160, 240, 180, 40);
        getContentPane().add(psf);
        psf.setBounds(150, 110, 190, 40);
        getContentPane().add(osf);
        osf.setBounds(150, 50, 190, 40);
        getContentPane().add(csf);
        csf.setBounds(150, 170, 190, 40);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        String oldpassword = osf.getText();

        String newpassword = psf.getText();
        String confirmpassword = csf.getText();
        if (oldpassword == null || newpassword == null || confirmpassword == null) {
            JOptionPane.showMessageDialog(this, "Enter the Current valid password");
        }
        if (!(confirmpassword.equals(newpassword))) {
            JOptionPane.showMessageDialog(this, "new password and confirm password not match");
        } else {
            try {

                Class.forName("com.mysql.jdbc.Driver");

                Connection conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/test", "root", "hello");

                Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);

                ResultSet rs = stmt.executeQuery("select * from Admin_login where password='" + oldpassword + "' and email='" + this.email + "'");
                System.out.println("ResultSet created");

                if (rs.next()) {
                    rs.updateString("password", newpassword);
                    rs.updateRow();
                    JOptionPane.showMessageDialog(this, "Password Changed");
                    osf.setText("");
                    psf.setText("");
                    csf.setText("");
                } else {
                    JOptionPane.showMessageDialog(this, "Invalid old password");
                }

            } catch (Exception ex) {
                ex.printStackTrace();
            }

        }


    }//GEN-LAST:event_jButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPasswordField csf;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JTextField jTFnewpassword;
    private javax.swing.JPasswordField osf;
    private javax.swing.JPasswordField psf;
    // End of variables declaration//GEN-END:variables
}
