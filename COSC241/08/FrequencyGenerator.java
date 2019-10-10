package week08;

import java.util.*;
import java.io.*;
/**
 * Generate a random word using weighted letter selection.
 * @author Ethan Simmonds
 * @since April 2018
 */

public class FrequencyGenerator implements WordGenerator {
    /** Generate an instance of class Random called random.*/
    private Random random;
    /** Declare the beginning of ascii character set('a'). */
    private static final char ASCII = 97;
    
    /**
     * Basic constructor.
     * @param r an instance of the random class
     */
    public FrequencyGenerator(Random r) {
        random = r;
    }
    /**
     * Generate the next random word.
     * @param n the length
     * @return build.toString() a toString representation of
     * StringBuilder
     */
    
    public String nextWord(int n){
        try{
            Double[] weights = readFile("letter-frequencies.txt");
            StringBuilder build = new StringBuilder();
            for(int a = 0; a < n; a++){
                int k = chooseIndex(weights);
                build.append((char)(k + ASCII));
            }
            return build.toString();
        } catch(FileNotFoundException e){
            return "File not found";
        }
        
    }
    /**
     * Read letter frequencies from an external file
     * into an array within the class.
     * @param name a string containing the name of the file
     * @return an array of weights
     * @throws FileNotFoundException if target file isn't present
     */
    public Double[] readFile(String name) throws FileNotFoundException{
        File f = new File(name);
        Scanner scan = new Scanner(f);
        int s = 0;
        while(scan.hasNextLine()){
            s++;
            scan.nextLine();
        }
        Double[] weights = new Double[s];
        scan = new Scanner(f);
        for(int u = 0; u < s; u++){
            weights[u] = Double.parseDouble(scan.nextLine());
        }
        return weights;
    }
    /**
     * Select the weight to determine letter placement of
     * our final word.
     * @param weights an array of weights
     * @return return the chosen weight
     */
    public int chooseIndex(Double[] weights){
        int u = 0;
        double r = random.nextDouble();
        while(r > weights[u]){
            r = r - weights[u];
            u++;
        }
        return u;
    }
}
