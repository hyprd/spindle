import java.awt.*;
import java.util.Random;

public class Shape{
  private int x;
  private int y;
  private int height;
  private int width;
  private Color colour;
  
  /** Return a random number between determined values */
  public int randomInt(int min, int max){
    Random random = new Random();
    int range = random.nextInt((max - min) + 1) + min;
    return range;
  }
  
  /** Set values of fields using random-related methods */
  public Shape(){
    Random random = new Random();
    
    width = random.nextInt((30 - 10 ) + 1) + 10;
    height = width;
    
    x = random.nextInt(400 - width);
    y = random.nextInt(400 - height);
    
    int r = random.nextInt(256);
    int g = random.nextInt(256);
    int b = random.nextInt(256);
    
    colour = new Color(r,g,b);
    
  }
  
  /** Display circles with thier own defined values */
  public void display(Graphics displayShape){
    displayShape.setColor(colour);
    displayShape.fillOval(x, y, width, height);
  }
}