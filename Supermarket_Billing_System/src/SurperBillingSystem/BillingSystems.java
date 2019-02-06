/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package SurperBillingSystem;

import DBB.Db_connect;
import DBB.Parameter;
import java.awt.event.KeyEvent;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
        
/**
 *
 * @author ZEROCOOL
 */
public class BillingSystems extends javax.swing.JFrame {

    ResultSet rs;
    Db_connect db;
    String username1, password1, hak;
      
    public BillingSystems() {
         db = new Db_connect(new Parameter().HOST_DB, new Parameter().USERNAME_DB,new Parameter().PASSWORD_DB, new Parameter().IPHOST, new Parameter().PORT);    

        initComponents();
    }
    
    public void signMe(){
        
         rs = db.querySelectAll("users", "username='" + txt_username.getText() + "' and password='" + txt_password.getText() + "'");
        try {
            while (rs.next()) {
                username1 = rs.getString("username");
                password1 = rs.getString("password");
                hak = rs.getString("Type");
            }
        } catch (SQLException ex) {
            Logger.getLogger(BillingSystems.class.getName()).log(Level.SEVERE, null, ex);
        }

        if (username1 == null && password1 == null) {
            JOptionPane.showMessageDialog(this, "invalid username and password");
        } else {
            if (hak.equals("cashier")) {
                MainFrame mf = new MainFrame();
                mf.setVisible(true);
                this.dispose();
            } 
      
            else {
                JOptionPane.showMessageDialog(this, "invalid username and password");
            }
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNIG: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
  
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txt_password = new javax.swing.JPasswordField();
        jButton1 = new javax.swing.JButton();
        jTextField5 = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        txt_username = new javax.swing.JPasswordField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(51, 102, 255));

        jPanel1.setBackground(new java.awt.Color(102, 102, 0));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        jPanel1.setLayout(null);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Enter your username:");
        jPanel1.add(jLabel1);
        jLabel1.setBounds(390, 180, 210, 30);

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("       Choose your option:");
        jPanel1.add(jLabel3);
        jLabel3.setBounds(400, 90, 210, 20);

        txt_password.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_passwordActionPerformed(evt);
            }
        });
        txt_password.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_passwordKeyPressed(evt);
            }
        });
        jPanel1.add(txt_password);
        txt_password.setBounds(420, 280, 150, 30);

        jButton1.setBackground(new java.awt.Color(0, 204, 0));
        jButton1.setText("ENTER");
        jButton1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jButton1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jButton1KeyPressed(evt);
            }
        });
        jPanel1.add(jButton1);
        jButton1.setBounds(450, 330, 100, 50);

        jTextField5.setEditable(false);
        jTextField5.setBackground(new java.awt.Color(0, 51, 153));
        jTextField5.setFont(new java.awt.Font("Dialog", 1, 48)); // NOI18N
        jTextField5.setForeground(new java.awt.Color(255, 255, 255));
        jTextField5.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField5.setText("Supermarket Billing System Version 1.0");
        jPanel1.add(jTextField5);
        jTextField5.setBounds(0, 0, 950, 70);

        jButton2.setBackground(new java.awt.Color(0, 153, 255));
        jButton2.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jButton2.setText("ADMINISTRATION PANEL");
        jButton2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton2);
        jButton2.setBounds(400, 120, 200, 50);

        jButton3.setBackground(new java.awt.Color(255, 102, 102));
        jButton3.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jButton3.setText("EXIT");
        jButton3.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton3);
        jButton3.setBounds(270, 400, 460, 50);
        jPanel1.add(jLabel2);
        jLabel2.setBounds(850, 270, 0, 0);

        txt_username.setToolTipText("");
        txt_username.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_usernameActionPerformed(evt);
            }
        });
        txt_username.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_usernameKeyPressed(evt);
            }
        });
        jPanel1.add(txt_username);
        txt_username.setBounds(420, 210, 150, 30);

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Enter your password:");
        jPanel1.add(jLabel4);
        jLabel4.setBounds(390, 250, 210, 30);

        getContentPane().add(jPanel1, java.awt.BorderLayout.CENTER);
        getContentPane().add(jLabel5, java.awt.BorderLayout.PAGE_END);

        setSize(new java.awt.Dimension(968, 529));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void txt_passwordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_passwordActionPerformed
                // TODO add your handling code here:
        
        
        
    }//GEN-LAST:event_txt_passwordActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

        signMe();
        
        
        
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
       AccessLevel ac = new AccessLevel();
                ac.setVisible(true);
                this.dispose(); 
    }//GEN-LAST:event_jButton2ActionPerformed

    private void txt_usernameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_usernameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_usernameActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
      
        this.dispose();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jButton1KeyPressed
       
       
      //  if (evt.getKeyCode()==KeyEvent.VK_ENTER)
       //  {
         //    signMe();
       //  }
    }//GEN-LAST:event_jButton1KeyPressed

    private void txt_passwordKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_passwordKeyPressed
       
           if (evt.getKeyCode()==KeyEvent.VK_ENTER)
        {
            signMe();
        }
    }//GEN-LAST:event_txt_passwordKeyPressed

    private void txt_usernameKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_usernameKeyPressed
          
           if (evt.getKeyCode()==KeyEvent.VK_ENTER)
        {
            signMe();
        }
    }//GEN-LAST:event_txt_usernameKeyPressed

               
  


   
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
       
        //</editor-fold>

      // JFrame frame = new JFrame();
     //  frame.setSize(800, 600);
      // frame.setVisible(true);
      // frame.setTitle("Title");
       
       
      // frame.setResizable(true);

 
              
          
  

   // print the number of free bytes
   System.out.println("" + Runtime.getRuntime().freeMemory());

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                
               
                BillingSystems title = new BillingSystems();
                title.setTitle("Billing System Version 1.0");
                title.setVisible(true);
                title.setSize(968, 540);
                                           
                                        }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JTextField jTextField5;
    private javax.swing.JPasswordField txt_password;
    private javax.swing.JPasswordField txt_username;
    // End of variables declaration//GEN-END:variables

    
   
}
