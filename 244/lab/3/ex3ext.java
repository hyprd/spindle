import java.util.Scanner;
public class ex3ext{
    public static void main(String[] args) {
        new ex3ext();
    }
    ex3ext(){
        Scanner scan = new Scanner(System.in);
        while(scan.hasNextLine()){
            String s = scan.nextLine();
            Scanner scanWhitespace = new Scanner(s);
            while(scanWhitespace.hasNext()){
                String word = scanWhitespace.next();
                if(word.length() == 4){
                    System.out.println("****");
                } else{
                    System.out.println(word);
                }
            }
            System.out.println();
            scanWhitespace.close();
        }
        scan.close();  
    }
}