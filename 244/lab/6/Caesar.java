import java.io.*;
public class Caesar{
    public static void main(String[] args) {
        new Caesar(args);
    }

    Caesar(String[] args){
        try{
            if(args.length < 1) throw new RuntimeException("invalid input");
            int cipher = Integer.parseInt(args[0]);
            InputStream in = System.in;
            OutputStream out = System.out;
            int token = in.read();
            while(token != -1){
                out.write((token + cipher) % 256);
                token = in.read();
            }
            out.close();
            return;
        } catch(Exception e){
            System.out.println("Exception - " + e.getMessage());
            return;
        } 
    }
}
