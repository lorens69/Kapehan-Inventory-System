/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package finalprojectinjava;

import com.mysql.cj.protocol.Resultset;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import net.proteanit.sql.DbUtils;

/**
 *
 * @author student.admin
 */
public class ctransactions extends javax.swing.JFrame {

    
    public ctransactions() {
        initComponents();
        ShowSTransactions();
        
    }
    
    Connection Con = null;
    Statement st = null;
    Resultset rs = null;
    

    public void ShowSTransactions() {
        
      try {
          Con = DriverManager.getConnection("jdbc:mysql://localhost:3306/lorendsdatabase", "root","");
          st = Con.createStatement();
          rs = (Resultset) st.executeQuery("SELECT * FROM `ctransactions`");
          ctranstable.setModel(DbUtils.resultSetToTableModel((ResultSet) (rs)));

      } catch(SQLException e) {
          
          e.printStackTrace();
      }      
    }
    
    public void FbyUserDateIncome() {
        
      try {
          Con = DriverManager.getConnection("jdbc:mysql://localhost:3306/lorendsdatabase", "root","");
          st = Con.createStatement();
          rs = (Resultset) st.executeQuery("SELECT `UserID`,`Date`, SUM(`Amount`) FROM `ctransactions` GROUP BY `UserID` ORDER BY `UserID`,`Date`");
          ctranstable.setModel(DbUtils.resultSetToTableModel((ResultSet) (rs)));

      } catch(SQLException e) {
          
          e.printStackTrace();
      }      
    }
    
    public void FbyUserDate() {
        
      try {
          Con = DriverManager.getConnection("jdbc:mysql://localhost:3306/lorendsdatabase", "root","");
          st = Con.createStatement();
          rs = (Resultset) st.executeQuery("SELECT * FROM `ctransactions` ORDER BY `UserID`,`Date`");
          ctranstable.setModel(DbUtils.resultSetToTableModel((ResultSet) (rs)));

      } catch(SQLException e) {
          
          e.printStackTrace();
      }      
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jRadioButton1 = new javax.swing.JRadioButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        ctranstable = new javax.swing.JTable();
        two = new javax.swing.JButton();
        one = new javax.swing.JButton();
        three = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();

        jRadioButton1.setText("jRadioButton1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(177, 204, 163));

        jLabel2.setIcon(new javax.swing.ImageIcon("Z:\\Laurence's Files\\Java\\picsforfinalproject\\back arrow.png")); // NOI18N
        jLabel2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel2MouseClicked(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Bookman Old Style", 1, 36)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(51, 51, 51));
        jLabel3.setText("CASHIER ");

        jLabel4.setFont(new java.awt.Font("Bookman Old Style", 1, 36)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(51, 51, 51));
        jLabel4.setText("TRANSACTIONS");

        jLabel1.setIcon(new javax.swing.ImageIcon("Z:\\Laurence's Files\\Java\\picsforfinalproject\\ctrans1.png")); // NOI18N

        ctranstable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "CTransaction ID", "Inventory ID", "Quantity", "Amount", "User ID", "Date", "Time"
            }
        ));
        jScrollPane1.setViewportView(ctranstable);

        two.setBackground(new java.awt.Color(114, 175, 110));
        two.setFont(new java.awt.Font("Bookman Old Style", 1, 14)); // NOI18N
        two.setForeground(new java.awt.Color(51, 51, 51));
        two.setText("Arrange One");
        two.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 51, 51), 3));
        two.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                twoMouseClicked(evt);
            }
        });

        one.setBackground(new java.awt.Color(164, 206, 119));
        one.setFont(new java.awt.Font("Bookman Old Style", 1, 14)); // NOI18N
        one.setForeground(new java.awt.Color(51, 51, 51));
        one.setText("Default");
        one.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 51, 51), 3));
        one.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                oneMouseClicked(evt);
            }
        });

        three.setBackground(new java.awt.Color(191, 215, 188));
        three.setFont(new java.awt.Font("Bookman Old Style", 1, 14)); // NOI18N
        three.setForeground(new java.awt.Color(51, 51, 51));
        three.setText("Arrange Two");
        three.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 51, 51), 3));
        three.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                threeMouseClicked(evt);
            }
        });
        three.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                threeActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Bookman Old Style", 1, 11)); // NOI18N
        jLabel5.setText("The default table of the Cashiers Transactions.");

        jLabel6.setFont(new java.awt.Font("Bookman Old Style", 1, 11)); // NOI18N
        jLabel6.setText("Table filtered by UserID and Date.");

        jLabel7.setFont(new java.awt.Font("Bookman Old Style", 1, 11)); // NOI18N
        jLabel7.setText("Table filtered by UserID and Date and Income.");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(57, 57, 57)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(one, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(two, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(three, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 243, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 328, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(77, 77, 77)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 644, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4)
                .addGap(102, 102, 102)
                .addComponent(jLabel2)
                .addGap(43, 43, 43))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel2)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel3)
                        .addComponent(jLabel4)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 271, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 247, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(one, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(two, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(three, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7))
                        .addGap(61, 61, 61)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jLabel2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel2MouseClicked
        admin admin = new admin();
        admin.setVisible(true);
        admin.pack();
        admin.setLocationRelativeTo(null);
        admin.setDefaultCloseOperation(ctransactions.EXIT_ON_CLOSE);
        this.dispose();
    }//GEN-LAST:event_jLabel2MouseClicked

    private void threeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_threeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_threeActionPerformed

    private void oneMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_oneMouseClicked
        ShowSTransactions();
    }//GEN-LAST:event_oneMouseClicked

    private void twoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_twoMouseClicked
        FbyUserDate();
    }//GEN-LAST:event_twoMouseClicked

    private void threeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_threeMouseClicked
        FbyUserDateIncome();
    }//GEN-LAST:event_threeMouseClicked

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
            java.util.logging.Logger.getLogger(ctransactions.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ctransactions.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ctransactions.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ctransactions.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ctransactions().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable ctranstable;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JRadioButton jRadioButton1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton one;
    private javax.swing.JButton three;
    private javax.swing.JButton two;
    // End of variables declaration//GEN-END:variables
}
