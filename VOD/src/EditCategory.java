
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

public class EditCategory extends javax.swing.JInternalFrame {

    JFileChooser ch;
    String photopath;
    String path;
    Singlecategory singlecategory;

    public EditCategory(Singlecategory sc) {
        singlecategory = sc;
        initComponents();
        new Thread(new Runnable() {
            public void run() {
                try {
                    jTFname.setText(singlecategory.name);
                    jTAdescription.setText(singlecategory.description);

                    Image scaledInstance = ImageIO.read(new File(singlecategory.photo)).getScaledInstance(jLbphoto.getWidth(),
                            jLbphoto.getHeight(), Image.SCALE_SMOOTH);
                    ImageIcon icon = new ImageIcon(scaledInstance);
                    jLbphoto.setIcon(icon);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }).start();
       
        this.setVisible(true);
        this.setSize(500, 500);
        ch = new JFileChooser("D:\\");
    }


    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLayeredPane1 = new javax.swing.JLayeredPane();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jTFname = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTAdescription = new javax.swing.JTextArea();
        jBtbrowse = new javax.swing.JButton();
        jLbphoto = new javax.swing.JLabel();
        jBtupdate = new javax.swing.JButton();

        javax.swing.GroupLayout jLayeredPane1Layout = new javax.swing.GroupLayout(jLayeredPane1);
        jLayeredPane1.setLayout(jLayeredPane1Layout);
        jLayeredPane1Layout.setHorizontalGroup(
            jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 210, Short.MAX_VALUE)
        );
        jLayeredPane1Layout.setVerticalGroup(
            jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        getContentPane().setLayout(null);

        jLabel1.setText("Category Name");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(40, 20, 140, 20);

        jLabel2.setText("Category Description");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(40, 80, 140, 40);

        jLabel3.setText("Category Photo");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(30, 180, 170, 40);

        jTFname.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTFnameActionPerformed(evt);
            }
        });
        getContentPane().add(jTFname);
        jTFname.setBounds(280, 10, 190, 30);

        jTAdescription.setColumns(20);
        jTAdescription.setRows(5);
        jScrollPane1.setViewportView(jTAdescription);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(280, 60, 166, 96);

        jBtbrowse.setText("Browse");
        jBtbrowse.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtbrowseActionPerformed(evt);
            }
        });
        getContentPane().add(jBtbrowse);
        jBtbrowse.setBounds(270, 190, 67, 23);
        getContentPane().add(jLbphoto);
        jLbphoto.setBounds(350, 160, 240, 130);

        jBtupdate.setText("Update");
        jBtupdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtupdateActionPerformed(evt);
            }
        });
        getContentPane().add(jBtupdate);
        jBtupdate.setBounds(240, 300, 230, 40);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTFnameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTFnameActionPerformed
        jTFname.setEnabled(false);
    }//GEN-LAST:event_jTFnameActionPerformed

    private void jBtupdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtupdateActionPerformed

        int showConfirmDialog = JOptionPane.showConfirmDialog(EditCategory.this, "Are you sure you want to update?",
                "Update Confirmatin", JOptionPane.YES_NO_OPTION);

        if (showConfirmDialog == JOptionPane.YES_OPTION) {
            try {
                String cname = jTFname.getText();
                String tadesc = jTAdescription.getText();
//get cname from tf
                Class.forName("com.mysql.jdbc.Driver");

                Connection conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/test", "root", "hello");

                Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);

                ResultSet rs = stmt.executeQuery("select * from Category where name = '" + cname + "'");

                if (rs.next()) {
                    rs.updateString("description", tadesc);
                    if (path != null) {
                        rs.updateString("photo", path);
                    }
                    rs.updateRow();
                    JOptionPane.showMessageDialog(this, "Category updated successfully!!");
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }

    }//GEN-LAST:event_jBtupdateActionPerformed

    private void jBtbrowseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtbrowseActionPerformed
        try {

            int ans = ch.showOpenDialog(EditCategory.this);

            if (ans == JFileChooser.APPROVE_OPTION) {
                File f = ch.getSelectedFile();
                path = f.getPath();
                Image scaledimage = ImageIO.read(new File(path)).getScaledInstance(jLbphoto.getWidth(), jLbphoto.getHeight(), Image.SCALE_SMOOTH);
                ImageIcon img = new ImageIcon(scaledimage);
                jLbphoto.setIcon(img);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_jBtbrowseActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBtbrowse;
    private javax.swing.JButton jBtupdate;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLayeredPane jLayeredPane1;
    private javax.swing.JLabel jLbphoto;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTAdescription;
    private javax.swing.JTextField jTFname;
    // End of variables declaration//GEN-END:variables
}
