
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

public class Editmovie extends javax.swing.JInternalFrame {

    int vid;
    String vpath;
    String tpath;

    public Editmovie(int vid) {
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
                jTFvideopath.setText(rs.getString("video_path"));
                jTFtrailerpath.setText(rs.getString("trailer_path"));
                jTFdirector.setText(rs.getString("director"));
                jTFproducer.setText(rs.getString("producer"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTFname = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTAdescription = new javax.swing.JTextArea();
        jBtbrowse = new javax.swing.JButton();
        jBtupdate = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jPanelmovies = new javax.swing.JPanel();
        jLabeltitle = new javax.swing.JLabel();
        jLabelvideopath = new javax.swing.JLabel();
        jLabelTrailerapath = new javax.swing.JLabel();
        jLabeldirector = new javax.swing.JLabel();
        jLabelproducer = new javax.swing.JLabel();
        jTFtitle = new javax.swing.JTextField();
        jTFdirector = new javax.swing.JTextField();
        jTFproducer = new javax.swing.JTextField();
        jBtvideopath = new javax.swing.JButton();
        jBttarilerpath = new javax.swing.JButton();
        jTFvideopath = new javax.swing.JTextField();
        jTFtrailerpath = new javax.swing.JTextField();
        jLbreleasingdate = new javax.swing.JLabel();
        jComboBoxdate = new javax.swing.JComboBox<>();
        jComboBoxmonth = new javax.swing.JComboBox<>();
        jComboBoxyear = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jBtupdatemovie = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();

        jTFname.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTFnameActionPerformed(evt);
            }
        });

        jTAdescription.setColumns(20);
        jTAdescription.setRows(5);
        jScrollPane1.setViewportView(jTAdescription);

        jBtbrowse.setText("Browse");
        jBtbrowse.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtbrowseActionPerformed(evt);
            }
        });

        jBtupdate.setText("Update");
        jBtupdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtupdateActionPerformed(evt);
            }
        });

        jLabel3.setText("Category Photo");

        jLabel2.setText("Category Description");

        jLabel1.setText("Category Name");

        getContentPane().setLayout(null);

        jPanelmovies.setLayout(null);

        jLabeltitle.setText("Title");
        jPanelmovies.add(jLabeltitle);
        jLabeltitle.setBounds(10, 14, 47, 14);

        jLabelvideopath.setText("Video path");
        jPanelmovies.add(jLabelvideopath);
        jLabelvideopath.setBounds(0, 50, 70, 14);

        jLabelTrailerapath.setText("trailer path");
        jPanelmovies.add(jLabelTrailerapath);
        jLabelTrailerapath.setBounds(0, 90, 70, 14);

        jLabeldirector.setText("Director");
        jPanelmovies.add(jLabeldirector);
        jLabeldirector.setBounds(0, 140, 60, 14);

        jLabelproducer.setText("Producer");
        jPanelmovies.add(jLabelproducer);
        jLabelproducer.setBounds(0, 180, 60, 14);
        jPanelmovies.add(jTFtitle);
        jTFtitle.setBounds(80, 10, 280, 20);
        jPanelmovies.add(jTFdirector);
        jTFdirector.setBounds(80, 140, 280, 20);
        jPanelmovies.add(jTFproducer);
        jTFproducer.setBounds(80, 170, 280, 20);

        jBtvideopath.setText("Browse");
        jBtvideopath.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtvideopathActionPerformed(evt);
            }
        });
        jPanelmovies.add(jBtvideopath);
        jBtvideopath.setBounds(280, 50, 80, 20);

        jBttarilerpath.setText("Browse");
        jBttarilerpath.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBttarilerpathActionPerformed(evt);
            }
        });
        jPanelmovies.add(jBttarilerpath);
        jBttarilerpath.setBounds(280, 90, 80, 20);
        jPanelmovies.add(jTFvideopath);
        jTFvideopath.setBounds(80, 50, 190, 20);
        jPanelmovies.add(jTFtrailerpath);
        jTFtrailerpath.setBounds(80, 90, 190, 20);

        jLbreleasingdate.setText("Releasing date");
        jPanelmovies.add(jLbreleasingdate);
        jLbreleasingdate.setBounds(0, 220, 120, 14);

        jComboBoxdate.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] {
            "1",
            "2",
            "3",
            "4",
            "5",
            "6",
            "7",
            "8",
            "9",
            "10",
            "11",
            "12",
            "13",
            "14",
            "15",
            "16",
            "17",
            "18",
            "19",
            "20",
            "21",
            "22",
            "23",
            "24",
            "25",
            "26",
            "27",
            "28",
            "29",
            "30",
            "31"
        }));
        jPanelmovies.add(jComboBoxdate);
        jComboBoxdate.setBounds(140, 220, 60, 20);

        jComboBoxmonth.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] {
            "1",
            "2",
            "3",
            "4",
            "5",
            "6",
            "7",
            "8",
            "9",
            "10",
            "11",
            "12"}));
jPanelmovies.add(jComboBoxmonth);
jComboBoxmonth.setBounds(220, 220, 60, 20);

jComboBoxyear.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] {
    "2014",
    "2015",
    "2016",
    "2017",
    "2018",
    "2019",
    "2020"
    }));
    jPanelmovies.add(jComboBoxyear);
    jComboBoxyear.setBounds(300, 220, 60, 20);

    jLabel4.setText("date");
    jPanelmovies.add(jLabel4);
    jLabel4.setBounds(160, 200, 60, 14);

    jLabel5.setText("month");
    jPanelmovies.add(jLabel5);
    jLabel5.setBounds(230, 200, 60, 14);

    jLabel6.setText("year");
    jPanelmovies.add(jLabel6);
    jLabel6.setBounds(320, 200, 50, 14);

    jBtupdatemovie.setText("Update Movie");
    jBtupdatemovie.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            jBtupdatemovieActionPerformed(evt);
        }
    });
    jPanelmovies.add(jBtupdatemovie);
    jBtupdatemovie.setBounds(120, 253, 220, 40);

    getContentPane().add(jPanelmovies);
    jPanelmovies.setBounds(20, 50, 530, 360);

    jLabel7.setText("Edit Movie");
    getContentPane().add(jLabel7);
    jLabel7.setBounds(250, 0, 160, 50);

    pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTFnameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTFnameActionPerformed
//        jTFname.setEnabled(false);
    }//GEN-LAST:event_jTFnameActionPerformed

    private void jBtbrowseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtbrowseActionPerformed

    }//GEN-LAST:event_jBtbrowseActionPerformed

    private void jBtupdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtupdateActionPerformed


    }//GEN-LAST:event_jBtupdateActionPerformed

    private void jBtvideopathActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtvideopathActionPerformed
        JFileChooser ch1 = new JFileChooser("c:\\");
        int ans = ch1.showOpenDialog(this);
        if (ans == JFileChooser.APPROVE_OPTION) {
            File f = ch1.getSelectedFile();
            vpath = f.getPath();
            jTFvideopath.setText(vpath);

        }
    }//GEN-LAST:event_jBtvideopathActionPerformed

    private void jBttarilerpathActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBttarilerpathActionPerformed
        JFileChooser ch2 = new JFileChooser("c:\\");
        int ans = ch2.showOpenDialog(this);
        if (ans == JFileChooser.APPROVE_OPTION) {
            File f = ch2.getSelectedFile();
            tpath = f.getPath();
            jTFtrailerpath.setText(tpath);

        }
    }//GEN-LAST:event_jBttarilerpathActionPerformed

    private void jBtupdatemovieActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtupdatemovieActionPerformed
        try {
            String title = jTFtitle.getText();
            String vidpath = jTFvideopath.getText();
            String trapath = jTFtrailerpath.getText();
            String pro = jTFproducer.getText();
            String dir = jTFdirector.getText();
            String date = (String) jComboBoxdate.getSelectedItem();
            String month = (String) jComboBoxmonth.getSelectedItem();
            String year = (String) jComboBoxyear.getSelectedItem();
            String releasedate = date + "-" + month + "-" + year;

            if (title == null || vidpath == null || trapath == null || pro == null || dir == null) {
                JOptionPane.showMessageDialog(this, "Enter the required fields");
            } else {

                Class.forName("com.mysql.jdbc.Driver");
                Connection conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/test", "root", "hello");
                Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
                ResultSet rs = stmt.executeQuery("select * from vid  where vid='" + vid + "' ");
                if (rs.next()) {

                    rs.updateString("title", title);
                    rs.updateString("video_path", vidpath);
                    rs.updateString("trailer_path", trapath);
                    rs.updateString("producer", pro);
                    rs.updateString("director", dir);
                    rs.updateString("release_date", releasedate);
                    rs.updateRow();
                    JOptionPane.showMessageDialog(rootPane, "Movie Detail Updated Successfully");
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_jBtupdatemovieActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBtbrowse;
    private javax.swing.JButton jBttarilerpath;
    private javax.swing.JButton jBtupdate;
    private javax.swing.JButton jBtupdatemovie;
    private javax.swing.JButton jBtvideopath;
    private javax.swing.JComboBox<String> jComboBoxdate;
    private javax.swing.JComboBox<String> jComboBoxmonth;
    private javax.swing.JComboBox<String> jComboBoxyear;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabelTrailerapath;
    private javax.swing.JLabel jLabeldirector;
    private javax.swing.JLabel jLabelproducer;
    private javax.swing.JLabel jLabeltitle;
    private javax.swing.JLabel jLabelvideopath;
    private javax.swing.JLabel jLbreleasingdate;
    private javax.swing.JPanel jPanelmovies;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTAdescription;
    private javax.swing.JTextField jTFdirector;
    private javax.swing.JTextField jTFname;
    private javax.swing.JTextField jTFproducer;
    private javax.swing.JTextField jTFtitle;
    private javax.swing.JTextField jTFtrailerpath;
    private javax.swing.JTextField jTFvideopath;
    // End of variables declaration//GEN-END:variables
}
