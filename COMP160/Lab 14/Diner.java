/** COMP160 Lab 14 - Diner.java
  *  Ethan Simmonds - January 2017
  *  Generate a graphic of a diner seating chart
  */

import java.awt.*;
import javax.swing.*;
import java.awt.Color;
public class Diner{
  private int x;
  private int y;
  private String name;
  private int seatNum;
  private Color colour;
  final int DIAMETER = 50; 
  
  /** Set data fields*/
  public Diner(int xi, int yi, String namei, int seatNumi, Color colouri){
    x = xi;
    y = yi;
    name = namei;
    seatNum = seatNumi;
    colour = colouri;
  }
  
  /** Handle display of diner graphics and naming tags */
  public void draw(Graphics g){
    g.setColor(colour);
    g.fillOval(x,y,DIAMETER,DIAMETER);
    g.setColor(Color.black);
    g.setFont(new Font("Courier ", Font.BOLD, 12));
    g.drawString(name,x+10,y+35);
    g.setFont(new Font("Courier ", Font.PLAIN, 10));
    g.drawString(Integer.toString(seatNum),x+22,y+15);
  } 
}

