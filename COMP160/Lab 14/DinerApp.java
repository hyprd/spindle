/** COMP160 Lab 14 - DinerApp.java
  *  Ethan Simmonds - January 2017
  *  
  */
import javax.swing.*;
import java.awt.*;
public class DinerApp{
  public static void main (String[] args){
    //Generate new JFrame
    JFrame frame = new JFrame("Diner");
    // frame.setSize(300, 450);
    
    //Add TablePanel to frame
    frame.getContentPane().add(new TablePanel());
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.pack();
    frame.setVisible(true);   
  }
  
}