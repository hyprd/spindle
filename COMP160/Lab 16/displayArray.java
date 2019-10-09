/** COMP160 Lab - displayArray.java 
 *  Ethan Simmonds - Febuary 2017
 *  Print the values of a 2-Dimensional array
 */
public class DisplayArray{
  public static void main(String[] args){
    int cols = 12;
    int rows = 12;
    int[][] arr = new int[cols][rows];
    for (int row = 0; row < rows; row++){
      for(int col = 0; col < cols; col++){
        arr[row][col] = (row+1) * (col+1); 
      }
    }
    //print values stored in array
    for (int[] arr2: arr){
      for (int a: arr2){
          System.out.print(a + "\t");
      }
      System.out.println();
    }
  }
}