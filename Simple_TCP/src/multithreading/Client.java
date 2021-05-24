package multithreading;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    public Client() throws Exception{
        Socket socket = new Socket("192.168.56.1",2021);
        System.out.println("Connection successful for client side");
        BufferedReader inputSocket = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        PrintWriter outputScoket = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()),true);

        String msg = inputSocket.readLine();
        System.out.println("Server said: "+msg);
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the msg: ");
        msg = sc.nextLine();
        outputScoket.println(msg);
        socket.close();
        System.out.println("Socket closed from client!");

    }
    public static void main(String[] args) {
        try {
            new simple_tcp.Client();
        } catch (Exception e){
            System.out.println("Something proble from client creation");
            e.printStackTrace();
        }
    }
}
