
import java.awt.Image;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.net.Socket;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import static javax.swing.WindowConstants.DISPOSE_ON_CLOSE;

public class Userhome extends javax.swing.JFrame {

    String email;
    Socket socket;
    DataInputStream dis;
    DataOutputStream dos;

    public Userhome(Socket socket, String email) {
        initComponents();

        this.email = email;
        this.socket = socket;
        try {
            dis = new DataInputStream((socket.getInputStream()));
            dos = new DataOutputStream((socket.getOutputStream()));
        } catch (Exception e) {
        }

        try {

            Image scaledimage2 = ImageIO.read(new File("E:\\Movies\\Buttons\\Client home.jpg")).getScaledInstance(backlb.getWidth(), backlb.getHeight(), Image.SCALE_SMOOTH);
            ImageIcon img2 = new ImageIcon(scaledimage2);
          
            backlb.setIcon(img2);
            welcomelb.setText("WELCOME    " + this.email);
        } catch (Exception e) {
            e.printStackTrace();
        }

        this.setTitle("USER HOME");
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        this.setSize(700, 500);
        this.setVisible(true);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        changepasswordBt = new javax.swing.JButton();
        videobt = new javax.swing.JButton();
        welcomelb = new javax.swing.JLabel();
        backlb = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        changepasswordBt.setBackground(new java.awt.Color(204, 255, 153));
        changepasswordBt.setFont(new java.awt.Font("Verdana", 3, 12)); // NOI18N
        changepasswordBt.setText("Change Password");
        changepasswordBt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                changepasswordBtActionPerformed(evt);
            }
        });
        getContentPane().add(changepasswordBt);
        changepasswordBt.setBounds(230, 130, 230, 80);

        videobt.setBackground(new java.awt.Color(204, 255, 153));
        videobt.setFont(new java.awt.Font("Verdana", 3, 12)); // NOI18N
        videobt.setText("VIEW MOVIES/TVSHOWS");
        videobt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                videobtActionPerformed(evt);
            }
        });
        getContentPane().add(videobt);
        videobt.setBounds(230, 250, 230, 90);

        welcomelb.setFont(new java.awt.Font("Georgia", 3, 24)); // NOI18N
        welcomelb.setForeground(new java.awt.Color(255, 255, 255));
        welcomelb.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        welcomelb.setText("jLabel1");
        getContentPane().add(welcomelb);
        welcomelb.setBounds(0, 10, 370, 50);
        getContentPane().add(backlb);
        backlb.setBounds(0, 0, 720, 480);
        setJMenuBar(jMenuBar1);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void changepasswordBtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_changepasswordBtActionPerformed
        Changepasswordclient cp = new Changepasswordclient(socket, email);
        cp.setVisible(true);
        cp.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    }//GEN-LAST:event_changepasswordBtActionPerformed

    private void videobtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_videobtActionPerformed
        VODMainFrame obj = new VODMainFrame();
        obj.setVisible(true);
        obj.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    }//GEN-LAST:event_videobtActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel backlb;
    private javax.swing.JButton changepasswordBt;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JButton videobt;
    private javax.swing.JLabel welcomelb;
    // End of variables declaration//GEN-END:variables
}
