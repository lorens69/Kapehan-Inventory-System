package finalprojectinjava;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;


public class stafflogin extends javax.swing.JFrame {

    
    public stafflogin() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel3 = new javax.swing.JLabel();
        us3rname = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        p4ssword = new javax.swing.JPasswordField();
        jButtonLogin = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        jButtonregisterform = new javax.swing.JButton();
        jLabel11 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        pass = new javax.swing.JPasswordField();
        managerlogin = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        managerregister = new javax.swing.JButton();
        jLabel12 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        username = new javax.swing.JTextField();

        jLabel3.setFont(new java.awt.Font("Arial Black", 0, 12)); // NOI18N
        jLabel3.setText("Username:");

        jLabel5.setFont(new java.awt.Font("Arial Black", 0, 12)); // NOI18N
        jLabel5.setText("Password:");

        p4ssword.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                p4sswordActionPerformed(evt);
            }
        });

        jButtonLogin.setBackground(new java.awt.Color(150, 113, 55));
        jButtonLogin.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButtonLogin.setForeground(new java.awt.Color(255, 255, 255));
        jButtonLogin.setText("LOGIN");
        jButtonLogin.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));
        jButtonLogin.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButtonLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonLoginActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 12)); // NOI18N
        jLabel7.setText("Not an admin yet?");

        jButtonregisterform.setBackground(new java.awt.Color(150, 113, 55));
        jButtonregisterform.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButtonregisterform.setForeground(new java.awt.Color(255, 255, 255));
        jButtonregisterform.setText("Join Here!");
        jButtonregisterform.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));
        jButtonregisterform.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButtonregisterform.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButtonregisterformMouseClicked(evt);
            }
        });
        jButtonregisterform.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonregisterformActionPerformed(evt);
            }
        });

        jLabel11.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel11.setText("Back to Login as...");
        jLabel11.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel11.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel11MouseClicked(evt);
            }
        });

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setIcon(new javax.swing.ImageIcon("Z:\\Laurence's Files\\Java\\picsforfinalproject\\Mobile login-amico.png")); // NOI18N

        jLabel2.setBackground(new java.awt.Color(51, 51, 51));
        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 30)); // NOI18N
        jLabel2.setText("MANAGER LOGIN");

        jLabel6.setFont(new java.awt.Font("Arial Black", 0, 12)); // NOI18N
        jLabel6.setText("Password:");

        pass.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 51, 51), 2));
        pass.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                passActionPerformed(evt);
            }
        });

        managerlogin.setBackground(new java.awt.Color(228, 175, 176));
        managerlogin.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        managerlogin.setForeground(new java.awt.Color(51, 51, 51));
        managerlogin.setText("LOGIN");
        managerlogin.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));
        managerlogin.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        managerlogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                managerloginActionPerformed(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Book Antiqua", 1, 12)); // NOI18N
        jLabel8.setText("Not a manager yet?");

        managerregister.setBackground(new java.awt.Color(228, 175, 176));
        managerregister.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        managerregister.setForeground(new java.awt.Color(51, 51, 51));
        managerregister.setText("Join Here!");
        managerregister.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));
        managerregister.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        managerregister.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                managerregisterMouseClicked(evt);
            }
        });
        managerregister.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                managerregisterActionPerformed(evt);
            }
        });

        jLabel12.setFont(new java.awt.Font("Book Antiqua", 0, 14)); // NOI18N
        jLabel12.setText("Back to Login as...");
        jLabel12.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel12.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel12MouseClicked(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Arial Black", 0, 12)); // NOI18N
        jLabel9.setText("Username:");

        username.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 51, 51), 2));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 341, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(jLabel6)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(pass, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(jLabel9)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(username, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(jLabel2))
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 91, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(managerlogin, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(83, 83, 83))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(10, 10, 10)
                                        .addComponent(jLabel12))
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(managerregister, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel8)))
                                .addGap(67, 67, 67))))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(username, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(pass, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(managerlogin, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(managerregister, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel12)
                .addGap(37, 37, 37))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 282, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void p4sswordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_p4sswordActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_p4sswordActionPerformed

    private void jButtonLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonLoginActionPerformed

       
    }//GEN-LAST:event_jButtonLoginActionPerformed

    private void jButtonregisterformMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonregisterformMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jButtonregisterformMouseClicked

    private void jButtonregisterformActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonregisterformActionPerformed

        staffregister rgf = new staffregister();
        rgf.setVisible(true);
        rgf.pack();
        rgf.setLocationRelativeTo(null);
        rgf.setDefaultCloseOperation(stafflogin.EXIT_ON_CLOSE);
        this.dispose();
    }//GEN-LAST:event_jButtonregisterformActionPerformed

    private void passActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_passActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_passActionPerformed

    private void managerloginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_managerloginActionPerformed

        PreparedStatement st;
        ResultSet rs;
        
        
        String user = username.getText();
        String password = String.valueOf(pass.getPassword());
        String stat = "Active";
        String role = "Staff";
        

        String query = "SELECT * FROM `users` WHERE `Username` = ?  AND `Password` = ? AND `Status` = ? AND `Role` = ?";

        try {
            st = sqlconnection.getConnection().prepareStatement(query);

            
            st.setString(1 , user);
            st.setString(2 , password);
            st.setString(3 , stat);
            st.setString(4 , role);
            rs = st.executeQuery();

            if (rs.next()) {
                inventory manager = new inventory();
                manager.setVisible(true);
                manager.pack();
                manager.setLocationRelativeTo(null);
                manager.setDefaultCloseOperation(stafflogin.EXIT_ON_CLOSE);
                this.dispose();
                
                
            } else {
                JOptionPane.showMessageDialog(null, "Invalid Account or Account needs confirmation from the Admin.", "Login Error", 2);
            }

        } catch (SQLException ex) {
            Logger.getLogger(adminlogin.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_managerloginActionPerformed

    private void managerregisterMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_managerregisterMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_managerregisterMouseClicked

    private void managerregisterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_managerregisterActionPerformed

        staffregister rgf = new staffregister();
        rgf.setVisible(true);
        rgf.pack();
        rgf.setLocationRelativeTo(null);
        rgf.setDefaultCloseOperation(stafflogin.EXIT_ON_CLOSE);
        this.dispose();
    }//GEN-LAST:event_managerregisterActionPerformed

    private void jLabel11MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel11MouseClicked
        loginasUI lui = new loginasUI();
        lui.setVisible(true);
        lui.pack();
        lui.setLocationRelativeTo(null);
        lui.setDefaultCloseOperation(adminpass.EXIT_ON_CLOSE);
        this.dispose();
    }//GEN-LAST:event_jLabel11MouseClicked

    private void jLabel12MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel12MouseClicked
        loginasUI lui = new loginasUI();
        lui.setVisible(true);
        lui.pack();
        lui.setLocationRelativeTo(null);
        lui.setDefaultCloseOperation(adminpass.EXIT_ON_CLOSE);
        this.dispose();
    }//GEN-LAST:event_jLabel12MouseClicked

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
            java.util.logging.Logger.getLogger(stafflogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(stafflogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(stafflogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(stafflogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new stafflogin().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonLogin;
    private javax.swing.JButton jButtonregisterform;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JButton managerlogin;
    private javax.swing.JButton managerregister;
    private javax.swing.JPasswordField p4ssword;
    private javax.swing.JPasswordField pass;
    private javax.swing.JTextField us3rname;
    public static javax.swing.JTextField username;
    // End of variables declaration//GEN-END:variables
}
