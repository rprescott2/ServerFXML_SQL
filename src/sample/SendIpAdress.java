package sample;

import java.io.IOException;
import java.net.*;


import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;

public class SendIpAdress implements Runnable {

    private DatagramSocket socket2;
    private InetAddress address;
    private byte[] buf;
    private String message = "Hello";
    Thread thread2;
    public SendIpAdress()  {
        thread2 = new Thread(this, "IpAdress5");
        thread2.start();
    }

    @Override
    public void run() {
        try {
            buf = message.getBytes();
            socket2 = new DatagramSocket();
            address = InetAddress.getByName(Inet4Address.getLocalHost().getHostAddress());
            boolean tr = true;
            while (tr) {
                DatagramPacket packet = new DatagramPacket(buf, buf.length, address, 9999);
                socket2.send(packet);
            }
        } catch (SocketException e){

        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
