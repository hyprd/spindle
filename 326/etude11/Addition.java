import java.util.*;
import java.text.*;

public class Addition {
    private int base, remainder, carry = 0;
    private int[] firstArray, secondArray;
    private int[] quotientArray, divisorArray;
    private int[] sumArray;
    private boolean[] negativeNumbers;
    private boolean signStatus = false;
    private ArrayList<String> input;

    public static void main(String[] args) {
        new Addition();
    }

    Addition() {
        input = getInput();
        // Check the input is sanitized before performing work on it
        if (sanitizedInput(input)) {
            int size = getSize(input);
            base = Integer.parseInt(input.get(0));
            firstArray = populateArray(input.get(1), size);
            secondArray = populateArray(input.get(2), size);
            sumArray = getSum(size);
            remainder = divideSum();
            printResult();
        } else {
            System.out.println("Invalid input");
            return;
        }
    }

    /**
     * Print results of sum and division.
     */
    void printResult() {
        int indexQuot = 0, indexSum = 0;
        ArrayList<Integer> sumList = new ArrayList<Integer>();
        for (int val : sumArray) {
            sumList.add(val);
        }

        ArrayList<Integer> quotientList = new ArrayList<Integer>();
        for (int val : quotientArray) {
            quotientList.add(val);
        }

        Iterator<Integer> iterSum = sumList.iterator();
        Iterator<Integer> iterQuot = quotientList.iterator();
        // If the numbers added are of different sizes, the arrays containing
        // the numbers within them still have placeholder 0's to bring the smallest
        // of the two up to the size of the other. Therefore iterate over the
        // array and increment the index which will act at the cutoff point
        // for the leading zeroes.
        while (iterQuot.hasNext() && iterQuot.next() == 0)
            indexQuot++;
        while (iterSum.hasNext() && iterSum.next() == 0)
            indexSum++;
        // Clean up zeroes on both lists
        sumList.subList(0, indexSum).clear();
        quotientList.subList(0, indexQuot).clear();
        System.out.print("Sum: ");
        if (signStatus)
            System.out.print("-");
        if (carry > 0)
            System.out.print(0);
        if (sumList.isEmpty()) {
            System.out.print(0);
        } else {
            sumList.forEach(System.out::print);
        }
        System.out.print("\nQuotient: ");
        if (signStatus)
            System.out.print("-");
        if (quotientList.isEmpty()) {
            System.out.print(0);

        } else {
            quotientList.forEach(System.out::print);
        }
        System.out.print("\nRemainder: " + remainder + "\n");
    }

    /**
     * Perform division of the sum by 2 and retrieve the remainder.
     * 
     * @return remainder
     */
    int divideSum() {
        int remainder = 0, size = sumArray.length;
        quotientArray = new int[sumArray.length];
        divisorArray = Arrays.copyOf(sumArray, size);
        // divisorArray is a carbon copy of the sumArray. Iterate over
        // each value and divide it by 2. This hopefully should generate
        // a total sum which is divided by 2.
        for (int i = 0; i < size; i++) {
            quotientArray[i] = divisorArray[i] / 2;
            // If division leaves a remainder
            if (divisorArray[i] % 2 == 1) {
                if (i != size - 1) {
                    divisorArray[i + 1] += base;
                } else {
                    remainder = 1;
                }
            }
        }
        return remainder;
    }

    /**
     * Get the sum value of adding two numbers (in list form).
     * 
     * @param size size of the array
     * @return sum in list form
     */
    int[] getSum(int size) {
        sumArray = new int[size];
        if(negativeNumbers[0] ^ negativeNumbers[1]){
            // fill arrays up to length
            // if first is negative, place at bottom and perform addition
            // if second is negative, ignore and perform addition
            ArrayList<Integer> firstList = new ArrayList<Integer>(Collections.nCopies(size, 0));
            ArrayList<Integer> secondList = new ArrayList<Integer>(Collections.nCopies(size, 0));
            for(int i = size - 1; i > 0; i--){
                firstList.set(i, firstArray[i]);
                secondList.set(i, secondArray[i]);
            }
            if(negativeNumbers[0]){
                for (int i = size - 1; i >= 0; i--) {
                    sumArray[i] = -firstArray[i] + secondArray[i] + carry;
                    carry = 0;
                    if(sumArray[i] > 0){
                        int wrap = 10 - sumArray[i];
                        sumArray[i] = wrap;
                        carry = 1;
                    }
                }
            }
        }

        else {
            if(negativeNumbers[0] && negativeNumbers[1]) signStatus = true;
            for (int i = size - 1; i >= 0; i--) {
                sumArray[i] = Integer.sum(firstArray[i], secondArray[i]);
            }
        }
        return sumArray;
    }

    int[] populateArray(String number, int size) {
        // For arrays of different sizes the values from the shortest of the two arrays
        // need to be brought up to the size of the largest of the two. The short array
        // attaches the end of their values to an array the size of the largest
        // (filled with 0's)
        //
        // This means:
        // first number: 429,
        // second number: 10000
        // output: [0, 0, 4, 2, 9]
        int[] insertArray = number.chars().map(ch -> ch - '0').toArray();
        // negative symbols have a character value of -3, change to 0 to not destroy the strings
        if (insertArray[0] == -3) {
            insertArray[0] = 0;
        }
        if (size == insertArray.length)
            return insertArray;
        int[] longArray = new int[size];
        int iterator = insertArray.length;
        for (int i = longArray.length - 1; iterator > 0; i--) {
            longArray[i] = insertArray[--iterator];
        }
        return longArray;
    }

    ArrayList<String> getInput() {
        ArrayList<String> list = new ArrayList<String>();
        try (Scanner sc = new Scanner(System.in)) {
            System.out.print("Enter base: ");
            list.add(sc.nextLine());
            System.out.print("Enter first number: ");
            list.add(sc.nextLine());
            System.out.print("Enter second number: ");
            list.add(sc.nextLine());
        }
        return list;
    }

    boolean sanitizedInput(ArrayList<String> input) {
        negativeNumbers = new boolean[2];
        ParsePosition pp;
        for (int i = 0; i < input.size(); i++) {
            if (input.get(i).length() == 0)
                return false;
            switch (i) {
            // Case for base number
            case 0:
                pp = new ParsePosition(0);
                if (!isNumeric(input.get(0), pp))
                    return false;
                // Check the base is between 2 - 10 (inclusive)
                int baseNumber = Integer.parseInt(input.get(0));
                if (baseNumber < 2 || baseNumber > 10)
                    return false;
                // Case for numbers to add
            case 1:
            case 2:
                String numberCheck = input.get(i);
                pp = new ParsePosition(0);
                // Check if negative signs (-) are present at the beginning of the word
                // If so, start the line parser at 1, else start it at 0 as usual.
                if (numberCheck.charAt(0) == '-') {
                    pp = new ParsePosition(1);
                    negativeNumbers[i - 1] = true;
                }
                if (!isNumeric(numberCheck, pp))
                    return false;
                // Check the numbers to add are between 2 - 1000 characters
                // in length
                String numberString = input.get(i);
                if (numberString.length() == 0 || numberString.length() > 1000)
                    return false;
            default:
                continue;
            }
        }
        return true;
    }

    int getSize(ArrayList<String> input) {
        return Math.max(input.get(1).length(), input.get(2).length());
    }

    boolean isNumeric(String line, ParsePosition parsePos) {
        /*
         * NumberFormat instance iterates each character of a string. If it reaches the
         * end of the line then every number it has checked is (hopefully) an integer.
         * 
         * This means the position of the parser is the same as length of the line (as
         * it is at the end). If not then the string has 1 or more letters/symbols in
         * it.
         */
        NumberFormat nf = NumberFormat.getInstance();
        nf.parse(line, parsePos);
        return line.length() == parsePos.getIndex();
    }
}