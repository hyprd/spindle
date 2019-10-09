public class HouseNumbers{
    public static void main(String[] args) {
        new HouseNumbers();
    }

    HouseNumbers(){
        int houseNumber = 1;
        // Start at 1 since houses themselves don't start at 0
        long k = getK(1);
        long n = getN(1);
        while(n < Integer.MAX_VALUE){
            k = getK(houseNumber);
            n = getN(houseNumber);
            houseNumber++;
            if(k != 1) System.out.println("k: " + k + "\tn: " + n);
        }
    }

    /**
     * Recursively find K.
     * @param num
     * @return values
     */
    long getK(int num){
        if(num == 0) return 0;
        if(num == 1) return 1;
        return 6 * getK(num - 1) - getK(num - 2);
    }

    /**
     * Recursively find N.
     * @param num
     * @return
     */
    long getN(int num){
        if(num == 0) return 0;
        if(num == 1) return 1;
        return 6 * getN(num - 1) - getN(num - 2) + 2;
    }
}