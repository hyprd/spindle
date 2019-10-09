package shapes;
import java.awt.*;

public class Circle extends Shape{
  public void display(Graphics displayShape){
    displayShape.setColor(colour);
    displayShape.fillOval(x, y, width, height);
  }
  
}