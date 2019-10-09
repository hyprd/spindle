/** COMP160 Lab 16 - Fruit.java 
  *  Ethan Simmonds - Febuary 2017
  *  After accepting user input, ask the user what fruit was entered
  */
import java.util.Scanner;

public class Fruit{
  
  public static void main (String[] args){
    String[] fruits = new String[3];
    Scanner scan = new Scanner(System.in);
    //ask for user input
    for (int i = 0; i < fruits.length; i++){
      System.out.println("Enter fruit");
      String fruitLine = scan.nextLine().toLowerCase();
      fruits[i] = fruitLine;
    }
    //ask for user to guess fruit input, return boolean isCorrect as true if input matches
    for(String i: fruits){
      boolean isCorrect = false;
      // System.out.println("Guess what fruit I am? " + i.substring(0,2) + "\t" + i.length() + " letters");
      // String guessLine;
//      if(guessLine.equals(i)){
//        System.out.println("Correct");
//        isCorrect = true;
//        
//      }
      //if use enters incorrect input, repeat until isCorrect is true
      //else{
      do{
        System.out.println("Guess what fruit I am? " + i.substring(0,2) + "\t" + i.length() + " letters");
        
        String guessLine = scan.nextLine();
        if(guessLine.equals(i)){
          System.out.println("Correct");
          isCorrect = true;
        }
        else{
          System.out.println("Try again");
        }
      } while(isCorrect == false);
    }
  }
}




