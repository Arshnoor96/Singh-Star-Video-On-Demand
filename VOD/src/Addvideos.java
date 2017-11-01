
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

public class Addvideos extends javax.swing.JInternalFrame {

    JFileChooser ch1;
    JFileChooser ch2;
    JFileChooser ch3;
    JFileChooser ch4;
    JFileChooser ch5;
    JFileChooser ch6;
    String cname = "";
    String coverphoto = "";
    String tvcoverphoto = "";
    String squarephoto = "";
    String tvsquarephoto = "";

    public Addvideos() {
        initComponents();

        jPanelmovies.setVisible(false);
        jPaneltvshows.setVisible(false);
        jBtaddmov.setVisible(false);

        ch1 = new JFileChooser();
        ch2 = new JFileChooser();
        ch3 = new JFileChooser();
        ch4 = new JFileChooser();
        ch5 = new JFileChooser();
        ch6 = new JFileChooser();

        this.setVisible(true);
        this.setSize(800, 700);

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

        jTextField3 = new javax.swing.JTextField();
        jPaneltvshows = new javax.swing.JPanel();
        jLabeldirector1 = new javax.swing.JLabel();
        jTFdirector1 = new javax.swing.JTextField();
        jTFproducer1 = new javax.swing.JTextField();
        jLabelproducer1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jBtAddtvshows = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        covertf = new javax.swing.JTextField();
        coverbt = new javax.swing.JButton();
        jLabel11 = new javax.swing.JLabel();
        squaretf = new javax.swing.JTextField();
        squarebt = new javax.swing.JButton();
        jLabel12 = new javax.swing.JLabel();
        tvshowgenretf = new javax.swing.JTextField();
        jLbselectcategory = new javax.swing.JLabel();
        jCbsc = new javax.swing.JComboBox<>();
        jScrollPane2 = new javax.swing.JScrollPane();
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
        jBtaddmov = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        ratingtf = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        descriptionta = new javax.swing.JTextArea();
        coverphotobt = new javax.swing.JButton();
        squarephotobt = new javax.swing.JButton();
        genretf = new javax.swing.JTextField();
        coverphototf = new javax.swing.JTextField();
        squarephototf = new javax.swing.JTextField();

        jTextField3.setText("jTextField3");

        getContentPane().setLayout(null);

        jPaneltvshows.setLayout(null);

        jLabeldirector1.setText("Director");
        jPaneltvshows.add(jLabeldirector1);
        jLabeldirector1.setBounds(10, 50, 60, 14);
        jPaneltvshows.add(jTFdirector1);
        jTFdirector1.setBounds(80, 50, 260, 20);
        jPaneltvshows.add(jTFproducer1);
        jTFproducer1.setBounds(80, 90, 260, 20);

        jLabelproducer1.setText("Producer");
        jPaneltvshows.add(jLabelproducer1);
        jLabelproducer1.setBounds(10, 90, 70, 14);

        jLabel2.setText("Title");
        jPaneltvshows.add(jLabel2);
        jLabel2.setBounds(10, 10, 65, 20);
        jPaneltvshows.add(jTextField1);
        jTextField1.setBounds(79, 11, 260, 20);

        jBtAddtvshows.setText("Add TV Shows");
        jBtAddtvshows.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtAddtvshowsActionPerformed(evt);
            }
        });
        jPaneltvshows.add(jBtAddtvshows);
        jBtAddtvshows.setBounds(90, 280, 240, 50);

        jLabel10.setText("Cover Photo");
        jPaneltvshows.add(jLabel10);
        jLabel10.setBounds(10, 140, 70, 14);
        jPaneltvshows.add(covertf);
        covertf.setBounds(90, 140, 180, 20);

        coverbt.setText("Browse");
        coverbt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                coverbtActionPerformed(evt);
            }
        });
        jPaneltvshows.add(coverbt);
        coverbt.setBounds(300, 140, 67, 23);

        jLabel11.setText("Square Photo");
        jPaneltvshows.add(jLabel11);
        jLabel11.setBounds(10, 180, 65, 14);
        jPaneltvshows.add(squaretf);
        squaretf.setBounds(90, 180, 180, 20);

        squarebt.setText("Browse");
        squarebt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                squarebtActionPerformed(evt);
            }
        });
        jPaneltvshows.add(squarebt);
        squarebt.setBounds(300, 180, 67, 23);

        jLabel12.setText("Genre");
        jPaneltvshows.add(jLabel12);
        jLabel12.setBounds(20, 240, 29, 14);
        jPaneltvshows.add(tvshowgenretf);
        tvshowgenretf.setBounds(90, 240, 240, 20);

        getContentPane().add(jPaneltvshows);
        jPaneltvshows.setBounds(400, 70, 370, 340);

        jLbselectcategory.setText("Select category");
        getContentPane().add(jLbselectcategory);
        jLbselectcategory.setBounds(140, 10, 150, 40);

        jCbsc.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] {  }));
        jCbsc.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jCbscItemStateChanged(evt);
            }
        });
        getContentPane().add(jCbsc);
        jCbsc.setBounds(330, 20, 240, 20);

        jPanelmovies.setPreferredSize(new java.awt.Dimension(250, 1000));
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

    jLabel3.setText("date");
    jPanelmovies.add(jLabel3);
    jLabel3.setBounds(160, 200, 60, 14);

    jLabel4.setText("month");
    jPanelmovies.add(jLabel4);
    jLabel4.setBounds(230, 200, 60, 14);

    jLabel5.setText("year");
    jPanelmovies.add(jLabel5);
    jLabel5.setBounds(320, 200, 50, 14);

    jBtaddmov.setText("Add Movie");
    jBtaddmov.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            jBtaddmovActionPerformed(evt);
        }
    });
    jPanelmovies.add(jBtaddmov);
    jBtaddmov.setBounds(90, 570, 220, 40);

    jLabel1.setText("Rating");
    jPanelmovies.add(jLabel1);
    jLabel1.setBounds(0, 290, 60, 14);

    jLabel6.setText("Description");
    jPanelmovies.add(jLabel6);
    jLabel6.setBounds(0, 350, 100, 14);

    jLabel7.setText("Cover Photo");
    jPanelmovies.add(jLabel7);
    jLabel7.setBounds(0, 440, 90, 14);

    jLabel8.setText("Square Photo");
    jPanelmovies.add(jLabel8);
    jLabel8.setBounds(0, 470, 100, 14);

    jLabel9.setText("Genre");
    jPanelmovies.add(jLabel9);
    jLabel9.setBounds(0, 510, 70, 14);
    jPanelmovies.add(ratingtf);
    ratingtf.setBounds(80, 290, 270, 20);

    descriptionta.setColumns(20);
    descriptionta.setRows(5);
    jScrollPane1.setViewportView(descriptionta);

    jPanelmovies.add(jScrollPane1);
    jScrollPane1.setBounds(120, 340, 166, 80);

    coverphotobt.setText("Browse");
    coverphotobt.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            coverphotobtActionPerformed(evt);
        }
    });
    jPanelmovies.add(coverphotobt);
    coverphotobt.setBounds(290, 440, 80, 23);

    squarephotobt.setText("Browse");
    squarephotobt.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            squarephotobtActionPerformed(evt);
        }
    });
    jPanelmovies.add(squarephotobt);
    squarephotobt.setBounds(290, 470, 80, 23);
    jPanelmovies.add(genretf);
    genretf.setBounds(80, 510, 260, 20);
    jPanelmovies.add(coverphototf);
    coverphototf.setBounds(109, 440, 160, 20);
    jPanelmovies.add(squarephototf);
    squarephototf.setBounds(110, 470, 160, 20);

    jScrollPane2.setViewportView(jPanelmovies);

    getContentPane().add(jScrollPane2);
    jScrollPane2.setBounds(10, 70, 380, 650);

    pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jCbscItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jCbscItemStateChanged

        cname = jCbsc.getSelectedItem().toString();
        if (cname.equals("movies")) {
            jPanelmovies.setVisible(true);
            jPaneltvshows.setVisible(false);
            jBtaddmov.setVisible(true);
        }
        if (cname.equals("tvshows")) {
            jPanelmovies.setVisible(false);
            jPaneltvshows.setVisible(true);
            jBtaddmov.setVisible(true);
        }
    }//GEN-LAST:event_jCbscItemStateChanged

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

    private void jBtaddmovActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtaddmovActionPerformed
        try {
            String title = jTFtitle.getText();
            String vidpath = jTFvideopath.getText();
            String trapath = jTFtrailerpath.getText();
            String rating = ratingtf.getText();
            String description = descriptionta.getText();
            String genre = genretf.getText();
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
                    JOptionPane.showMessageDialog(this, "Same Entitled movie Already Exists");
                } else {
                    rs.moveToInsertRow();
                    rs.updateString("title", title);
                    rs.updateString("video_path", vidpath);
                    rs.updateString("trailer_path", trapath);
                    rs.updateString("producer", pro);
                    rs.updateString("director", dir);
                    rs.updateString("cname", cname);
                    rs.updateString("release_date", releasedate);
                    rs.updateString("rating", rating);
                    rs.updateString("description", description);
                    rs.updateString("cover_photo", this.coverphoto);
                    rs.updateString("square_photo", this.squarephoto);
                    rs.updateString("genre", genre);

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

    }//GEN-LAST:event_jBtaddmovActionPerformed

    private void jBtAddtvshowsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtAddtvshowsActionPerformed
        try {
            String title = jTextField1.getText();
            String pro = jTFproducer1.getText();
            String dir = jTFdirector1.getText();
            String genre = tvshowgenretf.getText();

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
                    rs.updateString("cname", cname);
                    rs.updateString("cover_photo", this.tvcoverphoto);
                    rs.updateString("square_photo", this.tvsquarephoto);
                    rs.updateString("genre",genre);

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
    }//GEN-LAST:event_jBtAddtvshowsActionPerformed

    private void coverphotobtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_coverphotobtActionPerformed
        int ans = ch3.showOpenDialog(this);
        if (ans == JFileChooser.APPROVE_OPTION) {
            File f = ch3.getSelectedFile();
            this.coverphoto = f.getPath();
            coverphototf.setText(coverphoto);

        }
    }//GEN-LAST:event_coverphotobtActionPerformed

    private void squarephotobtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_squarephotobtActionPerformed
        int ans = ch4.showOpenDialog(this);
        if (ans == JFileChooser.APPROVE_OPTION) {
            File f = ch4.getSelectedFile();
            this.squarephoto = f.getPath();
            squarephototf.setText(squarephoto);

        }
    }//GEN-LAST:event_squarephotobtActionPerformed

    private void coverbtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_coverbtActionPerformed
        int ans = ch5.showOpenDialog(this);
        if (ans == JFileChooser.APPROVE_OPTION) {
            File f = ch5.getSelectedFile();
            this.tvcoverphoto = f.getPath();
            covertf.setText(this.tvcoverphoto);

        }
    }//GEN-LAST:event_coverbtActionPerformed

    private void squarebtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_squarebtActionPerformed
        int ans = ch6.showOpenDialog(this);
        if (ans == JFileChooser.APPROVE_OPTION) {
            File f = ch5.getSelectedFile();
            this.tvsquarephoto = f.getPath();
            squaretf.setText(this.tvsquarephoto);

        }
    }//GEN-LAST:event_squarebtActionPerformed
    public static void main(String[] args) {
        Addvideos obj=new Addvideos();
        obj.setVisible(true);
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton coverbt;
    private javax.swing.JButton coverphotobt;
    private javax.swing.JTextField coverphototf;
    private javax.swing.JTextField covertf;
    private javax.swing.JTextArea descriptionta;
    private javax.swing.JTextField genretf;
    private javax.swing.JButton jBtAddtvshows;
    private javax.swing.JButton jBtaddmov;
    private javax.swing.JButton jBttarilerpath;
    private javax.swing.JButton jBtvideopath;
    private javax.swing.JComboBox<String> jCbsc;
    private javax.swing.JComboBox<String> jComboBoxdate;
    private javax.swing.JComboBox<String> jComboBoxmonth;
    private javax.swing.JComboBox<String> jComboBoxyear;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel jLabelTrailerapath;
    private javax.swing.JLabel jLabeldirector;
    private javax.swing.JLabel jLabeldirector1;
    private javax.swing.JLabel jLabelproducer;
    private javax.swing.JLabel jLabelproducer1;
    private javax.swing.JLabel jLabeltitle;
    private javax.swing.JLabel jLabelvideopath;
    private javax.swing.JLabel jLbreleasingdate;
    private javax.swing.JLabel jLbselectcategory;
    private javax.swing.JPanel jPanelmovies;
    private javax.swing.JPanel jPaneltvshows;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField jTFdirector;
    private javax.swing.JTextField jTFdirector1;
    private javax.swing.JTextField jTFproducer;
    private javax.swing.JTextField jTFproducer1;
    private javax.swing.JTextField jTFtitle;
    private javax.swing.JTextField jTFtrailerpath;
    private javax.swing.JTextField jTFvideopath;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField ratingtf;
    private javax.swing.JButton squarebt;
    private javax.swing.JButton squarephotobt;
    private javax.swing.JTextField squarephototf;
    private javax.swing.JTextField squaretf;
    private javax.swing.JTextField tvshowgenretf;
    // End of variables declaration//GEN-END:variables

}
