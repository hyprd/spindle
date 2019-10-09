/** COMP160 Lab 23 - ShapePanel.java
  *  Ethan Simmonds - Febuary 2017
  *  Create frames, declare components and handle events for displaying an array of shapes 
  */
package shapes;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ShapePanel extends JPanel{
  //Component and timer declarations
  private JButton addShape, startButton, stopButton;
  private JTextField textField;
  private JLabel count;
  private DrawingPanel drawPanel;
  private int objectCounter = 0;
  private Timer timer, colourTimer;
  private final int DELAY = 10;
  
  Shape[] objectArray = new Shape[20];
  JButton[] buttonArray = {new JButton("Circle"), new JButton("Square"), 
    new JButton("Oval"), new JButton("Smiley"), new JButton("Swirl"),
    new JButton("Start"), new JButton("Stop")};
  
  
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
    // Component declarations for ShapePanel
    textField = new JTextField(2);
    count = new JLabel("Count");
    
    //Frame, panel and listener declarations
    JPanel controlPanel = new JPanel(); 
    controlPanel.setPreferredSize(new Dimension(100,400));
    DrawingPanel drawPanel = new DrawingPanel();
    ButtonListener listener = new ButtonListener();
    
    //Add ActionListeners to buttons and declare timers 
    timer =  new Timer(DELAY, listener);
    colourTimer = new Timer(5000, listener);
    //Add buttons to panel
    
    controlPanel.add(textField);
    controlPanel.add(count);
    add(controlPanel);
    add(drawPanel);
    
    for(JButton u: buttonArray){
      u.addActionListener(listener);
      controlPanel.add(u);
    }
  }
  
  /** Perform listener actions when add shape button is pressed */
  private class ButtonListener implements ActionListener{
    
    public void actionPerformed(ActionEvent event){
      if (objectCounter <= objectArray.length){
        if (event.getSource().equals(timer)){
          for (int i = 0; i < objectCounter; i++){
            objectArray[i].move();
            colourTimer.start();
          } 
        }
        else if (event.getSource().equals(colourTimer)){
          for (int i = 0 ; i < objectCounter; i++){
            objectArray[i].changeColour();
          }
        }
        
        else{
          JButton button = (JButton) event.getSource();
          if (button.getText().equals("Stop")){
            timer.stop();
          }
          else if (button.getText().equals("Start")){
            timer.start();
          }
          else if (button.getText().equals("Circle")){
            if (objectCounter < objectArray.length){
              objectArray[objectCounter] = new Circle();
              objectCounter++;
            }
          }
          else if(button.getText().equals("Square")){
            if (objectCounter < objectArray.length){
              objectArray[objectCounter] = new Square();
              objectCounter++;
            }
          }
          else if(button.getText().equals("Oval")){
            if (objectCounter < objectArray.length){
              objectArray[objectCounter] = new Oval();
              objectCounter++;
            }
          }
          else if(button.getText().equals("Smiley")){
            if (objectCounter < objectArray.length){
              objectArray[objectCounter] = new Smiley();
              objectCounter++;
            }
          }
          else if (button.getText().equals("Swirl")){
            if (objectCounter < objectArray.length){
              objectArray[objectCounter] = new Swirl();
              objectCounter++;
            }
          }
        }
        textField.setText(Integer.toString(objectCounter));
      }
      repaint();
    }
  }
  
  
  /**  Create frame to hold all visible shape objects */
  private class DrawingPanel extends JPanel{
    public DrawingPanel(){
      setPreferredSize(new Dimension(400,400));
      setBackground(Color.pink);
    }
    
    /** Invoke the display method on each availiable array object*/
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