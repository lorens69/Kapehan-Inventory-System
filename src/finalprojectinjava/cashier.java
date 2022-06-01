/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package finalprojectinjava;

import com.mysql.cj.protocol.Resultset;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.Timer;
import javax.swing.table.DefaultTableModel;
import net.proteanit.sql.DbUtils;

/**
 *
 * @author student.admin
 */
public class cashier extends javax.swing.JFrame {

    /**
     * Creates new form cashier
     */
    public cashier() {
        initComponents();
        ShowUserandID();
        ShowDate();
        ShowTime();
        ShowProducts();
    }
    
    Connection Con = null;
    Statement st = null;
    Resultset rs = null;
    Timer t;
    SimpleDateFormat at;

    public void getinvID() {
        
        PreparedStatement st;
        ResultSet rs;
  
        String query = "SELECT MAX(InventoryID) FROM inventory;";

        try {
            st = sqlconnection.getConnection().prepareStatement(query);
            rs = st.executeQuery();

            if (rs.next()) {
                cinvid.setText(rs.getString(1)); 
            } 
        } catch (SQLException e) {
            e.printStackTrace();
        }     
    }
    
    
    public void addtotransactions(){
        
        getinvID();
        
        Integer iid = Integer.valueOf(cinvid.getText());
        Integer q = Integer.valueOf(cquantity.getText());
        Integer a = Integer.valueOf(cprice.getText());
        Integer uid = Integer.valueOf(di.getText());
        String d = cdate.getText();
        String tm = ctime.getText();
     
        try {
            
        PreparedStatement ps;
        String querty ="INSERT INTO `ctransactions`( `InventoryID`, `Quantity`, `Amount`, `UserID`, `Date`, `Time` ) VALUES (?,?,?,?,?,?)";
        
            ps = sqlconnection.getConnection().prepareStatement(querty);
            ps.setInt(1,iid);
            ps.setInt(2, q);
            ps.setInt(3, a);
            ps.setInt(4, uid);
            ps.setString(5,d);
            ps.setString(6,tm);
            
            if (ps.executeUpdate() != 0 ) {
                    JOptionPane.showMessageDialog(null,"A coffee a day, keeps a grumpy away!");
         
                } else {
                        JOptionPane.showMessageDialog(null,"Error! Check your information.");
}
        
        } catch (SQLException ex) {
                    Logger.getLogger(inventory.class.getName()).log(Level.SEVERE, null, ex);
                } 
    }
    
    
    private void minusproduct(){
        
        int newquantity = dquantity - Integer.valueOf(cquantity.getText());
        
        try {
            Con = DriverManager.getConnection("jdbc:mysql://localhost:3306/lorendsdatabase", "root","");
                
                String Query = "UPDATE `inventory` SET `Quantity`="+ newquantity +" WHERE `inventoryID`="+Integer.valueOf(cinvid.getText());
                Statement Add = Con.createStatement();
                Add.executeUpdate(Query);
                
                ShowProducts();
                
        } catch (Exception e) {
            
        }
    }
    
    public void ShowProducts() {
        
      try {
          Con = DriverManager.getConnection("jdbc:mysql://localhost:3306/lorendsdatabase", "root","");
          st = Con.createStatement();
          rs = (Resultset) st.executeQuery("SELECT `InventoryID`, `ProductName`, `Description`, `SellingPrice`, `Quantity`, `UnitofMeasure`, `Availability` FROM `inventory`  ");
          ctable.setModel(DbUtils.resultSetToTableModel((ResultSet) (rs)));
          
          
      } catch(SQLException e) {
          
          e.printStackTrace();
      }      
    } 
    
    
    public void ShowUserandID() {
        
        PreparedStatement st;
        ResultSet rs;
  
        String query = "SELECT * FROM users WHERE Username='"+ cashierlogin.us3rname.getText()+"'";

        try {
            st = sqlconnection.getConnection().prepareStatement(query);
            rs = st.executeQuery();

            if (rs.next()) {
                di.setText(rs.getString(1));
                du.setText(rs.getString(5));
            } 
        } catch (SQLException e) {
            e.printStackTrace();
        }     
    }
    
    public void ShowDate(){
        
        Date d = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String dd = sdf.format(d);
        cdate.setText(dd);       
    }
    
    public void ShowTime(){
       
        t = new Timer(0, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            Date dt = new Date();
            at = new SimpleDateFormat("hh:mm:ss a");
            
            String tt = at.format(dt);
            ctime.setText(tt);
            
            }   
        }); 
        t.start();
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        ctable = new javax.swing.JTable();
        cdate = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        ctime = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        du = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        di = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        cproduct = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        cdescription = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        cprice = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        cquantity = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        cmeasure = new javax.swing.JTextField();
        addtoorder = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        otable = new javax.swing.JTable();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        ftotal = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        cinvid = new javax.swing.JTextField();
        avail = new javax.swing.JLabel();
        jButton4 = new javax.swing.JButton();
        jLabel15 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(254, 215, 191));

        jLabel2.setFont(new java.awt.Font("Bookman Old Style", 1, 36)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(50, 19, 20));
        jLabel2.setText("CASHIER");

        jLabel1.setIcon(new javax.swing.ImageIcon("Z:\\Laurence's Files\\Java\\picsforfinalproject\\cashier.png")); // NOI18N

        ctable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Inventory ID", "ProductName", "Description", "SellingPrice", "Quantity", "Unit of Measure", "Availability"
            }
        ));
        ctable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ctableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(ctable);

        cdate.setFont(new java.awt.Font("Sylfaen", 1, 16)); // NOI18N
        cdate.setForeground(new java.awt.Color(132, 94, 90));
        cdate.setText("date");

        jLabel6.setFont(new java.awt.Font("Sylfaen", 1, 16)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(132, 94, 90));
        jLabel6.setText("Date");

        ctime.setFont(new java.awt.Font("Sylfaen", 1, 16)); // NOI18N
        ctime.setForeground(new java.awt.Color(132, 94, 90));
        ctime.setText("time");

        jLabel4.setFont(new java.awt.Font("Sylfaen", 1, 16)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(132, 94, 90));
        jLabel4.setText("Time");

        jLabel3.setFont(new java.awt.Font("Book Antiqua", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(51, 51, 51));
        jLabel3.setText("Cashier:");

        du.setFont(new java.awt.Font("Book Antiqua", 1, 18)); // NOI18N
        du.setForeground(new java.awt.Color(51, 51, 51));
        du.setText("~~~");

        jLabel5.setFont(new java.awt.Font("Book Antiqua", 1, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(51, 51, 51));
        jLabel5.setText("ID:");

        di.setFont(new java.awt.Font("Book Antiqua", 1, 18)); // NOI18N
        di.setForeground(new java.awt.Color(51, 51, 51));
        di.setText("~~~");

        jLabel7.setFont(new java.awt.Font("Bookman Old Style", 1, 36)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(132, 94, 90));
        jLabel7.setText("Coffee List");

        jLabel8.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(132, 94, 90));
        jLabel8.setText("Product Name");

        cproduct.setEditable(false);
        cproduct.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 51, 51), 2));

        jLabel9.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(132, 94, 90));
        jLabel9.setText("Description");

        cdescription.setEditable(false);
        cdescription.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 51, 51), 2));

        jLabel10.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(132, 94, 90));
        jLabel10.setText("Price");

        cprice.setEditable(false);
        cprice.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 51, 51), 2));

        jLabel11.setFont(new java.awt.Font("Calibri", 1, 16)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(132, 94, 90));
        jLabel11.setText("Cups to Serve");

        cquantity.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 51, 51), 2));
        cquantity.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cquantityActionPerformed(evt);
            }
        });

        jLabel12.setFont(new java.awt.Font("Calibri", 1, 16)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(132, 94, 90));
        jLabel12.setText("Unit of Measure");

        cmeasure.setEditable(false);
        cmeasure.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 51, 51), 2));

        addtoorder.setBackground(new java.awt.Color(132, 94, 90));
        addtoorder.setFont(new java.awt.Font("Bookman Old Style", 1, 12)); // NOI18N
        addtoorder.setForeground(new java.awt.Color(255, 255, 255));
        addtoorder.setText("SERVE");
        addtoorder.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 51, 51), 3));
        addtoorder.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        addtoorder.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                addtoorderMouseClicked(evt);
            }
        });
        addtoorder.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addtoorderActionPerformed(evt);
            }
        });

        otable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "OrderNumber", "Coffee", "Cups", "Price", "Total"
            }
        ));
        jScrollPane2.setViewportView(otable);

        jLabel13.setFont(new java.awt.Font("Bookman Old Style", 1, 30)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(132, 94, 90));
        jLabel13.setText("Slurped!");

        jLabel14.setFont(new java.awt.Font("Bookman Old Style", 1, 24)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(132, 94, 90));
        jLabel14.setText("Total");

        ftotal.setFont(new java.awt.Font("Bookman Old Style", 1, 30)); // NOI18N
        ftotal.setForeground(new java.awt.Color(132, 94, 90));
        ftotal.setText("total");

        jLabel16.setFont(new java.awt.Font("Calibri", 1, 16)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(132, 94, 90));
        jLabel16.setText("InventoryID");

        cinvid.setEditable(false);
        cinvid.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 51, 51), 2));

        avail.setFont(new java.awt.Font("Book Antiqua", 0, 12)); // NOI18N
        avail.setForeground(new java.awt.Color(132, 94, 90));
        avail.setText("Availability");

        jButton4.setBackground(new java.awt.Color(255, 51, 51));
        jButton4.setFont(new java.awt.Font("Calibri", 1, 12)); // NOI18N
        jButton4.setForeground(new java.awt.Color(255, 255, 255));
        jButton4.setText("LOG OUT");
        jButton4.setAlignmentX(0.5F);
        jButton4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 69, 79), 3));
        jButton4.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton4.setMargin(new java.awt.Insets(4, 14, 2, 14));
        jButton4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton4MouseClicked(evt);
            }
        });

        jLabel15.setFont(new java.awt.Font("Book Antiqua", 1, 12)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(132, 94, 90));
        jLabel15.setText("This table shows the order have been made by the cashier.");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(41, 41, 41)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(ctime)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel6)
                        .addGap(18, 18, 18)
                        .addComponent(cdate))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel16)
                                    .addComponent(cinvid, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(avail))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel8)
                                    .addComponent(cproduct, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel9)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(2, 2, 2)
                                        .addComponent(cdescription, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(cmeasure, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(10, 10, 10)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel11)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(cquantity, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel10)
                                    .addComponent(cprice, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(18, 18, 18)
                        .addComponent(addtoorder, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 528, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel13)
                        .addGap(123, 123, 123)
                        .addComponent(jLabel14)
                        .addGap(18, 18, 18)
                        .addComponent(ftotal)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jLabel1))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(87, 87, 87)
                        .addComponent(jLabel2)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 758, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(23, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(71, 71, 71)
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(du)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(di)
                        .addGap(18, 18, 18)
                        .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(47, 47, 47))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 331, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(107, 107, 107))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addGap(31, 31, 31)
                                    .addComponent(jLabel7))
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                    .addContainerGap()
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel3)
                                        .addComponent(jLabel5)
                                        .addComponent(du)
                                        .addComponent(di))))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jButton4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 245, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 267, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(ctime)
                            .addComponent(jLabel6)
                            .addComponent(cdate))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(avail)
                        .addGap(0, 0, 0)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel8)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cproduct, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel16)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cinvid, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel10)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cprice, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel9)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cdescription, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(jLabel11)
                                    .addGap(0, 0, 0)
                                    .addComponent(cquantity, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(jLabel12)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(cmeasure, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel13)
                            .addComponent(jLabel14)
                            .addComponent(ftotal))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(12, 12, 12)
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(52, 52, 52)
                                .addComponent(addtoorder, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel15)
                .addContainerGap(16, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    int i = 1, uprice, tot=0, total;
    
    private void addtoorderMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_addtoorderMouseClicked
        
        if(flag == 0 || cquantity.getText().isEmpty() || avail.getText().contains("Unavailable") || Integer.valueOf(cquantity.getText()) > dquantity) {
            JOptionPane.showMessageDialog(null, "Please check your quantity, it might be empty or you inputted more than we can serve.");
        } else {
        uprice = Integer.valueOf(cprice.getText());
        tot = uprice * Integer.valueOf(cquantity.getText());
        Vector v = new Vector();
        v.add(i);
        v.add(cproduct.getText());
        v.add(cquantity.getText());
        v.add(uprice);
        v.add(tot);
        DefaultTableModel dt = (DefaultTableModel)otable.getModel();
        dt.addRow(v);
        total = total + tot;
        ftotal.setText(total + "php");
        minusproduct();
        i++;
        JOptionPane.showMessageDialog(null, "You have added "+cquantity.getText()+" "+cproduct.getText()+" in order table.");
        addtotransactions();
            }
        
    }//GEN-LAST:event_addtoorderMouseClicked

    private void addtoorderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addtoorderActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_addtoorderActionPerformed
int flag = 0, dquantity;
    private void ctableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ctableMouseClicked
        flag = 1;
        try {
            
            DefaultTableModel model = (DefaultTableModel)ctable.getModel();
            int Myindex = ctable.getSelectedRow();
            dquantity = Integer.valueOf(model.getValueAt(Myindex, 4).toString());
            cinvid.setText(model.getValueAt(Myindex, 0).toString());
            cproduct.setText(model.getValueAt(Myindex, 1).toString());
            cprice.setText(model.getValueAt(Myindex, 3).toString()); 
            cdescription.setText(model.getValueAt(Myindex, 2).toString());
            cmeasure.setText(model.getValueAt(Myindex, 5).toString());
            avail.setText(model.getValueAt(Myindex, 6).toString());
            
            String av = avail.getText();
            String name = du.getText();
            
            
         if ( av.contains("Unavailable")) {
            JOptionPane.showMessageDialog(null, "This product is unavailable, you cannot sell this product mr/ms. "+ name);
        }
        
        } catch (NumberFormatException ex){
            ex.printStackTrace();
        } 
    }//GEN-LAST:event_ctableMouseClicked

    private void cquantityActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cquantityActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cquantityActionPerformed

    private void jButton4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton4MouseClicked
        cashierlogin rgf = new cashierlogin();
        rgf.setVisible(true);
        rgf.pack();
        rgf.setLocationRelativeTo(null);
        rgf.setDefaultCloseOperation(cashier.EXIT_ON_CLOSE);
        this.dispose();
    }//GEN-LAST:event_jButton4MouseClicked

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
            java.util.logging.Logger.getLogger(cashier.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(cashier.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(cashier.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(cashier.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new cashier().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addtoorder;
    private javax.swing.JLabel avail;
    private javax.swing.JLabel cdate;
    private javax.swing.JTextField cdescription;
    private javax.swing.JTextField cinvid;
    private javax.swing.JTextField cmeasure;
    private javax.swing.JTextField cprice;
    private javax.swing.JTextField cproduct;
    private javax.swing.JTextField cquantity;
    private javax.swing.JTable ctable;
    private javax.swing.JLabel ctime;
    private javax.swing.JLabel di;
    private javax.swing.JLabel du;
    private javax.swing.JLabel ftotal;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable otable;
    // End of variables declaration//GEN-END:variables
}
