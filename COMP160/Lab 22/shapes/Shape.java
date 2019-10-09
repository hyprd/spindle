/** COMP160 Lab 22 - Shape.java
  * Ethan Simmonds - Febuary 2017
  * Generate displayable shapes for use in an array
  */
package shapes;
import java.awt.*;
import java.util.Random;

public class Shape{
  // field declarations
  private int x, y, height, width;
  private int moveY = 1; 
  private int moveX = 1;
  private Color colour;
  
  /** Generate a random number between defined limits */
  public int randomInt(int low, int high){
    Random random = new Random();
    int range = random.nextInt((high - low + 1)) + low;
    return range;
  }
  
  /** Generate dimensions, position and colour of each shape */
  public Shape(){
    width = randomInt(10,30);
    height = width;
    
    x = randomInt(0, 400 - width);
    y = randomInt(0, 400 - height);
    
    if(y < 200){
      moveY = -1;
      
    }
    
    
    int r = randomInt(0,255);
    int g = randomInt(0,255);
    int b = randomInt(0,255);
    
    colour = new Color(r,g,b);
  }
  
  /** If the shape position exceeds the bounds of the frame, invert its travel path */
  public void move(){
    x += moveX;
    y += moveY;
    
    if (x > 400 - width || x < 0){
      moveX = -moveX; 
    }
    
    if (y > 400 - height || y < 0){
      moveY = -moveY; 
    } 
  }
  
  /** Generate a new colour for a given shape object */
  public void changeColour(){
    int r = randomInt(0,255);
    int g = randomInt(0,255);
    int b = randomInt(0,255);
    colour = new Color(r,g,b);
  }
  
  /** Set initial colour, size and position for the shape object */
  public void display(Graphics displayShape){
    displayShape.setColor(colour);
    displayShape.fillOval(x, y, width, height);
  } 
}

