/** COMP160 Lab 12 - ReadString.java
  * Ethan Simmonds - January 2017
  * Counts the vowels and consonants of a given sentence  
  */
import java.util.Scanner;
public class ReadString{
  
  public static void main (String [] args){
    
    int consonant = 0;
    int vowelCount = 0;
    char character;
    
    Scanner scan = new Scanner(System.in);
    System.out.println("Enter a sentence");
    String uString = scan.nextLine().toLowerCase();
    
    
    
    for (int count = 0; count < uString.length(); count++){
      character = uString.charAt(count);
      if ('a' <= character && character <= 'z'){ 
        switch(character){
          case 'a':
          case 'e':
          case 'i':
          case 'o':
          case 'u':
            vowelCount += 1;
            break;
            
          default:
            consonant += 1; 
        }
      }
    }
    // Display result
    System.out.println("Sentence is: " + uString);
    System.out.println("Vowel count: " + vowelCount);
    System.out.println("Consonant count: " + consonant);
  }
}




