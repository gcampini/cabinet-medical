package sample;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import model.RDV;
import services.RDVServices;

import java.net.URL;
import java.util.ResourceBundle;

public class DossierController implements Initializable {

    private RDV rdv;

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

    public RDV getRdv() {
        return rdv;
    }

    public void setRdv(RDV rdv) {
        this.rdv = rdv;
    }

    @FXML
    private TextField ChampNom;

    @FXML
    private TextField ChampPrenom;

    @FXML
    private DatePicker ChampDate;

    @FXML
    private TextField ChampHeure;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        // Faire les initialisations avant affichage ici.
        this.rdv = new RDV() ;

        this.getRdv().nomProperty().bindBidirectional(ChampNom.textProperty());
        this.getRdv().prenomProperty().bindBidirectional(ChampPrenom.textProperty());
        this.getRdv().dateProperty().bindBidirectional(ChampDate.valueProperty());
        //this.getRdv().heureProperty().bindBidirectional(ChampHeure.textProperty());
    }

    public void save(){
        RDVServices rdvServices = new RDVServices();
        if(!rdvServices.getAllRDV()
                .stream()
                .filter(x -> x.getNom().equals(getRdv().getNom()) && x.getPrenom().equals(getRdv().getPrenom()))
                .findAny()
                .isPresent()) {
            rdvServices.saveRDV(this.getRdv());
        }
    }
}
