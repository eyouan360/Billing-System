package SurperBillingSystem;

import BDD.ResultSetTableModel;
import DBB.Db_connect;
import DBB.Parameter;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.Statement;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ZEROCOOL
 */
public class MainFrame extends javax.swing.JFrame  implements ActionListener{
 ResultSet rs;
 
    Db_connect db;
     int old, dec, now;
    
    int sumquant = 0;
    
    int clicked = 0;
    String labe = null;
    
    public MainFrame() {
          db = new Db_connect(new Parameter().HOST_DB, new Parameter().USERNAME_DB, new Parameter().PASSWORD_DB, new Parameter().IPHOST, new Parameter().PORT);
      initComponents();
      jam();
        
    }
    
      public void jam() {
        Date s = new Date();
        SimpleDateFormat tgl = new SimpleDateFormat("EEEE-dd-MMM-yyyy");
        SimpleDateFormat jam = new SimpleDateFormat("HH:mm:ss");
        lbl1.setText(jam.format(s));
        lbl2.setText(tgl.format(s));}
   
       public void table() {
        String t[] = {"Product_Id","Bare_code","Product_Name","Reference","Brand","Category","Price","Stock"};
        rs = db.querySelect(t, "product");
        //textDq.getText();
       //  tbl_res.setModel(new ResultSetTableModel(rs));
    }
       
      
       
       
     
      public void importer2() {
        String colo[] = {"Product_id","Receipt_number", "Price", "quantity", "subtotal"};
        rs = db.fcSelectCommand(colo, "sales", "Receipt_number='" + txtfac.getText() + "'");
        tbl_ven.setModel(new ResultSetTableModel(rs));
    }  
       
       
  public void importer() {
       try{
           if (searchfil.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Please Enter Product Name");
        }
           else{ 
               String colon[] = {"Product_id","Product_Name","Stock","Price"};
        rs = db.fcSelectCommand(colon, "product", "Product_Name LIKE '%" + searchfil.getText() + "%'");
        tbl_res.setModel(new ResultSetTableModel(rs));
           }
       }catch (Exception ex)
       {
         JOptionPane.showMessageDialog(this, "Invalid Product Name");    
       }
    }
  
  
   public void total() {
        rs = db.exécutionQuery("SELECT SUM(subtotal) as subtotal FROM sales WHERE Receipt_number= '" + txtfac.getText() + "'");
        try {
            rs.next();
            lbltot2.setText(rs.getString("subtotal"));
        } catch (SQLException ex) {
            Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
       public boolean test_stock() throws SQLException {
        boolean teststock;
        rs = db.querySelectAll("product","Product_id='" + tfId.getText() + "'");
        while (rs.next()) {
            old = rs.getInt("stock");
        }
        dec = Integer.parseInt(tfSt.getText());
        if (old < dec) {
            teststock = false;
        } else {
            teststock = true;
        }
        return teststock;
    }

       public void def() throws SQLException {
        rs = db.querySelectAll("product","Product_id='" + tfId.getText() + "'");
        while (rs.next()) {
            old = rs.getInt("stock");
        }
        dec = Integer.parseInt(tfSt.getText());
        now = old - dec;
         String nvstock = Integer.toString(now);

        String a = String.valueOf(nvstock);
        String[] colon = {"stock"};
        String[] isi = {a};
        System.out.println(db.queryUpdate("product", colon, isi, "Product_id='" +  tfId.getText() + "'"));
    }
  
  
  // method call pour le click tab
  
  public void callTab() {
      
       
  }
  
  public void addTab(){
      
        
      
      
  }
    
    

  
  
    /**
     * This method is called from within the constructor to initialize the form.jText_Search = RNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton3 = new javax.swing.JButton();
        searchfil = new java.awt.TextField();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        label8 = new java.awt.Label();
        lbl1 = new java.awt.Label();
        lbl2 = new java.awt.Label();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_ven = new javax.swing.JTable();
        jButton7 = new javax.swing.JButton();
        lbltot2 = new javax.swing.JTextField();
        jButton34 = new javax.swing.JButton();
        txtTak = new java.awt.TextField();
        jButton4 = new javax.swing.JButton();
        jButton9 = new javax.swing.JButton();
        label3 = new java.awt.Label();
        tfId = new javax.swing.JTextField();
        tfPn = new javax.swing.JTextField();
        tfSt = new javax.swing.JTextField();
        tfPz = new javax.swing.JTextField();
        jTextField6 = new javax.swing.JTextField();
        lbltot = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        lbltot1 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tbl_res = new javax.swing.JTable();
        txtfac = new javax.swing.JTextField();
        label9 = new java.awt.Label();
        jButton1 = new javax.swing.JButton();
        label4 = new java.awt.Label();
        jButton8 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(1040, 845));
        setResizable(false);
        getContentPane().setLayout(null);

        jButton3.setBackground(new java.awt.Color(255, 0, 153));
        jButton3.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jButton3.setText("EXIT");
        jButton3.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton3);
        jButton3.setBounds(550, 10, 100, 67);

        searchfil.setBackground(new java.awt.Color(204, 204, 255));
        searchfil.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
        searchfil.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchfilActionPerformed(evt);
            }
        });
        searchfil.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                searchfilKeyReleased(evt);
            }
        });
        getContentPane().add(searchfil);
        searchfil.setBounds(31, 130, 360, 28);

        jButton5.setBackground(new java.awt.Color(0, 153, 255));
        jButton5.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
        jButton5.setText("Delete - All - Product");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton5);
        jButton5.setBounds(700, 690, 200, 31);

        jButton6.setBackground(new java.awt.Color(0, 153, 255));
        jButton6.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
        jButton6.setText(">>Ticket");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton6);
        jButton6.setBounds(845, 644, 173, 36);

        label8.setBackground(new java.awt.Color(0, 153, 153));
        label8.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        label8.setText("SUPERMARKET");
        getContentPane().add(label8);
        label8.setBounds(790, 80, 140, 30);

        lbl1.setAlignment(java.awt.Label.CENTER);
        lbl1.setBackground(new java.awt.Color(0, 0, 0));
        lbl1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        lbl1.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        lbl1.setForeground(new java.awt.Color(255, 255, 255));
        getContentPane().add(lbl1);
        lbl1.setBounds(541, 168, 220, 31);

        lbl2.setAlignment(java.awt.Label.CENTER);
        lbl2.setBackground(new java.awt.Color(0, 0, 0));
        lbl2.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        lbl2.setForeground(new java.awt.Color(255, 255, 255));
        lbl2.setText("      ");
        getContentPane().add(lbl2);
        lbl2.setBounds(761, 168, 260, 31);

        jPanel1.setBackground(new java.awt.Color(0, 153, 153));
        jPanel1.setLayout(null);

        tbl_ven.setBackground(new java.awt.Color(204, 204, 255));
        tbl_ven.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        tbl_ven.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        tbl_ven.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "id", "Product Name", "Stock"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.Object.class, java.lang.Integer.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbl_ven.setMinimumSize(new java.awt.Dimension(50, 0));
        tbl_ven.setRowHeight(25);
        tbl_ven.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_venMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbl_ven);
        tbl_ven.getColumnModel().getColumn(0).setResizable(false);
        tbl_ven.getColumnModel().getColumn(0).setPreferredWidth(45);

        jPanel1.add(jScrollPane1);
        jScrollPane1.setBounds(540, 210, 490, 430);

        jButton7.setBackground(new java.awt.Color(0, 153, 255));
        jButton7.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jButton7.setText("Search Product");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton7);
        jButton7.setBounds(35, 170, 360, 29);

        lbltot2.setEditable(false);
        lbltot2.setBackground(new java.awt.Color(0, 0, 0));
        lbltot2.setFont(new java.awt.Font("Dialog", 1, 36)); // NOI18N
        lbltot2.setForeground(new java.awt.Color(0, 255, 0));
        lbltot2.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        lbltot2.setText("0.00");
        jPanel1.add(lbltot2);
        lbltot2.setBounds(660, 10, 380, 70);

        jButton34.setBackground(new java.awt.Color(204, 0, 0));
        jButton34.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jButton34.setForeground(new java.awt.Color(255, 255, 255));
        jButton34.setText("CALCULATOR");
        jButton34.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton34ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton34);
        jButton34.setBounds(170, 730, 190, 60);

        txtTak.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        txtTak.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        txtTak.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTakActionPerformed(evt);
            }
        });
        txtTak.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtTakKeyReleased(evt);
            }
        });
        jPanel1.add(txtTak);
        txtTak.setBounds(260, 590, 68, 30);

        jButton4.setBackground(new java.awt.Color(102, 255, 102));
        jButton4.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
        jButton4.setText("Add to Sales >>");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton4);
        jButton4.setBounds(180, 670, 173, 36);

        jButton9.setBackground(new java.awt.Color(0, 153, 255));
        jButton9.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
        jButton9.setText("Delete - Product");
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton9);
        jButton9.setBounds(540, 640, 173, 36);

        label3.setBackground(new java.awt.Color(0, 153, 153));
        label3.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        label3.setForeground(new java.awt.Color(255, 51, 0));
        label3.setText("Quantity :");
        jPanel1.add(label3);
        label3.setBounds(190, 590, 70, 30);

        tfId.setEditable(false);
        tfId.setBackground(new java.awt.Color(0, 153, 153));
        tfId.setForeground(new java.awt.Color(0, 153, 153));
        tfId.setBorder(null);
        jPanel1.add(tfId);
        tfId.setBounds(30, 600, 80, 20);

        tfPn.setEditable(false);
        tfPn.setBackground(new java.awt.Color(0, 153, 153));
        tfPn.setForeground(new java.awt.Color(0, 153, 153));
        tfPn.setBorder(null);
        jPanel1.add(tfPn);
        tfPn.setBounds(110, 600, 80, 20);

        tfSt.setEditable(false);
        tfSt.setBackground(new java.awt.Color(0, 153, 153));
        tfSt.setForeground(new java.awt.Color(0, 153, 153));
        tfSt.setBorder(null);
        jPanel1.add(tfSt);
        tfSt.setBounds(210, 600, 80, 20);

        tfPz.setEditable(false);
        tfPz.setBackground(new java.awt.Color(0, 153, 153));
        tfPz.setForeground(new java.awt.Color(0, 153, 153));
        tfPz.setBorder(null);
        jPanel1.add(tfPz);
        tfPz.setBounds(310, 600, 80, 20);

        jTextField6.setEditable(false);
        jTextField6.setBackground(new java.awt.Color(0, 153, 153));
        jTextField6.setForeground(new java.awt.Color(0, 153, 153));
        jTextField6.setBorder(null);
        jPanel1.add(jTextField6);
        jTextField6.setBounds(410, 600, 80, 20);

        lbltot.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
        lbltot.setText("GHS");
        jPanel1.add(lbltot);
        lbltot.setBounds(350, 630, 60, 21);

        jLabel2.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
        jLabel2.setText("Total :");
        jPanel1.add(jLabel2);
        jLabel2.setBounds(140, 630, 60, 21);

        lbltot1.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
        lbltot1.setText("0.00");
        jPanel1.add(lbltot1);
        lbltot1.setBounds(270, 630, 60, 21);

        tbl_res.setBackground(new java.awt.Color(204, 204, 255));
        tbl_res.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        tbl_res.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        tbl_res.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "id", "Product Name", "Stock"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.Object.class, java.lang.Integer.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbl_res.setMinimumSize(new java.awt.Dimension(50, 0));
        tbl_res.setRowHeight(25);
        tbl_res.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_resMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(tbl_res);
        tbl_res.getColumnModel().getColumn(0).setResizable(false);
        tbl_res.getColumnModel().getColumn(0).setPreferredWidth(45);

        jPanel1.add(jScrollPane3);
        jScrollPane3.setBounds(30, 210, 490, 370);

        txtfac.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
        txtfac.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtfac.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtfacActionPerformed(evt);
            }
        });
        jPanel1.add(txtfac);
        txtfac.setBounds(830, 110, 110, 30);

        label9.setBackground(new java.awt.Color(0, 153, 153));
        label9.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        label9.setForeground(new java.awt.Color(255, 51, 0));
        label9.setText("Printable Receipt:");
        jPanel1.add(label9);
        label9.setBounds(690, 110, 130, 30);

        jButton1.setBackground(new java.awt.Color(0, 153, 255));
        jButton1.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jButton1.setText("ADMINISTRATION PANEL");
        jButton1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1);
        jButton1.setBounds(120, 10, 226, 50);

        label4.setBackground(new java.awt.Color(0, 153, 153));
        label4.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
        label4.setForeground(new java.awt.Color(255, 102, 0));
        label4.setText("Name of Product:");
        jPanel1.add(label4);
        label4.setBounds(140, 100, 138, 25);

        getContentPane().add(jPanel1);
        jPanel1.setBounds(0, 0, 1060, 880);
        jPanel1.getAccessibleContext().setAccessibleDescription("");

        jButton8.setBackground(new java.awt.Color(0, 153, 255));
        jButton8.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
        jButton8.setText("Delete - Product");
        getContentPane().add(jButton8);
        jButton8.setBounds(541, 644, 173, 36);

        java.awt.Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
        setBounds((screenSize.width-1067)/2, (screenSize.height-835)/2, 1067, 835);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
    AccessLevel al = new AccessLevel();
        al.setVisible(true);
        this.dispose();
       
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
       this.dispose(); 
    }//GEN-LAST:event_jButton3ActionPerformed

    private void txtTakActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTakActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTakActionPerformed

    private void searchfilKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_searchfilKeyReleased
importer();      
    }//GEN-LAST:event_searchfilKeyReleased

  
    
    
      //JLabel labms1 = (JLabel) e.getSource();
     // String text = input.getText();
     // input.setText("");

    private void searchfilActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchfilActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_searchfilActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        String totalAmount = lbltot2.getText();
        
        PrintOut po = new PrintOut();
        po.genCode(totalAmount);
                po.setVisible(true);
                this.dispose();
                
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        importer();
    }//GEN-LAST:event_jButton7ActionPerformed

    private void jButton34ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton34ActionPerformed
     
          Runtime rt = Runtime.getRuntime();
          
            try {
                rt.exec("calc");
            } catch (IOException ex) {
                System.out.println("Exception"+ex);
            }
       
                
    }//GEN-LAST:event_jButton34ActionPerformed

    private void txtTakKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTakKeyReleased
     
    subtotal();   
//callTab();
        
    }//GEN-LAST:event_txtTakKeyReleased

      public void cout() {
        double a = Double.parseDouble(tfPz.getText());
        //double b = Double.parseDouble(txtrem.getText());
       // double c = a - a * (b / 100);
      //  txtnou.setText(String.valueOf(c));
    }
     public void subtotal() {
        double a = Double.parseDouble(tfPz.getText());
        double b = Double.parseDouble(txtTak.getText());
        double c = a * b;
        lbltot1.setText(String.valueOf(c));}
    
   //  void reset() {
      //  txtPro.setText("");
      //  txtPr.setText("");
     ////  labms1.setText("");
      //   textq.setText("");
     //   textqp.setText("");
    //   txtPr.setText("");
   // }
     
     public void clearTable(){
         
         DefaultTableModel dm = (DefaultTableModel)tbl_ven.getModel();
int rowCount = dm.getRowCount();
//Remove rows one by one from the end of the table
for (int i = rowCount - 1; i >= 0; i--) {
    dm.removeRow(i);
}
     }
    
    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
clearTable();

        
        
       // reset();
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
      
         if ( tfId.getText().equals("") || tfPn.getText().equals("") ||  tfSt.getText().equals("")
                || tfPz.getText().equals("") ||txtTak.getText().equals("") ) {
            JOptionPane.showMessageDialog(this, "Please enter quantity!");}
         else if (txtfac.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Please enter Receipt Number!");
         }else {
             
              String[] colon = {"Product_id","Price", "Receipt_number", "subtotal", "quantity", "StockOut"};
                String[] isi = {tfId.getText(),tfPz.getText() ,txtfac.getText() ,lbltot1.getText(), txtTak.getText(),tfSt.getText() };
             System.out.println(db.queryInsert("sales", colon, isi));
              try {
                if (!test_stock()) { 
                    JOptionPane.showMessageDialog(this, "limited stock");
                } else {
                    def(); //true
                    table(); //true
                }
            } catch (SQLException ex) {
                Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
                System.err.println("\n"+ex);
            }
             
             
            subtotal();
           importer2();
            total();
        }
        
        
    }//GEN-LAST:event_jButton4ActionPerformed

    private void tbl_resMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_resMouseClicked
        tfId.setText(String.valueOf(tbl_res.getValueAt(tbl_res.getSelectedRow(), 0)));
        tfPn.setText(String.valueOf(tbl_res.getValueAt(tbl_res.getSelectedRow(), 1)));
        tfSt.setText(String.valueOf(tbl_res.getValueAt(tbl_res.getSelectedRow(), 2)));
        tfPz.setText(String.valueOf(tbl_res.getValueAt(tbl_res.getSelectedRow(), 3)));
         cout();
    }//GEN-LAST:event_tbl_resMouseClicked

    private void tbl_venMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_venMouseClicked

       

        //addTab();

    }//GEN-LAST:event_tbl_venMouseClicked

    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed
      
         String id = String.valueOf(tbl_ven.getValueAt(tbl_ven.getSelectedRow(), 0));
        if (JOptionPane.showConfirmDialog(this, "are you sure to delete ", "Attention", JOptionPane.OK_CANCEL_OPTION) == JOptionPane.OK_OPTION) {
            db.queryDelete("sales", "Receipt_number=" + id );
        } else {
            return;
        }
        importer2();
        total();
        
    }//GEN-LAST:event_jButton9ActionPerformed

    private void txtfacActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtfacActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtfacActionPerformed

    

   
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
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        
        
        // print the number of free bytes
   System.out.println("" + Runtime.getRuntime().freeMemory());

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainFrame().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton34;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTextField jTextField6;
    private java.awt.Label label3;
    private java.awt.Label label4;
    private java.awt.Label label8;
    private java.awt.Label label9;
    private java.awt.Label lbl1;
    private java.awt.Label lbl2;
    private javax.swing.JLabel lbltot;
    private javax.swing.JLabel lbltot1;
    private javax.swing.JTextField lbltot2;
    private java.awt.TextField searchfil;
    private javax.swing.JTable tbl_res;
    private javax.swing.JTable tbl_ven;
    private javax.swing.JTextField tfId;
    private javax.swing.JTextField tfPn;
    private javax.swing.JTextField tfPz;
    private javax.swing.JTextField tfSt;
    private java.awt.TextField txtTak;
    private javax.swing.JTextField txtfac;
    // End of variables declaration//GEN-END:variables

    @Override
    public void actionPerformed(ActionEvent ae) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    
}
