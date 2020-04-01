package sample;

import javafx.fxml.FXML;
import javafx.scene.control.Label;


public class Controller {
    @FXML
    private Label monLabel;



    public void changeText(){
        monLabel.setText("autre text");
    }
}
