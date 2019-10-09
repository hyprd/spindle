/** COMP160 Lab 21 - ShapePanel.java 
  * Ethan Simmonds - Febuary 2017
  * Create frame panels to hold generation of random shapes
  */
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ShapePanel extends JPanel{
  private JButton addShape;
  private JTextField textField;
  private JLabel count;
  private DrawingPanel drawPanel;
  private int objectCounter = 0;
  
  Shape[] objectArray = new Shape[20];
  
  public static void main (String[] args){
    JFrame frame = new JFrame("Shape Panel");
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.getContentPane().add(new ShapePanel());
    frame.pack(); 
    frame.setVisible(true);
    
  }
  
  /** Instantiate components and */
  public ShapePanel(){
    
    addShape = new JButton("Add Shape");
    textField = new JTextField(2);
    count = new JLabel("Count: ");
    
    JPanel controlPanel = new JPanel(); 
    controlPanel.setPreferredSize(new Dimension(100,400));
    DrawingPanel drawPanel = new DrawingPanel();
    
    ButtonListener listener = new ButtonListener();
    addShape.addActionListener(listener); 
    
    controlPanel.add(addShape);
    controlPanel.add(textField);
    controlPanel.add(count);
    
    add(controlPanel);
    add(drawPanel);
    
  }
  
  /** Generate a new shape once the addShape listener */
  private class ButtonListener implements ActionListener{
    public void actionPerformed(ActionEvent event){
      if (objectCounter < objectArray.length){
        if (event.getSource().equals(addShape)){
          objectArray[objectCounter] = new Shape();
          objectCounter++;  
        }
        
      }
      textField.setText(Integer.toString(objectCounter));
      repaint();
    }
  }
  /** Drawing panel frame for shapes*/
  private class DrawingPanel extends JPanel{
    public DrawingPanel(){
      setPreferredSize(new Dimension(400, 400));
      setBackground(Color.pink);   
    }
    
    /** If shapes exist in the object array, display them on the frame */
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