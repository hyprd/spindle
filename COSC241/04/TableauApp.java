package week04;
import java.util.Arrays;

/**
 * Skeleton code for an array based implementation of Young's tableau.
 *
 * @author Iain Hewson
 */
public class TableauApp {

    /**
     * The main method is just used for testing.
     *
     * @param args command line arguments are not used.
     */
    public static void main(String[] args) {
    }

    /**
     * Determines whether the array passed to it is a valid tableau or not.
     * @param t a two-dimensional array to test for tableau-ness.
     * @return true if the parameter is a valid tableau, otherwise false
     */

    public static boolean isTableau(int[][] t){
        if (columnValuesIncrease(t) && rowValuesIncrease(t)
            && rowLengthsDecrease(t) && isSetOf1toN(t)){
            return true;
        }
        return false;
    }

    
    /**
     * Determine whether there is no row longer than a preceding row.
     * @return true if no row is longer than a preceding row, otherwise false
     * @param t a 2D array representing a Young tableau.
     */
    public static boolean rowLengthsDecrease (int[][] t){
        for(int u = 1; u < t.length - 1; u++){
            if (t[u].length > t[u - 1].length){
                return false;
            }
        } return true;
    }
    
    /**
     * Determine whether integers are increasing from left to right in any row.
     * @param t a 2D array representing a Young tableau
     * @return true if they are increasing from left to right, otherwise false
     */
    public static boolean rowValuesIncrease(int[][] t){
        for (int a = 0; a < t.length; a++){
            for (int b = 1; b < t[a].length; b++){
                if (t[a][b] < t[a][b - 1]){
                    return false;
                }

            }

        } return true;

    }
    
    /**
     * True if from top to bottom in any column integers are increasing.
     * @return true if column integers are increasing, false if not
     * @param t a 2D array representation of a Young tableau
     */

    public static boolean columnValuesIncrease(int[][] t){
        for (int i = 1; i < t.length; i++){
            for (int u = 0; u < t[i].length; u++){
                if (t[i][u] < t[i - 1][u]){
                    return false;
                }
            }
        }
        return true;
    }
    /**
     * True if the set of integers used is sorted 1 to N, otherwise false.
     * @return true if the set of integers is sorted, otherwise fals
     * @param t a 2D array representation of a Young tableau
     */

    public static boolean isSetOf1toN(int[][] t){
        int a = 0;
        int i = 0;
        //append a with length of b location in array
        for (int b = 0; b < t.length; b++){
            a += t[b].length;
        }
        
        
        int[] array = new int[a];
        //nested loop to append in array
        for (int out = 0; out < t.length; out++){
            for(int in = 0; in < t[out].length; in++){
                array[i] = t[out][in];
                i++;
            }
        }
        
        Arrays.sort(array);
        
        //if array location doesnt equal previous array location, eval false
        for (i = 1; i < array.length; i++){
            if (array[i] != array[i - 1] + 1){
                return false;
            }
        } return true;                     
    }
    
    

    /**
     *  Returns a string representation of an array based tableau.
     *
     * @param t a two-dimensional array which represents a tableau.
     *
     * @return a string representation of an array based tableau.
     */
    public static String toString(int[][] t) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < t.length; i++) {
            for (int j = 0; j < t[i].length; j++) {
                result.append(String.format("%-4s", t[i][j]));
            }
            if (i < t.length-1) {
                result.append("\n");
            }
        }
        return result.toString();
    }
    
}
