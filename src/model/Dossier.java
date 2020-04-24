package model;

import javafx.beans.InvalidationListener;
import javafx.beans.Observable;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.ObservableList;

public class Dossier implements Observable {

    private int id;
    private BooleanProperty validitePatient;
    private StringProperty cin;
    private ObjectProperty<Patient> patient;

    public Dossier() {
        this.validitePatient = new BooleanProperty("");
        this.cin = new SimpleStringProperty("");
        this.patient = new ObservableList<Consultation>(Patient);
    }

    private ObservableList<Consultation> consultations;


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

    public boolean isValiditePatient() {
        return validitePatient.get();
    }

    public BooleanProperty validitePatientProperty() {
        return validitePatient;
    }

    public void setValiditePatient(boolean validitePatient) {
        this.validitePatient.set(validitePatient);
        //notifyAll();
    }

    public String getCin() {
        return cin.get();
    }

    public StringProperty cinProperty() {
        return cin;
    }

    public void setCin(String cin) {
        this.cin.set(cin);
        //notifyAll();
    }

    public Patient getPatient() {
        return patient.get();
    }

    public ObjectProperty<Patient> patientProperty() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient.set(patient);
        //notifyAll();
    }

    public ObservableList<Consultation> getConsultations() {
        return consultations;
    }

    public void setConsultations(ObservableList<Consultation> consultations) {
        this.consultations = consultations;
        //notifyAll();
    }
}
