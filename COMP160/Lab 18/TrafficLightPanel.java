/** COMP160 Lab 18 - TrafficLightPanel.java
  *  Ethan Simmonds - Febuary 2017
  *  Create a panel corresponding to traffic lights supported by user input
  */

import javax.swing.JPanel;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class TrafficLightPanel extends JPanel{
  //component declarations
  JButton red = new JButton("Red");
  JButton amber = new JButton("Amber");
  JButton green = new JButton("Green");
  JLabel buttonLabel = new JLabel("Button Panel");
  JLabel lastPressed = new JLabel("last pressed");
  JPanel buttonPanel = new JPanel();
  
  /** Add listeners to buttons and labels, set size and color then add components to button panel*/
  public TrafficLightPanel(){
    
    ButtonListener listener = new ButtonListener();
    
    setPreferredSize(new Dimension(200,300));
    setBackground(Color.blue);
    buttonPanel.setPreferredSize(new Dimension(80,290));
    buttonPanel.setBackground(Color.white);
    
    buttonPanel.add(buttonLabel);
    buttonPanel.add(red);
    buttonPanel.add(amber);
    buttonPanel.add(green);
    
    red.addActionListener(listener);
    amber.addActionListener(listener);
    green.addActionListener(listener);
    
    LightPanel lightPanel = new LightPanel();
    add(buttonPanel);
    add(lightPanel);
  }
  
  
  private class LightPanel extends JPanel{
    /** Draw all buttons, then colour a certain button per user input */
    public void paintComponent(Graphics g){
      super.paintComponent(g);
      g.setColor(Color.black);
      g.fillOval(20,20,40,40);
      g.fillOval(20,80,40,40);
      g.fillOval(20,140,40,40);
      
      if (lastPressed.getText().equals("Red")){
        g.setColor(Color.red);
        g.fillOval(20,20,40,40);
      }
      
      else if (lastPressed.getText().equals("Amber")){
        g.setColor(Color.orange);
        g.fillOval(20,80,40,40);
      }
      
      else if (lastPressed.getText().equals("Green")){
        g.setColor(Color.green);
        g.fillOval(20,140,40,40);
      }
    }  
    /** Create a panel to hold button objects*/
    public LightPanel(){
      setPreferredSize(new Dimension(80,290));
      setBackground(Color.cyan);
    }
  }
  
  private class ButtonListener implements ActionListener{
    /** If a listener recieves user action, set pressed text to its corresponding button */
    public void actionPerformed (ActionEvent event){
      if (event.getSource() == red){
        lastPressed.setText("Red");
      }
      else if (event.getSource() == amber){
        lastPressed.setText("Amber");
      }
      else if (event.getSource() == green){
        lastPressed.setText("Green");
      }
      repaint();
    } 
  } 
}

