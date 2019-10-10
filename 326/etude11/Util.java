import java.util.*;

public class Util {
    public static String sanitise(String n, int base) {
        int idx = 0;
        
        if (n.length() > 0 && n.charAt(0) == '-') idx++;
        if (base > 1) {
            if (idx > 0 && n.length() == 1 || n.length() == 0) return null;
            for (; idx < n.length(); idx++) {
                try {
                    Integer.parseInt(Character.toString(n.charAt(idx)), base);
                } catch (NumberFormatException e) {
                    return null;
                }
            }
        } else {
            for (; idx < n.length(); idx++) {
                if (n.charAt(idx) != '1') return null;
            }
        }
        
        return n;
    }
    
    public static int[] strToArr(String s) {
        int sidx = 0;
        int size = s.length();
        if (size > 0 && s.charAt(0) == '-') {
            sidx++;
            size--;
        }
        
        for (; sidx < s.length() - 1; sidx++) {
            if (s.charAt(sidx) != '0') break;
            size--;
        }
        
        int[] res = new int[size];
        int ridx = 0;
        
        for (; sidx < s.length(); sidx++) {
            res[ridx++] = Integer.parseInt(Character.toString(s.charAt(sidx)));
        }
        
        return res;
    }
    
    // Source: https://www.geeksforgeeks.org/reverse-an-array-in-java/
    public static int[] reverse(int[] arr) {
        int idx, tmp; 
        for (idx = 0; idx < arr.length / 2; idx++) { 
            tmp = arr[idx]; 
            arr[idx] = arr[arr.length - idx - 1]; 
            arr[arr.length - idx - 1] = tmp; 
        }
        
        return arr;
    }
    
    public static void printArray(int[] arr, boolean p) {
        if (!p) System.out.print("-");
        
        for (int d : arr) {
            System.out.print(Integer.toString(d));
        }
        System.out.println();
    }
    
    public static int magnitude(int[] n1, int[] n2) {
        if (n1.length > n2.length) return 1;
        if (n2.length > n1.length) return -1;
        
        for (int idx = 0; idx < n1.length; idx++) {
            if (n1[idx] > n2[idx]) return 1;
            if (n2[idx] > n1[idx]) return -1;
        }
        
        return 0;
    }
    
    public static int[] add(int[] n1, int[] n2, int base) {
        String res = "";
        
        if (base == 1) {
            for (int idx = 0; idx < n1.length; idx++) {
                res += "1";
            }
            for (int idx = 0; idx < n2.length; idx++) {
                res += "1";
            }
            
            return strToArr(res);
        }
        
        n1 = reverse(n1);
        n2 = reverse(n2);
        
        int carry = 0;
        for (int idx = 0; idx < n2.length; idx++) {
            int sum = n2[idx] + n1[idx] + carry;
            if (sum >= base) carry = 1;
            else carry = 0;
            res += Character.forDigit(sum % base, base);
        }
        
        for (int idx = n2.length; idx < n1.length; idx++) {
            int sum = n1[idx] + carry;
            if (sum >= base) carry = 1;
            else carry = 0;
            res += Character.forDigit(sum % base, base);
        }
        
        if (carry > 0) res += (char)(carry + '0');
        
        res = new StringBuilder(res).reverse().toString();
        return strToArr(res);
    }
    
    public static int[] difference(int[] n1, int[] n2, int base) {
        String res = "";
        
        if (base == 1) {
            for (int iter = 0; iter < (n1.length - n2.length); iter++) {
                res += "1";
            }
            
            return strToArr(res);
        }
        
        n1 = reverse(n1);
        n2 = reverse(n2);
        
        int carry = 0;
        for (int idx = 0; idx < n2.length; idx++) {
            int diff = n1[idx] - n2[idx] - carry;
            if (diff < 0) {
                diff += base;
                carry = 1;
            }
            else carry = 0;
            res += Character.forDigit(diff, base);
        }
        
        for (int idx = n2.length; idx < n1.length; idx++) {
            int diff = n1[idx] - carry;
            if (diff < 0) {
                diff += base;
                carry = 1;
            }
            else carry = 0;
            res += Character.forDigit(diff, base);
        }
        
        res = new StringBuilder(res).reverse().toString();
        int idx = 0;
        while (idx < res.length() && res.charAt(idx) == '0') idx++;
        res = res.substring(idx);
        if (res.length() == 0) res = "0";
        return strToArr(res);
    }
    
    public static void divide(int[] n, int base, boolean p) {
        String res = "";
        
        if (base == 1) {
            for (int iter = 0; iter < n.length / 2; iter++) {
                res += "1";
            }
            System.out.println("Quotient: " + (!p && res.length() > 0 ? "-" : "") + res);
            System.out.println("Remainder: " + (n.length % 2 == 0 ? "" : "1"));
            return;
        }
        
        int remainder = 0;
        for (int idx = 0; idx < n.length; idx++) {
            res += n[idx] / 2;
            if (n[idx] % 2 == 1) {
                if (idx < n.length - 1) n[idx + 1] += base;
                else remainder = 1;
            }
        }
        
        int idx = 0;
        while (idx < res.length() && res.charAt(idx) == '0') idx++;
        res = res.substring(idx);
        if (res.length() == 0) res = "0";
        
        System.out.println("Quotient: " + (!p && res.length() > 0 && res.charAt(0) != '0' ? "-" : "") + res);
        System.out.println("Remainder: " + remainder);
    }
}
