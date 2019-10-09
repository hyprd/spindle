import java.util.Scanner; //importing the scanner utility 
/**COMP160 LAB 3
  * Ethan Simmonds July 2016
  */
public class Fish {
  public static void main (String [] args){ //main method
    
    String verse3 = "This one has a little star.";
    String verse4; //default value of verse4
    
    Scanner scan = new Scanner(System.in); //input for the user
    System.out.println("Enter a line of text"); //message the use asking for their input
    verse4 = scan.nextLine();
    System.out.println("You entered: \"" + verse4 + "\""); //returns user input to console
    //call each verses method where applicable
    
    printVerse1();
    printVerse2();
    printVerse(verse3);
    printVerse(verse4);
  }
  public static void printVerse1(){ //first verse
    String verse1 = "One fish\nTwo fish\nRed fish\nBlue fish.\n";
    System.out.println(verse1);
  }
  public static void printVerse2(){ //second verse
    String verse2 = "Black fish\nBlue fish\nOld fish\nNew fish.\n";
    System.out.println(verse2);
  }
  public static void printVerse(String verse){ //third verse
    System.out.println(verse +"\n");
  }
  
  
}
