/** COMP160 Lab 14 - Diner.java
  * Ethan Simmonds - January 2017
  */
import javax.swing.*;
import java.awt.*;
public class TablePanel extends JPanel{
  private Diner diner1;
  private Diner diner2;
  private Diner diner3;
  private Diner diner4;
  private Diner diner5;
  private Diner diner6;
  
  public TablePanel(){
    
   diner1 = new Diner(150, 40,"Caleb" , 1, Color.cyan);
   diner2 = new Diner(225, 150 ,"Georgia", 2, Color.pink);
   diner3 = new Diner(225, 250, "Maala", 3, Color.cyan);
   diner4 = new Diner(150, 350, "Bic", 4, Color.pink);
   diner5 = new Diner(75, 250, "Kings", 5, Color.cyan);
   diner6 = new Diner(75, 150, "Lorde", 6, Color.pink); 
   setPreferredSize(new Dimension(350,400));
 }
  
  public void paintComponent(Graphics g){
    super.paintComponent(g);
    diner1.draw(g);
    diner2.draw(g);
    diner3.draw(g);
    diner4.draw(g);
    diner5.draw(g);
    diner6.draw(g);
    g.fillRect(140,120,70,200);
    
    
  }
    
  
  
}