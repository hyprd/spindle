package shapes;
import java.awt.*;
import java.util.Random;

public class Shape{
  private int x, y, height, width;
  private int moveY = 1; 
  private int moveX = 1;
  private Color colour;
  
  public int randomInt(int lowlimit, int highlimit){
    Random random = new Random();
    int range = random.nextInt((highlimit - lowlimit) + 1) + lowlimit;
    return range;
  }
  
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
  
  public void move(){
   x += moveX;
   y += moveY;
   
   if (x > 380 || x < 0){
    Random random = new Random();
    moveX =- moveX; 
    width = random.nextInt((30-10)+1)+10;
    height =  width;
    
   }
   if (y > 380 || y < 0){
    Random random = new Random(); 
    moveY =- moveY;
    width = random.nextInt((30 - 10) + 1) + 10;
    height = width;
    
   }
  }
  
  public void display(Graphics displayShape){
    displayShape.setColor(colour);
    displayShape.fillOval(x, y, width, height);
  }
}