package sample;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import model.Patient;
import services.PatientServices;

import java.net.URL;
import java.util.ResourceBundle;

public class PatientController implements Initializable {

    private Double RowHeight = 100.0;

    private Double ColumnWidth = 100.0;

    private Patient patient;

    public Patient getPatient() {
        return patient;
    }

    public Double getRowHeight() {
        return RowHeight;
    }

    public Double getColumnWidth() {
        return ColumnWidth;
    }

    public void setRowHeight(Double rowHeight) {
        RowHeight = rowHeight;
    }

    public void setColumnWidth(Double columnWidth) {
        ColumnWidth = columnWidth;
    }

    @FXML
    private TextField ChampNom;

    @FXML
    private TextField ChampPrenom;

    @FXML
    private DatePicker ChampDateNaissance;

    @FXML
    private TextField ChampProfession;

    @FXML
    private TextField ChampAdresse;

    @FXML
    private TextField ChampTelephone;

    @FXML
    private TextField ChampNumeroSecuriteSociale;


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        // Faire les initialisations avant affichage ici.
        this.patient = new Patient();

        this.getPatient().nomProperty().bindBidirectional(ChampNom.textProperty());
        this.getPatient().prenomProperty().bindBidirectional(ChampPrenom.textProperty());
        this.getPatient().dateNaissanceProperty().bindBidirectional(ChampDateNaissance.valueProperty());
        this.getPatient().professionProperty().bindBidirectional(ChampProfession.textProperty());
        this.getPatient().adresseProperty().bindBidirectional(ChampAdresse.textProperty());
        this.getPatient().telephoneProperty().bindBidirectional(ChampTelephone.textProperty());
        this.getPatient().numeroSecuriteSocialeProperty().bindBidirectional(ChampNumeroSecuriteSociale.textProperty());
    }

    public void save(){
        PatientServices patientServices = new PatientServices();
        if(!patientServices.getAllPatient()
                .stream()
                .filter(x -> x.getNom().equals(getPatient().getNom()) && x.getPrenom().equals(getPatient().getPrenom()))
                .findAny()
                .isPresent()) {
            patientServices.savePatient(this.getPatient());
        }
    }
}
