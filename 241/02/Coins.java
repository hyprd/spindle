package week02;


/**
 *   Determine rolls of a dice and return the result.
 *   @author Ethan Simmonds March  2018
 */
public class Coins{
    /** Initialize the boolean field HEADS as true. */ 
    public static final boolean HEADS = true;
    
    /** Initialize the boolean field TAILS as false. */ 
    public static final boolean TAILS = false;
    
    /**
     *  Initialize the integer field headCount( zero-default assignment).
     */
    public int headCount;
    
    /** Initialize the String field str. */
    public String str = "";
    
    /** Initialize the String field lengthStr. */
    public String lengthStr = "";
    
    /** Initialize the String field runStr. */
    public String runStr = "";
    
    /** Initialize boolean array coins. */
    private boolean[] coins;

    /**
     *  Constructor to set given array to value of coins.
     *  @param coins array of coin tosses
     */
    public Coins(boolean[] coins) {
        this.coins = coins;
    }
    
    /**
     * Returns the run count of a string of coin tosses.
     * @return the runs of the object
     */
    public int countRuns(){
        int runs = 1;
        for (int l = 1; l < coins.length; l++){
            if (coins[l] != coins[l - 1]){
                runs++;
            }
        }
        return runs;
    }

    /**
     *   Set value of String coinStr to given field c.
     *  @param c A string of coin tosses
     */
    public Coins(String c){
        boolean[] elementArray  = new boolean[c.length()];
        char[] array = c.toCharArray();
        for (int u = 0; u < array.length; u++){
            if (array[u] == 'H'){
                elementArray[u] = HEADS;
                           
            } else{
                elementArray[u] = TAILS;
            }
        }
        this.coins = elementArray;
    }

    /**
       Main method execution block.
       @param args Command line arguments in an array of String objects
    */
    public static void main (String[] args){
        boolean[] b = {HEADS, TAILS, HEADS, HEADS, TAILS};
        Coins c = new Coins(b);
        System.out.println(c.countHeads());
        System.out.println(c.toString());
    }
    
    
    /**
     * Construct a Coins object via random coin toss.
     * @param length the length
     */
    public Coins(int length){
        boolean[] array = new boolean[length];
        
        for (int a = 0; a < array.length; a++){
            double x = Math.round(Math.random());
            if (x < 0.5){
                array[a] = HEADS;                
            } else {
                array[a] = TAILS;
            }
        }
        this.coins = array;        
    }


    /**
     *   Count the number of heads present in the coin array iteration.
     *   @return Return the head count of the  array
     */
    public int countHeads(){
        for (int i = 0; i < coins.length; i++){  
            if (coins[i] == HEADS){
                headCount +=1;
            }
        }
        return headCount;
    }
    
    /**
     *  Return a String version of coins array. H as Heads, T as tails.
     *  @return Return a String of coin tosses
     *
     */
    public String toString(){
        for (int i = 0; i < coins.length; i++){
            if (coins[i] == HEADS){
                str = str.concat("H");
            }else{
                str = str.concat("T");
            }
        }
        return str;
    }
}
