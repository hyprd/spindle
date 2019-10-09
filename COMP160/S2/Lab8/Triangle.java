//Triangle.java - COMP160 LAB 8 - Ethan Simmonds - August 2016
public class Triangle{
  // Data field declarations
  private int p1x;
  private int p1y;
  private int p2x;
  private int p2y;
  private int p3x;
  private int p3y;
  private String name;
  
  /** Constructor to set triangle information */
  public Triangle(int pt1x, int pt1y, int pt2x, int pt2y, int pt3x, int pt3y, String nameIn){
    p1x = pt1x;
    p2x = pt2x;
    p3x = pt3x;
    p1y = pt1y;
    p2y = pt2y;
    p3y = pt3y;
    name = nameIn;
  }
  
  
  /** Constructor to calculate and return the length of a side */
  private double calcSide(int x1, int y1, int x2, int y2){
     return Math.pow(Math.pow((x1-x2), 2)+Math.pow((y1-y2), 2), 0.5);
  }
  
  /** Method to add the 3 sides and calculate the perimeter*/
  public double getPerimeter(){
    return calcSide(p1x, p1y, p2x, p2y)+calcSide(p1x, p1y, p3x, p3y)+calcSide(p2x, p2y, p3x, p3y);
  }
  
  /** Method for returning the name of the triangle*/
  public String getName(){
    return name;
  }
}