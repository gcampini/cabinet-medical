package model;

import javafx.beans.property.BooleanProperty;

public class CertificatAptitude extends Certificat {
    private BooleanProperty aptitude;

    public boolean isAptitude() {
        return aptitude.get();
    }

    public BooleanProperty aptitudeProperty() {
        return aptitude;
    }

    public void setAptitude(boolean aptitude) {
        this.aptitude.set(aptitude);
        //notifyAll();
    }
}
