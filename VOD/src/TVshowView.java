
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;

public class TVshowView extends javax.swing.JInternalFrame {

    ArrayList<SingleTVShow> al = new ArrayList<>();
    mymodel tm;

    public TVshowView() {
        initComponents();
        this.setVisible(true);
        this.setSize(500, 500);

        tm = new mymodel();
        jTable1.setModel(tm);

        try {

            Class.forName("com.mysql.jdbc.Driver");

            Connection conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/test", "root", "hello");

            Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);

            ResultSet rs = stmt.executeQuery("select * from vid where cname='tvshows' ");

            while (rs.next()) {
                String title = rs.getString("title");
//                int epid=rs.getInt("epid");
                int vid = rs.getInt("vid");
                String director = rs.getString("director");
                String producer = rs.getString("producer");
                al.add(new SingleTVShow(vid, title, director, producer));
            }
            tm.fireTableDataChanged();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    class mymodel extends AbstractTableModel {

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
                return al.get(rowIndex).title;
            } else if (columnIndex == 2) {
                String director = al.get(rowIndex).director;
                return director;
            } else {
                String producer = al.get(rowIndex).producer;
                return producer;
            }
        }

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jBtedit = new javax.swing.JButton();
        jBtdelete = new javax.swing.JButton();

        getContentPane().setLayout(null);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Serial no", "Ttile", "Producer", "lDirector"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(120, 20, 452, 110);

        jBtedit.setText("Edit");
        jBtedit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBteditActionPerformed(evt);
            }
        });
        getContentPane().add(jBtedit);
        jBtedit.setBounds(150, 220, 120, 50);

        jBtdelete.setText("Delete");
        jBtdelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtdeleteActionPerformed(evt);
            }
        });
        getContentPane().add(jBtdelete);
        jBtdelete.setBounds(400, 220, 110, 50);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jBtdeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtdeleteActionPerformed
        int index = jTable1.getSelectedRow();
        if (index == -1) {
            JOptionPane.showMessageDialog(rootPane, "Select row first !!");
        } else {
            int ans = JOptionPane.showConfirmDialog(rootPane, "Are you sure to delete this TVShow ?",
                    "Confirmation dialog", JOptionPane.YES_NO_OPTION);
            if (ans == JOptionPane.YES_OPTION) {
                try {

                    int vid = al.get(index).vid;
                    Class.forName("com.mysql.jdbc.Driver");
                    Connection conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/test", "root", "hello");
                    Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
                    ResultSet rs = stmt.executeQuery("select * from vid where vid='" + vid + "'");
                    if (rs.next()) {
                        rs.deleteRow();
                        al.remove(index);
                        tm.fireTableDataChanged();
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
                JOptionPane.showMessageDialog(rootPane, "Selected TVShow is deleted");

                tm.fireTableDataChanged();
            }
        }
    }//GEN-LAST:event_jBtdeleteActionPerformed

    private void jBteditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBteditActionPerformed
             int index = jTable1.getSelectedRow();
        if (index == -1) {
            JOptionPane.showMessageDialog(this, "Select any category first !!");
        } else {
            int vid = al.get(index).vid;

            EditTVShow em = new EditTVShow(vid);

            em.setSize(700, 900);
            em.setIconifiable(true);
            em.setResizable(true);
            em.setVisible(true);

            this.getDesktopPane().add(em);

            em.moveToFront();
        }
    }//GEN-LAST:event_jBteditActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBtdelete;
    private javax.swing.JButton jBtedit;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
