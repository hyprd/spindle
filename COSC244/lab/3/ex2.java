import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
public class ex2{
    public static void main(String[] args) {
        new ex2();
    }
    ex2(){
        StringBuilder build = new StringBuilder();
        try{ 
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            String line;
            do{
                line = br.readLine();
                build.append(line);
                System.out.println(build.reverse().toString());
                build.setLength(0);
            } while(line != null);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}