/**
 Pie.java
 Provided for Part 2, Lab5, COMP160 2016
 * Ethan Simmonds COMP160 LAB 5
 * 29 July 2016
 * Creates an 8 figure pie chart with a slice taken out
 */

import javax.swing.*;
import java.awt.*;

public class Pie extends JFrame{
    
    /** creates an instance of Pie called chart1*/
    public static void main(String[]args){
        Pie chart1 = new Pie(); 
        chart1.setSize(300,200);
        chart1.setVisible(true);
    }
    
    /** all drawing code goes in the paint method, which is called automatically*/
    public void paint (Graphics page){
      final int X = 75;
      final int Y = 50;
      final int Height = 150;
      final int Width = 150;
      final int Angle = 45;
        page.setColor(Color.white);
        page.fillRect(0,0,300,300);
        //your pie chart code goes here
        page.setColor(Color.gray); //set the color of any objects after this line until a new color has been defined
        page.fillArc (X+10,Y-5,Height,Width,0,Angle);
        
        page.setColor(Color.orange);
        page.fillArc (X,Y,Height,Width,45,Angle);
        
        page.setColor(Color.blue);
        page.fillArc (X,Y,Height,Width,90,Angle);
        
        page.setColor(Color.red);
        page.fillArc (X,Y,Height,Width,135,Angle);
        
        page.setColor(Color.green);
        page.fillArc (X,Y,Height,Width,180,Angle);
        
        page.setColor(Color.cyan);
        page.fillArc (X,Y,Height,Width,225,Angle);
        
        page.setColor(Color.magenta);
        page.fillArc (X,Y,Height,Width,270,Angle);
        
        page.setColor(Color.yellow);
        page.fillArc (X,Y,Height,Width,315,Angle);     
    }
}
