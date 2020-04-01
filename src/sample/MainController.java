package sample;

import javafx.fxml.FXML;
import javafx.scene.control.Label;


public class MainController {
    @FXML
    private Label monLabel;



    public void changeText(){
        monLabel.setText("autre text");
    }
}
