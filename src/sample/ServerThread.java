package sample;

import javafx.application.Platform;

public class ServerThread implements Runnable{
     Thread ThreadServer;
    public ServerThread(){
        ThreadServer = new Thread( this,"ThreadServer");
        ThreadServer.start();
    }

    @Override
    public void run(){
        try {
            new Server();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
