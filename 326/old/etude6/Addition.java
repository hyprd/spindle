import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Set;
import java.util.Arrays;
/*
 * COSC326 - EFFECTIVE PROGRAMMING
 * ETHAN SIMMONDS - SEMESTER 1 2019
 * ADDITION - WRITE A PROGRAM TO ADD TWO NUMBERS WITH UP TO 1000 DIGITS
 * IN ANY BASE UP TO 10
 */
public class Addition{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter first number:");
        String FirstNumber = sc.nextLine();
        System.out.println("Enter second number:");
        String SecondNumber = sc.nextLine();
        System.out.println("Enter base:");
        Integer Base = sc.nextInt();
        NumberAddition(FirstNumber, SecondNumber, Base);
        sc.close();
    }

    public static Integer CheckSize(char[] First, char[] Second){
        Integer FirstSize = First.length, SecondSize = Second.length, Size = FirstSize + 1;
        if(SecondSize > First.length){
            Size = SecondSize + 1;
        } else if(SecondSize.equals(First.length)){
            Size++;
        }
        return Size;
    }

    public static Integer[] PopulateNumberArrays(char[] OriginalOrderArray, Integer Size){
        Integer ReverseIterator = 0;
        Integer[] ReverseOrderArray = new Integer[Size];
        for(int i = OriginalOrderArray.length - 1; i >= 0; i--){
            ReverseOrderArray[ReverseIterator] = Character.getNumericValue(OriginalOrderArray[i]);       
            ReverseIterator++;
        }
        for(int u = 0; u < ReverseOrderArray.length; u++){
            if(ReverseOrderArray[u] == null) ReverseOrderArray[u] = 0;
        }
        return ReverseOrderArray;
    }

    public static Integer[] PopulateAndConvertSum(Integer Size, Integer[] FirstVal, Integer[] SecondVal, Integer Base){
        Integer SumIterator = Size - 1;
        Integer[] ReturnSum = new Integer[Size];
        // Populate the sum array starting from the highest value - 1.
        // Add the lowest sums to the end of the array
        for(int i = 0; i < Size; i++){
            ReturnSum[SumIterator] = FirstVal[i] + SecondVal[i];
            SumIterator--;
        }
        // Base Conversion
        for(int j = Size - 1; j >= 0; j--){
            if(ReturnSum[j] >= Base) {
                ReturnSum[j] -= Base; 
                ReturnSum[j - 1]++;
            }
        }
        return ReturnSum;
    }

    public static void GenerateResults(Integer[] SumArray, Integer[] QuotientArray, Integer Base){
        System.out.println("\nSum: ");
        for(int i : SumArray){
            if(i != 0) {
                System.out.print(i);
            }
        }
        System.out.println("\nQuotient: ");
        for(int j : QuotientArray){
            if(j != 0) {
                System.out.print(j);
            }
        }
    }

    public static Integer Calculate(Integer[] QuotientArray, Integer[] DivisorArray, Integer Remainder, Integer Size, Integer Base){
        for(int i = 0; i < Size; i++){
            QuotientArray[i] = DivisorArray[i] / 2;
            if(DivisorArray[i] % 2 == 1){
                if(i != Size - 1){
                    DivisorArray[i + 1] += Base;
                } else{
                    Remainder = 1;
                }
            }
        }
        return Remainder;
    }


    public static void NumberAddition(String First, String Second, Integer BaseValue){
        char[] FirstDigits = First.toCharArray(), SecondDigits = Second.toCharArray();  
        Integer Remainder = 0;
        final Integer Size = CheckSize(FirstDigits, SecondDigits);
        Integer[] FirstValues = PopulateNumberArrays(FirstDigits, Size);
        Integer[] SecondValues = PopulateNumberArrays(SecondDigits, Size);
        Integer[] Sum = PopulateAndConvertSum(Size, FirstValues, SecondValues, BaseValue);
        Integer[] Divisor = Arrays.copyOf(Sum, Size);
        Integer[] Quotient = new Integer[Size];
        Remainder = Calculate(Quotient, Divisor, Remainder, Size, BaseValue);
        GenerateResults(Sum, Quotient, BaseValue);
        System.out.println("\nRemainder: " + Remainder);
    }
}
