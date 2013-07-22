/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package shsu.airline;

import java.awt.event.*;
import javax.swing.*;

/**
 *
 * @author QUAN DO
 */
public class SHSUAirline {

    /**
     * @param args the command line arguments
     */
    public SHSUAirline () {
        
        JFrame frame = new JFrame("Menu");
        frame.setVisible(true);
        frame.setSize(400,200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JMenuBar menubar = new JMenuBar();
        frame.setJMenuBar(menubar);
        JTextArea ta = new JTextArea();
        ta.setSize(380,180);
        frame.add(ta);
        String welcome = ("WELCOM TO SHSU AIRLINE!")+("\n")+
                           ("Here are some data from the database that")+ ("\n")+
                            ("you can use to run the application.")+("\n")+
                              ("Confirmation numbers: 64267890, 33445566")+ ("\n")+
                                ("Flight number: 1234, 5719")+("\n")+
                                    ("Driver license: 34433, 45678");
        ta.setText(welcome);
        
        
        
        JMenu fli = new JMenu("Flight");
        menubar.add(fli);
        JMenuItem af = new JMenuItem("Add Flight");
        fli.add(af);
        JMenuItem sta = new JMenuItem("Check Flight Status");
        fli.add(sta);
        JMenuItem de = new JMenuItem("Check Flight Detail");
        fli.add(de);
        JMenuItem re = new JMenuItem("Remove Flight");
        fli.add(re);



        JMenu cus = new JMenu("Customer");
        menubar.add(cus);
        JMenuItem addc = new JMenuItem("Add Customer");
        cus.add(addc);
        JMenuItem listc = new JMenuItem("List Customer");
        cus.add(listc);
        JMenuItem ser = new JMenuItem("Search Customer");
        cus.add(ser);
     //Flight action 
        af.addActionListener(
                new ActionListener() {
                   public void actionPerformed(ActionEvent e)
                   {
                  //    AddFlight a = new AddFlight(); 
                      new AddFlight().setVisible(true);
                 
                   }
                }
                );
        
          de.addActionListener(
                new ActionListener() {
                   public void actionPerformed(ActionEvent e)
                   {  
                       new Search_results().setVisible(true);
                   }    
                }
                  );

          sta.addActionListener(
                new ActionListener() {
                   public void actionPerformed(ActionEvent e)
                   {  
                       new CheckingStatus().setVisible(true);
                   }    
                }
                  );
          
           re.addActionListener(
                new ActionListener() {
                   public void actionPerformed(ActionEvent e)
                   {  
                       new removeFlight().setVisible(true);
                   }    
                }
                  );         
          
          
      //Customer action
         addc.addActionListener(
                new ActionListener() {
                   public void actionPerformed(ActionEvent e)
                   {
                  //    AddFlight a = new AddFlight(); 
                      new Customer_register().setVisible(true);
          
                   }
                }
                );          
          
         listc.addActionListener(
                new ActionListener() {
                   public void actionPerformed(ActionEvent e)
                   {
                  //    AddFlight a = new AddFlight(); 
                      new ListCustomer().setVisible(true);
          
                   }
                }
                ); 
         
         ser.addActionListener(
                new ActionListener() {
                   public void actionPerformed(ActionEvent e)
                   {
                  //    AddFlight a = new AddFlight(); 
                      new searchCustomer().setVisible(true);
          
                   }
                }
                ); 
          
          
          
          
          
 
    }
    
   public static void main(String[] args){
       SHSUAirline s = new SHSUAirline();
        
   }

}

