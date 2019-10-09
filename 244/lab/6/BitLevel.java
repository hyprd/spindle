import java.io.*;
import java.util.*;
public class BitLevel{
    public static void main(String[] args) {
        new BitLevel(args);
    }
    BitLevel(String[] args){
        try(
            Scanner scan = new Scanner(System.in);
            FileInputStream fis = new FileInputStream(new File(args[0]));
            FileOutputStream fos = new FileOutputStream(args[1])){
            
            System.out.println("Enter key: ");
            String key = scan.nextLine();
            ArrayList<Integer> keyList = new ArrayList<Integer>();
            for(char ch : key.toCharArray()){
                keyList.add(Character.getNumericValue(ch));
            }
            int i = 0, in = fis.read();
            while(in != -1){
                fos.write(in^keyList.get(i++));
                i %= keyList.size();
                in = fis.read();
            }
        } catch(Exception e){
            System.out.println("Invalid input");
            return;
        } 
    }
}
