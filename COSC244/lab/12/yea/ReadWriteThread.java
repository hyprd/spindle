import java.io.*;
import java.net.*;
public class ReadWriteThread extends Thread{
    private BufferedReader input;
    private PrintWriter output;
    private String prefix;
    
    public ReadWriteThread(InputStream input, OutputStream output, String prefix){
        this.input = new BufferedReader(new InputStreamReader(input));
        this.output = new PrintWriter(output, true);
        this.prefix = prefix;
    }

    @Override
    public void run(){
        try{
            String line;
            while((line = input.readLine()) != null){
                if (prefix == ""){
                    output.println(line);
                } else{
                    output.println(prefix + "" + line);
                }
            }
        } catch(Exception e){
            e.printStackTrace();
        }
    }
}
