/** COMP 160 Lab 11 - Song.java 
  * Ethan Simmonds - January 2017
  * Process a given song line and display alterations to the screen
  */

public class Song {
  //field declarations
  private String songLine;
  
  public Song(String newSongLine){
    songLine = newSongLine;
  }
  
  public String toString(){
    return ("Song line: " + songLine);
  }
  
  //* Provide alterations (if possible) to a user-defined string */
  public void process(){
    
    
    //Print out length of song line
    System.out.println("Length of song line: " + songLine.length());
    
    //Print out last character in songLine
    System.out.println("Last character: "+ songLine.charAt(songLine.length() - 1));
    
    int firstSpace = songLine.indexOf(" ");
    int secondSpace = songLine.indexOf(" ", firstSpace + 1);
    
    
    if (secondSpace == songLine.length()-1 || secondSpace < 0){
      System.out.println("- Index position doesn't exist -");
    }
    
    
    else{
      
      //First two words of songLine  
      System.out.println("First two words of song line: " + songLine.substring(0, secondSpace)); 
      
      //Subsequent words of songLine
      System.out.println("Subsequent words of song line: " + songLine.substring((secondSpace)));
      
      //First letter of the third word
      System.out.println("First letter of third word: " + songLine.charAt(secondSpace + 1));
    }
    
    //Convert to uppercase
    System.out.println("Uppercase conversion: " + songLine.toUpperCase());
    
    //Replace spaces with 'x'
    System.out.println("Replace white space with x: " + songLine.replaceAll("\\s+", "x"));
    
    System.out.println("******************************");
  }
}


