
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.AbstractTableModel;

public class Viewepisode extends javax.swing.JInternalFrame {

    ArrayList<Singleepisode> al = new ArrayList<>();
    mymodel tm;
    String title;
    int vid;
    int epid;

    public Viewepisode() {
        initComponents();
        this.setVisible(true);
        this.setSize(500, 500);

        tm = new mymodel();
        jTable1.setModel(tm);

        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/test", "root", "hello");
            Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            ResultSet rs = stmt.executeQuery("select * from vid where cname = 'tvshows'");
            jComboBox1.addItem("--Select the TV Show--");

            while (rs.next()) {
                String title = rs.getString("title");

                jComboBox1.addItem(title);

            }
            tm.fireTableDataChanged();

        } catch (Exception e) {
        }
    }

    class mymodel extends AbstractTableModel {

        String title[] = {"Serial no", "Episode Name", "Description", "Duration"};

        public String getColumnName(int Column) {
            return title[Column];
        }

        public int getRowCount() {
            return al.size();
        }

        public int getColumnCount() {
            return 4;
        }

        public Object getValueAt(int rowIndex, int columnIndex) {
            if (columnIndex == 0) {
                return rowIndex + 1;
            } else if (columnIndex == 1) {
                return al.get(rowIndex).episode_name;
            } else if (columnIndex == 2) {
                String description = al.get(rowIndex).description;
                return description;
            } else {
                String duration = al.get(rowIndex).duration;
                return duration;
            }
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jComboBox1 = new javax.swing.JComboBox<>();
        jBtedit = new javax.swing.JButton();
        jBdelete = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();

        getContentPane().setLayout(null);

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] {  }));
        jComboBox1.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jComboBox1ItemStateChanged(evt);
            }
        });
        getContentPane().add(jComboBox1);
        jComboBox1.setBounds(170, 20, 390, 30);

        jBtedit.setText("Edit");
        jBtedit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBteditActionPerformed(evt);
            }
        });
        getContentPane().add(jBtedit);
        jBtedit.setBounds(80, 340, 130, 40);

        jBdelete.setText("Delete");
        jBdelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBdeleteActionPerformed(evt);
            }
        });
        getContentPane().add(jBdelete);
        jBdelete.setBounds(460, 340, 130, 40);

        jLabel1.setText("Edit TV show");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(40, 30, 110, 14);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Serial number", "Episode name", "Description", "Duration"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(90, 100, 500, 190);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jBteditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBteditActionPerformed
        int index = jTable1.getSelectedRow();
        if (index == -1) {
            JOptionPane.showMessageDialog(this, "Select any Episode first !!");
        } else {
            int epid = al.get(index).epid;
            Editepisode ep = new Editepisode(epid);
            ep.setSize(700, 900);
            ep.setIconifiable(true);
            ep.setResizable(true);
            ep.setVisible(true);

            this.getDesktopPane().add(ep);

            ep.moveToFront();
        }
    }//GEN-LAST:event_jBteditActionPerformed

    private void jComboBox1ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jComboBox1ItemStateChanged
        title = jComboBox1.getSelectedItem().toString();
        al.clear();
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/test", "root", "hello");
            Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            ResultSet rs1 = stmt.executeQuery("select * from vid where title = '" + title + "' ");
            if (rs1.next()) {
                vid = rs1.getInt("vid");
            }
            ResultSet rs = stmt.executeQuery("select * from episode where vid = '" + vid + "' ");
            while (rs.next()) {

                String episode_name = rs.getString("episode_name");
                String description = rs.getString("description");
                String duration = rs.getString("duration");
                int epid = rs.getInt("epid");

                al.add(new Singleepisode(epid, episode_name, description, duration));
            }
            tm.fireTableDataChanged();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }//GEN-LAST:event_jComboBox1ItemStateChanged

    private void jBdeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBdeleteActionPerformed
        // TODO add your handling code here:
        int index = jTable1.getSelectedRow();
        if (index == -1) {
            JOptionPane.showMessageDialog(this, "Select row first !!");
        } else {
            int ans = JOptionPane.showConfirmDialog(this, "Are you sure to delete this movie ?",
                    "Confirmation dialog", JOptionPane.YES_NO_OPTION);
            if (ans == JOptionPane.YES_OPTION) {
                try {

                    int epid = al.get(index).epid;
                    Class.forName("com.mysql.jdbc.Driver");
                    Connection conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/test", "root", "hello");
                    Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
                    ResultSet rs = stmt.executeQuery("select * from episode where epid = '"+epid+"'");
                    if (rs.next()) {
                        rs.deleteRow();
                        al.remove(index);
                        tm.fireTableDataChanged();
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
                JOptionPane.showMessageDialog(this, "Selected episode is deleted");

                tm.fireTableDataChanged();
            }
    }   
    }//GEN-LAST:event_jBdeleteActionPerformed
    public class Singleepisode {

        int epid;

        String episode_name;
        String description;
        String duration;

        public Singleepisode(int epid, String episode_name, String description, String duration) {
            this.epid = epid;
            this.episode_name = episode_name;
            this.description = description;
            this.duration = duration;

        }
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBdelete;
    private javax.swing.JButton jBtedit;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
