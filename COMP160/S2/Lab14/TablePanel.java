/**COMP160 Lab 14 -  TablePanel.java - Ethan Simmonds - September 2016*/
import javax.swing.*;
import java.awt.*;

public class TablePanel extends JPanel {
  //data field declarations for each diner
  private Diner diner1;
  private Diner diner2;
  private Diner diner3;
  private Diner diner4;
  private Diner diner5;
  private Diner diner6;
  
 /** Create diner objects, passing information to the constructor found in Diner.java*/
 public TablePanel(){
   diner1 = new Diner(210, 125, "Clare" , 2, Color.gray);
   diner2 = new Diner(210, 200, "Michael" , 3, Color.white);
   
   diner3 = new Diner(140, 290, "Metiria", 4, Color.gray);
   diner4 = new Diner(140, 40 ,"David" , 1, Color.white);
   
   diner5 = new Diner(70, 200, "Todd", 5, Color.white);
   diner6 = new Diner(70, 125, "Jacqui" , 6, Color.gray); 
   
   setBackground(Color.blue);
   setSize(350,450);
 }
 
 /** Using each objects input parameters given in the TablePanel method, call the draw method in Diner.java to generate the 'diners' objects onto the JFrame*/
 public void paintComponent(Graphics g){
   super.paintComponent(g);
   diner1.draw(g);
   diner2.draw(g);
   diner3.draw(g);
   diner4.draw(g);
   diner5.draw(g);
   diner6.draw(g);
   //Creating the table section in the middle of the frame
   g.fillRect(125,100,80,180); 
 }
}
