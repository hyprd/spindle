public class Server {
    public static void main(String[] args){
        try{
            int port = Integer.parseInt(args[0]);
            ServerSocket serverSocket = new ServerSocket(port);
            System.err.println("Awaiting connections...");
            Socket socket - new serverSocket.accept();
            System.err.println("Accepted connection on port" + port);
            new ReadWriteThread(System.in, socket.getOutputStream(), "");
            new ReadWriteThread(socket.getInputStream(), System.out, "");
        } catch(Exception e){
            e.printStackTrace();
            System.err.println("\nUsage: java Server <port>");
        }
    }
}