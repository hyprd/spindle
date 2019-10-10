package week01;
import java.util.Scanner;

/**
 *   A simple counter program to determine line and word count of a
 *   given sentence.
 *   @author Ethan Simmonds
 *   @since Febuary 2018
 */
public class Counter{

    /** Main execution method.
     *   @param args arguments for methods
     */
    public static void main (String[] args){
        Scanner inputLine = new Scanner(System.in);
        print(inputLine);              
    }

    /**
     *  Returns the word and line count of a sentence given by the
     *  Scanner instance.
     *  @param sc - An instance of java.util.Scanner used by the
     *  argument sentence
     */
    public static void print(Scanner sc){
        int countWord = 0;
        int countLine = 0;
        
        while (sc.hasNextLine()){
            String w = sc.nextLine().trim();
            
            countLine++;
            if(!w.isEmpty()){
                countWord += w.split("\\s+").length;
            }           
        }
        System.out.println("lines: " + countLine + "\nwords: " + countWord);
    }    
}

    
