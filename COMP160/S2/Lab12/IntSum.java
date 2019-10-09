//COMP160 LAB12 - IntSum.java - Ethan Simmonds - August 2016
import java.util.Scanner;
public class IntSum {
 /** The entire program is written in this main method*/
 public static void main (String[] args){
  int minvalue = 2;
  int sum = 0;
  Scanner scan = new Scanner(System.in);
  System.out.println("Please enter your maximum value greater than one: ");
  int uservalue = scan.nextInt();
  
  if (uservalue < minvalue){
   System.out.println("Input value must not be less than 2");
  }
  
  else{
  int i = uservalue; 
  while (uservalue != minvalue){
    if (uservalue % 2 ==0){
   sum+= uservalue;
    }
   uservalue -= 1;
  }
  
  if (uservalue == minvalue){
   System.out.println("Sum of even numbers between " + minvalue + " and " + i + " inclusive is: " + (sum + minvalue));
   
  }
  
  }
   
  
   
   
   
   
   
  }
  
}
  
  
  
  
  



