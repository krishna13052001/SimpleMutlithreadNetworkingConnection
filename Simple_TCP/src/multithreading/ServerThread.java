package multithreading;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;

public class ServerThread implements Runnable{

    private Socket socket;
    public ServerThread(Socket socket){
        this.socket=socket;
    }


    @Override
    public void run() {
        try{
            System.out.println("New client has been connected.");
            BufferedReader inputSocket = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter outputScoket = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()),true);
            outputScoket.println("Welcome, what is your name!");
            String msg = inputSocket.readLine();
            System.out.println("Client says "+ msg);
            socket.close();
            System.out.println("Client with name "+msg+" Socket has been closed!!");
        } catch(Exception e){
            System.out.println("Something went wrong in run method of the ServerThread class!!");
            e.printStackTrace();
        }
    }
}
