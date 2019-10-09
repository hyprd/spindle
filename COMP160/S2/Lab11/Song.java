//COMP160 - Song.java - Ethan Simmonds - August 2016
/** Create and return an edited line of a song*/
public class Song {
 //declare the data field
 private String songLine;
 
 /** Constructor to set the value*/
 public Song (String sl){
  songLine = sl;
 }
 /** Method to return the song line of the object*/
 public String toString(){
  return "Song line: " + songLine;
 }
 /** Method to edit and manipulate a given song line*/
 public void process(){
   
  System.out.println("Length is: " + songLine.length());
  System.out.println("Last character of songLine: " + songLine.charAt(songLine.length() - 1));
  
  if (songLine.indexOf(" " , songLine.indexOf(" ")+1) > 0){
    System.out.println("First two words of songLine: " + songLine.substring(0,songLine.indexOf(" " , songLine.indexOf(" ")+1)));
    System.out.println("Subsequent words of songLine: " + songLine.substring(songLine.indexOf(" " , songLine.indexOf(" ")+1)));
    System.out.println("First letter in the third word of songLine: " + songLine.charAt(songLine.indexOf(" " , songLine.indexOf(" ")+1)+1));;
   }
  
  else{
   System.out.println("The index you are trying to reach doesn't exist"); 
  }
  
  System.out.println("Uppercase: " + songLine.toUpperCase());
  System.out.println("Replaced spaces with x: " + songLine.replaceAll(" ", "X"));
  
  if (songLine.indexOf("b")>0){
  System.out.println("First instance of 'b': " + songLine.indexOf("b"));
  }
  else{
  System.out.println("The first instance of b cannot be found");
  System.out.println("Reprinted songLine: " + songLine);
  }
 }
}
  
  
  
  
 


