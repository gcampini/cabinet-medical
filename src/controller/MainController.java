package controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.layout.FlowPane;
import javafx.scene.text.Text;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class MainController  implements Initializable {

    @FXML
    public FlowPane mainContainer;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        Text text = new Text("Bienvenue dans l'application de gestion de cabinet.");
        mainContainer.getChildren().add(text);
    }

    @FXML
    public void goToRDV() throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/sample/rdv.fxml"));
        mainContainer.getChildren().setAll(root);
    }

    @FXML
    public void goToPatient() throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/sample/patient.fxml"));
        mainContainer.getChildren().setAll(root);
    }


}