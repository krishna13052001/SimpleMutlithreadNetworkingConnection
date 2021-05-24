package simple_udp;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;

public class Reciver {
    public Reciver() throws Exception {
        DatagramSocket socket = new DatagramSocket(2021);
        System.out.println("Reciver started running");
        Scanner sc=new Scanner(System.in);
        byte[] buffer=new byte[1500];
        DatagramPacket packet= new DatagramPacket(buffer,buffer.length);
        socket.receive(packet);
        String msg = new String(buffer).trim();
        System.out.println("Recived Msg: "+msg);

        // Now, we are sending the msg
        InetAddress senderAddress = packet.getAddress();
        int portNumber = packet.getPort();
        System.out.println("Enter the msgs: ");
        msg = sc.nextLine();
        buffer = msg.getBytes();
        packet = new DatagramPacket(buffer,buffer.length,senderAddress,portNumber);
        socket.send(packet);
        System.out.println("Sent: "+msg);


    }
    public static void main(String[] args) {
        try{
            new Reciver();
        } catch(Exception e){
            e.printStackTrace();
        }
    }
}
