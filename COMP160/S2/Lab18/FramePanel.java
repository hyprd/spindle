/**COMP160 Lab 18 - FramePanel.java - Ethan Simmonds - September 2016*/
import javax.swing.JFrame;
public class FramePanel {
  /** Instantiate a JFrame panel to host all objects */
  public static void main(String[] args) {
  
  JFrame frame = new JFrame ("Panel");
  
  //close the frame on exit
  frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  //add the objects of TrafficLightPanel
  frame.getContentPane().add(new TrafficLightPanel());
  frame.pack();
  frame.setVisible(true);
 }
}
