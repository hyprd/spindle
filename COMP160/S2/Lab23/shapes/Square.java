package shapes;
import java.awt.*;

public class Square extends Shape{
  public void display(Graphics displayShape){
    displayShape.setColor(colour);
    displayShape.fillRect(x, y, width, height);
  }
  
}