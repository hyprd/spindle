//COMP160 LAB6 Part 1 - MyFrame.java - Ethan Simmonds - August 2016
import javax.swing.*;
import java.awt.*;
/**  
 * MyFrame.java
 * 
 * Displays a graphic alongside a historical quote 
 */
public class MyFrame extends JFrame {
  /** Make our own paint method */
  /** Create a method for shape and string creation*/
 public void paint(Graphics g){
   /* Create the shapes on the frame */
  g.drawRect(50, 50, 40, 40);
  g.drawRect(60, 80, 225, 30);
  g.drawOval(75, 65, 20, 20);
  g.drawLine(35, 60, 100, 120);
  /* Create the strings on the frame */
  g.drawString("Out of clutter, find simplicity", 110, 75);
  g.drawString("- - Albert Einstein", 120, 100);
 }
 /** Fill the frame with a shade of colour*/
 public void decorate(Color shade, String title, int yOffset){
  setLocation(0,yOffset);
  setBackground(shade);
  setTitle(title);
 }
}
