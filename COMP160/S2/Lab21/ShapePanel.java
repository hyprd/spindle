/** COMP160 Lab 21 - ShapePanel.java - Ethan Simmonds - October 2016 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ShapePanel extends JPanel{
  //field declarations
  private JButton addShape;
  private JTextField countField;
  private JLabel count;
  private DrawingPanel drawPanel;
  private int objectCounter = 0;
  
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
    addShape = new JButton("Add Shape");
    countField = new JTextField(2);
    count = new JLabel("Count");
    
    JPanel controlPanel = new JPanel(); 
    DrawingPanel drawPanel = new DrawingPanel();
    ButtonListener listener = new ButtonListener();
    
    addShape.addActionListener(listener);
    controlPanel.setPreferredSize(new Dimension(100,400));
    
    controlPanel.add(addShape);
    controlPanel.add(countField);
    controlPanel.add(count);
    add(controlPanel);
    add(drawPanel);
  }
  /** Inner class for listener actions if the Add Shape button is pressed*/
  private class ButtonListener implements ActionListener{
   /** Perform an action when conditions are fulfilled by these certain if statements */
    public void actionPerformed(ActionEvent event){
      if (objectCounter < objectArray.length){
        if (event.getSource().equals(addShape)){
          objectArray[objectCounter] = new Shape();
          objectCounter++;  
       }
      }
      //update textField to the value of objectCounter
      countField.setText(Integer.toString(objectCounter));
      repaint();
    }
  }
  /** Create a drawing panel to neatly place every circle into a specific area of the frame*/
  private class DrawingPanel extends JPanel{
    /** Constructor to set size and colour of the panel*/
    public DrawingPanel(){
      setPreferredSize(new Dimension(400,400));
      setBackground(Color.pink);
    }
    
    /** If shapes are present in the array (via the objectCounter field,) loop through each object and call the display method on it */
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