public class Box {
  ///data field declarations
 private int height;
 private int width;
 private int length;
 
 //mutator for height
 public void setHeight(int h){
  height = h;
 }
 //mutator for width
 public void setWidth(int w){
  width = w;
 }
 //mutator for length
 public void setLength(int l){
  length = l;
 }
 //surface area formula
 public int getSurfaceArea(){
  return 2*(height*length)+2*(length*width)+2*(width*height);
 }
 //volume formula
 public int getVolume(){
  return height*width*length;
 }
 //return data field information alongide volume and surface area formulae answers to the console
 public String toString(){
  return "Height is " + height + ". " +
    "Length is " + length + ". " +                  
    "Width is "  + width + ". " + 
    "Volume is " + getVolume() + ". " + 
    "Surface Area is " + getSurfaceArea() + ". ";
  
 }
 //constructor for box accepting 3 arguments
 public Box(int sh, int sw, int sl){
  height = sh;
  width = sw;
  length = sl; 
 }
 //default constructor
 public Box(){
 }
 //constructor for cube which only accepts one argument
 public Box(int s){
  height=s;
  width=s;
  length=s;
 }
 
 

 
 

}
