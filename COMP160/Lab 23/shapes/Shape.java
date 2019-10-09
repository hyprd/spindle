/** COMP160 Lab 23 - Shape.java
  * Ethan Simmonds - Febuary 2017
  * Generate displayable shapes for use in an array
  */
package shapes;
import java.awt.*;
import java.util.Random;

public abstract class Shape{
  // field declarations
  protected int x, y, height, width;
  protected Color colour;
  private int moveY = 1; 
  private int moveX = 1;
  
  
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
    
    x = randomInt(width, 380);
    y = randomInt(height, 380);
    
    int r = randomInt(0,255);
    int g = randomInt(0,255);
    int b = randomInt(0,255);
    
    colour = new Color(r,g,b);
  }
  
  /** If the shape position exceeds the bounds of the frame, invert its travel path */
  public void move(){
    x += moveX;
    y += moveY;
    
    if (x > 380 || x < 0){
      moveX = -moveX; 
    }
    
    if (y > 380 || y < 0){
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
  public abstract void display(Graphics displayShape); 
}

