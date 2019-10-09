import java.util.stream.*;
import java.util.*;
public class etude10{
    private ArrayList<Integer> ValuesList = new ArrayList<Integer>();
    private Integer ExpectedOutput = 0;
    private Character SearchType;
    private Scanner sc = new Scanner(System.in);
    public static void main (String[] args){ new etude10(); }
    public etude10(){
        FetchInput();
    }
    /**
     * Evaluate and determine search type given user input. 
     * @param Numbers numbers to perform arithmetic on
     */
    private void Evaluate(ArrayList<Integer> Numbers){
        /* 
         * If the minimum possible value (summing all values) from value input
         * is greater than our expected output value then there is no way 
         * we will find a series of operations to reach the answer. 
         * Therefore we throw an exception before any arithmetic is attempted.
         */
        int[] SumArray = new int[Numbers.size()];   
        try{
            for(int i = 0; i < SumArray.length; i++){
                SumArray[i] = Numbers.get(i);
            }
        } catch(NullPointerException e){
            System.out.print("\n" + SearchType + " " + ExpectedOutput + " impossible");
        }
        Integer MinimumPossibleValue = IntStream.of(SumArray).sum();
        if(MinimumPossibleValue <= ExpectedOutput){
            ArrayList<Integer> Copy = new ArrayList<Integer>(Numbers);
            /* 
             * Determines which order of operations to follow, given
             * by users input. Default
             */
            switch(SearchType){
                case 'L':
                    SequentialSolve(Numbers, Copy);  
                    break;              
                case 'N':
                    PrioritySolve(Numbers, Copy);
                    break;
                default:
                System.out.print("\n" + SearchType + " " + ExpectedOutput + " impossible");
            }      
        } else{
            System.out.print("\n" + SearchType + " " + ExpectedOutput + " impossible");
        }
    }
    /**
     * Solve the problem using in-order operations.
     * @param Numbers numbers to perform arithmetic on
     * @param Copy a copy of numbers to perform arithmetic on
     */
    private void SequentialSolve(ArrayList<Integer> Numbers, ArrayList<Integer> Copy){
        Integer NumbersSize = Numbers.size() - 1;
        Boolean First = true;
        Integer SymbolCount = 0;
        Integer Sum = 0;
        /*
         * If only one number is given by the user, there is no ned to perform 
         * arithmetic at all. Therefore we return the value and exit.
         */
        if(Numbers.size() == 1) {
            System.out.println("L " + Numbers.get(0));
            return;
        }
        /* 
         * To find the correct set of values, we iterate over every possible 
         * combination of operators using binary strings until we find the 
         * correct answer. These strings act as placeholders for the operators
         * until they are replaced with addition and multiplication characters. 
         * Once binary strings have been translated into characters, we evaluate 
         * the string with values inserted in between them. 
         * 
         * If the string we are evaluating returns the expected output, then
         * that is our series of operators needed. Return that series as the 
         * answer.
         */
        for(int i = 0; i < Math.pow(2 , NumbersSize); i++){
            String BinarySequence = Integer.toBinaryString(i);
            /*
             * Populate the string with as many operators as we need for the length 
             * of the user input.
             */
            while(BinarySequence.length() < NumbersSize){
                BinarySequence = "0" + BinarySequence;
            }
            /* 
             * Replace string sequence with operators (0 -> add, 1 -> multiply).
             */
            String ReplaceBinaryZeroes = BinarySequence.replace('0', '+');
            String ReplaceBinaryOnes = ReplaceBinaryZeroes.replace('1','*');
            char[] Symbols = ReplaceBinaryOnes.toCharArray();
            /* 
             * Iterate each symbol. Add or multiply the sum by the number
             * at the start of the list. Remove the number to perform 
             * arithmetic on the next number in line.
             */
            for(Character ch : Symbols){
                SymbolCount++;
                if(First){
                    Sum = Numbers.get(0);
                    Numbers.remove(0);
                }
                switch(ch){
                    case '+':
                        Sum += Numbers.get(0);
                        break;
                    case '*':
                        Sum *= Numbers.get(0);
                        break;
                }
            Numbers.remove(0);
            First = false;
            /* 
             * If we have reached the end of the string sequence and found our expected
             * value, print out each character and operator in order and exit.
             * 
             * If we have reached he end of the sequence and not found the expected value
             * given our operation, using the copied ArrayList of numbers from the beginning
             * repopulate the Numbers ArrayList (which was empty from performing the arithmetic)
             * and try again, repeating until we find the correct set of operations or deeming
             * it impossible given our input.
             */
            Boolean EndOfSequence = (SymbolCount.equals(NumbersSize)) ? true : false;
            Boolean FoundExpectedValue = (Sum.equals(ExpectedOutput)) ? true : false;
            if(EndOfSequence && FoundExpectedValue){
                Integer SymbolToPrint = 0;
                System.out.print("\nL " + ExpectedOutput + " ");
                for(int k = 0; k < Copy.size(); k++){
                    System.out.print(Copy.get(k) + " ");
                    if(SymbolToPrint.equals(NumbersSize)) break;
                    System.out.print(Symbols[SymbolToPrint] + " ");
                    SymbolToPrint++;
                }
                return;
                } if(EndOfSequence && !FoundExpectedValue){
                    First = true;
                    Sum = 0;
                    SymbolCount = 0;
                    for(int p = 0; p < Copy.size(); p++){
                        Numbers.add(p, Copy.get(p));
                    }
                }
            }
        }
        System.out.print("\n" + SearchType + " " + ExpectedOutput + " impossible");
    }
    /**
     * Solve the problem using BEDMAS operations.
     * @param Numbers numbers to perform arithmetic on
     * @param Copy a copy of numbers to perform arithmetic on
     */
    private void PrioritySolve(ArrayList<Integer> Numbers, ArrayList<Integer> Copy){
        Integer Sum = 0;
        Integer NumbersSize = Numbers.size() - 1;
        /*
         * If only one number is given by the user, there is no ned to perform 
         * arithmetic at all. Therefore we return the value and exit.
         */
        if(Numbers.size() == 1) {
            System.out.println("N " + Numbers.get(0));
            return;
        }
        /* 
         * To find the correct set of values, we iterate over every possible 
         * combination of operators using binary strings until we find the 
         * correct answer. These strings act as placeholders for the operators
         * until they are replaced with addition and multiplication characters. 
         * Once binary strings have been translated into characters, we evaluate 
         * the string with values inserted in between them. 
         * 
         * If the string we are evaluating returns the expected output, then
         * that is our series of operators needed. Return that series as the 
         * answer.
         */
        for(int i = 0; i < Math.pow(2, NumbersSize); i++){
            String BinarySequence = Integer.toBinaryString(i);
            /*
             * Populate the string with as many operators as we need for the length 
             * of the user input.
             */
            while(BinarySequence.length() < NumbersSize){
                BinarySequence = "0" + BinarySequence;
            }
            /* 
             * Replace string sequence with operators (0 -> add, 1 -> multiply).
             */
            String ReplaceBinaryZeroes = BinarySequence.replace('0', '+');
            String ReplaceBinaryOnes = ReplaceBinaryZeroes.replace('1','*');
            char[] Symbols = ReplaceBinaryOnes.toCharArray();
            /* 
             * Append each symbol to a string sequence.
             */
            String ConvertArrayToList = "";
            for(Character ch: Symbols){
                ConvertArrayToList += ch;
            }
            /*
             * Convert a character array to List<Character>, then cast that List<Character> to ArrayList<Character>,
             * then make a copy for printing purposes at the end.
             */ 
            ArrayList<Character> SymbolList = new ArrayList<Character>(ConvertArrayToList.chars().mapToObj(c -> (char) c).collect(Collectors.toList()));
            ArrayList<Character> SymbolCopy = new ArrayList<Character>(SymbolList); 
            /* 
             * Since operations are performed out of order, we perform multiplication and addition seperately.
             * By performing all multiplication operations first, all that is needed afterwards is to add all 
             * these multiplied numbers together. 
             * 
             * This cannot be done if we are calculating the sum in sequential order because the output of 
             * the current evaluation between two numbers depends on the previous output. BEDMAS operations 
             * don't suffer from this issue.
             */
            for(int u = 0; u < SymbolList.size(); u++){
                switch(SymbolList.get(u)){
                    case '*':
                        Integer Multiplication = Numbers.get(u) * Numbers.get(u + 1);
                        Numbers.remove(u);
                        Numbers.remove(u);
                        Numbers.add(u, Multiplication);
                        SymbolList.remove(u);
                        u--;
                        break;
                    case '+':
                        break;
                }
            }
            Sum = 0;
            /* 
             * Performs the addition part of the operations.
             */
            for(Integer val : Numbers){
                Sum += val;
            }
            /* 
             * If we have found our expected value, print out each character and operator 
             * in order and exit.
             * 
             * If we have not found the expected value given our operation, using the copied 
             * ArrayList of numbers from the beginning we repopulate the Numbers ArrayList 
             * (which was empty from performing the arithmetic)  and try again, repeating until
             *  we find the correct set of operations or deeming it impossible given our input.
             */
            Boolean FoundExpectedValue = (Sum.equals(ExpectedOutput)) ? true : false;
            if(!FoundExpectedValue){
                Numbers.clear();
                for(int k = 0; k < Copy.size(); k++){
                    Numbers.add(Copy.get(k));
                }
            }
            if(FoundExpectedValue){         
                Integer SymbolToPrint = 0;               
                System.out.print("\nN " + ExpectedOutput + " ");
                for(int e = 0; e < Copy.size(); e++){
                    System.out.print(Copy.get(e) + " ");
                    Boolean EndOfSequence = (SymbolToPrint.equals(NumbersSize)) ? true : false;
                    if(EndOfSequence) break;
                    System.out.print(SymbolCopy.get(SymbolToPrint) + " ");
                    SymbolToPrint++;
                }            
                return;
            }
        }
        System.out.print("\n" + SearchType + " " + ExpectedOutput + " impossible");
    }

    /**
     * Retrieve input from the user and dissect into values and params lists.
     */
    private void FetchInput(){
        try{
            ArrayList<String> ValuesListString = new ArrayList<String>();
            ArrayList<String> ParamsList = new ArrayList<String>();
            /* 
             * Get input until there is none left from the user/
            */
            while(sc.hasNextLine()){
                ValuesListString.add(sc.nextLine());
                ParamsList.add(sc.nextLine());
            }
            for(int i = 0; i < ParamsList.size();  i++){
                ValuesList.clear();
                ExpectedOutput = null;
                SearchType = null;
                String[] SplitValues = ValuesListString.get(i).split("\\s");
                String[] SplitParams = ParamsList.get(i).split("\\s");
                ExpectedOutput = Integer.parseInt(SplitParams[0]);
                SearchType = SplitParams[1].charAt(0);
                for(String str : SplitValues){
                    ValuesList.add(Integer.parseInt(str));
                    }
                Evaluate(ValuesList);
                } 
            System.out.println();
            } catch(NoSuchElementException e){
                System.out.print("\n" + SearchType + " " + ExpectedOutput + " impossible");
                FetchInput();
            } catch(ArrayIndexOutOfBoundsException e){
                System.out.print("\n" + SearchType + " " + ExpectedOutput + " impossible");
                FetchInput();
            } catch(NumberFormatException e){
                System.out.print("\n" + SearchType + " " + ExpectedOutput + " impossible");
                FetchInput();
        }
    }
}