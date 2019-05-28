package sample;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

public class Controller {

public void helpAc(){
    Platform.runLater(() -> {
        LastUsers.setText("       Вот команды, которые вам нужны" + "\n" + "quite - чтобы закрыть сервер" + "\n" + "для отправки команды нажмите Enter");
    });
}
    @FXML
    public static Label UserNumber;

    @FXML
    public TextField CommandEntry;
@FXML
void CommandEntryActivity(KeyEvent event){
    if(event.getCode() == KeyCode.ENTER){
        new ServerCommand(CommandEntry.getText().toLowerCase());
        CommandEntry.setText("");

    }
}
    @FXML
    public Label LastUsers;

    @FXML
    void initialize() {
        new ServerThread();
        helpAc();
    }
}
