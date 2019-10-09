import java.util.Random;
import java.util.Scanner;

public class IntCounterApp {
  
  public static void main(String[] args){
    for (int i = 0; i < 3; i++){ 
      Scanner scan = new Scanner(System.in);
      System.out.println(" Which number do you wish to find? ");
      int uValue = scan.nextInt();
      IntCounter arr = new IntCounter(makeArray());
      arr.showTarget(uValue);
      
    } 
  }
  
  /** Create a random variable for makeArray*/
  public static int randInt(int min, int max){
    Random rand = new Random();
    int randomNum = rand.nextInt((max - min) + 1) + min;
    return randomNum;
    
  }
  /** Create and return a random array */
  public static int[] makeArray(){
    int[] newArray = new int[randInt(5,10)];
    for (int a = 0 ; a < newArray.length;  a++){
      newArray[a] = randInt(0,4);
    }
    return newArray;
  }
}
