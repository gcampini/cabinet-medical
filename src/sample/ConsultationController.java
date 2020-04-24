package sample;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import model.Consultation;
import services.RDVServices;

import java.net.URL;
import java.util.ResourceBundle;

public class ConsultationController implements Initializable {

    private Consultation consultation;

    private Double RowHeight = 100.0;

    private Double ColumnWidth = 100.0;

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

    public Consultation getConsultation() {
        return consultation;
    }

    public void setConsultation(Consultation consultaion) {
        this.consultation = consultaion;
    }

    @FXML
    private TextField ChampDate;

    @FXML
    private TextField ChampObservations;

    @FXML
    private DatePicker ChampDossier;

    @FXML
    private TextField ChampPrescription;

    @FXML
    private TextField ChampCertificat;

    @FXML
    private TextField ChampExamen;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        // Faire les initialisations avant affichage ici.
        this.consultation = new Consultation() ;

        this.getConsultation().nomProperty().bindBidirectional(ChampNom.textProperty());
        this.getConsultation().prenomProperty().bindBidirectional(ChampPrenom.textProperty());
        this.getConsultation().dateProperty().bindBidirectional(ChampDate.valueProperty());
        //this.getRdv().heureProperty().bindBidirectional(ChampHeure.textProperty());
    }

    public void save(){
        ConsultationServices consultationServices = new ConsultationServices();
        if(!consultationServices.getAllConsultation()
                .stream()
                .filter(x -> x.getNom().equals(getConsultation().getNom()) && x.getPrenom().equals(getConsultation().getPrenom()))
                .findAny()
                .isPresent()) {
            consultationServices.saveRDV(this.getConsultation());
        }
    }
}
