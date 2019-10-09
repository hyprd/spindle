/** Lab 4 COMP160 S2 2016
  * Ethan Simmonds
  */
import java.util.Scanner;

public class FahrenheitToCelsius {
  public static void main(String[] args){
    convertFToC();
    convertFToC();
    convertFToC(); 
  }
  
//Gets input from the user representing Fahrenheit and displays the Celsius equivalent
  public static void convertFToC(){
    Scanner scan = new Scanner (System.in);
    System.out.println("Enter Fahrenheit temperature: ");
    double fahrenheit = scan.nextDouble();
    System.out.println( fahrenheit + " degrees Fahrenheit is " + toCelsius(fahrenheit) + " degrees Celsius" );   
  }
//The conversion formula for converting Fahrenheit to Celsius
  public static double toCelsius (double fahr){
    final int BASE = 32;
    final double CONVERSION_FACTOR = 5.0/9.0;
    double celsius = (fahr - BASE)* CONVERSION_FACTOR;
    return celsius;
  }
}
