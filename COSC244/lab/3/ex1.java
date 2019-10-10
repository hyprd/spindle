import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
public class ex1{
    public static void main(String[] args) {
        new ex1();
    }
    ex1(){
        InputStream in = System.in;
        OutputStream out = System.out;
        try{
            int b;
            while((b = in.read()) != -1){
                out.write(b);
            }
            
            //System.out.println(b);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
