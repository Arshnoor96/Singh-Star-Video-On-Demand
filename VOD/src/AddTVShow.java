
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
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

import javax.swing.JOptionPane;

public class AddTVShow extends javax.swing.JInternalFrame {

    JFileChooser ch1;
    JFileChooser ch2;
    String cname = "";

    public AddTVShow() {
        initComponents();

        jPanelmovies.setVisible(false);
        jPaneltvshows.setVisible(false);
        jBtmov.setVisible(false);

        ch1 = new JFileChooser("G:\\Movies\\");
        ch2 = new JFileChooser("G:\\Movies\\");

        this.setVisible(true);
        this.setSize(500, 500);

        try {

            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/test", "root", "hello");
            Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            ResultSet rs = stmt.executeQuery("select * from category ");
            jCbsc.addItem("--select category--");
            while (rs.next()) {
                jCbsc.addItem(rs.getString("name"));

            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPaneltvshows = new javax.swing.JPanel();
        jLabeldirector1 = new javax.swing.JLabel();
        jTFdirector1 = new javax.swing.JTextField();
        jTFproducer1 = new javax.swing.JTextField();
        jLabelproducer1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jBttvshows = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        covertf = new javax.swing.JTextField();
        squaretf = new javax.swing.JTextField();
        coverbt = new javax.swing.JButton();
        squarebt = new javax.swing.JButton();
        tfgenre = new javax.swing.JTextField();
        jLabelproducer2 = new javax.swing.JLabel();
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
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jBtmov = new javax.swing.JButton();
        jCbsc = new javax.swing.JComboBox<>();
        jLbselectcategory = new javax.swing.JLabel();

        getContentPane().setLayout(null);

        jPaneltvshows.setLayout(null);

        jLabeldirector1.setText("Director");
        jPaneltvshows.add(jLabeldirector1);
        jLabeldirector1.setBounds(10, 50, 60, 16);
        jPaneltvshows.add(jTFdirector1);
        jTFdirector1.setBounds(80, 50, 260, 22);
        jPaneltvshows.add(jTFproducer1);
        jTFproducer1.setBounds(80, 90, 260, 22);

        jLabelproducer1.setText("Producer");
        jPaneltvshows.add(jLabelproducer1);
        jLabelproducer1.setBounds(10, 90, 70, 16);

        jLabel2.setText("Title");
        jPaneltvshows.add(jLabel2);
        jLabel2.setBounds(10, 10, 65, 20);
        jPaneltvshows.add(jTextField1);
        jTextField1.setBounds(79, 11, 260, 22);

        jBttvshows.setText("Add TV Shows");
        jBttvshows.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBttvshowsActionPerformed(evt);
            }
        });
        jPaneltvshows.add(jBttvshows);
        jBttvshows.setBounds(100, 330, 240, 50);

        jLabel1.setText("Cover Photo");
        jPaneltvshows.add(jLabel1);
        jLabel1.setBounds(20, 230, 70, 16);

        jLabel6.setText("Square Photo");
        jPaneltvshows.add(jLabel6);
        jLabel6.setBounds(20, 270, 77, 16);
        jPaneltvshows.add(covertf);
        covertf.setBounds(100, 230, 180, 22);
        jPaneltvshows.add(squaretf);
        squaretf.setBounds(100, 270, 180, 22);

        coverbt.setText("Browse");
        coverbt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                coverbtActionPerformed(evt);
            }
        });
        jPaneltvshows.add(coverbt);
        coverbt.setBounds(310, 230, 75, 25);

        squarebt.setText("Browse");
        squarebt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                squarebtActionPerformed(evt);
            }
        });
        jPaneltvshows.add(squarebt);
        squarebt.setBounds(310, 270, 75, 25);
        jPaneltvshows.add(tfgenre);
        tfgenre.setBounds(80, 150, 260, 22);

        jLabelproducer2.setText("Genre");
        jPaneltvshows.add(jLabelproducer2);
        jLabelproducer2.setBounds(0, 150, 70, 16);

        getContentPane().add(jPaneltvshows);
        jPaneltvshows.setBounds(400, 70, 370, 420);

        jPanelmovies.setLayout(null);

        jLabeltitle.setText("Title");
        jPanelmovies.add(jLabeltitle);
        jLabeltitle.setBounds(20, 10, 47, 16);

        jLabelvideopath.setText("Video path");
        jPanelmovies.add(jLabelvideopath);
        jLabelvideopath.setBounds(10, 50, 70, 16);

        jLabelTrailerapath.setText("trailer path");
        jPanelmovies.add(jLabelTrailerapath);
        jLabelTrailerapath.setBounds(10, 90, 70, 16);

        jLabeldirector.setText("Director");
        jPanelmovies.add(jLabeldirector);
        jLabeldirector.setBounds(10, 140, 60, 16);

        jLabelproducer.setText("Producer");
        jPanelmovies.add(jLabelproducer);
        jLabelproducer.setBounds(10, 180, 60, 16);
        jPanelmovies.add(jTFtitle);
        jTFtitle.setBounds(80, 10, 280, 22);
        jPanelmovies.add(jTFdirector);
        jTFdirector.setBounds(80, 140, 280, 22);
        jPanelmovies.add(jTFproducer);
        jTFproducer.setBounds(80, 170, 280, 22);

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
        jTFvideopath.setBounds(80, 50, 190, 22);
        jPanelmovies.add(jTFtrailerpath);
        jTFtrailerpath.setBounds(80, 90, 190, 22);

        jLbreleasingdate.setText("Releasing date");
        jPanelmovies.add(jLbreleasingdate);
        jLbreleasingdate.setBounds(10, 220, 120, 16);

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
        jComboBoxdate.setBounds(140, 220, 60, 22);

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
jComboBoxmonth.setBounds(220, 220, 60, 22);

jComboBoxyear.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] {
    "2014",
    "2015",
    "2016",
    "2017"
    }));
    jPanelmovies.add(jComboBoxyear);
    jComboBoxyear.setBounds(300, 220, 60, 22);

    jLabel3.setText("date");
    jPanelmovies.add(jLabel3);
    jLabel3.setBounds(160, 200, 60, 16);

    jLabel4.setText("month");
    jPanelmovies.add(jLabel4);
    jLabel4.setBounds(230, 200, 60, 16);

    jLabel5.setText("year");
    jPanelmovies.add(jLabel5);
    jLabel5.setBounds(320, 200, 50, 16);

    jBtmov.setText("Add Movie");
    jBtmov.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            jBtmovActionPerformed(evt);
        }
    });
    jPanelmovies.add(jBtmov);
    jBtmov.setBounds(120, 253, 220, 40);

    getContentPane().add(jPanelmovies);
    jPanelmovies.setBounds(10, 70, 390, 310);

    jCbsc.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] {  }));
    jCbsc.addItemListener(new java.awt.event.ItemListener() {
        public void itemStateChanged(java.awt.event.ItemEvent evt) {
            jCbscItemStateChanged(evt);
        }
    });
    jCbsc.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            jCbscActionPerformed(evt);
        }
    });
    getContentPane().add(jCbsc);
    jCbsc.setBounds(330, 20, 240, 22);

    jLbselectcategory.setText("Select category");
    getContentPane().add(jLbselectcategory);
    jLbselectcategory.setBounds(140, 10, 150, 40);

    pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jBttvshowsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBttvshowsActionPerformed
        try {

            String title = jTextField1.getText();
            String pro = jTFproducer1.getText();
            String dir = jTFdirector1.getText();
            String cvphoto =covertf.getText();
            String sqphoto=squaretf.getText();
            String genre =tfgenre.getText();
            
//            String date = (String) jComboBoxdate.getSelectedItem();
//            String month = (String) jComboBoxmonth.getSelectedItem();
//            String year = (String) jComboBoxyear.getSelectedItem();
//            String releasedate = date + "-" + month + "-" + year;

            if (title == null || pro == null || dir == null) {
                JOptionPane.showMessageDialog(this, "Enter the required fields");
            } else {
                Class.forName("com.mysql.jdbc.Driver");
                Connection conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/test", "root", "hello");
                Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
                ResultSet rs = stmt.executeQuery("select * from vid where title='" + title + "' ");
                if (rs.next()) {
                    JOptionPane.showMessageDialog(this, "Tv Show already Exists!!");
                } else {

                    rs.moveToInsertRow();
                    rs.updateString("title", title);
                    rs.updateString("producer", pro);
                    rs.updateString("director", dir);
                    rs.updateString("cover_photo", cvphoto);
                    rs.updateString("square_photo", sqphoto);
                    rs.updateString("trailer_path", "");
                    rs.updateString("video_path", "");
                    rs.updateString("release_date", "");
                    rs.updateString("genre", genre);
                    rs.updateString("cname", cname);

                    rs.insertRow();
                    JOptionPane.showMessageDialog(this, "Tv Show added successfully!!");
                    jTextField1.setText("");

                    jTFdirector1.setText("");
                    jTFproducer1.setText("");
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_jBttvshowsActionPerformed

    private void jBtvideopathActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtvideopathActionPerformed

        int ans = ch1.showOpenDialog(this);
        if (ans == JFileChooser.APPROVE_OPTION) {
            File f = ch1.getSelectedFile();
            String path = f.getPath();
            jTFvideopath.setText(path);

        }
    }//GEN-LAST:event_jBtvideopathActionPerformed

    private void jBttarilerpathActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBttarilerpathActionPerformed
        int ans = ch2.showOpenDialog(this);
        if (ans == JFileChooser.APPROVE_OPTION) {
            File f = ch2.getSelectedFile();
            String path = f.getPath();
            jTFtrailerpath.setText(path);

        }
    }//GEN-LAST:event_jBttarilerpathActionPerformed

    private void jBtmovActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtmovActionPerformed
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
                cname = jCbsc.getSelectedItem().toString();
                Class.forName("com.mysql.jdbc.Driver");
                Connection conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/test", "root", "hello");
                Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
                ResultSet rs = stmt.executeQuery("select * from vid where title='" + title + "' ");
                if (rs.next()) {
                    JOptionPane.showMessageDialog(this, "Same Entitled Movie Already Exists");
                } else {
                    rs.moveToInsertRow();
                    rs.updateString("title", title);
                    rs.updateString("video_path", vidpath);
                    rs.updateString("trailer_path", trapath);
                    rs.updateString("producer", pro);
                    rs.updateString("director", dir);
                    rs.updateString("cname", cname);
                    rs.updateString("release_date", releasedate);

                    rs.insertRow();
                    JOptionPane.showMessageDialog(this, " Movie Added Successfully");
                    jTFtitle.setText("");
                    jTFvideopath.setText("");
                    jTFtrailerpath.setText("");
                    jTFdirector.setText("");
                    jTFproducer.setText("");
                    jComboBoxdate.setSelectedIndex(0);
                    jComboBoxmonth.setSelectedIndex(0);
                    jComboBoxyear.setSelectedIndex(0);
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_jBtmovActionPerformed

    private void jCbscItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jCbscItemStateChanged

        cname = jCbsc.getSelectedItem().toString();
        if (cname.equals("movies")) {
            jPanelmovies.setVisible(true);
            jPaneltvshows.setVisible(false);
            jBtmov.setVisible(true);
        }
        if (cname.equals("tvshows")) {
            jPanelmovies.setVisible(false);
            jPaneltvshows.setVisible(true);
            jBtmov.setVisible(true);
        }
    }//GEN-LAST:event_jCbscItemStateChanged

    private void jCbscActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCbscActionPerformed

    }//GEN-LAST:event_jCbscActionPerformed

    private void coverbtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_coverbtActionPerformed
int ans = ch1.showOpenDialog(this);
        if (ans == JFileChooser.APPROVE_OPTION) {
            File f = ch1.getSelectedFile();
            String path = f.getPath();
            covertf.setText(path);

   }       
    }//GEN-LAST:event_coverbtActionPerformed

    private void squarebtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_squarebtActionPerformed
    int ans = ch1.showOpenDialog(this);
        if (ans == JFileChooser.APPROVE_OPTION) {
            File f = ch1.getSelectedFile();
            String path = f.getPath();
            squarebt.setText(path);
    }//GEN-LAST:event_squarebtActionPerformed
        }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton coverbt;
    private javax.swing.JTextField covertf;
    private javax.swing.JButton jBtmov;
    private javax.swing.JButton jBttarilerpath;
    private javax.swing.JButton jBttvshows;
    private javax.swing.JButton jBtvideopath;
    private javax.swing.JComboBox<String> jCbsc;
    private javax.swing.JComboBox<String> jComboBoxdate;
    private javax.swing.JComboBox<String> jComboBoxmonth;
    private javax.swing.JComboBox<String> jComboBoxyear;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabelTrailerapath;
    private javax.swing.JLabel jLabeldirector;
    private javax.swing.JLabel jLabeldirector1;
    private javax.swing.JLabel jLabelproducer;
    private javax.swing.JLabel jLabelproducer1;
    private javax.swing.JLabel jLabelproducer2;
    private javax.swing.JLabel jLabeltitle;
    private javax.swing.JLabel jLabelvideopath;
    private javax.swing.JLabel jLbreleasingdate;
    private javax.swing.JLabel jLbselectcategory;
    private javax.swing.JPanel jPanelmovies;
    private javax.swing.JPanel jPaneltvshows;
    private javax.swing.JTextField jTFdirector;
    private javax.swing.JTextField jTFdirector1;
    private javax.swing.JTextField jTFproducer;
    private javax.swing.JTextField jTFproducer1;
    private javax.swing.JTextField jTFtitle;
    private javax.swing.JTextField jTFtrailerpath;
    private javax.swing.JTextField jTFvideopath;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JButton squarebt;
    private javax.swing.JTextField squaretf;
    private javax.swing.JTextField tfgenre;
    // End of variables declaration//GEN-END:variables
}
