/** COMP160 Lab 18 - TrafficLightPanelApp.java
  *  Ethan Simmonds - Febuary 2017
  */
import javax.swing.JFrame;

public class TrafficLightPanelApp {
   public static void main(String[]args){
      JFrame Frame = new JFrame();
      Frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      Frame.getContentPane().add(new TrafficLightPanel());
      Frame.pack();
      Frame.setVisible(true);
    }
}
