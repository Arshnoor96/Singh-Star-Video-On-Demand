
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

public class Addcategory extends javax.swing.JInternalFrame {

    String photopath;
    JFileChooser ch;
    String path;

    public Addcategory() {
        initComponents();
        this.setVisible(true);
        this.setSize(700, 600);
        ch = new JFileChooser("D:\\");
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jTFcn = new javax.swing.JTextField();
        jBbrowse = new javax.swing.JButton();
        jBadd = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTAcd = new javax.swing.JTextArea();
        jLphoto = new javax.swing.JLabel();

        getContentPane().setLayout(null);

        jLabel1.setText("Category Name");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(33, 28, 130, 40);

        jLabel2.setText("Category Discription");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(30, 90, 140, 40);

        jLabel3.setText("Category Photo");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(30, 190, 140, 60);
        getContentPane().add(jTFcn);
        jTFcn.setBounds(190, 30, 150, 40);

        jBbrowse.setText("Browse");
        jBbrowse.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBbrowseActionPerformed(evt);
            }
        });
        getContentPane().add(jBbrowse);
        jBbrowse.setBounds(190, 210, 160, 40);

        jBadd.setText("ADD");
        jBadd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBaddActionPerformed(evt);
            }
        });
        getContentPane().add(jBadd);
        jBadd.setBounds(190, 300, 170, 80);

        jTAcd.setColumns(20);
        jTAcd.setRows(5);
        jScrollPane1.setViewportView(jTAcd);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(190, 90, 166, 96);
        getContentPane().add(jLphoto);
        jLphoto.setBounds(420, 190, 260, 150);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jBbrowseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBbrowseActionPerformed
        try {
            int ans = ch.showOpenDialog(Addcategory.this);
            if (ans == JFileChooser.APPROVE_OPTION) {
                File f = ch.getSelectedFile();
                path = f.getPath();
                Image scaledimage = ImageIO.read(new File(path)).getScaledInstance(jLphoto.getWidth(), jLphoto.getHeight(), Image.SCALE_SMOOTH);
                ImageIcon img = new ImageIcon(scaledimage);
                jLphoto.setIcon(img);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }//GEN-LAST:event_jBbrowseActionPerformed

    private void jBaddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBaddActionPerformed
        // TODO add your handling code here:
        String cname = jTFcn.getText();
        String cdesc = jTAcd.getText();
        if (cname == null || cdesc == null) {
            JOptionPane.showMessageDialog(this, "All fields required enter again");
        } else {
            try {

                Class.forName("com.mysql.jdbc.Driver");

                Connection conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/test", "root", "hello");

                Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);

                ResultSet rs = stmt.executeQuery("select * from category where name='" + cname + "' ");
                System.out.println("ResultSet created");

                if (rs.next()) {

                    JOptionPane.showMessageDialog(this, "this category already exists");

                } else if (path == null) {
                    rs.moveToInsertRow();
                    rs.updateString("name", cname);
                    rs.updateString("description", cdesc);
                    rs.updateString("photo", "D:\\Abheyjeet\\Pixxoooo\\10172592_890798847633587_1960178288060575055_n.JPEG");
//                       
                    rs.insertRow();

                    jTAcd.setText("");
                    jTFcn.setText("");
                    jLphoto.setText("");

                    JOptionPane.showMessageDialog(this, "new category added successfully");
                } else {
                    rs.moveToInsertRow();
                    rs.updateString("name", cname);
                    rs.updateString("description", cdesc);
                    rs.updateString("photo", path);
//                       
                    rs.insertRow();

                    jTAcd.setText("");
                    jTFcn.setText("");

                    JOptionPane.showMessageDialog(this, "new category added successfully");
                }

            } catch (Exception ex) {
                ex.printStackTrace();
            }

        }
    }//GEN-LAST:event_jBaddActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBadd;
    private javax.swing.JButton jBbrowse;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLphoto;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTAcd;
    private javax.swing.JTextField jTFcn;
    // End of variables declaration//GEN-END:variables
}
