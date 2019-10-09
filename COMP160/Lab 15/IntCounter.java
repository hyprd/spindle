
public class IntCounter {
  public int[] numArray;
  
  /** Return the elements of an array */
  public IntCounter(int setArray[]){
    this.numArray = setArray;
    for(int i : numArray){
      System.out.print(i + " ");  
    }
    System.out.println(" Array is of length: " + numArray.length);
  }
  
  /** Loop every element in the array and return the position if an integer matches*/
  public void showTarget(int i){ 
    boolean found = false;
    for(int a = 0;  a < numArray.length; a++){
      if (i == numArray[a]){
        System.out.println("There is a " + i + " in position " + a); 
        found = true;
      }
    } 
    if (found == false){
      System.out.println("Array position doesnt exist");
    } 
  }  
}


