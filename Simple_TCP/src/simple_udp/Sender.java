package simple_udp;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;

public class Sender {
    public Sender() throws Exception{
        DatagramSocket socket=new DatagramSocket();
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the msg: ");
        String msg =  sc.nextLine();
        byte[] buffer = msg.getBytes();
        DatagramPacket packet = new DatagramPacket(buffer,buffer.length, InetAddress.getByName("localhost"),2021);
        socket.send(packet);
        System.out.println("sent "+msg);

        buffer = new byte[1500];
        packet = new DatagramPacket(buffer,buffer.length);
        socket.receive(packet);

        msg = new String(buffer).trim();
        System.out.println("Recived: "+msg);


    }
    public static void main(String[] args) {
        try{
            new Sender();
        } catch(Exception e){
            e.printStackTrace();
        }
    }
}
