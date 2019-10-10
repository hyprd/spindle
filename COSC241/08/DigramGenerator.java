package week08;

import java.util.*;
import java.io.*;
/**
 * Generate digrams.
 * @author Ethan Simmonds
 * @since April 2018
 */

public class DigramGenerator implements WordGenerator {
    /** An instance of Random. */
    private Random random;
    /** ASCII declaration for beginning of lowercase alphabet.*/
    private static final char ASCII = 97;
    /** Length of the English alphabet. */
    private static final int ALPHABET = 26;
    
    /**
     * Basic constructor.
     * @param r an instance of Random
     */

    public DigramGenerator(Random r) {
        random = r;
    }
    /**
     * Determine the strong to be returned.
     * @return toString representation of the StringBuilder object
     * @param n the length of the word
     */
                
    public String nextWord(int n) {
        try{
            
            String[][] table = generate("continuations.txt");
            File firstFile = new File("first-letters.txt");
            Scanner scan = new Scanner(firstFile);
            StringBuilder build = new StringBuilder();
            //first line
            String first = scan.nextLine();
            scan.close();
            //next int of length first
            int index = random.nextInt(first.length());          
            char letter = first.charAt(index);
            build.append(letter);
            
            for(int a = 0; a < n - 1; a++){
                //first element - subtract ascii from cast int letter
                //second element - first column length
                index = random.nextInt
                    (table[(int) letter - ASCII][1].length());
                // first element - subtract ascii from cast int letter
                // second element - charat index referenced above
                letter = table[(int) letter - ASCII][1].charAt(index);
                build.append(letter);        
            }
            return build.toString();           
        }catch(FileNotFoundException e){
            return "File not found";

        }
    }
    /**
     * Process the table array with elements.
     * @param f name of the file
     * @return a 2D array str
     * @throws FileNotFoundException file not found
     */
    public String[][] generate(String f)
        throws FileNotFoundException{
        String[][] str = new String[ALPHABET][2];
        char c = 0;
        int u = 0;
        File generateFile = new File(f);
        Scanner scan = new Scanner(generateFile);
        while(scan.hasNextLine()){
            c = (char)(u + ASCII);
            str[u][0] = String.valueOf(c);
            str[u][1] = scan.nextLine();
            u++;      
        }
        scan.close();
        
               
        return str;
    }    
}
