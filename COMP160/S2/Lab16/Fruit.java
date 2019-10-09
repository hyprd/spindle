/** COMP160 Lab 16 - Fruit.java - Ethan Simmonds - September 2016*/
import java.util.*;

public class Fruit{
  public static void main (String [] args){
    Scanner scan = new Scanner(System.in);
    
    String [] fruitArray = new String[3];
    
    int i = 0;
    while (i < fruitArray.length){
      System.out.println("Please name a fruit to add to the array");
      for (int cnd = 0; cnd < fruitArray.length; cnd++) {
        fruitArray[cnd] = scan.nextLine();
        i++;
     }
    }
    
    for (String fruit : fruitArray){
      fruit = fruit.toLowerCase();
      
      System.out.println("Guess what fruit I am? " + fruit.substring(0,2) + " - " + fruit.length() + " letters");
      String guess = scan.nextLine();
      if (guess.toString() == fruit.toString()){
        System.out.println("Correct");
        
      }
       
        
      }
      
      
    }
    
    
      
     
  
  
}
