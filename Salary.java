/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package GUI;

import ViewTable.loadDAO;
import entity.Attributes;
import java.sql.Connection;
import java.sql.Statement;
import ViewTable.loadDAO;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

/**
 *
 * @author Truong Dat
 */
public class Salary extends javax.swing.JFrame {

    /**
     * Creates new form Salary
     */
    public Salary() {
        initComponents();
        setLocationRelativeTo(null);

        loadDAO load = new loadDAO();
        List<Attributes> listPersonnel = load.get3Infor();
        DefaultTableModel model = new DefaultTableModel();
        model = (DefaultTableModel) personnel_infor.getModel();
        while (model.getRowCount() != 0) {
            model.removeRow(0);
        }
        for (Attributes o : listPersonnel) {
            model.addRow(new Object[]{o.getId(), o.getName(), o.getPosition()});
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        lbID = new javax.swing.JLabel();
        lbPosition_coefficient = new javax.swing.JLabel();
        lbSalary = new javax.swing.JLabel();
        tfSalary = new javax.swing.JTextField();
        btnInsert = new javax.swing.JButton();
        btnUpdate = new javax.swing.JButton();
        btnView = new javax.swing.JButton();
        btnReset = new javax.swing.JButton();
        tfID = new javax.swing.JTextField();
        lbOvertime = new javax.swing.JLabel();
        tfOvertime = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        personnel_infor = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 51, 0), 2, true));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lbID.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lbID.setText("ID");
        jPanel1.add(lbID, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 30, 130, -1));

        lbPosition_coefficient.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lbPosition_coefficient.setText("Position coefficient");
        jPanel1.add(lbPosition_coefficient, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 150, 130, -1));

        lbSalary.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lbSalary.setText("Salary");
        jPanel1.add(lbSalary, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 70, 130, -1));

        tfSalary.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jPanel1.add(tfSalary, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 70, 140, -1));

        btnInsert.setText("INSERT");
        btnInsert.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInsertActionPerformed(evt);
            }
        });
        jPanel1.add(btnInsert, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 220, 100, 30));

        btnUpdate.setText("UPDATE");
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });
        jPanel1.add(btnUpdate, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 220, 100, 30));

        btnView.setText("VIEW");
        btnView.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnViewActionPerformed(evt);
            }
        });
        jPanel1.add(btnView, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 220, 100, 30));

        btnReset.setText("RESET");
        jPanel1.add(btnReset, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 270, 100, 30));

        tfID.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jPanel1.add(tfID, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 30, 140, -1));

        lbOvertime.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lbOvertime.setText("Overtime");
        jPanel1.add(lbOvertime, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 110, 130, -1));

        tfOvertime.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jPanel1.add(tfOvertime, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 110, 140, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 100, 460, 370));

        jLabel2.setFont(new java.awt.Font("Segoe UI Semilight", 1, 18)); // NOI18N
        jLabel2.setText("PERSONNEL INFORMATION");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 60, 240, 30));

        jLabel1.setFont(new java.awt.Font("Segoe UI Semilight", 1, 18)); // NOI18N
        jLabel1.setText("MANAGE PERSONNEL SALARY");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 60, 280, 30));

        personnel_infor.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "ID", "Name", "Position"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        personnel_infor.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                personnel_inforMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(personnel_infor);
        if (personnel_infor.getColumnModel().getColumnCount() > 0) {
            personnel_infor.getColumnModel().getColumn(0).setPreferredWidth(50);
            personnel_infor.getColumnModel().getColumn(1).setPreferredWidth(100);
        }

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 100, 340, 370));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnInsertActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInsertActionPerformed
        try {
            loadDAO load = new loadDAO();
            String id = tfID.getText();
            Float salary = Float.parseFloat(tfSalary.getText());
            Float overtime = Float.parseFloat(tfOvertime.getText());
            Integer position = spinPosition.getValue();
            load.InsertSalary(id, salary, overtime, position);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error: " + e);
        }
    }//GEN-LAST:event_btnInsertActionPerformed

    private void personnel_inforMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_personnel_inforMouseClicked
        int row = personnel_infor.getSelectedRow();
        TableModel model = personnel_infor.getModel();
        String ID = model.getValueAt(row, 0).toString().trim();
        tfID.setText(ID);
        String position = model.getValueAt(row, 2).toString();
//        CEO
//Manager
//Admin
//Secretary
//Developer
//Marketer
        switch (position) {
            case "CEO":
                spinPosition.setValue(6);
                break;
            case "Manager":
                spinPosition.setValue(4);
                break;
            case "Admin":
               spinPosition.setValue(5);
                break;
            case "Secretary":
                spinPosition.setValue(3);
                break;
            case "Developer":
                spinPosition.setValue(2);
                break;
            case "Marketer":
                spinPosition.setValue(2);
                break;
            default:
                throw new AssertionError();
        }

    }//GEN-LAST:event_personnel_inforMouseClicked

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
        int row = personnel_infor.getSelectedRow();
        TableModel model = personnel_infor.getModel();
        String ID = model.getValueAt(row, 0).toString().trim();
        tfID.setText(ID);
        if (tfID.getText().equals("")) {
            tfID.setText("");
            JOptionPane.showMessageDialog(this, "You must enter ID to UPDATE");
        } else {

            try {
                loadDAO load = new loadDAO();
                String id = tfID.getText();
                Float salary = Float.parseFloat(tfSalary.getText());
                Float overtime = Float.parseFloat(tfOvertime.getText());
                Integer position = spinPosition.getValue();
                load.UpdateSalary(id, salary, overtime, position);
            } catch (Exception e) {
                JOptionPane.showMessageDialog(this, "Error: " + e);
            }
        }
    }//GEN-LAST:event_btnUpdateActionPerformed

    private void btnViewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnViewActionPerformed
        new SalaryView().setVisible(true);
    }//GEN-LAST:event_btnViewActionPerformed

    /**
     * @param args the command line arguments
     */
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
            java.util.logging.Logger.getLogger(Salary.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Salary.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Salary.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Salary.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Salary().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnInsert;
    private javax.swing.JButton btnReset;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JButton btnView;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbID;
    private javax.swing.JLabel lbOvertime;
    private javax.swing.JLabel lbPosition_coefficient;
    private javax.swing.JLabel lbSalary;
    private javax.swing.JTable personnel_infor;
    private javax.swing.JTextField tfID;
    private javax.swing.JTextField tfOvertime;
    private javax.swing.JTextField tfSalary;
    // End of variables declaration//GEN-END:variables
}
