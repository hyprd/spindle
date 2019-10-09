/** COMP160 Lab 23 - Circle.java
  *  Ethan Simmonds - Febuary 2017
  */

package shapes;
import java.awt.*;
public class Circle extends Shape {
  public void display(Graphics displayShape){
    displayShape.setColor(colour);
    displayShape.fillOval(x, y, width, height);
  } 
}