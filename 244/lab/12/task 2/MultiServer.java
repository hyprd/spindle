public class MultiServer extends Thread{

    public static void main(String[] args){
        try{

        int port = Integer.parseInt()args[0];
        ServerSocket serverSocket = new ServerSocket(port);
        System.err.println("Awaiting connections..."):
        new MultiServer().start();
        while(true){
            Socket socket = serverSocket.accept();
            synchronized(clients){
                clients.add(new PrintWriter(socket.getOutputStream(), true));
            }
            System.err.println("Accepted connection on port " + port);
            new ReadWriteThread(System.in, socket.getOutputStream(), "-->");
            new ReadWriteThread(socket.getOutputStream(), System.out, "-->");
        }
        } catch(Exception e){
            e.printStackTrace();

        }
    }

    @Override
    public void run(){
        Scanne scan = new Scanner(System.in);
        while(scan.hasNextLine()){
            String line = scan.nextLine();
            synchronized(clients){
                for(PrintWriter cl : clients){
                    cl.println(line);
                }
            }
        }
    }
}