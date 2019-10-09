
/**
 * COSC326 - Effective Programming
 * Etude 2 - Prime days
 * 
 * Write a program that takes input from the command line a single sequence
 * of month lengths (always positive integers) separated by spaces and prints
 * to stdout all the truly prime days of the corresponding calendar, one per line
 * in the following format:
 *      <number of days>: <number of month> <day of month> 
 * 
 * @author Ethan Simmonds
 * @since July 2019
 */
import java.util.Arrays;

public class PrimeDays {
    private Sieve sieve = new Sieve();

    public static void main(String[] args) {
        try{
            new PrimeDays(args);
        } catch (Throwable e) {
            System.out.println("Exception: " + e.getMessage());
            e.printStackTrace();
        }
    }

    PrimeDays(String[] months) {
        // The sieve limit will end up being whatever the longest month is.
        int sieveLimit = Integer.parseInt(months[0]);
        for (String currentMonth : months) {
            int currentMonthInt = Integer.parseInt(currentMonth);
            if (currentMonthInt > sieveLimit)
                sieveLimit = currentMonthInt;
        }
        // SieveValues evaluates up to the largest month (highest amount of days). To
        // save time checking every day of the year for primality it's done at the
        // end using method isPrime after every other check. This cuts down the
        // amount of values to sieve quite a bit depending on input.
        boolean[] primeNumbers;
        // If the total amount of months is longer than the longest month is in days, the 
        // program will try to check prime numbers out of bounds in its array. Therefore 
        // take the largest out of the two and set that as the limit for the sieved values.
        if(sieveLimit > months.length){
            primeNumbers = sieve.SieveValues(sieveLimit);
        } else{
            primeNumbers = sieve.SieveValues(months.length);
        }
        // Iterate over every month, checking for primality sieved values.
        for (int i = 1; i < months.length + 1; i++) {
            if (primeNumbers[i] == false) {
                continue;
            } else {
                // Iterate over each day of the month. Only occurs if the month
                // evaluates primality to true.
                int monthLength = Integer.parseInt(months[i - 1]);
                for (int j = 1; j < monthLength + 1; j++) {
                    if (primeNumbers[j] == false) {
                        continue;
                    } else {
                        // Set day of the year to j (the current day in the current month).
                        int dayOfYear = j;
                        // Add all the values of every previous month before the current
                        // to get the total amount of day which have passed.
                        for (int k = 0; k < i - 1; k++) {
                            dayOfYear += Integer.parseInt(months[k]);
                        }
                        // If the day of the year is prime, print the value.
                        if (isPrime(dayOfYear)) {
                            System.out.println(dayOfYear + ": " + i + " " + j);
                        }
                    }
                }
            }
        }
    }

    /**
     * An implementation of a prime number checker.
     * 
     * @param n the number to check
     * @return a numbers primality
     */
    boolean isPrime(int n) {
        if (n == 2)
            return true;
        if (n % 2 == 0)
            return false;
        for (int i = 3; i * i <= n; i += 2) {
            if (n % i == 0)
                return false;
        }
        return true;
    }

    /**
     * A Java implementation of the Sieve of Eratosthenes, a simple but effective
     * method of determining which numbers in a value set are prime without
     * calculating them one-by-one.
     * 
     * Reference webpage: https://www.geeksforgeeks.org/sieve-of-eratosthenes/
     */
    private class Sieve {
        /**
         * Filter the number set to determine which numbers in it are prime.
         * 
         * @param limit the upper bound of the number set
         * @return an array of the number set and their expected primalities
         */
        boolean[] SieveValues(int limit) {
            boolean primalities[] = new boolean[limit + 1];
            // Set all elements to initially true
            Arrays.fill(primalities, true);
            // 0 and 1 are NOT prime, and will evaluate true in this
            // implementation. So set them manually.
            if (primalities.length > 2) {
                primalities[0] = false;
                primalities[1] = false;
            }
            for (int j = 2; j * j < limit; j++) {
                // If primality tests true
                if (primalities[j] == true) {
                    // Update multiples to false
                    for (int k = j * j; k <= limit; k += j) {
                        primalities[k] = false;
                    }
                }
            }
            return primalities;
        }
    }

}