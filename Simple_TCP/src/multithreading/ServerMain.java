package multithreading;

import java.net.ServerSocket;
import java.net.Socket;

public class ServerMain {
    public ServerMain() throws Exception{
        ServerSocket server_socket = new ServerSocket(2021);
        System.out.println("port 2021 is open");
        while(true){
            Socket socket = server_socket.accept();
            ServerThread server_thread = new ServerThread(socket);
            Thread thread = new Thread(server_thread);
            thread.start();
        }
    }
    public static void main(String[] args) {
        try{
            new ServerMain();
        } catch (Exception e){
            System.out.println("Some thing went wrong with the creation of server main");
            e.printStackTrace();
        }
    }
}
