
import java.awt.Color;
import java.awt.Image;
import java.io.File;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

public class LaunchEpisode extends javax.swing.JFrame {

    Episodes videoData1;

    LaunchEpisode(Episodes videoData) {
        initComponents();
        this.videoData1 = videoData;
        namelb.setText(videoData.episode_name);
        descta.setText(videoData.description);
        durationlb.setText(videoData.duration);
        System.out.println("episode cover photo " + videoData.episode_cover_photo);
        System.out.println("episode square photo " + videoData.episode_square_photo);
        try {
            Image scaledInstance1 = ImageIO.read(new File(videoData.episode_cover_photo)).getScaledInstance(lbCover.getWidth(),
                    lbCover.getHeight(), Image.SCALE_SMOOTH);
            lbCover.setIcon(new ImageIcon(scaledInstance1));
            Image scaledInstance2 = ImageIO.read(new File(videoData.episode_square_photo)).getScaledInstance(lbSquare.getWidth(),
                    lbSquare.getHeight(), Image.SCALE_SMOOTH);
            lbSquare.setIcon(new ImageIcon(scaledInstance2));
            Image scaledInstance3 = ImageIO.read(new File("E:\\Movies\\Buttons\\play button.png")).getScaledInstance(jLabel3.getWidth(),
                    jLabel3.getHeight(), Image.SCALE_SMOOTH);
            jLabel3.setIcon(new ImageIcon(scaledInstance3));
        } catch (Exception e) {
        }
        this.setSize(850, 710);
        this.setTitle("LAUNCH EPISODE");
        getContentPane().setBackground(Color.PINK);
        this.lbCover.setOpaque(true);
        this.lbSquare.setOpaque(true);
        this.setVisible(true);

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jPanel1 = new javax.swing.JPanel();
        lbSquare = new javax.swing.JLabel();
        lbCover = new javax.swing.JLabel();
        lbTitle1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        namelb = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        durationlb = new javax.swing.JLabel();
        descta = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        jPanel1.setPreferredSize(new java.awt.Dimension(100, 800));
        jPanel1.setLayout(null);

        lbSquare.setForeground(new java.awt.Color(255, 102, 102));
        lbSquare.setText("jLabel1");
        jPanel1.add(lbSquare);
        lbSquare.setBounds(10, 170, 270, 120);

        lbCover.setBackground(new java.awt.Color(255, 0, 0));
        lbCover.setForeground(new java.awt.Color(255, 51, 0));
        lbCover.setText("jLabel1");
        jPanel1.add(lbCover);
        lbCover.setBounds(0, 0, 790, 300);

        lbTitle1.setText("Episode Name");
        jPanel1.add(lbTitle1);
        lbTitle1.setBounds(10, 360, 100, 40);

        jLabel3.setText("Play Episode");
        jLabel3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel3MouseClicked(evt);
            }
        });
        jPanel1.add(jLabel3);
        jLabel3.setBounds(390, 470, 100, 30);

        jLabel4.setText("Duration");
        jPanel1.add(jLabel4);
        jLabel4.setBounds(20, 430, 60, 30);

        jLabel5.setText("Description");
        jPanel1.add(jLabel5);
        jLabel5.setBounds(20, 530, 80, 30);

        namelb.setText("namelb");
        jPanel1.add(namelb);
        namelb.setBounds(140, 360, 180, 50);
        jPanel1.add(jLabel7);
        jLabel7.setBounds(160, 340, 0, 0);

        durationlb.setText("durationlb");
        jPanel1.add(durationlb);
        durationlb.setBounds(130, 430, 190, 50);
        jPanel1.add(descta);
        descta.setBounds(120, 500, 200, 120);

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 11)); // NOI18N
        jLabel1.setText("Play Episode");
        jPanel1.add(jLabel1);
        jLabel1.setBounds(390, 520, 70, 14);

        jScrollPane1.setViewportView(jPanel1);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(0, 0, 810, 660);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jLabel3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel3MouseClicked
        String path = videoData1.video_path;
        System.out.println(path + "********************");
        VLCFrameDemo cFrameDemo = new VLCFrameDemo(path);
        cFrameDemo.setVisible(true);
        cFrameDemo.setLocation(250, 200);
        cFrameDemo.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    }//GEN-LAST:event_jLabel3MouseClicked

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
//                new LaunchMovie().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField descta;
    private javax.swing.JLabel durationlb;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbCover;
    private javax.swing.JLabel lbSquare;
    private javax.swing.JLabel lbTitle1;
    private javax.swing.JLabel namelb;
    // End of variables declaration//GEN-END:variables
}
