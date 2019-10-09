/** COMP160 Lab 21 - Shape.java - Ethan Simmonds - October 2016 */
import java.awt.*;
import java.util.Random;

/**Declares any necessary variables and perform appropriate calculations*/
public class Shape{
  //data field declarations 
  private int x;
  private int y;
  private int height;
  private int width;
  private Color colour;
  
  /** Shape constructor to randomly generate values for size, position and colour*/
  public Shape(){
    Random random = new Random();
    
    width = random.nextInt((30 - 10) + 1) + 10;
    height = width;
    
    x = random.nextInt(400 - width);
    y = random.nextInt(400 - height);
    
    int r = random.nextInt(256);
    int g = random.nextInt(256);
    int b = random.nextInt(256);
    
    colour = new Color(r,g,b);
    
  }
  /** Given values from the Shpae constructor, generate the shape */
  public void display(Graphics displayShape){
    displayShape.setColor(colour);
    displayShape.fillOval(x, y, width, height);
  }
}