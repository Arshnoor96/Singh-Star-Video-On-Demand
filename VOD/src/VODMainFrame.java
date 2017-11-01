
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.net.Socket;
import java.util.ArrayList;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

public class VODMainFrame extends javax.swing.JFrame {

    ArrayList<VideoData> alData = new ArrayList<>();
    ArrayList<VideoData> alData1 = new ArrayList<>();
    ArrayList<EpisodeGenre> alepisodegenre = new ArrayList<>();

    public VODMainFrame() {
        initComponents();
        setSize(1300, 680);

        new Thread(new GetData()).start();
        new Thread(new FillMovieAndTvShow()).start();
        new Thread(new FillEpisodeGenre()).start();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lbsquare = new javax.swing.JLabel();
        lbmainPhoto = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jpslider = new javax.swing.JPanel();
        jtaboptions = new javax.swing.JTabbedPane();
        jpmovies = new javax.swing.JPanel();
        jpmovie3 = new javax.swing.JPanel();
        lbmovgenremovie2 = new javax.swing.JLabel();
        lbg2 = new javax.swing.JLabel();
        jpmovie1 = new javax.swing.JPanel();
        lbmovgenremovie3 = new javax.swing.JLabel();
        lbg3 = new javax.swing.JLabel();
        jpmovie2 = new javax.swing.JPanel();
        lbmovgenremovie1 = new javax.swing.JLabel();
        lbg1 = new javax.swing.JLabel();
        lbSmallGalleryMovie = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jptvshows = new javax.swing.JPanel();
        jpshow3 = new javax.swing.JPanel();
        lbtvshowg2 = new javax.swing.JLabel();
        lb3 = new javax.swing.JLabel();
        jpshow1 = new javax.swing.JPanel();
        lbtvshowg1 = new javax.swing.JLabel();
        lb1 = new javax.swing.JLabel();
        jpshow4 = new javax.swing.JPanel();
        lbtvshowg3 = new javax.swing.JLabel();
        lb9 = new javax.swing.JLabel();
        lbSmallGallery = new javax.swing.JLabel();
        viewalltvshows = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        lbsquare.setBackground(new java.awt.Color(51, 255, 0));
        lbsquare.setText("jLabel1");
        lbsquare.setOpaque(true);
        getContentPane().add(lbsquare);
        lbsquare.setBounds(30, 130, 270, 120);

        lbmainPhoto.setBackground(new java.awt.Color(255, 0, 51));
        lbmainPhoto.setText("jLabel1");
        lbmainPhoto.setOpaque(true);
        getContentPane().add(lbmainPhoto);
        lbmainPhoto.setBounds(0, 0, 780, 250);

        jScrollPane1.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);

        jpslider.setLayout(null);
        jScrollPane1.setViewportView(jpslider);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(0, 260, 780, 100);

        jpmovies.setLayout(null);

        jpmovie3.setLayout(null);

        lbmovgenremovie2.setText("lbGenremovie2");
        jpmovie3.add(lbmovgenremovie2);
        lbmovgenremovie2.setBounds(4, 4, 360, 20);

        lbg2.setText("jLabel1");
        jpmovie3.add(lbg2);
        lbg2.setBounds(0, 30, 370, 120);

        jpmovies.add(jpmovie3);
        jpmovie3.setBounds(390, 10, 370, 150);

        jpmovie1.setLayout(null);

        lbmovgenremovie3.setText("lbGenremovie1");
        jpmovie1.add(lbmovgenremovie3);
        lbmovgenremovie3.setBounds(4, 4, 360, 20);

        lbg3.setText("jLabel1");
        jpmovie1.add(lbg3);
        lbg3.setBounds(0, 30, 370, 120);

        jpmovies.add(jpmovie1);
        jpmovie1.setBounds(770, 10, 370, 150);

        jpmovie2.setLayout(null);

        lbmovgenremovie1.setText("lbGenremovie1");
        jpmovie2.add(lbmovgenremovie1);
        lbmovgenremovie1.setBounds(4, 4, 360, 20);

        lbg1.setText("jLabel1");
        jpmovie2.add(lbg1);
        lbg1.setBounds(0, 30, 370, 120);

        jpmovies.add(jpmovie2);
        jpmovie2.setBounds(10, 10, 370, 150);

        lbSmallGalleryMovie.setText("jLabel1");
        jpmovies.add(lbSmallGalleryMovie);
        lbSmallGalleryMovie.setBounds(1150, 10, 130, 90);

        jLabel2.setBackground(new java.awt.Color(0, 0, 255));
        jLabel2.setFont(new java.awt.Font("Tahoma", 3, 18)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("View All");
        jLabel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jLabel2MousePressed(evt);
            }
        });
        jpmovies.add(jLabel2);
        jLabel2.setBounds(1150, 110, 130, 20);

        jtaboptions.addTab("Movies", jpmovies);

        jptvshows.setLayout(null);

        jpshow3.setLayout(null);
        jpshow3.add(lbtvshowg2);
        lbtvshowg2.setBounds(4, 4, 360, 20);
        jpshow3.add(lb3);
        lb3.setBounds(10, 30, 350, 90);

        jptvshows.add(jpshow3);
        jpshow3.setBounds(790, 10, 370, 130);

        jpshow1.setLayout(null);
        jpshow1.add(lbtvshowg1);
        lbtvshowg1.setBounds(4, 4, 350, 20);
        jpshow1.add(lb1);
        lb1.setBounds(10, 30, 330, 90);

        jptvshows.add(jpshow1);
        jpshow1.setBounds(10, 10, 360, 130);

        jpshow4.setLayout(null);
        jpshow4.add(lbtvshowg3);
        lbtvshowg3.setBounds(4, 4, 360, 20);
        jpshow4.add(lb9);
        lb9.setBounds(10, 30, 360, 100);

        jptvshows.add(jpshow4);
        jpshow4.setBounds(390, 10, 370, 130);

        lbSmallGallery.setText("jLabel1");
        jptvshows.add(lbSmallGallery);
        lbSmallGallery.setBounds(1180, 10, 130, 90);

        viewalltvshows.setBackground(new java.awt.Color(0, 0, 255));
        viewalltvshows.setFont(new java.awt.Font("Tahoma", 3, 18)); // NOI18N
        viewalltvshows.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        viewalltvshows.setText("View All");
        viewalltvshows.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                viewalltvshowsMouseClicked(evt);
            }
        });
        jptvshows.add(viewalltvshows);
        viewalltvshows.setBounds(1180, 110, 130, 20);

        jtaboptions.addTab("TV Shows", jptvshows);

        getContentPane().add(jtaboptions);
        jtaboptions.setBounds(0, 370, 1310, 190);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jLabel2MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel2MousePressed
        // TODO add your handling code here:
        ViewAllMovies allMovies = new ViewAllMovies();
        allMovies.setVisible(true);
        allMovies.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    }//GEN-LAST:event_jLabel2MousePressed

    private void viewalltvshowsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_viewalltvshowsMouseClicked
        ViewAllTvShows allTvShows = new ViewAllTvShows();
        allTvShows.setVisible(true);
        allTvShows.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    }//GEN-LAST:event_viewalltvshowsMouseClicked

    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(VODMainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VODMainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VODMainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VODMainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VODMainFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel jpmovie1;
    private javax.swing.JPanel jpmovie2;
    private javax.swing.JPanel jpmovie3;
    private javax.swing.JPanel jpmovies;
    private javax.swing.JPanel jpshow1;
    private javax.swing.JPanel jpshow3;
    private javax.swing.JPanel jpshow4;
    private javax.swing.JPanel jpslider;
    private javax.swing.JPanel jptvshows;
    private javax.swing.JTabbedPane jtaboptions;
    private javax.swing.JLabel lb1;
    private javax.swing.JLabel lb3;
    private javax.swing.JLabel lb9;
    private javax.swing.JLabel lbSmallGallery;
    private javax.swing.JLabel lbSmallGalleryMovie;
    private javax.swing.JLabel lbg1;
    private javax.swing.JLabel lbg2;
    private javax.swing.JLabel lbg3;
    private javax.swing.JLabel lbmainPhoto;
    private javax.swing.JLabel lbmovgenremovie1;
    private javax.swing.JLabel lbmovgenremovie2;
    private javax.swing.JLabel lbmovgenremovie3;
    private javax.swing.JLabel lbsquare;
    private javax.swing.JLabel lbtvshowg1;
    private javax.swing.JLabel lbtvshowg2;
    private javax.swing.JLabel lbtvshowg3;
    private javax.swing.JLabel viewalltvshows;
    // End of variables declaration//GEN-END:variables

    class GetData implements Runnable {

        @Override
        public void run() {
            try {
                Socket socket = new Socket("127.0.0.1", 9000);
                DataOutputStream serverOut = new DataOutputStream(socket.getOutputStream());
                DataInputStream serverInp = new DataInputStream(socket.getInputStream());
                serverOut.writeBytes("senddata\r\n");
                while (true) {
                    String inpu = serverInp.readUTF();
                    if (inpu.equals("done")) {
                        break;
                    } else if (inpu.equals("receive")) {
                        String name = serverInp.readUTF();
                        String path = serverInp.readUTF();
                        String trailer = serverInp.readUTF();
                        String director = serverInp.readUTF();
                        String prducer = serverInp.readUTF();
                        String rating = serverInp.readUTF();
                        String releasedate = serverInp.readUTF();
                        String desc = serverInp.readUTF();
                        String cover = serverInp.readUTF();
                        String square = serverInp.readUTF();
                        String videoid = serverInp.readUTF();
                        String type = serverInp.readUTF();
                        String genre = serverInp.readUTF();
                        alData.add(new VideoData(name, path, trailer, director, prducer, rating,
                                releasedate, desc, cover, square, videoid, type, genre));
                    }
                }
                lbmainPhoto.setBounds(lbmainPhoto.getX(), lbmainPhoto.getY(),
                        getWidth(), getHeight() - 400);
                lbmainPhoto.setOpaque(true);
                lbmainPhoto.setBackground(Color.red);
                try {
                    int x = 10;
                    jScrollPane1.setBounds(1, lbmainPhoto.getHeight() + 10, getWidth(), 160);
                    jpslider.setOpaque(true);
                    jpslider.setBackground(Color.BLUE);
                    jtaboptions.setBounds(jScrollPane1.getX(),
                            lbmainPhoto.getHeight() + jScrollPane1.getHeight() + 10, getWidth(),
                            jScrollPane1.getHeight() + 30);
                    jpmovies.setSize(jpmovies.getWidth(), jpmovies.getHeight() - 50);
                    jtaboptions.setOpaque(true);
                    jtaboptions.setBackground(Color.red);

                    jpmovies.setOpaque(true);
                    jpmovies.setBackground(Color.GREEN);

                    jptvshows.setOpaque(true);
                    jptvshows.setBackground(Color.ORANGE);

                    jpslider.setPreferredSize(new Dimension(3000 + 150, 300));
                    for (int i = 0; i < alData.size(); i++) {
                        VideoData videoData = alData.get(i);
                        SingleImage image = new SingleImage();
                        String filename1 = videoData.square;
                        image.setBounds(x, 10, 300, 150);
                        try {
                            Image scaledInstance1 = ImageIO.read(new File(filename1)).getScaledInstance(image.getWidth(),
                                    image.getHeight(), Image.SCALE_SMOOTH);
                            image.lbImage.setIcon(new ImageIcon(scaledInstance1));
                            image.lbImage.addMouseListener(new MouseAdapter() {
                                @Override
                                public void mouseClicked(MouseEvent e) {
                                    LaunchMovie launchMovie = new LaunchMovie(videoData);
                                    launchMovie.setVisible(true);
                                    launchMovie.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
                                    launchMovie.setLocation(100, 60);
                                }
                            });
                        } catch (Exception e) {
                            System.out.println("Error " + e.getMessage());
                        }
                        jpslider.add(image);
                        jpslider.repaint();
                        x = x + image.getWidth() + 10;
                    }
                    repaint();

                    try {
                        Image scaledInstance = ImageIO.read(new File("C:\\Users\\Admin\\Desktop\\Cover\\multi_images.jpg")).
                                getScaledInstance(lbSmallGalleryMovie.getWidth(),
                                        lbSmallGalleryMovie.getHeight(), Image.SCALE_SMOOTH);
                        lbSmallGalleryMovie.setIcon(new ImageIcon(scaledInstance));
                    } catch (Exception e) {
                    }

                    while (true) {
                        try {
                            int no = (int) (Math.random() * alData.size());
                            System.out.println(no);
                            VideoData videoData = alData.get(no);
                            Image scaledInstance = ImageIO.read(new File(videoData.cover)).getScaledInstance(lbmainPhoto.getWidth(),
                                    lbmainPhoto.getHeight(), Image.SCALE_SMOOTH);
                            lbmainPhoto.setIcon(new ImageIcon(scaledInstance));
                            Image scaledInstance1 = ImageIO.read(new File(videoData.square)).getScaledInstance(lbsquare.getWidth(),
                                    lbsquare.getHeight(), Image.SCALE_SMOOTH);
                            lbsquare.setIcon(new ImageIcon(scaledInstance1));
                            Thread.sleep(1500);
                        } catch (Exception e) {
                            continue;
                        }
                    }

                } catch (Exception e) {
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }

    class FillMovieAndTvShow implements Runnable {

        @Override
        public void run() {
            try {
                Socket socket = new Socket("127.0.0.1", 9000);
                DataOutputStream serverOut = new DataOutputStream(socket.getOutputStream());
                DataInputStream serverInp = new DataInputStream(socket.getInputStream());
                serverOut.writeBytes("sendGenreMovie\r\n");
                while (true) {
                    String inpu = serverInp.readUTF();
                    if (inpu.equals("done")) {
                        break;
                    } else if (inpu.equals("receive")) {
                        String name = serverInp.readUTF();
                        String square = serverInp.readUTF();
                        alData1.add(new VideoData(name, "", "", "", "", "",
                                "", "", "", square, "", "", ""));
                    }
                }

                jpmovie1.setOpaque(true);
                jpmovie1.setBackground(Color.magenta);
                jpmovie2.setOpaque(true);
                jpmovie2.setBackground(Color.magenta);
                jpmovie3.setOpaque(true);
                jpmovie3.setBackground(Color.magenta);
                for (int i = 0; i < alData1.size(); i++) {
                    VideoData videoData = alData1.get(i);
                    String name = videoData.name;;
                    String sqaure = videoData.square;
                    Image scaledInstance = null;
                    if (i == 0) {
                        scaledInstance = ImageIO.read(new File(sqaure)).getScaledInstance(lbg1.getWidth(),
                                lbg1.getHeight(), Image.SCALE_SMOOTH);
                        lbg1.setIcon(new ImageIcon(scaledInstance));
                        lbg1.setToolTipText(name);
                        lbmovgenremovie1.setText(name);
                    } else if (i == 1) {
                        scaledInstance = ImageIO.read(new File(sqaure)).getScaledInstance(lbg2.getWidth(),
                                lbg2.getHeight(), Image.SCALE_SMOOTH);
                        lbg2.setIcon(new ImageIcon(scaledInstance));
                        lbg2.setToolTipText(name);
                        lbmovgenremovie2.setText(name);
                    } else if (i == 2) {
                        scaledInstance = ImageIO.read(new File(sqaure)).getScaledInstance(lbg3.getWidth(),
                                lbg3.getHeight(), Image.SCALE_SMOOTH);
                        lbg3.setIcon(new ImageIcon(scaledInstance));
                        lbg3.setToolTipText(name);
                        lbmovgenremovie3.setText(name);
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }

    class FillEpisodeGenre implements Runnable {

        @Override
        public void run() {
            try {
                Socket socket = new Socket("127.0.0.1", 9000);
                DataOutputStream serverOut = new DataOutputStream(socket.getOutputStream());
                DataInputStream serverInp = new DataInputStream(socket.getInputStream());
                serverOut.writeBytes("sendgenretv\r\n");
                while (true) {
                    String inpu = serverInp.readUTF();
                    if (inpu.equals("done")) {
                        break;
                    } else if (inpu.equals("receive")) {
                        int vid = serverInp.readInt();
                        String title = serverInp.readUTF();
                        String square = serverInp.readUTF();
                        alepisodegenre.add(new EpisodeGenre(vid, title, "", "", "", "", square, ""));
                    }
                }

                jpshow1.setOpaque(true);
                jpshow1.setBackground(Color.magenta);
                jpshow4.setOpaque(true);
                jpshow4.setBackground(Color.magenta);
                jpshow3.setOpaque(true);
                jpshow3.setBackground(Color.magenta);
                for (int i = 0; i < alepisodegenre.size(); i++) {
                    EpisodeGenre episodegenre = alepisodegenre.get(i);
                    int vid = episodegenre.vid;;
                    String title = episodegenre.title;;
                    String sqaure = episodegenre.squarephoto;
                    Image scaledInstance = null;
                    if (i == 0) {
                        scaledInstance = ImageIO.read(new File(sqaure)).getScaledInstance(lb1.getWidth(),
                                lb1.getHeight(), Image.SCALE_SMOOTH);
                        lb1.setIcon(new ImageIcon(scaledInstance));
                        lb1.setToolTipText(title);
                        lbtvshowg1.setText(title);
                    } else if (i == 1) {
                        scaledInstance = ImageIO.read(new File(sqaure)).getScaledInstance(lb9.getWidth(),
                                lb9.getHeight(), Image.SCALE_SMOOTH);
                        lb9.setIcon(new ImageIcon(scaledInstance));
                        lb9.setToolTipText(title);
                        lbtvshowg3.setText(title);
                    } else if (i == 2) {
                        scaledInstance = ImageIO.read(new File(sqaure)).getScaledInstance(lb3.getWidth(),
                                lb3.getHeight(), Image.SCALE_SMOOTH);
                        lb3.setIcon(new ImageIcon(scaledInstance));
                        lb3.setToolTipText(title);
                        lbtvshowg2.setText(title);
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }

}

class VideoData {

    String name;
    String path;
    String trailer;
    String director;
    String prducer;
    String rating;
    String releasedate;
    String desc;
    String cover;
    String square;
    String videoid;
    String type;
    String genre;

    public VideoData(String name, String path, String trailer, String director,
            String prducer, String rating, String releasedate, String desc, String cover,
            String square, String videoid, String type, String genre) {
        this.name = name;
        this.path = path;
        this.trailer = trailer;
        this.director = director;
        this.prducer = prducer;
        this.rating = rating;
        this.releasedate = releasedate;
        this.desc = desc;
        this.cover = cover;
        this.square = square;
        this.videoid = videoid;
        this.type = type;
        this.genre = genre;

    }
}

class EpisodeGenre {

    int vid;
    String title;
    String director;
    String producer;
    String cname;
    String coverphoto;
    String squarephoto;
    String genre;

    public EpisodeGenre(int vid, String title, String director, String producer, String cname, String coverphoto, String squarephoto, String genre) {
        this.vid = vid;
        this.title = title;
        this.director = director;
        this.producer = producer;
        this.cname = cname;
        this.coverphoto = coverphoto;
        this.squarephoto = squarephoto;
        this.genre = genre;

    }
}
