
import java.awt.Color;
import java.awt.Image;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import static javax.swing.WindowConstants.DISPOSE_ON_CLOSE;

public class adminhome extends javax.swing.JFrame {

    String email;

    public adminhome(String email) throws IOException {

        this.email = email;

        Server server = new Server();
        Thread th = new Thread(server);
        th.start();
        initComponents();
        getContentPane().setBackground(Color.PINK);
        this.setTitle("ADMIN HOME");
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        this.setVisible(true);
        this.setSize(1200, 900);
        this.setResizable(false);
        dpback.setSize(1200, 900);
        labelback.setSize(1200, 900);
          Image scaledimage2 = ImageIO.read(new File("C:\\Users\\Arshnoor Singh\\Desktop\\New folder\\depositphotos_23778971-stock-illustration-blue-technology-background-vector.jpg ")).getScaledInstance(labelback.getWidth(), labelback.getHeight(), Image.SCALE_SMOOTH);
            ImageIcon img2 = new ImageIcon(scaledimage2);
          
            labelback.setIcon(img2);

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jDesktopPane2 = new javax.swing.JDesktopPane();
        jMenuBar2 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenu2 = new javax.swing.JMenu();
        jMenuItem4 = new javax.swing.JMenuItem();
        dpback = new javax.swing.JDesktopPane();
        labelback = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMmanagecategory = new javax.swing.JMenu();
        jMenuItemAdd = new javax.swing.JMenuItem();
        jMenuItemview = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenu4 = new javax.swing.JMenu();
        jMenuItem5 = new javax.swing.JMenuItem();
        jMenuItem6 = new javax.swing.JMenuItem();
        jMenuItem7 = new javax.swing.JMenuItem();
        jMenuItem8 = new javax.swing.JMenuItem();
        jMenuChangepassword = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();

        jMenu1.setText("File");
        jMenuBar2.add(jMenu1);

        jMenu2.setText("Edit");
        jMenuBar2.add(jMenu2);

        jMenuItem4.setText("jMenuItem4");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        labelback.setText("jLabel1");
        dpback.add(labelback);
        labelback.setBounds(0, 0, 1060, 650);

        getContentPane().add(dpback);
        dpback.setBounds(0, 0, 1060, 650);

        jMmanagecategory.setText("Manage category");

        jMenuItemAdd.setText("Add");
        jMenuItemAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemAddActionPerformed(evt);
            }
        });
        jMmanagecategory.add(jMenuItemAdd);

        jMenuItemview.setText("View");
        jMenuItemview.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemviewActionPerformed(evt);
            }
        });
        jMmanagecategory.add(jMenuItemview);

        jMenuBar1.add(jMmanagecategory);

        jMenu3.setText("Manage Movie");

        jMenuItem2.setText("Add Movie");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem2);

        jMenuItem3.setText("View Movie");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem3);

        jMenuBar1.add(jMenu3);

        jMenu4.setText("Manage TV Shows");

        jMenuItem5.setText("Add TV Show");
        jMenuItem5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem5ActionPerformed(evt);
            }
        });
        jMenu4.add(jMenuItem5);

        jMenuItem6.setText("View TV Show");
        jMenuItem6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem6ActionPerformed(evt);
            }
        });
        jMenu4.add(jMenuItem6);

        jMenuItem7.setText("Add Episode");
        jMenuItem7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem7ActionPerformed(evt);
            }
        });
        jMenu4.add(jMenuItem7);

        jMenuItem8.setText("View Episode");
        jMenuItem8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem8ActionPerformed(evt);
            }
        });
        jMenu4.add(jMenuItem8);

        jMenuBar1.add(jMenu4);

        jMenuChangepassword.setText("Other");

        jMenuItem1.setText("Change Password");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenuChangepassword.add(jMenuItem1);

        jMenuBar1.add(jMenuChangepassword);

        setJMenuBar(jMenuBar1);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        changepassword cp1 = new changepassword(email);
        cp1.setMaximizable(true);
        cp1.setResizable(false);
        cp1.setClosable(true);
        cp1.setSize(700, 500);
        cp1.setIconifiable(true);
        cp1.setResizable(true);
        cp1.setVisible(true);
        cp1.moveToFront();
        dpback.add(cp1);
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jMenuItemAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemAddActionPerformed
        Addcategory ac1 = new Addcategory();
        ac1.setSize(700, 500);
        ac1.setMaximizable(true);
        ac1.setResizable(false);
        ac1.setClosable(true);
        ac1.setIconifiable(true);
        ac1.setResizable(true);
        ac1.setVisible(true);
        ac1.moveToFront();
        dpback.add(ac1);

    }//GEN-LAST:event_jMenuItemAddActionPerformed

    private void jMenuItemviewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemviewActionPerformed
        Viewcategory vc1 = new Viewcategory();
        vc1.setMaximizable(true);
        vc1.setResizable(false);
        vc1.setClosable(true);
        vc1.setSize(700, 500);
        vc1.setIconifiable(true);
        vc1.setResizable(true);
        vc1.setVisible(true);
        vc1.moveToFront();
        dpback.add(vc1);

    }//GEN-LAST:event_jMenuItemviewActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        Addvideos av = new Addvideos();
        av.setSize(800, 500);
        av.setIconifiable(true);
        av.setMaximizable(true);
        av.setResizable(false);
        av.setClosable(true);
        av.setVisible(true);
        av.moveToFront();
        dpback.add(av);

    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
        Viewmovies vm = new Viewmovies();
        vm.setSize(800, 500);
        vm.setIconifiable(true);
        vm.setMaximizable(true);
        vm.setResizable(false);
        vm.setClosable(true);
        vm.setVisible(true);
        vm.moveToFront();
        dpback.add(vm);
    }//GEN-LAST:event_jMenuItem3ActionPerformed

    private void jMenuItem5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem5ActionPerformed
        AddTVShow tvs = new AddTVShow();
        tvs.setSize(800, 500);
        tvs.setIconifiable(true);
        tvs.setMaximizable(true);
        tvs.setResizable(false);
        tvs.setClosable(true);
        tvs.setVisible(true);
        tvs.moveToFront();
        dpback.add(tvs);
    }//GEN-LAST:event_jMenuItem5ActionPerformed

    private void jMenuItem6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem6ActionPerformed
        TVshowView vtv = new TVshowView();
        vtv.setSize(800, 500);
        vtv.setIconifiable(true);
        vtv.setMaximizable(true);
        vtv.setResizable(false);
        vtv.setClosable(true);
        vtv.setVisible(true);
        vtv.moveToFront();
        dpback.add(vtv);
    }//GEN-LAST:event_jMenuItem6ActionPerformed

    private void jMenuItem7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem7ActionPerformed
        Addepisode1 ad = new Addepisode1();
        ad.setSize(800, 500);
        ad.setIconifiable(true);
        ad.setMaximizable(true);
        ad.setResizable(false);
        ad.setClosable(true);
        ad.setVisible(true);
        ad.moveToFront();
        dpback.add(ad);
    }//GEN-LAST:event_jMenuItem7ActionPerformed

    private void jMenuItem8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem8ActionPerformed
        Viewepisode ve = new Viewepisode();
        ve.setSize(800, 500);
        ve.setIconifiable(true);
        ve.setMaximizable(true);
        ve.setResizable(false);
        ve.setClosable(true);
        ve.setVisible(true);
        ve.moveToFront();
        dpback.add(ve);
    }//GEN-LAST:event_jMenuItem8ActionPerformed

    public class Server implements Runnable {

        ServerSocket sersock;

        public Server() {

        }

        public void run() {
            try {
                sersock = new ServerSocket(9000);
                while (true) {
                    Socket socket = sersock.accept();

                    ClientHandler ch = new ClientHandler(socket);
                    Thread th = new Thread(ch);
                    th.start();
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }

        public class ClientHandler implements Runnable {

            Socket socket;
            DataInputStream dis;
            DataOutputStream dos;
            private Connection dbCon;
            String readline = "";

            public ClientHandler(Socket socket) {
                this.socket = socket;
                try {
                    Class.forName("com.mysql.jdbc.Driver");
                    dbCon = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/test", "root", "hello");
                } catch (ClassNotFoundException | SQLException e) {
                    System.out.println("Error : While initializing : " + e.getMessage());
                }
            }

            @Override
            public void run() {

                try {
                    dis = new DataInputStream(socket.getInputStream());
                    dos = new DataOutputStream(socket.getOutputStream());
                    String headers = "";

                    do {
                        readline = dis.readLine();
                        System.out.println("readline " + readline);
                        if (readline.equals("Signup")) {
                            signup();
                        } else if (readline.equals("login")) {
                            login();
                        } else if (readline.equals("forgetpassword")) {

                            forgetpassword();
                        } else if (readline.equals("")) {
                            break;
                        } else if (readline.equals("")) {
                            headers = headers + readline + "\n";
                        } else if (readline.equals("changepassword")) {
                            changepassword();
                        } else if (readline.equals("sendmovies")) {
                            sendmovies();
                        } else if (readline.equals("senddata")) {
                            sendRandomRows();
                        } else if (readline.equals("sendGenreMovie")) {
                            sendGenreMovie();
                        } else if (readline.equals("sendgenretv")) {
                            sendgenretv();
                        } else if (readline.equals("sendGenre")) {
                            sendGenre();
                        } else if (readline.equals("sendMovies")) {
                            sendMovies();
                        } else if (readline.equals("sendGenreForTv")) {
                            sendGenreForTv();
                        } else if (readline.equals("sendTvShows")) {
                            sendTvShows();
                        } else if (readline.equals("sendEpisodeForTv")) {
                            sendEpisodeForTv();
                        } else if (readline.equals("sendTvShowEpisodes")) {
                            sendTvShowEpisodes();
                        }
                    } while (readline != null);

                    if (headers.contains(".mp4")) {
                        int indexOfFirstSlash = headers.indexOf("/");
                        int indexOfSpaceAfterFirstSlash = headers.indexOf(" ", indexOfFirstSlash);
                        if (indexOfFirstSlash != -1 && indexOfSpaceAfterFirstSlash != -1) {
                            String uri1 = headers.substring(indexOfFirstSlash, indexOfSpaceAfterFirstSlash);
                            System.out.println(uri1 + " ******uri");
                            if (uri1.endsWith(".mp4")) {
                                handleRequest1(dis, dos, headers, uri1);
                            } else if (uri1.endsWith(".jpg") || uri1.endsWith(".JPG") || uri1.endsWith(".JPEG")
                                    || uri1.endsWith(".png") || uri1.endsWith(".PNG")) {
                                sendImageToClient(uri1);
                            } else {
                                //write logic for index.html page
                            }
                        } else {
                            String backResponse = "HTTP/1.1 404 Not Found\r\n";
                            backResponse = backResponse + "Date: " + new Date() + "\r\n";
                            dos.writeBytes(backResponse + "\r\n");
                            dos.close();
                            dis.close();
                            socket.close();
                        }
                    }

                } catch (Exception e) {
                    System.out.println("Error while handling @" + socket.getPort());
                    System.out.println("Excepiton :" + e.getMessage());
                } finally {
                    try {
                        socket.close();
                    } catch (IOException ex) {
                        System.out.println("Error received while closing socket");
                        System.out.println("Exception: " + ex.getMessage());
                    }
                    if (dbCon != null) {
                        try {
                            dbCon.close();
                        } catch (SQLException sqlEx) {
                            System.out.println("Error while closing connection with database:");
                            System.out.println("Exception :" + sqlEx.getMessage());
                        }
                    }
                }
            }

            private void handleRequest1(DataInputStream dis, DataOutputStream dos, String headers, String uri1) {
                try {
                    File wwwroot = new File(".").getAbsoluteFile(); //get the directory where the videos are being saved
                    File f = new File(uri1); //make file object of requested video from wwwroot folder
                    if (!f.exists())//check if file exists or not,if exits then serve that file to client :)
                    {
                        String backResponse = "HTTP/1.1 404 Not Found\r\n";
                        backResponse = backResponse + "Date: " + new Date() + "\r\n";
                        dos.writeBytes(backResponse + "\r\n");
                        dos.close();
                        dis.close();
                        socket.close();
                        return;
                    }
                    String mime = "video/mp4";
                    try {
                        String etag = Integer.toHexString((f.getAbsolutePath() + f.lastModified() + "" + f.length()).hashCode());
                        long startFrom = 0;
                        long endAt = -1;

                        if (headers.contains("bytes=")) {
                            int indexOfBytesEquals = headers.indexOf("bytes=");
                            String range1 = headers.substring(indexOfBytesEquals);
                            range1 = range1.substring("bytes=".length());
                            int minus = range1.indexOf('-');
                            if (minus > 0) {
                                startFrom = Long.parseLong(range1.substring(0, minus));
                                String substring = range1.substring(0, minus + 1);
                                if (substring.length() > substring.indexOf("-") + 1) {
                                    endAt = Long.parseLong(substring.substring(substring.indexOf("-") + 1));
                                }
                            }
                            String backResponse = "HTTP/1.0 206 Partial Content\r\n";
                            backResponse = backResponse + "Content-Type: " + mime + "\r\n";
                            backResponse = backResponse + "Date: " + new Date() + "\r\n";
                            long fileLen = f.length();
                            if (range1 != null && startFrom >= 0) {
                                if (startFrom >= fileLen) {
                                    backResponse = backResponse + "Content-Range: bytes 0-0/" + fileLen + "\r\n";
                                    backResponse = backResponse + "ETag: " + etag + "\r\n";
                                    dos.writeBytes(backResponse + "\r\n");
                                } else {
                                    if (endAt < 0) {
                                        endAt = fileLen - 1;
                                    }
                                    long newLen = endAt - startFrom + 1;
                                    if (newLen < 0) {
                                        newLen = 0;
                                    }

                                    final long dataLen = newLen;
                                    FileInputStream fis = new FileInputStream(f) {
                                        public int available() throws IOException {
                                            return (int) dataLen;
                                        }
                                    };
                                    fis.skip(startFrom);
                                    backResponse = backResponse + "Content-Length: " + dataLen + "\r\n";
                                    backResponse = backResponse + "Content-Range: " + "bytes " + startFrom + "-" + endAt + "/" + fileLen + "\r\n";
                                    backResponse = backResponse + "ETag: " + etag + "\r\n";
                                    backResponse = backResponse + "Accept-Ranges: bytes\r\n";
                                    dos.writeBytes(backResponse + "\r\n");
                                    if (fis != null) {
                                        int pending = fis.available();
                                        int theBufferSize = 16 * 1024;
                                        byte[] buff = new byte[theBufferSize];
                                        while (pending > 0) {
                                            int read = fis.read(buff, 0, ((pending > theBufferSize)
                                                    ? theBufferSize : pending));
                                            if (read <= 0) {
                                                break;
                                            }
                                            dos.write(buff, 0, read);
                                            pending -= read;
                                        }
                                    }
                                    dos.close();
                                    if (fis != null) {
                                        fis.close();
                                    }
                                }
                            }
                        }
                    } catch (IOException ioe) {
                    }
                } catch (Exception e) {
                }
            }

            private void sendImageToClient(String uri1) {
                try {
                    File wwwroot = new File(".").getAbsoluteFile(); //get the directory where the images are being saved
                    File imageFolder = new File(wwwroot, "images");
                    if (!imageFolder.exists()) {
                        imageFolder.mkdir();
                    }
                    File f = new File(imageFolder, uri1); //make file object of requested image from wwwroot folder
                    if (!f.exists())//check if file exists or not,if exits then serve that file to client :)
                    {
                        String backResponse = "HTTP/1.1 404 Not Found\r\n";
                        backResponse = backResponse + "Date: " + new Date() + "\r\n";
                        dos.writeBytes(backResponse + "\r\n");
                        dos.close();
                        dis.close();
                        dis.close();
                        return;
                    } else {
                        String mime = "";
                        uri1 = uri1.toLowerCase();
                        if (uri1.endsWith("jpg") || uri1.endsWith("jpeg")) {
                            mime = "image/jpeg";
                        } else if (uri1.endsWith("png")) {
                            mime = "image/png";
                        }
                        System.out.println(mime + " mime type");
                        long length = f.length();
                        String backResponse = "HTTP/1.0 200 OK\r\n";
                        backResponse = backResponse + "Content-Type: " + mime + "\r\n";
                        backResponse = backResponse + "Date: " + new Date() + "\r\n";
                        backResponse = backResponse + "Content-Length: " + length + "\r\n";
                        dos.writeBytes(backResponse + "\r\n");
                        FileInputStream fis = new FileInputStream(f);

                        if (fis != null) {
                            int pending = fis.available();
                            int theBufferSize = 16 * 1024;
                            byte[] buff = new byte[theBufferSize];
                            while (pending > 0) {
                                int read = fis.read(buff, 0, ((pending > theBufferSize)
                                        ? theBufferSize : pending));
                                if (read <= 0) {
                                    break;
                                }
                                dos.write(buff, 0, read);
                                pending -= read;
                            }
                        }
                        dos.close();
                        if (fis != null) {
                            fis.close();
                        }
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

            private void sendRandomRows() {
                try {
                    Statement stmt = dbCon.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
                            ResultSet.CONCUR_UPDATABLE);
                    ResultSet rs = stmt.executeQuery("SELECT * from vid where cname='movies' order by rand()");

                    while (rs.next()) {
                        String videoid = rs.getString("vid");
                        String type = rs.getString("cname");
                        String mname = rs.getString("title");
                        String mpath = rs.getString("video_path");
                        String mtrailerpath = rs.getString("trailer_path");
                        String mdirector = rs.getString("director");
                        String mproducer = rs.getString("producer");
                        String rating = rs.getString("rating");
                        String releasedate = rs.getString("release_date");
                        String description = rs.getString("description");
                        String cover = rs.getString("cover_photo");
                        String square = rs.getString("square_photo");
                        String genre = rs.getString("genre");

                        dos.writeUTF("receive");
                        dos.writeUTF(mname);
                        dos.writeUTF(mpath);
                        dos.writeUTF(mtrailerpath);
                        dos.writeUTF(mdirector);
                        dos.writeUTF(mproducer);
                        dos.writeUTF(rating);
                        dos.writeUTF(releasedate);
                        dos.writeUTF(description);
                        dos.writeUTF(cover);
                        dos.writeUTF(square);
                        dos.writeUTF(videoid);
                        dos.writeUTF(type);
                        dos.writeUTF(genre);

                    }
                    dos.writeUTF("done");

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

            private void sendGenreMovie() {
                try {
                    Statement stmt = dbCon.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
                            ResultSet.CONCUR_UPDATABLE);
                    ResultSet rs = stmt.executeQuery("SELECT title,square_photo from vid where genre in(select genre_name from genre order by rand()) and   cname='movies'\n"
                            + " order by rand() limit 3");

                    while (rs.next()) {
                        String mname = rs.getString("title");
                        String square = rs.getString("square_photo");
                        dos.writeUTF("receive");
                        dos.writeUTF(mname);
                        dos.writeUTF(square);
                    }
                    dos.writeUTF("done");
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

            private void sendgenretv() {
                try {
                    Statement stmt = dbCon.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
                            ResultSet.CONCUR_UPDATABLE);
                    ResultSet rs = stmt.executeQuery("SELECT vid,title,square_photo from vid where genre in(select genre_name from genre order by rand()) and   cname='tvshows'\n"
                            + "                             order by rand() limit 3");

                    while (rs.next()) {
                        int vid = rs.getInt("vid");
                        String title = rs.getString("title");
                        String square = rs.getString("square_photo");

                        dos.writeUTF("receive");
                        dos.writeInt(vid);
                        dos.writeUTF(title);
                        dos.writeUTF(square);
                    }
                    dos.writeUTF("done");
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

            private void sendGenre() {
                try {
                    Statement stmt = dbCon.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
                            ResultSet.CONCUR_UPDATABLE);
                    ResultSet rs = stmt.executeQuery("SELECT distinct genre from vid;");

                    while (rs.next()) {
                        String mname = rs.getString("genre");
                        dos.writeUTF(mname);
                    }
                    dos.writeUTF("done");
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

            private void sendMovies() {
                try {
                    String genrename = dis.readLine();
                    Statement stmt = dbCon.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
                            ResultSet.CONCUR_UPDATABLE);
                    ResultSet rs = stmt.executeQuery("SELECT *from vid where genre='" + genrename + "' and cname='movies'");

                    while (rs.next()) {
                        String videoid = rs.getString("vid");
                        String type = rs.getString("cname");
                        String mname = rs.getString("title");
                        String mpath = rs.getString("video_path");
                        String mtrailerpath = rs.getString("trailer_path");
                        String mdirector = rs.getString("director");
                        String mproducer = rs.getString("producer");
                        String rating = rs.getString("rating");
                        String releasedate = rs.getString("release_date");
                        String description = rs.getString("description");
                        String cover = rs.getString("cover_photo");
                        String square = rs.getString("square_photo");
                        String genre = rs.getString("genre");

                        dos.writeUTF("receive");
                        dos.writeUTF(mname);
                        dos.writeUTF(mpath);
                        dos.writeUTF(mtrailerpath);
                        dos.writeUTF(mdirector);
                        dos.writeUTF(mproducer);
                        dos.writeUTF(rating);
                        dos.writeUTF(releasedate);
                        dos.writeUTF(description);
                        dos.writeUTF(cover);
                        dos.writeUTF(square);
                        dos.writeUTF(videoid);
                        dos.writeUTF(type);
                        dos.writeUTF(genre);

                    }
                    dos.writeUTF("done");
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

            private void sendGenreForTv() {
                try {
                    Statement stmt = dbCon.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
                            ResultSet.CONCUR_UPDATABLE);
                    ResultSet rs = stmt.executeQuery("SELECT distinct genre from vid where cname='tvshows'");

                    while (rs.next()) {
                        String mname = rs.getString("genre");
                        dos.writeUTF(mname);
                    }
                    dos.writeUTF("done");
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

            private void sendTvShows() {
                try {
                    String genrename = dis.readLine();
                    Statement stmt = dbCon.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
                            ResultSet.CONCUR_UPDATABLE);
                    ResultSet rs = stmt.executeQuery("SELECT *from vid where genre='" + genrename + "' and cname='tvshows'");

                    while (rs.next()) {
                        int videoid = rs.getInt("vid");
                        String type = rs.getString("cname");
                        String mname = rs.getString("title");

                        String mdirector = rs.getString("director");
                        String mproducer = rs.getString("producer");

                        String cover = rs.getString("cover_photo");
                        String square = rs.getString("square_photo");
                        String genre = rs.getString("genre");

                        dos.writeUTF("receive");
                        dos.writeUTF(mname);

                        dos.writeUTF(mdirector);
                        dos.writeUTF(mproducer);

                        dos.writeUTF(cover);
                        dos.writeUTF(square);
                        dos.writeInt(videoid);
                        dos.writeUTF(type);
                        dos.writeUTF(genre);

                    }
                    dos.writeUTF("done");
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

            private void sendEpisodeForTv() {
                try {
                    int vid = dis.readInt();
                    Statement stmt = dbCon.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
                            ResultSet.CONCUR_UPDATABLE);
                    ResultSet rs = stmt.executeQuery("SELECT * from episode where vid='" + vid + "'");

                    while (rs.next()) {
                        String mname = rs.getString("episode_name");
                        dos.writeUTF(mname);
                    }
                    dos.writeUTF("done");
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

            private void sendTvShowEpisodes() {
                try {
                    String genrename = dis.readLine();
                    String name = dis.readLine();
                    Statement stmt = dbCon.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
                            ResultSet.CONCUR_UPDATABLE);
                    ResultSet rs = stmt.executeQuery("SELECT *from episode where vid='" + genrename + "' ");

                    while (rs.next()) {
                        int epid = rs.getInt("epid");
                        String episode_name = rs.getString("episode_name");
                        String episode_cover_photo = rs.getString("episode_cover_photo");

                        String episode_square_photo = rs.getString("episode_square_photo");
                        String duration = rs.getString("duration");

                        String video_path = rs.getString("video_path");
                        String description = rs.getString("description");

                        dos.writeUTF("receive");
                        dos.writeInt(epid);

                        dos.writeUTF(episode_name);
                        dos.writeUTF(episode_cover_photo);

                        dos.writeUTF(episode_square_photo);
                        dos.writeUTF(duration);
                        dos.writeUTF(video_path);
                        dos.writeUTF(description);

                    }
                    dos.writeUTF("done");
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

            public void signup() {
                try {
                    String email = dis.readLine();
                    String password = dis.readLine();
                    String sec_ques = dis.readLine();
                    String sec_ans = dis.readLine();
                    String contact = dis.readLine();
                    try {
                        Class.forName("com.mysql.jdbc.Driver");
                        Connection conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/test", "root", "hello");
                        Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
                        ResultSet rs = stmt.executeQuery("select * from client_login where email = '" + email + "' ");
                        if (rs.next()) {
                            dos.writeBytes("sameuseralreadyexist\r\n ");
                        } else {
                            rs.moveToInsertRow();
                            rs.updateString("email", email);
                            rs.updateString("password", password);
                            rs.updateString("security_question", sec_ques);
                            rs.updateString("security_answer", sec_ans);
                            rs.updateString("contact", contact);
                            rs.insertRow();
                            dos.writeBytes("signupsuccess\r\n ");
                        }

                    } catch (Exception e) {
                        e.printStackTrace();
                    }

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

            public void login() {
                try {
                    String email = dis.readLine();
                    String password = dis.readLine();
                    System.out.println(email);
                    System.out.println(password);

                    Class.forName("com.mysql.jdbc.Driver");
                    Connection conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/test", "root", "hello");
                    Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
                    ResultSet rs = stmt.executeQuery("select * from client_login where email = '" + email + "' and password = '" + password + "'");
                    if (rs.next()) {
                        dos.writeBytes("success\r\n ");
                    } else {
                        dos.writeBytes("fail\r\n ");
                    }

                } catch (Exception e) {
                    e.printStackTrace();
                }

            }

            private void forgetpassword() {
                try {
                    String email = dis.readLine();
                    try {
                        Class.forName("com.mysql.jdbc.Driver");
                        Connection conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/test", "root", "hello");
                        Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
                        ResultSet rs = stmt.executeQuery("select * from client_login where email = '" + email + "' ");
                        if (rs.next()) {
                            dos.writeBytes("emailsuccess\r\n");
                            dos.writeBytes(rs.getString("security_question") + "\r\n");

                            String sec_ans = dis.readLine();

                            if (sec_ans.equals(rs.getString("security_answer"))) {
                                dos.writeBytes("answercorrect\r\n");
                                dos.writeBytes(rs.getString("password") + "\r\n");
                            } else {
                                dos.writeBytes("wronganswer\r\n");
                            }
                        } else {
                            dos.writeBytes("wrongemail\r\n");
                        }

                    } catch (Exception e) {
                    }
                } catch (Exception e) {
                }
            }

            private void changepassword() {
                try {
                    String oldpassword = dis.readLine();
                    String newpassword = dis.readLine();
                    String email = dis.readLine();
                    try {
                        Class.forName("com.mysql.jdbc.Driver");
                        Connection conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/test", "root", "hello");
                        Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
                        ResultSet rs = stmt.executeQuery("select * from client_login where password = '" + oldpassword + "' "
                                + "and email='" + email + "'");
                        if (rs.next()) {
                            rs.updateString("password", newpassword);
                            rs.updateRow();
                            dos.writeBytes("success\r\n");
                        } else {
                            dos.writeBytes("wrongpassword\r\n");
                        }

                    } catch (Exception e) {
                    }
                } catch (Exception e) {
                }
            }

            public void sendmovies() {
                try {
                    Class.forName("com.mysql.jdbc.Driver");
                    Connection conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/test", "root", "hello");
                    Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
                    ResultSet rs = stmt.executeQuery("select * from vid where cname = 'movies' ");
                    if (rs.next()) {
                        dos.writeBytes("moviesare\r\n");
                    } else {
                        dos.writeBytes("error\r\n");
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

        }

    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JDesktopPane dpback;
    private javax.swing.JDesktopPane jDesktopPane2;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuBar jMenuBar2;
    private javax.swing.JMenu jMenuChangepassword;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JMenuItem jMenuItem5;
    private javax.swing.JMenuItem jMenuItem6;
    private javax.swing.JMenuItem jMenuItem7;
    private javax.swing.JMenuItem jMenuItem8;
    private javax.swing.JMenuItem jMenuItemAdd;
    private javax.swing.JMenuItem jMenuItemview;
    private javax.swing.JMenu jMmanagecategory;
    private javax.swing.JLabel labelback;
    // End of variables declaration//GEN-END:variables
}
