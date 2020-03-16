package model;

import javafx.beans.property.IntegerProperty;

public class CertificatDispense extends Certificat {
    private IntegerProperty periode;

    public int getPeriode() {
        return periode.get();
    }

    public IntegerProperty periodeProperty() {
        return periode;
    }

    public void setPeriode(int periode) {
        this.periode.set(periode);
        notifyAll();
    }
}
