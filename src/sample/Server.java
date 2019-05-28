package sample;

import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.effect.Light;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.*;
import java.util.LinkedList;
import java.util.Scanner;

import static sample.Controller.UserNumber;


public class Server {
    public static LinkedList<ServerSomthing> serverList = new LinkedList<ServerSomthing>();
    public ServerSocket server;
    boolean mark = true;
    int Usersss = 0;
    public Server() throws Exception {
        new SendIpAdress();
        server = new ServerSocket();
        Scanner sc = new Scanner(System.in);
        String ip = Inet4Address.getLocalHost().getHostAddress();
        System.out.println(ip);
        server.bind(new InetSocketAddress(ip, 9999));
        try {
            while (mark) {
                Socket socket = server.accept();
                try {
                    serverList.add(new ServerSomthing(socket));
                    Platform.runLater(()->{
                        Usersss++;
                       UserNumber.setText(String.valueOf(Usersss));

                    });
                } catch (IOException e) {
                    socket.close();
                }

            }
        }catch (BindException e) {

        }    finally
         {
            server.close();

        }
    }

}