package sample;

import javafx.fxml.Initializable;
import model.RDV;

import java.net.URL;
import java.util.ResourceBundle;

public class PrescriptionController implements Initializable {

    private Double RowHeight = 100.0;

    private Double ColumnWidth = 100.0;

    private RDV rdv;

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

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        // Faire les initialisations avant affichage ici.
        this.rdv = new RDV() ;
    }

}
