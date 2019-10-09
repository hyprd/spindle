//COMP160 Lab 13 - Anagram.java - Ethan Simmonds - August 2016

import java.util.Scanner;
import java.util.Arrays;

public class Anagram{
  /** Main method handles all parts of the application*/
  public static void main (String [] args){
    //user input, running twice to get both phrases
    Scanner scan = new Scanner(System.in);
    System.out.println("Enter first phrase");
    String phrase1 = scan.nextLine();
    System.out.println("Enter second phrase");
    String phrase2 = scan.nextLine();
    
    //store the unedited phrase so that it can be reused in returning the programs result
    String originalphrase1 = phrase1;
    String originalphrase2 = phrase2;
    
    /* formatting user given strings, allows the application to better handle capitalization 
     * aswell as punctuation and white space */
    
    //converting to lowercase
    phrase1 = phrase1.toLowerCase();
    phrase2 = phrase2.toLowerCase();
    //replace instances of non-word characters (punctuation + white space) with no character
    phrase1 = phrase1.replaceAll("\\W", "");
    phrase2 = phrase2.replaceAll("\\W", "");
    
    //create a char array and populate it with the characters from the user string
    char[] characters1 = phrase1.toCharArray();
    //sort the array entries (defaults to ascending)
    Arrays.sort(characters1);
    //create a new string using the ordered values from the array 
    String sortedphrase1 = new String(characters1);
    //return output to the console
    System.out.println(sortedphrase1 + " are the letters of " + originalphrase1 + " in order");
    
    //repeat for phrase 2
    char[] characters2 = phrase2.toCharArray();
    Arrays.sort(characters2);
    String sortedphrase2 = new String(characters2);
    System.out.println(sortedphrase2 + " are the letters of " + originalphrase2 + " in order");
    
    //check the sorted phrases to see if they have the same character count
    //phrases with matching amounts of characters in order are anagrams
    if (sortedphrase1.equals(sortedphrase2)){
      System.out.println(phrase1 + " is an anagram of " + phrase2);
    }
    else{
      System.out.println(phrase1 + " is not an anagram of " + phrase2);
      
    }
    
    
    
    
    
    

    
    
    
    
  }
  
}