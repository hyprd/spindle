package week03;
/** 
 * Return the amount and sum of digits in a given value.
 * @author Ethan Simmonds
 * @since March 2018
 */
public class RecursiveApp{
    /** 
     * Primary execution method.
     * @param args a String array of arguments
     */
    public static void main (String[] args){
        
        
        long a = Long.parseLong(args[0]);
        System.out.println(digits(a));
        System.out.println(sumOfDigits(a));
    }
    /**
     * Return a number of type 'long' equal to the length of 
     * digits in an argument.
     * @param n a user supplied value of type 'long'
     * @return iterate this method until every digit is counted
     */
    public static long digits(long n){
        if (n < 1){
            return 0;
        }
        return 1 + digits(n /10);
    }
    
    /** 
     * Return a number of type 'long' equal to the sum of every
     * digit in a given argument.
     * @param n a user supplied value of type 'long'
     * @return iterate this method until every digit is counted 
     */
    public static long sumOfDigits(long n){
        if (n % 10 == n){
            return n;

        }
        return (n % 10) + sumOfDigits(n / 10);
    }
}
