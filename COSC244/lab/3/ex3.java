import java.util.Scanner;
public class ex3{
    public static void main(String[] args) {
        new ex3();
    }
    ex3(){
        Scanner scan = new Scanner(System.in);
        while(scan.hasNextLine()){
            System.out.println(scan.nextLine().toUpperCase());
        }
        scan.close();
    }
}