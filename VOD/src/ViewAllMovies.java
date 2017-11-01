
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
import javax.swing.JOptionPane;

public class ViewAllMovies extends javax.swing.JFrame {

    public ViewAllMovies() {
        initComponents();
        this.setSize(1024, 768);
        jScrollPane2.setSize(1024, 768);
        jpAllMovies.setSize(1024, 768);
        jpAllMovies.setOpaque(true);
        jpAllMovies.setBackground(Color.RED);
        this.setVisible(true);
        new Thread(new GetAllMovies()).start();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane2 = new javax.swing.JScrollPane();
        jpAllMovies = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        javax.swing.GroupLayout jpAllMoviesLayout = new javax.swing.GroupLayout(jpAllMovies);
        jpAllMovies.setLayout(jpAllMoviesLayout);
        jpAllMoviesLayout.setHorizontalGroup(
            jpAllMoviesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jpAllMoviesLayout.setVerticalGroup(
            jpAllMoviesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jScrollPane2.setViewportView(jpAllMovies);

        getContentPane().add(jScrollPane2);
        jScrollPane2.setBounds(0, 40, 1210, 430);

        jLabel1.setBackground(new java.awt.Color(51, 51, 255));
        jLabel1.setFont(new java.awt.Font("Times New Roman", 3, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Movies");
        jLabel1.setOpaque(true);
        getContentPane().add(jLabel1);
        jLabel1.setBounds(10, 4, 1200, 30);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public static void main(String args[]) {
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
            java.util.logging.Logger.getLogger(ViewAllMovies.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ViewAllMovies.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ViewAllMovies.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ViewAllMovies.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ViewAllMovies().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JPanel jpAllMovies;
    // End of variables declaration//GEN-END:variables

    class GetAllMovies implements Runnable {

        ArrayList<String> algenre = new ArrayList<>();

        @Override
        public void run() {
            try {
                Socket socket = new Socket("127.0.0.1", 9000);
                DataOutputStream serverOut = new DataOutputStream(socket.getOutputStream());
                DataInputStream serverInp = new DataInputStream(socket.getInputStream());
                serverOut.writeBytes("sendGenre\r\n");
                while (true) {
                    String inpu = serverInp.readUTF();
                    if (inpu.equals("done")) {
                        break;
                    }
                    algenre.add(inpu);
                }

                if (algenre.size() == 0) {
                    JOptionPane.showMessageDialog(rootPane, "No Movies found!!");
                    dispose();
                    return;
                }

                long height = algenre.size() * 300;
                jpAllMovies.setPreferredSize(new Dimension(jpAllMovies.getWidth(), (int) height));

                for (int i = 0; i < algenre.size(); i++) {
                    String genre = algenre.get(i);
                    serverOut.writeBytes("sendMovies\r\n");
                    serverOut.writeBytes(genre + "\r\n");
                    ArrayList<VideoData> alData = new ArrayList<>();

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
                            alData.add(new VideoData(name, path, trailer, director, prducer, rating,
                                    releasedate, desc, cover, square, videoid, type, genre));
                        }
                    }
                    showPanels(genre, alData);

                }

            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        int x = 10;
        int y = 10;

        private void showPanels(String genre, ArrayList<VideoData> al) {
            try {
                int x = 10;
                int y = 10;
                GeneredVideos generedVideos = new GeneredVideos();
                int height = (al.size() * 270) + (al.size() * 10);
                generedVideos.jPanel1.setPreferredSize(new Dimension(getWidth(), height));
                generedVideos.jsGV.setSize(new Dimension(getWidth(), generedVideos.jsGV.getHeight()));
                generedVideos.jLabel1.setText(genre);
                generedVideos.setBounds(this.x, this.y, getWidth(), 265);
                this.y = this.y + 280;
                jpAllMovies.add(generedVideos);
                for (int i = 0; i < al.size(); i++) {
                    VideoData videoData = al.get(i);
                    SingleImage image = new SingleImage();
                    String filename1 = videoData.square;
                    image.setBounds(x, y, 300, 150);
                    Image scaledInstance1 = ImageIO.read(new File(filename1)).getScaledInstance(image.getWidth(),
                            image.getHeight(), Image.SCALE_SMOOTH);
                    image.lbImage.setIcon(new ImageIcon(scaledInstance1));
                    image.lbImage.addMouseListener(new MouseAdapter() {
                        @Override
                        public void mouseClicked(MouseEvent e) {
                            System.out.println(videoData.path);
                            LaunchMovie launchMovie = new LaunchMovie(videoData);
                            launchMovie.setVisible(true);
                            launchMovie.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
                        }
                    });
                    generedVideos.jPanel1.add(image);
                    generedVideos.jPanel1.repaint();
                    if ((i + 1) % 3 == 0) {
                        x = 10;
                        y = y + 150 + 10;
                    } else {
                        x = x + image.getWidth() + 10;
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }
}
