package simple_tcp;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server  {
    public Server() throws Exception {
        ServerSocket server_socket = new ServerSocket(2021);
        System.out.println("Port 2021 is open");
        Socket socket = server_socket.accept();
        System.out.println("Client IP Address: "+ socket.getInetAddress()+" has connected!!");

//        I/O
        BufferedReader inputSocket = new BufferedReader(new InputStreamReader(socket.getInputStream()));

        PrintWriter outputScoket = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()),true);

        outputScoket.println("Hello, client with ip address" + socket.getInetAddress()+ " now, you are connected to server");
        String msg = inputSocket.readLine();
        System.out.println("Client with ip address "+socket.getInetAddress()+" says "+ msg);

        socket.close();
        System.out.println("Socket is closed!!");

    }
    public static void main(String[] args) {
        try{
            new Server();


        } catch(Exception e){
            System.out.println("Server creation problem");
            e.printStackTrace();
        }
    }
}
