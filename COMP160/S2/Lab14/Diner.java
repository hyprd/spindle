/**COMP160 Lab 14 - Diner.java - Ethan Simmonds - September 2016*/
import javax.swing.*;
import java.awt.*;
public class Diner {
 //data field declarations
 private int x;
 private int y;
 private String name;
 private int seatNum;
 final int DIAMETER = 75;
 private Color colour;
 
 /** Constructor with object input parameters meant to fufill the information given from the TablePanel method in TablePanel.java*/
 public Diner (int x, int y, String name, int seatNum, Color colour){
   this.x = x;
   this.y = y;
   this.name = name;
   this.seatNum = seatNum;
   this.colour = colour;
 }

 /** The draw method applies personalization to the diner circles, creating the circle for each diner aswell as naming and labelling each one*/
 public void draw(Graphics g){
   g.setColor(colour);
   g.fillOval(x, y, DIAMETER-25, DIAMETER-25);
   
   //set font color to black, and first generate the diner name followed by the seat number
   g.setColor(Color.black);
   g.setFont(new Font("Helvetica", Font.BOLD, 12));
   g.drawString(name,x+5,y+30);
   
   g.setFont(new Font("Helvetica", Font.BOLD, 10));
   g.drawString(Integer.toString(seatNum),x+25,y+10);
 }
}
  


