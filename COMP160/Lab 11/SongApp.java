/** COMP 160 Lab 11 - SongApp.java 
  * Ethan Simmonds - January 2017
  * Instantiate objects of song line strings and process them 
  */
public class SongApp {
 public static void main (String [] args){
  Song song1 = new Song("While my guitar gently weeps");
  System.out.println(song1.toString());
  song1.process();
  
  Song song2 = new Song("Let it be");
  System.out.println(song2.toString());
  song2.process();
  
  Song song3 = new Song("Penny Lane");
  System.out.println(song3.toString());
  song3.process();
  
 }
}
