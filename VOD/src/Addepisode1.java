
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

public class Addepisode1 extends javax.swing.JInternalFrame {

    JFileChooser ch1;
    JFileChooser ch2;
    JFileChooser ch3;
    String cname = "";
    String coverpath;
    String squarepath;
    String selectedshow;
    int  selectedvid ;
    ArrayList<Episode> al = new ArrayList<>();

    public Addepisode1() {
        initComponents();
        this.setVisible(true);
        this.setSize(1000, 800);

        ch1 = new JFileChooser("D:\\Abheyjeet");
        ch2 = new JFileChooser("D:\\Abheyjeet");
        ch3 = new JFileChooser("G:\\Movies\\Hollywood");
        try {

            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/test", "root", "hello");
            Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            ResultSet rs = stmt.executeQuery("select * from vid where cname = 'tvshows'");

            jCBepisode.addItem("--Select the TV Show--");
            while (rs.next()) {
                al.add(new Episode(rs.getInt("vid"), rs.getString("title")));

            }

            for (int i = 0; i < al.size(); i++) {
                jCBepisode.addItem(al.get(i).title);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jCBepisode = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        jTFepisodename = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jLbepisodecoverphoto = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jLbepisodesquarephoto = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTAepisodedesc = new javax.swing.JTextArea();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jTFduration = new javax.swing.JTextField();
        jTFepisodevideopath = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jBtaddepisode = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();

        getContentPane().setLayout(null);

        jCBepisode.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] {  }));
        jCBepisode.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jCBepisodeItemStateChanged(evt);
            }
        });
        getContentPane().add(jCBepisode);
        jCBepisode.setBounds(190, 10, 380, 30);

        jLabel1.setText("Episode Video Path");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(20, 440, 100, 16);
        getContentPane().add(jTFepisodename);
        jTFepisodename.setBounds(150, 70, 360, 22);

        jLabel2.setText("Episode name");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(20, 70, 100, 16);

        jLabel3.setText("Episode Cover Photo");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(20, 134, 110, 20);

        jLabel4.setText("Episode Square Photo");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(20, 200, 110, 16);

        jButton1.setText("Browse");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1);
        jButton1.setBounds(150, 150, 80, 25);
        getContentPane().add(jLbepisodecoverphoto);
        jLbepisodecoverphoto.setBounds(410, 100, 100, 70);

        jButton2.setText("Browse");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2);
        jButton2.setBounds(150, 220, 80, 25);
        getContentPane().add(jLbepisodesquarephoto);
        jLbepisodesquarephoto.setBounds(410, 190, 100, 70);

        jTAepisodedesc.setColumns(20);
        jTAepisodedesc.setRows(5);
        jScrollPane1.setViewportView(jTAepisodedesc);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(150, 280, 360, 80);

        jLabel5.setText("Episode Description");
        getContentPane().add(jLabel5);
        jLabel5.setBounds(20, 280, 100, 16);

        jLabel6.setText("Episode Duration");
        getContentPane().add(jLabel6);
        jLabel6.setBounds(20, 390, 100, 16);
        getContentPane().add(jTFduration);
        jTFduration.setBounds(150, 390, 360, 22);
        getContentPane().add(jTFepisodevideopath);
        jTFepisodevideopath.setBounds(250, 440, 260, 22);

        jLabel7.setText("Available Videos");
        getContentPane().add(jLabel7);
        jLabel7.setBounds(60, 10, 110, 40);

        jBtaddepisode.setText("Add Episode");
        jBtaddepisode.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtaddepisodeActionPerformed(evt);
            }
        });
        getContentPane().add(jBtaddepisode);
        jBtaddepisode.setBounds(200, 490, 170, 50);

        jButton3.setText("Browse");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton3);
        jButton3.setBounds(150, 440, 90, 25);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jCBepisodeItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jCBepisodeItemStateChanged
        selectedshow = jCBepisode.getSelectedItem().toString();
        for(int i=0;i<al.size();i++){
            if(al.get(i).title.equals(selectedshow)){
                selectedvid=al.get(i).vid;
            }
        }

    }//GEN-LAST:event_jCBepisodeItemStateChanged

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        try {
            int ans = ch1.showOpenDialog(this);
            if (ans == JFileChooser.APPROVE_OPTION) {
                File f = ch1.getSelectedFile();
                this.coverpath = f.getPath();
                Image scaledimage = ImageIO.read(new File(this.coverpath)).getScaledInstance(jLbepisodecoverphoto.getWidth(), jLbepisodecoverphoto.getHeight(), Image.SCALE_SMOOTH);
                ImageIcon img = new ImageIcon(scaledimage);
                jLbepisodecoverphoto.setIcon(img);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        try {
            int ans = ch1.showOpenDialog(this);
            if (ans == JFileChooser.APPROVE_OPTION) {
                File f = ch1.getSelectedFile();
                squarepath = f.getPath();
                Image scaledimage = ImageIO.read(new File(squarepath)).getScaledInstance(jLbepisodesquarephoto.getWidth(), jLbepisodesquarephoto.getHeight(), Image.SCALE_SMOOTH);
                ImageIcon img = new ImageIcon(scaledimage);
                jLbepisodesquarephoto.setIcon(img);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }//GEN-LAST:event_jButton2ActionPerformed

    private void jBtaddepisodeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtaddepisodeActionPerformed
        String ename = jTFepisodename.getText();
        String edesc = jTAepisodedesc.getText();
        String edur = jTFduration.getText();
        String evidpath = jTFepisodevideopath.getText();
        String ecphoto = jLbepisodecoverphoto.getText();
        String esphoto = jLbepisodesquarephoto.getText();
        if (cname == null || edesc == null || edur == null || evidpath == null) {
            JOptionPane.showMessageDialog(this, "All fields required enter again");
        } else {
            try {

                Class.forName("com.mysql.jdbc.Driver");

                Connection conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/test", "root", "hello");

                Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);

                ResultSet rs = stmt.executeQuery("select * from episode where episode_name='"+jTFepisodename.getText()+"' and vid='"+selectedvid+"'");
                System.out.println("ResultSet created");

                if (rs.next()) {

                    JOptionPane.showMessageDialog(this, "this episode already exists");

                } 
                else if(ename.isEmpty()||this.coverpath.isEmpty()||this.squarepath.isEmpty()||edur.isEmpty()||evidpath.isEmpty()||edesc.isEmpty()){
                 JOptionPane.showMessageDialog(this, "Fill All The Required Fields");
            }
                else {
                    rs.moveToInsertRow();
                    rs.updateString("episode_name", ename);
                    rs.updateString("episode_cover_photo", this.coverpath);
                    rs.updateString("episode_square_photo", this.squarepath);
                    rs.updateString("duration", edur);
                    rs.updateString("video_path", evidpath);
                    rs.updateString("description", edesc);
                    rs.updateInt("vid", selectedvid);

                    rs.insertRow();

                    jTFduration.setText("");
                    jTFepisodename.setText("");
                    jTAepisodedesc.setText("");
                    jLbepisodecoverphoto.setText("");
                    jLbepisodesquarephoto.setText("");
                    jTFepisodevideopath.setText("");

                    JOptionPane.showMessageDialog(this, "new episode added successfully");

                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }

        }
    }//GEN-LAST:event_jBtaddepisodeActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        try {
            int ans = ch3.showOpenDialog(this);
            if (ans == JFileChooser.APPROVE_OPTION) {
                File f = ch3.getSelectedFile();
                String path = f.getPath();
                jTFepisodevideopath.setText(path);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_jButton3ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBtaddepisode;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JComboBox<String> jCBepisode;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLbepisodecoverphoto;
    private javax.swing.JLabel jLbepisodesquarephoto;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTAepisodedesc;
    private javax.swing.JTextField jTFduration;
    private javax.swing.JTextField jTFepisodename;
    private javax.swing.JTextField jTFepisodevideopath;
    // End of variables declaration//GEN-END:variables

    private static class Episode {

        int vid;
        String title;

        public Episode(int vid, String title) {
            this.vid = vid;
            this.title = title;
        }
    }
    public static void main(String[] args) {
        Addepisode1 obj =new Addepisode1();
        obj.setVisible(true);
    }
}
