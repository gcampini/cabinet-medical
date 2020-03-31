package model;

import javafx.beans.property.IntegerProperty;

public class CertificatRepos extends Certificat {
    private IntegerProperty nombreJours;

    public int getNombreJours() {
        return nombreJours.get();
    }

    public IntegerProperty nombreJoursProperty() {
        return nombreJours;
    }

    public void setNombreJours(int nombreJours) {
        this.nombreJours.set(nombreJours);
        //notifyAll();
    }
}
