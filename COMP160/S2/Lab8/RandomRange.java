/**
 * RandomRange.java
 * Lab 8, Part 2, COMP160  2016
 * Contains a single method which returns random integer between high and low parameters.
 */
import java.util.Random;
public class RandomRange{
  /** Returns random integer between high and low parameters.
 @param low lowest value of range required
 @param high highest value of range required
 @return a random integer between low and high values */
public int randomRange(int low, int high){
  Random generator = new Random();
  return generator.nextInt(high-low+1) + low;
}
} 