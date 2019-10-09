/** COMP160 Lab 12 - IntSum.java
  * Ethan Simmonds - January 2017
  * Sum even numbers between 2 and a user defined number
  */
import java.util.Scanner;

public class IntSum{
  public static void main (String [] args){
    Scanner scan = new Scanner(System.in);
    System.out.println("Enter an integer greater than 1");
    int value1 = scan.nextInt();
    
    if (value1 >= 2){
      int count = 0;
      int sum = 0;
      while (count < value1){
        count++;
        if (count % 2 == 0){
          sum += count;
        }
      }
      System.out.println("Sum of even numbers between 2 and " + value1 + " inclusive is: " + sum);
    }
    else{
      System.out.println("Input value must not be less than 2");
    } 
  }
}