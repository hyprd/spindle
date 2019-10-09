/** COMP160 Lab 13 - Phrase.java
  * Ethan Simmonds - January 2017 
  * Determine from user-defined phrases, whether one is an anagram of another
  */
import java.util.Scanner;
import java.util.Arrays;

public class Phrase{
  public static void main (String [] args){
    //initialize scanner object, request user input and store the phrases in individual variables
    Scanner scan = new Scanner(System.in);
    System.out.println("Enter first phrase");
    String originalPhrase1 = scan.nextLine();
    System.out.println("Enter second phrase");
    String originalPhrase2 = scan.nextLine();
    String phrase1 = originalPhrase1;
    String phrase2 = originalPhrase2;
    
    
    //replace non-word characters with no space 
    phrase1.replaceAll("\\W", "");
    phrase2.replaceAll("\\W", "");
    
    
    char[] characters1 = phrase1.toCharArray();
    Arrays.sort(characters1);
    char[] characters2 = phrase2.toCharArray();
    Arrays.sort(characters2);
    
    String sortedPhrase1 = new String(characters1);
    System.out.println(sortedPhrase1 + " are the letters of " + originalPhrase1 + " in order");
    String sortedPhrase2 = new String(characters2);
    System.out.println(sortedPhrase2 + " are the letters of " + originalPhrase2 + " in order");
    
    //compare sorted strings
    if (sortedPhrase1.equals(sortedPhrase2)){
      System.out.println(phrase1 + " is an anagram of " + phrase2);
    }
    else{
      System.out.println(phrase1 + " is not an anagram of " + phrase2);
    }   
  }
}