//COMP160 - Song.java - Ethan Simmonds - August 2016
public class SongApp {
 /** Main method to create objects and call their editing methods */
 public static void main(String[] args) {
  Song song1 = new Song("While my guitar gently weeps");
  System.out.println(song1.toString());
  song1.process();
  
  Song song2 = new Song("Let it be");
  System.out.println(song2.toString());
  song2.process();
  
  Song song3 = new Song("PennyLane");
  System.out.println(song3.toString());
  song3.process();
  
  

 }

}
