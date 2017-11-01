
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JFileChooser;
import java.io.*;
import java.awt.Image;
import java.awt.font.NumericShaper;
import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

public class Editepisode extends javax.swing.JInternalFrame {

    JFileChooser ch1;
    JFileChooser ch2;
    int eid;

    String cpath;
    String spath;
    String vpath;

    public Editepisode(int eid) {
        this.eid = eid;
        initComponents();

        try {

            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/test", "root", "hello");
            Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            ResultSet rs = stmt.executeQuery("select * from episode  where epid='" + eid + "' ");
            if (rs.next()) {

                jTFepisodename.setText(rs.getString("episode_name"));
                jTFepisodevideopath.setText(rs.getString("video_path"));
                jTAepisodedesc.setText(rs.getString("description"));
                Tfcover.setText(rs.getString("episode_cover_photo"));
                squareTf.setText(rs.getString("episode_square_photo"));
                jTFduration.setText(rs.getString("duration"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        this.setVisible(true);
        this.setSize(500, 500);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLbepisodecoverphoto = new javax.swing.JLabel();
        jTFepisodename = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTAepisodedesc = new javax.swing.JTextArea();
        jLabel6 = new javax.swing.JLabel();
        jTFduration = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        jTFepisodevideopath = new javax.swing.JTextField();
        jBtupdateepisode = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        Tfcover = new javax.swing.JTextField();
        squareTf = new javax.swing.JTextField();

        getContentPane().setLayout(null);
        getContentPane().add(jTFepisodename);
        jTFepisodename.setBounds(240, 60, 360, 20);

        jLabel2.setText("Episode name");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(110, 60, 100, 14);

        jLabel3.setText("Episode Cover Photo");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(110, 120, 110, 20);

        jButton1.setText("Browse");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1);
        jButton1.setBounds(240, 140, 80, 23);

        jLabel4.setText("Episode Square Photo");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(110, 190, 110, 14);

        jButton2.setText("Browse");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2);
        jButton2.setBounds(240, 210, 80, 23);

        jLabel5.setText("Episode Description");
        getContentPane().add(jLabel5);
        jLabel5.setBounds(110, 270, 100, 14);

        jTAepisodedesc.setColumns(20);
        jTAepisodedesc.setRows(5);
        jScrollPane1.setViewportView(jTAepisodedesc);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(240, 270, 360, 80);

        jLabel6.setText("Episode Duration");
        getContentPane().add(jLabel6);
        jLabel6.setBounds(110, 380, 100, 14);
        getContentPane().add(jTFduration);
        jTFduration.setBounds(240, 380, 360, 20);

        jLabel1.setText("Episode Video Path");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(110, 430, 100, 14);

        jButton3.setText("Browse");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton3);
        jButton3.setBounds(240, 430, 67, 23);
        getContentPane().add(jTFepisodevideopath);
        jTFepisodevideopath.setBounds(340, 430, 260, 20);

        jBtupdateepisode.setText("Update Episode");
        jBtupdateepisode.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtupdateepisodeActionPerformed(evt);
            }
        });
        getContentPane().add(jBtupdateepisode);
        jBtupdateepisode.setBounds(290, 480, 170, 50);

        jLabel7.setText("Edit Episode");
        getContentPane().add(jLabel7);
        jLabel7.setBounds(310, 10, 140, 14);
        getContentPane().add(Tfcover);
        Tfcover.setBounds(380, 130, 150, 20);
        getContentPane().add(squareTf);
        squareTf.setBounds(380, 210, 160, 20);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        JFileChooser ch1 = new JFileChooser("D:\\abheyjeet\\Pixxoooo");
        int ans = ch1.showOpenDialog(this);
        if (ans == JFileChooser.APPROVE_OPTION) {
            File f = ch1.getSelectedFile();
            cpath = f.getPath();
            Tfcover.setText(cpath);
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        JFileChooser ch1 = new JFileChooser("D:\\abheyjeet\\Pixxoooo");
        int ans = ch1.showOpenDialog(this);
        if (ans == JFileChooser.APPROVE_OPTION) {
            File f = ch1.getSelectedFile();
            spath = f.getPath();
            squareTf.setText(spath);
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        JFileChooser ch1 = new JFileChooser("D:\\Movies\\Hollywood");
        int ans = ch1.showOpenDialog(this);
        if (ans == JFileChooser.APPROVE_OPTION) {
            File f = ch1.getSelectedFile();
            vpath = f.getPath();
            jLbepisodecoverphoto.setText(vpath);
        }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jBtupdateepisodeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtupdateepisodeActionPerformed
        try {
            String ename = jTFepisodename.getText();
            String edesc = jTAepisodedesc.getText();
            String edur = jTFduration.getText();
            String evidpath = jTFepisodevideopath.getText();
            String ecphoto = Tfcover.getText();
            String esphoto = squareTf.getText();
            if (ename == null || edesc == null || edur == null || evidpath == null) {
                JOptionPane.showMessageDialog(this, "All fields required enter again");
            } else {

                Class.forName("com.mysql.jdbc.Driver");

                Connection conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/test", "root", "hello");

                Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);

                ResultSet rs = stmt.executeQuery("select * from episode where epid='" + eid + "'");
                System.out.println("ResultSet created");

                if (rs.next()) {

                    rs.updateString("episode_name", ename);
                    rs.updateString("episode_cover_photo", ecphoto);
                    rs.updateString("episode_square_photo", esphoto);
                    rs.updateString("duration", edur);
                    rs.updateString("video_path", evidpath);
                    rs.updateString("description", edesc);

                    rs.updateRow();

                    JOptionPane.showMessageDialog(this, "Episode Updated Successfully . . !!!");

                }
                else{
                    
                    JOptionPane.showMessageDialog(this, "Error In updating episode");
                }

            }
        } catch (Exception e) {
        }

    }//GEN-LAST:event_jBtupdateepisodeActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField Tfcover;
    private javax.swing.JButton jBtupdateepisode;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLbepisodecoverphoto;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTAepisodedesc;
    private javax.swing.JTextField jTFduration;
    private javax.swing.JTextField jTFepisodename;
    private javax.swing.JTextField jTFepisodevideopath;
    private javax.swing.JTextField squareTf;
    // End of variables declaration//GEN-END:variables
}
