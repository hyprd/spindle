//COMP160 LAB6 Part 1 - MyFrameApp.java - Ethan Simmonds - August 2016
import java.awt.Color;
public class MyFrameApp {
 public static void main (String [] args){
  MyFrame m1 = new MyFrame();
  m1.setSize(300,150);
  m1.setVisible(true);
  
  MyFrame m2 = new MyFrame();
  m2.setSize(300,150);
  m2.setVisible(true);
  
  m1.decorate(Color.pink, "Hello", 240);
  m2.decorate(Color.pink, "Hello 2", 80);
  
 }



 

}
