/** COMP160 Lab 23 - Oval.java
  *  Ethan Simmonds - Febuary 2017
  */
package shapes; 
import java.awt.*;
public class Oval extends Shape {
  public Oval(){
    
    height = width * 4;
    y = randomInt(height, 380);
  }
  public void display(Graphics displayShape){
    displayShape.setColor(colour);
    displayShape.fillOval(x, y, width, height);
  } 
}