//TriangleApp.java - COMP160 LAB 8 - Ethan Simmonds - August 2016
import java.text.DecimalFormat;
public class TriangleApp{
  public static void main (String[] args){
    DecimalFormat fmt = new DecimalFormat("0.##");
    
    //Create each triangle object
    Triangle a = new Triangle (0,3,3,4,1,9,"A");
    System.out.println("Triangle " + a.getName() + " Perimeter is " + fmt.format(a.getPerimeter()) + " units.");
    
    Triangle b = new Triangle (0,6,6,8,2,18,"B");
    System.out.println("Triangle " + b.getName() + " Perimeter is " + fmt.format(b.getPerimeter()) + " units.");
    
    Triangle c = new Triangle (0,9,9,12,3,27,"C");
    System.out.println("Triangle " + c.getName() + " Perimeter is " + fmt.format(c.getPerimeter()) + " units.");
    
    Triangle d = new Triangle (0,12,12,16,4,36,"D");
    System.out.println("Triangle " + d.getName() + " Perimeter is " + fmt.format(d.getPerimeter()) + " units.");
      

  }
  
}
