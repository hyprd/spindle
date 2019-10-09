//COMP160 LAB12 - StringVowel.java - Ethan Simmonds - August 2016
import java.util.Scanner;
public class StringVowel {
  /** The entire program is written in this main method */
  public static void main (String[] args){
    //create scanner and convert user-given input into lowercase
    //this allows the switch to be better specified between lower and uppercase
    Scanner scan = new Scanner(System.in);
    System.out.println("Enter a sentence");
    String userstring = scan.nextLine();
    String userstring1 = userstring.toLowerCase();
    
    //field declarations
    int vowelcount = 0;
    int consonantcount = 0;
    int n = 0;
    
    //n is the position of the index being incremented (or going through each value) at the end of each loop run
    while(n < userstring.length()){
    //switch to check for vowels and consonants
    switch(userstring1.charAt(n)){ 
      case 'a':
      case 'e':
      case 'i':
      case 'o':
      case 'u':
        vowelcount +=1;
        break;
      default:
        if (userstring1.charAt(n) <= 'z' && userstring1.charAt(n)>='a'){
        consonantcount+=1;
      }
     }
    n++;
    }
    System.out.println("Sentence is: " + userstring);
    System.out.println("VowelCount is: " + vowelcount);
    System.out.println("ConsonantCount is: " + consonantcount);
       
        
      
      
      
    }
    
    
    
    
    
  
}




