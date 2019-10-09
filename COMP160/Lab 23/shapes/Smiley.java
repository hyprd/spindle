/** COMP160 Lab 23 - Smiley.java
  *  Ethan Simmonds - Febuary 2017
  */
package shapes; 
import java.awt.*;
public class Smiley extends Shape {
  int stdSize = 30;
  public Smiley(){
    x = randomInt(stdSize, 380);
    y = randomInt(stdSize, 380);
  }
  public void display(Graphics displayShape){
    
    displayShape.setColor(Color.yellow);
    displayShape.fillOval(x, y, stdSize, stdSize);
    displayShape.setColor(Color.black);
    
    //drawArc(int x, int y, int width, int height, int startAngle, int arcAngle)
    displayShape.drawArc(x + 8, y + 10, 15, 13, 190, 160);
    //drawOval(int x, int y, int width, int height)
    displayShape.fillOval(x + 7, y + 8, 4, 4);
    displayShape.fillOval(x + 20, y + 8, 4, 4);
  } 
}
