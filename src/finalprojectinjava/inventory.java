package finalprojectinjava;

import com.mysql.cj.protocol.Resultset;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.util.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.Timer;
import javax.swing.table.DefaultTableModel;
import net.proteanit.sql.DbUtils;


public class inventory extends javax.swing.JFrame {

    
    public inventory() {
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
    
    String measure = "82g/ per cup";
    
    

    
    public void updatetotransactions(){
        
        Integer iid = Integer.valueOf(invid.getText());
        Integer q = Integer.valueOf(quantity.getText());
        String tt = "Updated a product.";
        Integer uid = Integer.valueOf(displayid.getText());
        String d = date.getText();
        String tm = time.getText();
     
        try {
            
        PreparedStatement ps;
        String querty ="INSERT INTO `stransactions`( `InventoryID`, `Quantity`,`TypeofTransaction`,`UserID`, `Date`, `Time` ) VALUES (?,?,?,?,?,?)";
        
            ps = sqlconnection.getConnection().prepareStatement(querty);
            ps.setInt(1,iid);
            ps.setInt(2, q);
            ps.setString(3, tt);
            ps.setInt(4, uid);
            ps.setString(5,d);
            ps.setString(6,tm);
            
            if (ps.executeUpdate() != 0 ) {
                    JOptionPane.showMessageDialog(null,"But first, COFFEE!");
         
                } else {
                        JOptionPane.showMessageDialog(null,"Error! Check your information.");
}
        
        } catch (SQLException ex) {
                    Logger.getLogger(inventory.class.getName()).log(Level.SEVERE, null, ex);
                } 
    }
    
    public void deletetotransactions(){
        
        Integer iid = Integer.valueOf(invid.getText());
        Integer q = Integer.valueOf(quantity.getText());
        String tt = "Deleted a product.";
        Integer uid = Integer.valueOf(displayid.getText());
        String d = date.getText();
        String tm = time.getText();
     
        try {
            
        PreparedStatement ps;
        String querty ="INSERT INTO `stransactions`( `InventoryID`, `Quantity`,`TypeofTransaction`,`UserID`, `Date`, `Time` ) VALUES (?,?,?,?,?,?)";
        
            ps = sqlconnection.getConnection().prepareStatement(querty);
            ps.setInt(1,iid);
            ps.setInt(2, q);
            ps.setString(3, tt);
            ps.setInt(4, uid);
            ps.setString(5,d);
            ps.setString(6,tm);
            
            if (ps.executeUpdate() != 0 ) {
                    JOptionPane.showMessageDialog(null,"A bad day with coffee is better than a good day without it!");
         
                } else {
                        JOptionPane.showMessageDialog(null,"Error! Check your information.");
}
        
        } catch (SQLException ex) {
                    Logger.getLogger(inventory.class.getName()).log(Level.SEVERE, null, ex);
                } 
    }
    
    
    public void addtotransactions(){
        
        getinvID();
        
        Integer iid = Integer.valueOf(invid.getText());
        Integer q = Integer.valueOf(quantity.getText());
        String tt = "Added a product.";
        Integer uid = Integer.valueOf(displayid.getText());
        String d = date.getText();
        String tm = time.getText();
     
        try {
            
        PreparedStatement ps;
        String querty ="INSERT INTO `stransactions`( `InventoryID`, `Quantity`,`TypeofTransaction`,`UserID`, `Date`, `Time` ) VALUES (?,?,?,?,?,?)";
        
            ps = sqlconnection.getConnection().prepareStatement(querty);
            ps.setInt(1,iid);
            ps.setInt(2, q);
            ps.setString(3, tt);
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
    
    
    public void ShowProducts() {
        
      try {
          Con = DriverManager.getConnection("jdbc:mysql://localhost:3306/lorendsdatabase", "root","");
          st = Con.createStatement();
          rs = (Resultset) st.executeQuery("SELECT * FROM inventory");
          invt.setModel(DbUtils.resultSetToTableModel((ResultSet) (rs)));
          
          
      } catch(SQLException e) {
          
          e.printStackTrace();
      }      
    }
    
    public void ShowDate(){
        Date d = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String dd = sdf.format(d);
        date.setText(dd);       
    }
    
    public void ShowTime(){
       
        t = new Timer(0, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            Date dt = new Date();
            at = new SimpleDateFormat("hh:mm:ss a");
            
            String tt = at.format(dt);
            time.setText(tt);
            
            }   
        }); 
        t.start();
    }
    
    public void ShowUserandID() {
        
        PreparedStatement st;
        ResultSet rs;
  
        String query = "SELECT * FROM users WHERE Username='"+ stafflogin.username.getText()+"'";

        try {
            st = sqlconnection.getConnection().prepareStatement(query);
            rs = st.executeQuery();

            if (rs.next()) {
                displayid.setText(rs.getString(1));
                displayuser.setText(rs.getString(5));
            } 
        } catch (SQLException e) {
            e.printStackTrace();
        }     
    }
    
    public void getinvID() {
        
        PreparedStatement st;
        ResultSet rs;
  
        String query = "SELECT MAX(InventoryID) FROM inventory;";

        try {
            st = sqlconnection.getConnection().prepareStatement(query);
            rs = st.executeQuery();

            if (rs.next()) {
                invid.setText(rs.getString(1)); 
            } 
        } catch (SQLException e) {
            e.printStackTrace();
        }     
    }
    
    public boolean verifyFields(){

            String p = product.getText();
            String d = description.getText();
            Integer b = Integer.valueOf(buy.getText());
            Integer s = Integer.valueOf(sell.getText());
            Integer q = Integer.valueOf(quantity.getText());
            String m = measure;

            if (p.trim().isEmpty() || d.trim().isEmpty() || b.toString().isEmpty() || s.toString().isEmpty() || q.toString().isEmpty() || m.isEmpty() ) {

                JOptionPane.showMessageDialog(null, "One or more fields are empty.");
                return false;
            }

            else {
                return true;
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

        jLabel5 = new javax.swing.JLabel();
        jTextField3 = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        invid = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        product = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        buy = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        sell = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        quantity = new javax.swing.JTextField();
        addproduct = new javax.swing.JButton();
        delete = new javax.swing.JButton();
        update = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jLabel12 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        description = new javax.swing.JTextPane();
        jLabel6 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        time = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        date = new javax.swing.JLabel();
        displayuser = new javax.swing.JLabel();
        clearbutton = new javax.swing.JButton();
        displayid = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        invt = new javax.swing.JTable();
        jLabel11 = new javax.swing.JLabel();
        avail = new javax.swing.JComboBox<>();
        jLabel14 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();

        jLabel5.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        jLabel5.setText("Product Name");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(254, 203, 176));

        jLabel1.setIcon(new javax.swing.ImageIcon("Z:\\Laurence's Files\\Java\\picsforfinalproject\\inv.png")); // NOI18N

        jLabel2.setFont(new java.awt.Font("Bookman Old Style", 1, 36)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(51, 51, 51));
        jLabel2.setText("Kapehan Inventory");

        jLabel3.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        jLabel3.setText("Inventory ID");

        invid.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 51, 51), 2));
        invid.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                invidActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        jLabel4.setText("Product Name");

        product.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 51, 51), 2));

        jLabel7.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        jLabel7.setText("Buying Price");

        buy.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(51, 51, 51), 2, true));

        jLabel8.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        jLabel8.setText("Selling Price");

        sell.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 51, 51), 2));

        jLabel9.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        jLabel9.setText("Quantity");

        quantity.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 51, 51), 2));

        addproduct.setBackground(new java.awt.Color(154, 119, 135));
        addproduct.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        addproduct.setText("ADD");
        addproduct.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 51, 51), 3));
        addproduct.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                addproductMouseClicked(evt);
            }
        });

        delete.setBackground(new java.awt.Color(228, 175, 176));
        delete.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        delete.setText("DELETE");
        delete.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 51, 51), 3));
        delete.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                deleteMouseClicked(evt);
            }
        });
        delete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteActionPerformed(evt);
            }
        });

        update.setBackground(new java.awt.Color(254, 215, 191));
        update.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        update.setText("UPDATE");
        update.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 51, 51), 3));
        update.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                updateMouseClicked(evt);
            }
        });

        jButton4.setBackground(new java.awt.Color(255, 51, 51));
        jButton4.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        jButton4.setText("LOG OUT");
        jButton4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 51, 51), 3));
        jButton4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton4MouseClicked(evt);
            }
        });

        jLabel12.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        jLabel12.setText("Description");

        description.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 51, 51), 2));
        jScrollPane2.setViewportView(description);

        jLabel6.setText("(Delete item by ID)");

        jLabel13.setFont(new java.awt.Font("Bookman Old Style", 1, 14)); // NOI18N
        jLabel13.setText("Time");

        time.setFont(new java.awt.Font("Bookman Old Style", 1, 14)); // NOI18N
        time.setText("0");

        jLabel15.setFont(new java.awt.Font("Bookman Old Style", 1, 14)); // NOI18N
        jLabel15.setText("Date");

        date.setFont(new java.awt.Font("Bookman Old Style", 1, 14)); // NOI18N
        date.setText("0");

        displayuser.setFont(new java.awt.Font("Bookman Old Style", 1, 16)); // NOI18N
        displayuser.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        displayuser.setText("~");
        displayuser.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 51, 51), 3));
        displayuser.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                displayuserMouseClicked(evt);
            }
        });

        clearbutton.setBackground(new java.awt.Color(154, 119, 135));
        clearbutton.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        clearbutton.setText("CLEAR");
        clearbutton.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 51, 51), 3));
        clearbutton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                clearbuttonMouseClicked(evt);
            }
        });

        displayid.setFont(new java.awt.Font("Bookman Old Style", 1, 14)); // NOI18N
        displayid.setText("00");

        invt.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "InventoryID", "ProductName", "Description", "BuyingPrice", "SellingPrice", "Quantity", "UnitofMeasure", "Availability"
            }
        ));
        invt.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                invtMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(invt);

        jLabel11.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        jLabel11.setText("Availability");

        avail.setBackground(new java.awt.Color(255, 204, 204));
        avail.setFont(new java.awt.Font("Bookman Old Style", 1, 12)); // NOI18N
        avail.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Available", "Unavailable" }));
        avail.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 51, 51), 2));

        jLabel14.setFont(new java.awt.Font("Book Antiqua", 1, 14)); // NOI18N
        jLabel14.setText("Manager:");

        jLabel16.setFont(new java.awt.Font("Book Antiqua", 1, 14)); // NOI18N
        jLabel16.setText("ID:");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(65, 65, 65)
                        .addComponent(jLabel1)
                        .addGap(50, 50, 50)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel4)
                                    .addComponent(product, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel7)
                                    .addComponent(buy, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel8)
                                    .addComponent(sell, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel11)))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel3)
                                        .addGap(48, 48, 48)
                                        .addComponent(jLabel6))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(invid, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(delete, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(18, 18, 18)
                                .addComponent(update, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel9)
                                    .addComponent(quantity, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(addproduct, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(clearbutton, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(avail, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(46, 46, 46)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 828, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(35, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(55, 55, 55)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel13)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(time, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel15)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(date, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel16)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(displayid)
                        .addGap(83, 83, 83))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel14)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(displayuser, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(85, 85, 85))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jLabel2)
                        .addGap(7, 7, 7)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel13)
                            .addComponent(time)
                            .addComponent(jLabel15)
                            .addComponent(date)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(41, 41, 41)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(displayuser)
                            .addComponent(jLabel14))
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(displayid)
                            .addComponent(jLabel16))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 246, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(14, 14, 14)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel8)
                                .addGap(41, 41, 41))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel7)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(buy, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(sell, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(product, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(quantity, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel9)
                                    .addComponent(jLabel12)
                                    .addComponent(jLabel11))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(avail, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(8, 8, 8)
                                        .addComponent(jLabel3))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(18, 18, 18)
                                        .addComponent(jLabel6)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(invid, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(update, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(delete, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(addproduct, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(clearbutton, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(25, 25, 25))))
                    .addComponent(jLabel1))
                .addContainerGap(33, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void addproductMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_addproductMouseClicked
        
        String a = avail.getSelectedItem().toString();
        String p = product.getText();
        String d = description.getText();
        Integer b = Integer.valueOf(buy.getText());
        Integer s = Integer.valueOf(sell.getText());
        Integer q = Integer.valueOf(quantity.getText());
        String m = measure;
        PreparedStatement ps;
        String query = "INSERT INTO `inventory`( `ProductName`, `Description`, `BuyingPrice`, `SellingPrice`, `Quantity`, `UnitofMeasure`, `Availability`) VALUES (?,?,?,?,?,?,?)";
                      
        if (verifyFields()) {
                try {

                    ps = sqlconnection.getConnection().prepareStatement(query);
                    ps.setString(1, p);
                    ps.setString(2, d);
                    ps.setInt(3, b);
                    ps.setInt(4, s);
                    ps.setInt(5, q);
                    ps.setString(6, m);
                    ps.setString(7, a);
             
                    
                    if (ps.executeUpdate() != 0 ) {
                        
                        JOptionPane.showMessageDialog(null,"Coffee Added Successfully!");
                        ShowProducts();
                        addtotransactions();
                        
                        
                    } else {
                        JOptionPane.showMessageDialog(null,"Error! Check your information.");
                    }

                } catch (SQLException ex) {
                    Logger.getLogger(inventory.class.getName()).log(Level.SEVERE, null, ex);
                }
        }
      
    }//GEN-LAST:event_addproductMouseClicked

    private void invidActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_invidActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_invidActionPerformed

    private void deleteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_deleteMouseClicked
        if (invid.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Enter the id to be selected");
        } else {
            try {
                
                Con = DriverManager.getConnection("jdbc:mysql://localhost:3306/lorendsdatabase", "root","");
                String id = invid.getText();
                String Query = "DELETE FROM `inventory` WHERE `InventoryID`=" + id;
                Statement Add = Con.createStatement();
                Add.executeUpdate(Query);
 
                ShowProducts();  
                
                JOptionPane.showMessageDialog(null,"Product Removed Successfully.");
                deletetotransactions();

                     
            } catch (SQLException e) {
                e.printStackTrace();
        }
        }
    }//GEN-LAST:event_deleteMouseClicked

    private void updateMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_updateMouseClicked
        try {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Con = DriverManager.getConnection("jdbc:mysql://localhost:3306/lorendsdatabase", "root","");
        int row = invt.getSelectedRow();
        String value = (invt.getModel().getValueAt(row, 0).toString());
        String query = "UPDATE `inventory` SET `ProductName`=?,`Description`=?,`BuyingPrice`=?,`SellingPrice`=?,`Quantity`=?,`UnitofMeasure`=?, `Availability`=? WHERE `InventoryID`=" + value;
        PreparedStatement ps = Con.prepareStatement(query);
 
        ps.setString(1, product.getText());
        ps.setString(2, description.getText());
        ps.setString(3, buy.getText());
        ps.setString(4, sell.getText());
        ps.setString(5, quantity.getText());
        ps.setString(6, measure);
        ps.setString(7, avail.getSelectedItem().toString());
        ps.executeUpdate();
        DefaultTableModel model = (DefaultTableModel)invt.getModel();
        model.setRowCount(0);
        
        JOptionPane.showMessageDialog(null,"Product Updated Successfully.");
        ShowProducts();
        updatetotransactions();
        
        
                    

       } catch (SQLException ex) {
        Logger.getLogger(inventory.class.getName()).log(Level.SEVERE, null, ex);
       } catch (ClassNotFoundException ex) {
            Logger.getLogger(inventory.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_updateMouseClicked

    private void displayuserMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_displayuserMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_displayuserMouseClicked

    private void clearbuttonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_clearbuttonMouseClicked
        invid.setText(null);
        product.setText(null);
        buy.setText(null);
        sell.setText(null);
        description.setText(null);
        quantity.setText(null);
        avail.setSelectedItem(null);
    }//GEN-LAST:event_clearbuttonMouseClicked

    private void jButton4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton4MouseClicked
        stafflogin rgf = new stafflogin();
        rgf.setVisible(true);
        rgf.pack();
        rgf.setLocationRelativeTo(null);
        rgf.setDefaultCloseOperation(inventory.EXIT_ON_CLOSE);
        this.dispose();
    }//GEN-LAST:event_jButton4MouseClicked

    private void invtMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_invtMouseClicked
        try {
            
        DefaultTableModel model = (DefaultTableModel)invt.getModel();
        int Myindex = invt.getSelectedRow();
        invid.setText(model.getValueAt(Myindex, 0).toString());
        product.setText(model.getValueAt(Myindex, 1).toString());
        description.setText(model.getValueAt(Myindex, 2).toString());
        buy.setText(model.getValueAt(Myindex, 3).toString());
        sell.setText(model.getValueAt(Myindex, 4).toString());
        quantity.setText(model.getValueAt(Myindex, 5).toString());
        avail.setSelectedItem(model.getValueAt(Myindex, 7).toString());
        
        
        Integer quan = Integer.valueOf(quantity.getText());
        
        if (quan <= 10 ) {
            JOptionPane.showMessageDialog(null, "Oof! We are running out of coffee. Please add more stocks!");
        }
        
        } catch (NumberFormatException ex){
            ex.printStackTrace();
        }
    }//GEN-LAST:event_invtMouseClicked

    private void deleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_deleteActionPerformed

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
            java.util.logging.Logger.getLogger(inventory.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(inventory.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(inventory.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(inventory.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new inventory().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addproduct;
    private javax.swing.JComboBox<String> avail;
    private javax.swing.JTextField buy;
    private javax.swing.JButton clearbutton;
    public static javax.swing.JLabel date;
    private javax.swing.JButton delete;
    private javax.swing.JTextPane description;
    public static javax.swing.JLabel displayid;
    public javax.swing.JLabel displayuser;
    public static javax.swing.JTextField invid;
    private javax.swing.JTable invt;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
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
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField product;
    public static javax.swing.JTextField quantity;
    private javax.swing.JTextField sell;
    public static javax.swing.JLabel time;
    private javax.swing.JButton update;
    // End of variables declaration//GEN-END:variables
}
