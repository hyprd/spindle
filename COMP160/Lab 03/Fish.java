/**
 * COMP160 Lab 03 - Fish.java - Ethan Simmonds - January 2017 
 */

import java.util.Scanner;
/** Displays a sequence of strings representing a poem, with user input added*/
public class Fish{
 
  public static void main(String [] args){
    //declarations for parameters used later
    String verse3 = "This one has a little star.";
    String verse4;
    //instantiate an instance of Scanner and request user input
    Scanner scan = new Scanner (System.in);
    System.out.println("Enter verse 4 text: ");
    verse4 = scan.nextLine();
    
    //call the method for each line in order, passing parameters if applicable 
    printVerse1(); 
    printVerse2();
    printVerse(verse3);
    printVerse(verse4);
    
    
    
  } //end main
  
  /**declares a String variable called verse1 and displays it on the screen*/
  public static void printVerse1(){
    String verse1 = "One fish\nTwo fish\nRed fish\nBlue fish.\n";
    System.out.println(verse1);
  } //end printVerse1
  
  /** declares a String variable called verse2 and displays it on the screen*/
  public static void printVerse2(){
    String verse2 = "Black fish\nBlue fish\nOld fish\nNew fish.\n";
    System.out.println(verse2);
  }
  
  /** displays the parameter verse the method is given to the screen*/
  public static void printVerse(String verse){
    System.out.println(verse + "\n");
    
  }
  
} //end class