
import java.awt.Color;
import java.awt.Image;
import java.io.File;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

public class LaunchMovie extends javax.swing.JFrame {

    VideoData videoData1;

    LaunchMovie(VideoData videoData) {
        initComponents();
        this.videoData1 = videoData;
        titlelb.setText(videoData.name);
        descta.setText(videoData.desc);
        directorlb.setText(videoData.director);
        producerlb.setText(videoData.prducer);
        ratinglb.setText(videoData.rating);
        releasedatelb.setText(videoData.releasedate);

        try {
            Image scaledInstance1 = ImageIO.read(new File(videoData.cover)).getScaledInstance(lbCover.getWidth(),
                    lbCover.getHeight(), Image.SCALE_SMOOTH);
            lbCover.setIcon(new ImageIcon(scaledInstance1));
            Image scaledInstance2 = ImageIO.read(new File(videoData.square)).getScaledInstance(lbSquare.getWidth(),
                    lbSquare.getHeight(), Image.SCALE_SMOOTH);
            lbSquare.setIcon(new ImageIcon(scaledInstance2));
            Image scaledInstance3 = ImageIO.read(new File("E:\\Movies\\Buttons\\play button.png")).getScaledInstance(jLabel3.getWidth(),
                    jLabel3.getHeight(), Image.SCALE_SMOOTH);
            jLabel3.setIcon(new ImageIcon(scaledInstance3));
            Image scaledInstance4 = ImageIO.read(new File("E:\\Movies\\Buttons\\play button.png")).getScaledInstance(jLabel4.getWidth(),
                    jLabel4.getHeight(), Image.SCALE_SMOOTH);
            jLabel4.setIcon(new ImageIcon(scaledInstance4));
        } catch (Exception e) {
        }
        this.setSize(820, 660);
        this.setTitle("LAUNCH MOVIE");
        getContentPane().setBackground(Color.PINK);
        this.lbCover.setOpaque(true);
        this.lbSquare.setOpaque(true);
        this.setVisible(true);

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        descta = new javax.swing.JTextArea();
        lbSquare = new javax.swing.JLabel();
        lbCover = new javax.swing.JLabel();
        lbDire = new javax.swing.JLabel();
        lbTitle1 = new javax.swing.JLabel();
        lbDire1 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        titlelb = new javax.swing.JLabel();
        directorlb = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        ratinglb = new javax.swing.JLabel();
        releasedatelb = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        producerlb = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        descta.setColumns(20);
        descta.setRows(5);
        jScrollPane2.setViewportView(descta);

        getContentPane().add(jScrollPane2);
        jScrollPane2.setBounds(470, 310, 220, 96);

        lbSquare.setForeground(new java.awt.Color(255, 102, 102));
        getContentPane().add(lbSquare);
        lbSquare.setBounds(10, 130, 270, 120);

        lbCover.setBackground(new java.awt.Color(255, 0, 0));
        lbCover.setForeground(new java.awt.Color(255, 51, 0));
        getContentPane().add(lbCover);
        lbCover.setBounds(-2, 0, 810, 250);

        lbDire.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        lbDire.setText("Producer :-");
        getContentPane().add(lbDire);
        lbDire.setBounds(10, 400, 100, 40);

        lbTitle1.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        lbTitle1.setText("Title :-");
        getContentPane().add(lbTitle1);
        lbTitle1.setBounds(10, 310, 60, 40);

        lbDire1.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        lbDire1.setText("Director :-");
        getContentPane().add(lbDire1);
        lbDire1.setBounds(10, 360, 100, 40);

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel1.setText("Rating :-");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(10, 450, 70, 30);

        jLabel2.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel2.setText("Release Date :-");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(10, 490, 100, 30);

        jLabel3.setText("Play Movie");
        jLabel3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel3MouseClicked(evt);
            }
        });
        getContentPane().add(jLabel3);
        jLabel3.setBounds(370, 480, 100, 70);

        titlelb.setText("titlelb");
        getContentPane().add(titlelb);
        titlelb.setBounds(110, 320, 140, 20);

        directorlb.setText("directorlb");
        getContentPane().add(directorlb);
        directorlb.setBounds(110, 370, 140, 20);
        getContentPane().add(jLabel6);
        jLabel6.setBounds(130, 370, 100, 0);

        ratinglb.setText("ratinglb");
        getContentPane().add(ratinglb);
        ratinglb.setBounds(110, 450, 160, 30);

        releasedatelb.setText("releaselb");
        getContentPane().add(releasedatelb);
        releasedatelb.setBounds(110, 490, 130, 40);

        jLabel9.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel9.setText("Description");
        getContentPane().add(jLabel9);
        jLabel9.setBounds(510, 270, 90, 22);

        producerlb.setText("producerlb");
        getContentPane().add(producerlb);
        producerlb.setBounds(110, 410, 130, 20);

        jLabel4.setText("Play Trailer");
        jLabel4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel4MouseClicked(evt);
            }
        });
        getContentPane().add(jLabel4);
        jLabel4.setBounds(560, 470, 100, 70);

        jLabel5.setFont(new java.awt.Font("Times New Roman", 1, 11)); // NOI18N
        jLabel5.setText("Play Trailer");
        getContentPane().add(jLabel5);
        jLabel5.setBounds(580, 560, 90, 20);

        jLabel7.setFont(new java.awt.Font("Times New Roman", 1, 11)); // NOI18N
        jLabel7.setText("Play Movie");
        getContentPane().add(jLabel7);
        jLabel7.setBounds(390, 560, 90, 20);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jLabel3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel3MouseClicked
        String path = videoData1.path;
        System.out.println(path + "********************");
        VLCFrameDemo cFrameDemo = new VLCFrameDemo(path);
        cFrameDemo.setVisible(true);
        cFrameDemo.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    }//GEN-LAST:event_jLabel3MouseClicked

    private void jLabel4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel4MouseClicked
        String path = videoData1.trailer;
        System.out.println(path + "********************");
        VLCFrameDemo cFrameDemo = new VLCFrameDemo(path);
        cFrameDemo.setVisible(true);
        cFrameDemo.setDefaultCloseOperation(DISPOSE_ON_CLOSE);

    }//GEN-LAST:event_jLabel4MouseClicked

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
//                new LaunchMovie().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextArea descta;
    private javax.swing.JLabel directorlb;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lbCover;
    private javax.swing.JLabel lbDire;
    private javax.swing.JLabel lbDire1;
    private javax.swing.JLabel lbSquare;
    private javax.swing.JLabel lbTitle1;
    private javax.swing.JLabel producerlb;
    private javax.swing.JLabel ratinglb;
    private javax.swing.JLabel releasedatelb;
    private javax.swing.JLabel titlelb;
    // End of variables declaration//GEN-END:variables
}
