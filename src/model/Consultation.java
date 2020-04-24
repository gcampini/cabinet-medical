package model;

import javafx.beans.InvalidationListener;
import javafx.beans.Observable;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.ObservableList;

import java.time.LocalDate;


public class Consultation implements Observable {

   private int id;
   private ObjectProperty<LocalDate> date;
   private StringProperty observations;
   private ObjectProperty<Dossier> dossier;
   private ObservableList<Prescription> prescriptions;
   private ObservableList<Certificat> certificats;
   private ObservableList<Examen> examens;


    public Consultation() {
        this.date = new SimpleObjectProperty<LocalDate>(LocalDate.now());
        this.observations = new SimpleStringProperty("");
        this.dateNaissance = new SimpleObjectProperty<LocalDate>(LocalDate.now());
        this.profession = new SimpleStringProperty("");
        this.adresse = new SimpleStringProperty("");
        this.telephone = new SimpleStringProperty("");
        this.numeroSecuriteSociale = new SimpleStringProperty("");
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


    public LocalDate getDate() {
        return date.get();
    }

    public ObjectProperty<LocalDate> dateProperty() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date.set(date);
        //notifyAll();
    }


    public String getObservations() {
        return observations.get();
    }

    public StringProperty observationsProperty() {
        return observations;
    }

    public void setObservations(String observations) {
        this.observations.set(observations);
        //notifyAll();
    }


    public Dossier getDossier() {
        return dossier.get();
    }

    public ObjectProperty<Dossier> dossierProperty() {
        return dossier;
    }

    public void setDossier(Dossier dossier) {
        this.dossier.set(dossier);
        //notifyAll();
    }

    public ObservableList<Prescription> getPrescriptions() {
        return prescriptions;
    }

    public void setPrescriptions(ObservableList<Prescription> prescriptions) {
        this.prescriptions = prescriptions;
        //notifyAll();
    }

    public ObservableList<Certificat> getCertificats() {
        return certificats;
    }

    public void setCertificats(ObservableList<Certificat> certificats) {
        this.certificats = certificats;
        //notifyAll();
    }

    public ObservableList<Examen> getExamens() {
        return examens;
    }

    public void setExamens(ObservableList<Examen> examens) {
        this.examens = examens;
        //notifyAll();
    }
}
