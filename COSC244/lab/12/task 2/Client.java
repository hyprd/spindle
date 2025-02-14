import java.net.*;

public class Client {
    try{
        int port = Integer.parseInt(args[0]);
        Socket clientSocket = new Socket(args[1], port);
        System.err.println("Connected to " + args[1] + " on port" + port);
        new ReadWriteThread(System.in, socket.getOutputStream(), "-->").start();
        new ReadWriteThread(socket.getInputStream(), System.out, "-->").start();
    } catch(Exception e){
        e.printStackTrace();
        System.err.println("\nUsage: java Client <port>");
    }
}