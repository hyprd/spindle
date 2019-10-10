import java.util.*;

public class Addition {
    private static final int BASEERR = -1;
    
    public static void main(String[] args) {
        Scanner kbd = new Scanner(System.in);
        int base;
        String ns1, ns2;
        int[] n1, n2, sum;
        boolean n1p, n2p, sump;
        
        try {
            while (true) {
                // MAIN LOOP ---------------------------------------------------
                do {
                    System.out.println("What base are the numbers in?");
                    try {
                        base = Integer.parseInt(kbd.nextLine(), 10);
                    } catch (NumberFormatException e) {
                        base = BASEERR;
                    }
                    if (base < 1 || base > 10) System.out.println("Invalid base.");
                } while (base < 1 || base > 10);
                
                do {
                    System.out.println("Enter the first number:");
                    ns1 = kbd.nextLine();
                    if (null == (ns1 = Util.sanitise(ns1, base))) System.out.println("Invalid number.");
                } while (null == ns1);
                
                do {
                    System.out.println("Enter the second number:");
                    ns2 = kbd.nextLine();
                    if (null == (ns2 = Util.sanitise(ns2, base))) System.out.println("Invalid number.");
                } while (null == ns2);
                System.out.println();
                
                n1 = Util.strToArr(ns1);
                if (ns1.length() > 0) n1p = ns1.charAt(0) == '-' ? false : true;
                else n1p = true;
                n2 = Util.strToArr(ns2);
                if (ns2.length() > 0) n2p = ns2.charAt(0) == '-' ? false : true;
                else n2p = true;

                if (Util.magnitude(n1, n2) < 0) {
                    int[] tmpn = n1;
                    boolean tmpnp = n1p;
                    
                    n1 = n2;
                    n1p = n2p;
                    
                    n2 = tmpn;
                    n2p = tmpnp;
                }
                
                if ((n1p && n2p) || (!n1p && !n2p)) sum = Util.add(n1, n2, base);
                else sum = Util.difference(n1, n2, base);
                if (n1p) sump = true;
                else sump = false;

                if (base == 1) {
                     if (sum.length == 0 && sump == false) sump = true;
                } else if (sum[0] == 0 && sump == false) {
                    sump = true;
                }
                System.out.print(base == 1 ? "Tally: " : "Sum: ");
                Util.printArray(sum, sump);
                Util.divide(sum, base, sump);
                System.out.println();
                // MAIN LOOP ENDS ----------------------------------------------
            }
        } catch (Exception e) {
            //e.printStackTrace();
            // Keyboard interrupt
        } finally {
            kbd.close();
        }
    }
}
