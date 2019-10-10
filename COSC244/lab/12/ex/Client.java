import java.net.*;

public class Client {
    public static void main(String[] args) {
        try{
            int port = Integer.parseInt(args[0]);
            Socket clientSocket = new Socket(args[1], port);
            System.err.println("Connected to " + args[1] + " on port " + port);
            new ReadWriteThread(System.in, clientSocket.getOutputStream(), "-->").start();
            new ReadWriteThread(clientSocket.getInputStream(), System.out, "-->").start();
        } catch(Exception e){
            e.printStackTrace();
            System.err.println("\nUsage: java Client <port>");

        }

    }
}