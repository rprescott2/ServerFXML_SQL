package sample;

import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;


public class ServerCommand {
    Thread serverCommand;
    public ServerCommand(String key){
        if(key.equals("quite")){
            try {
                Platform.exit();

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
    }



