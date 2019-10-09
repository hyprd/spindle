/** COMP160 Lab 23 - ShapePanel.java - Ethan Simmonds - October 2016 */
package shapes;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ShapePanel extends JPanel{
  //field declarations
  private JButton addShape, startButton, stopButton;
  private JTextField textField;
  private JLabel count;
  private DrawingPanel drawPanel;
  private int objectCounter = 0;
  private Timer timer;
  private final int DELAY = 10;
  
  JButton[] buttonArray = {
    new JButton ("Circle"), new JButton ("Square"),new JButton ("Oval"), new JButton ("Smiley"),
    new JButton ("Swirl"), new JButton ("Start"), new JButton ("Stop") };
  
  
                       
  
  //create new shape array of size 20
  Shape[] objectArray = new Shape[20];
  
  /** Main method to instantiate a frame with content from ShapePanel*/
  public static void main (String[] args){
    JFrame frame = new JFrame("Shape Panel");
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.getContentPane().add(new ShapePanel());
    frame.setVisible(true);
    frame.pack();  
  }
  
  
  /** Create objects for each panel element, set dimensions where appropriate then add them to the panel */
  public ShapePanel(){    
    textField = new JTextField(2);
    count = new JLabel("Count");
    
    JPanel controlPanel = new JPanel(); 
    controlPanel.setPreferredSize(new Dimension(100,400));
    DrawingPanel drawPanel = new DrawingPanel();
    ButtonListener listener = new ButtonListener();
    timer =  new Timer(DELAY, listener);
    
    controlPanel.add(textField);
    controlPanel.add(count);
    
    add(controlPanel);
    add(drawPanel);
    
    for (JButton a : buttonArray){
      buttonArray[0].addActionListener(listener);
      controlPanel.add(a);
  }
}
  /** Inner class for listener actions if the Add Shape button is pressed*/
  private class ButtonListener implements ActionListener{
   /** Perform an action when conditions are fulfilled by these certain if statements */
    public void actionPerformed(ActionEvent event){
      if (objectCounter < objectArray.length){
       if (event.getSource().equals(timer)){
        for (int i = 0; i < objectCounter; i++){
         objectArray[i].move();  
        } 
       }
       else if (event.getSource().equals(stopButton)){
        timer.stop();
        
       }
       else if (event.getSource().equals(startButton)){
        timer.start();
        
       }
       
       else if (event.getSource().equals(addShape)){
      objectArray[objectCounter] = new Circle();
      objectCounter++;  
       }
      }
      textField.setText(Integer.toString(objectCounter));
      repaint();
    }
  }
  
  private class DrawingPanel extends JPanel{
    public DrawingPanel(){
      setPreferredSize(new Dimension(400,400));
      setBackground(Color.pink);
    }
    
    public void paintComponent(Graphics g){
      super.paintComponent(g);
     if (objectCounter > 0){
      for(int i = 0; i < objectCounter; i++){
       objectArray[i].display(g);
    }
   }     
  } 
 }
}