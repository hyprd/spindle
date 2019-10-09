import java.util.Arrays;
import java.util.Scanner;
public class test {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int base = Integer.parseInt(scan.nextLine());
        String first = scan.nextLine();
        String second = scan.nextLine();
        addition(base, first, second);
        scan.close();
    }

    private static void addition(int base, String first, String second) {
        int size;
        int iterator;
        String[] firstString = first.split("(?!^)");
        String[] secondString = second.split("(?!^)");
        /* System.out.println("FirstString length: " + firstString.length);
        System.out.println("SecondString length: " + secondString.length); */

        size = firstString.length + 1;
        if(secondString.length > firstString.length) {
            size = secondString.length + 1;
        } else if(secondString.length == firstString.length) {
            size++;
        }
        
        //System.out.println("Size: " + size); 

        iterator = 0;
        int[] firstNumber = new int[size];
        for(int i = firstString.length-1; i >= 0; i--) {
            firstNumber[iterator] = Integer.parseInt(firstString[i]);
            iterator++;
        }

        iterator = 0;
        int[] secondNumber = new int[size];
        for(int u = secondString.length-1; u >= 0; u--) {
            secondNumber[iterator] = Integer.parseInt(secondString[u]);
            iterator++;
        }

        //System.out.println(Arrays.toString(firstNumber));
        //System.out.println(Arrays.toString(secondNumber));


        int[] sum = new int[size];
        int[] divisor = new int[size];
        int[] quotient = new int[size];
        int remainder = 0;
        /* System.out.println("FirstNumberList size: " + firstNumber.length);
        System.out.println("SecondNumberList size: " + secondNumber.length); */
        
        iterator = size - 1;
        for(int i = 0; i < size; i++) {
            sum[iterator] = firstNumber[i] + secondNumber[i];
            iterator--;

        }
        //System.out.println(Arrays.toString(sum));

        /* System.out.println("First number reversed: " + Arrays.toString(firstNumber));
        System.out.println("Second number reversed: " + Arrays.toString(secondNumber));
        System.out.println(Arrays.toString(sum)); */

        for(int i = size - 1; i >= 0; i--) {
            if(sum[i] >= base) {
                sum[i] -= base;
                sum[i-1]++;
            }
        }

        //System.out.println(Arrays.toString(sum));
        System.arraycopy(sum, 0, divisor, 0, size);
        for(int i = 0; i < size; i++) {
            quotient[i] = divisor[i]/2;
            if(divisor[i]%2 == 1) {
                if(i != size -1) {
                    divisor[i + 1] += base;
                } else {
                    remainder = 1;
                }
            }
        }

        /* System.out.println("###########################\n");
        System.out.println("Sum Array: \n" + Arrays.toString(sum));
        System.out.println("Divisor Array: \n" + Arrays.toString(divisor));
        System.out.println("Quotient Array: \n" + Arrays.toString(quotient));
        System.out.println("###########################\n");
        System.out.println("\nSum in base " + base + ":"); */
        boolean place = false;

        for(int i : sum){
            //System.out.println("\nSum: " + i + "\n");
            if(i != 0) {
                place = true;
            }
            if(place) {
                System.out.print(i);
            }
        }
        System.out.println("\nQuotient:");
        place = false;
        for(int i: quotient){
            //System.out.println("\nQuotient: " + i + "\n");
            if(i != 0) {
                place = true;
            }
            if(place) {
                System.out.print(i);
            }
        }
        System.out.println("\nRemainder: " + remainder);
    }
}