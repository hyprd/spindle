/**COMP160 lab 18 - TrafficLightPanel.java - Ethan Simmonds - September 2016*/
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class TrafficLightPanel extends JPanel {
  //data field declarations
  private JButton red, amber, green;
  private JLabel drawButtonPanel,pressPanel;
  private JPanel buttonPanel;

  /** This constructor creates and sets the size plus color of the frame objects, aswell as adding every object into the visible frame*/
  public TrafficLightPanel(){
    
    //create the LightPanel object
    LightPanel light = new LightPanel();
    
    //create objects for traffic lights, frame labels aswell as a panel background for the buttons
    red = new JButton("Red");
    amber = new JButton("Amber");
    green = new JButton("Green");
  
    drawButtonPanel = new JLabel("Button Panel");
    pressPanel = new JLabel("last pressed");
  
    buttonPanel = new JPanel();
    buttonPanel.setPreferredSize(new Dimension(80,290));
    buttonPanel.setBackground(Color.white);
    
    
    //create a listener object and bin them to each traffic light object, so that the buttons can perform an action on click 
    ButtonListener listener = new ButtonListener();
    red.addActionListener(listener);
    amber.addActionListener(listener);
    green.addActionListener(listener);
  
    //set the size and colour of TrafficLightPanel
    setPreferredSize(new Dimension(200,300));
    setBackground(Color.blue);
  
    //create an instance of each object, visible on the frame
    buttonPanel.add(drawButtonPanel);
    buttonPanel.add(red);
    buttonPanel.add(amber);
    buttonPanel.add(green);              
    add(buttonPanel);
    add(light);
 }
 /** This private class contains action logic when each button is pressed*/
 private class ButtonListener implements ActionListener{
  public void actionPerformed(ActionEvent event){
   if (event.getSource() == red){
    pressPanel.setText("red"); 
   }
   else if (event.getSource() == amber){
    pressPanel.setText("amber"); 
   }
   else if (event.getSource() == green){
    pressPanel.setText("green"); 
   }
   repaint();
  } 
 }
 /** Once a button is pressed, this private class recolours the given traffic light by retrieving the value of the pressPanel object*/
 private class LightPanel extends JPanel{
  /** Method to set the colour and size of the panel which the button objects are placed*/
  public LightPanel(){
  setPreferredSize(new Dimension(80,290));
  setBackground(Color.cyan);  
 }
 
  /** Initially, this method will set the colour of the button objects to black. 
    * Once an action is performed on any button, check the value of pressPanel and adjust accordingly*/
  public void paintComponent(Graphics g){
  super.paintComponent(g);
  g.setColor(Color.black);
  g.fillOval(20,50,40,40);
  
  g.setColor(Color.black);
  g.fillOval(20,150,40,40);
  
  g.setColor(Color.black);
  g.fillOval(20,100,40,40);
  
  if (pressPanel.getText().equals("red")){
   g.setColor(Color.red);
   g.fillOval(20,50,40,40);  
  }
  else if (pressPanel.getText().equals("amber")){
   g.setColor(Color.orange);
   g.fillOval(20,100,40,40); 
  }
  else if (pressPanel.getText().equals("green")){
   g.setColor(Color.green);
   g.fillOval(20,150,40,40);
  }
  
 }
}
}

