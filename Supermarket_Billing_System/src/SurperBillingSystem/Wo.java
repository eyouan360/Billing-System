/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package SurperBillingSystem;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

/**
 *
 * @author ZEROCOOL
 */
public class Wo extends JFrame {
    
    
     JLabel JL_fname, JL_lname, JL_age, JL_id;
    JTextField JT_fname, JT_lname, JT_age, JT_id;
    JButton btn_search;
    
    public Wo() {
       super("Search");
       JL_id = new JLabel("Enter ID: "); 
       JL_id.setBounds(20, 20, 200, 20);
       JT_id = new JTextField(20);
       JT_id.setBounds(130, 20, 150, 20);
       btn_search = new JButton("Search");
       btn_search.setBounds(300, 20, 80, 20);
      // btn_search.addActionListener(this);
       setVisible(true);
       setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       setLocationRelativeTo(null);
       setSize(500, 200);
    }
    
}
