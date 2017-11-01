import java.awt.Image;
import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class EditTVShow extends javax.swing.JInternalFrame {

int vid;

    public EditTVShow(int vid) {
        initComponents();
         this.vid = vid;
 
        this.setVisible(true);
        this.setSize(500, 500);
        try {

            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/test", "root", "hello");
            Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            ResultSet rs = stmt.executeQuery("select * from vid  where vid='" + vid + "' ");
            if (rs.next()) {

                jTFtitle.setText(rs.getString("title"));
                jTFdirector.setText(rs.getString("director"));
                jTFproducer.setText(rs.getString("producer"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

   

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTFtitle = new javax.swing.JTextField();
        jLabeltitle = new javax.swing.JLabel();
        jLabeldirector = new javax.swing.JLabel();
        jLabelproducer = new javax.swing.JLabel();
        jTFproducer = new javax.swing.JTextField();
        jTFdirector = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jBtupdatemovie = new javax.swing.JButton();

        getContentPane().setLayout(null);
        getContentPane().add(jTFtitle);
        jTFtitle.setBounds(160, 90, 280, 20);

        jLabeltitle.setText("Title");
        getContentPane().add(jLabeltitle);
        jLabeltitle.setBounds(80, 90, 60, 20);

        jLabeldirector.setText("Director");
        getContentPane().add(jLabeldirector);
        jLabeldirector.setBounds(80, 130, 60, 14);

        jLabelproducer.setText("Producer");
        getContentPane().add(jLabelproducer);
        jLabelproducer.setBounds(80, 170, 60, 14);
        getContentPane().add(jTFproducer);
        jTFproducer.setBounds(160, 170, 280, 20);
        getContentPane().add(jTFdirector);
        jTFdirector.setBounds(160, 130, 280, 20);

        jLabel7.setText("Edit TVShow");
        getContentPane().add(jLabel7);
        jLabel7.setBounds(240, 10, 160, 50);

        jBtupdatemovie.setText("Update Movie");
        jBtupdatemovie.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtupdatemovieActionPerformed(evt);
            }
        });
        getContentPane().add(jBtupdatemovie);
        jBtupdatemovie.setBounds(190, 220, 220, 40);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jBtupdatemovieActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtupdatemovieActionPerformed
        try {
            String title = jTFtitle.getText();
            String pro = jTFproducer.getText();
            String dir = jTFdirector.getText();

            if (title == null || pro == null || dir == null) {
                JOptionPane.showMessageDialog(this, "Enter the required fields");
            } else {

                Class.forName("com.mysql.jdbc.Driver");
                Connection conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/test", "root", "hello");
                Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
                ResultSet rs = stmt.executeQuery("select * from vid  where vid='" + vid + "' ");
                if (rs.next()) {

                    rs.updateString("title", title);
                    rs.updateString("producer", pro);
                    rs.updateString("director", dir);
                    rs.updateRow();
                    JOptionPane.showMessageDialog(rootPane, "Movie Detail Updated Successfully");
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_jBtupdatemovieActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBtupdatemovie;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabeldirector;
    private javax.swing.JLabel jLabelproducer;
    private javax.swing.JLabel jLabeltitle;
    private javax.swing.JTextField jTFdirector;
    private javax.swing.JTextField jTFproducer;
    private javax.swing.JTextField jTFtitle;
    // End of variables declaration//GEN-END:variables
}
