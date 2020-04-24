package sample;


import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import model.Examen;
import model.RDV;
import services.ExamenServices;
import services.RDVServices;

import java.net.URL;
import java.util.ResourceBundle;

public class ExamenController implements Initializable {

    private Examen examen;

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

    public Examen getExamen() {
        return examen;
    }

    public void setExamen(Examen examen) {
        this.examen = examen;
    }

    @FXML
    private TextField ChampType;

    @FXML
    private TextField ChampConsultation;


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        // Faire les initialisations avant affichage ici.
        this.examen = new Examen() ;

        this.getExamen().typeProperty().bindBidirectional(ChampType.textProperty());
        this.getExamen().consultationProperty().bindBidirectional(ChampConsultation.textProperty());
        this.getExamen().heureProperty().bindBidirectional(ChampHeure.textProperty());
    }

    public void save(){
        ExamenServices examenServices = new ExamenServices();
        if(!examenServices.getAllExamen()
                .stream()
                .filter(x -> x.getNom().equals(getRdv().getNom()) && x.getPrenom().equals(getRdv().getPrenom()))
                .findAny()
                .isPresent()) {
            examenServices.saveExamen(this.getExamen());
        }
    }
}
