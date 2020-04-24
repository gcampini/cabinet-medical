package model;

import javafx.beans.InvalidationListener;
import javafx.beans.Observable;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;


public class Prescription implements Observable {

    private int id;
    private StringProperty nomMedicament;
    private StringProperty posologie;
    private StringProperty dureeTraitement;
    private ObjectProperty<Consultation> consultation;


    public Prescription() {
        this.nomMedicament = new SimpleStringProperty("");
        this.posologie = new SimpleStringProperty("");
        this.dureeTraitement = new SimpleStringProperty("");
        this.consultation = null;
    }

    @Override
    public void addListener(InvalidationListener invalidationListener) {

    }

    @Override
    public void removeListener(InvalidationListener invalidationListener) {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
        //notifyAll();
    }

    public String getNomMedicament() {
        return nomMedicament.get();
    }

    public StringProperty nomMedicamentProperty() {
        return nomMedicament;
    }

    public void setNomMedicament(String nomMedicament) {
        this.nomMedicament.set(nomMedicament);
        //notifyAll();
    }

    public String getPosologie() {
        return posologie.get();
    }

    public StringProperty posologieProperty() {
        return posologie;
    }

    public void setPosologie(String posologie) {
        this.posologie.set(posologie);
        //notifyAll();
    }

    public String getDureeTraitement() {
        return dureeTraitement.get();
    }

    public StringProperty dureeTraitementProperty() {
        return dureeTraitement;
    }

    public void setDureeTraitement(String dureeTraitement) {
        this.dureeTraitement.set(dureeTraitement);
        //notifyAll();
    }

    public Consultation getConsultation() {
        return consultation.get();
    }

    public ObjectProperty<Consultation> consultationProperty() {
        return consultation;
    }

    public void setConsultation(Consultation consultation) {
        this.consultation.set(consultation);
        //notifyAll();
    }
}
