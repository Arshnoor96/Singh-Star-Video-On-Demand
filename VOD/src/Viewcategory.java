
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableModel;

public class Viewcategory extends javax.swing.JInternalFrame {

    ArrayList<Singlecategory> al = new ArrayList<>();
//    JTable jt;
    mymodel tm;
//    JScrollPane jsp;

    public Viewcategory() {
        initComponents();

        tm = new mymodel();

        cattable.setModel(tm);
//        jsp = new JScrollPane(jt);
//        this.add(jsp);
        this.setVisible(true);
        this.setSize(500, 500);

        try {
            Class.forName("com.mysql.jdbc.Driver");

            Connection conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/test", "root", "hello");

            Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);

            ResultSet rs = stmt.executeQuery("select * from category ");

            while (rs.next()) {
                String name = rs.getString("name");
                String des = rs.getString("description");
                String photo = rs.getString("photo");
                al.add(new Singlecategory(name, des, photo));
            }
            tm.fireTableDataChanged();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    class mymodel extends AbstractTableModel {

        String title[] = {"Serial no", "Category Name", "Category Description"};

        public String getColumnName(int Column) {
            return title[Column];
        }

        public int getRowCount() {
            return al.size();
        }

        public int getColumnCount() {
            return 3;
        }

        public Object getValueAt(int rowIndex, int columnIndex) {
            if (columnIndex == 0) {
                return rowIndex + 1;
            } else if (columnIndex == 1) {
                return al.get(rowIndex).name;
            } else {
                String description = al.get(rowIndex).description;
                return description;
            }
        }

    }


    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        cattable = new javax.swing.JTable();
        jBtedit = new javax.swing.JButton();
        jBtdelete = new javax.swing.JButton();

        getContentPane().setLayout(null);

        cattable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Serial No", "Category name", "Category description "
            }
        ));
        jScrollPane1.setViewportView(cattable);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(100, 50, 452, 110);

        jBtedit.setText("Edit");
        jBtedit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBteditActionPerformed(evt);
            }
        });
        getContentPane().add(jBtedit);
        jBtedit.setBounds(110, 220, 110, 40);

        jBtdelete.setText("Delete");
        jBtdelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtdeleteActionPerformed(evt);
            }
        });
        getContentPane().add(jBtdelete);
        jBtdelete.setBounds(430, 220, 120, 40);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jBtdeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtdeleteActionPerformed
        {
            int index = cattable.getSelectedRow();
            if (index == -1) {
                JOptionPane.showMessageDialog(this, "Select row first !!");
            } else {
                int ans = JOptionPane.showConfirmDialog(this, "Are you sure to delete this category ?",
                        "My Confirm Dialog", JOptionPane.YES_NO_OPTION);
                if (ans == JOptionPane.YES_OPTION) {
                    try {

                        Singlecategory singlecategory = al.get(index);
                        String cname = singlecategory.name;
//                        String desc = singlecategory.description;

                        Class.forName("com.mysql.jdbc.Driver");

                        Connection conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/test", "root", "hello");

                        Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);

                        ResultSet rs = stmt.executeQuery("select * from category where name='" + cname + "'");

                        if (rs.next()) {
                            rs.deleteRow();
                            al.remove(index);
                            tm.fireTableDataChanged();

                        }

                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    JOptionPane.showMessageDialog(this, "Selected category is deleted");

                    tm.fireTableDataChanged();
                }
            }
        }
    }//GEN-LAST:event_jBtdeleteActionPerformed

    private void jBteditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBteditActionPerformed

        int index = cattable.getSelectedRow();
        if (index == -1) {
            JOptionPane.showMessageDialog(this, "Select any category first !!");
        } else {
            Singlecategory sc = al.get(index);

            EditCategory ec = new EditCategory(sc);

            ec.setSize(700, 900);
            ec.setIconifiable(true);
            ec.setResizable(true);
            ec.setVisible(true);

            this.getDesktopPane().add(ec);

            ec.moveToFront();
        }
    }//GEN-LAST:event_jBteditActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable cattable;
    private javax.swing.JButton jBtdelete;
    private javax.swing.JButton jBtedit;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
