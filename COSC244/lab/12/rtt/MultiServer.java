import java.io.*;
import java.net.*;
import java.util.*;

public class MultiServer extends Thread{
    private static List<PrintWriter> clients = new LinkedList<PrintWriter>();

    public static void main(String[] args){
        try{
            int port = Integer.parseInt(args[0]);
            ServerSocket serverSocket = new ServerSocket(port);
            System.err.println("Awaiting connections");
            new MultiServer().start();
            while(true){
                Socket socket = serverSocket.accept();
                synchronized(clients){
                    clients.add(new PrintWriter(socket.getOutputStream(), true));
                }
                System.err.println("Connection accepted on port " + port);
                //new ReadWriteThread(System.in, socket.getOutputStream(), "").start();
                new ReadWriteThread(socket.getInputStream(), System.out, "").start();
            }

            
        } catch(Exception e){
            e.printStackTrace();

        }
        
    }
    
    @Override
    public void run(){
        try{
            Scanner scan = new Scanner(System.in);
            while(scan.hasNextLine()){
                String line = scan.nextLine();
                synchronized(clients){
                    for(PrintWriter cl : clients){
                        cl.println(line);
                    }
                }
            }

        }catch(Exception e){
            e.printStackTrace();

        }
        
    }
}
