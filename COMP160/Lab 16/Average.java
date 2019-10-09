/** COMP160 Lab 16 - Average.java
 *  Ethan Simmonds - Febuary 2017 
 *  Print the average of each row in a 2-Dimensional array
 */
public class Average{
  public static void main (String[] args){
    int[][] table = {{1,2,3},{4,5,6},{7,8}};
    
    //print values of the array
    for (int row1 = 0; row1 < table.length; row1++){
      int total = 0;
      for (int column1 = 0; column1 < table[row1].length; column1++){
        total += table[row1][column1];
        System.out.print(table[row1][column1] + " ");
        
      } 
      //print array averages
      System.out.println("\t" + "Average: " + (double)total/table[row1].length);
      System.out.println();
      
    } 
  }
}





