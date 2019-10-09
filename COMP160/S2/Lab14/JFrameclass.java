/**COMP160 Lab 14 - JFrameClass.java - Ethan Simmonds - September 2016*/
import javax.swing.*;
import java.awt.*;
public class JFrameclass{
  public static void main (String[] args){
    JFrame frame = new JFrame("Diner");
    frame.setSize(350, 450);
    frame.getContentPane().add(new TablePanel());
    frame.setVisible(true);   
    
  }
  
}