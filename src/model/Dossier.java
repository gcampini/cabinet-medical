package model;

import javafx.beans.InvalidationListener;
import javafx.beans.Observable;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.ObservableList;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
public class Dossier implements Observable {

    private int id;
    private BooleanProperty validitePatient;
    private StringProperty cin;
    private ObjectProperty<Patient> patient;
    private ObservableList<Consultation> consultations;


    @Override
    public void addListener(InvalidationListener invalidationListener) {

    }

    @Override
    public void removeListener(InvalidationListener invalidationListener) {

    }

    @Id
    @GeneratedValue(generator="increment")
    @GenericGenerator(name="increment", strategy = "increment")
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

    @Basic
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

    @Transient
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

    @OneToMany
    public ObservableList<Consultation> getConsultations() {
        return consultations;
    }

    public void setConsultations(ObservableList<Consultation> consultations) {
        this.consultations = consultations;
        //notifyAll();
    }
}
