package model;

import javafx.beans.InvalidationListener;
import javafx.beans.Observable;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

import java.time.LocalDate;

public class RDV implements Observable {

    private int id;
    private StringProperty nom;
    private StringProperty prenom;
    private ObjectProperty<LocalDate> date;
    private StringProperty heure;

    public RDV() {
        this.nom = new SimpleStringProperty("");
        this.prenom = new SimpleStringProperty("");
        this.date = new SimpleObjectProperty<>(LocalDate.now());
        this.heure = new SimpleStringProperty("");
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

    public String getNom() {
        return nom.get();
    }

    public StringProperty nomProperty() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom.set(nom);
    }

    public String getPrenom() {
        return prenom.get();
    }

    public StringProperty prenomProperty() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom.set(prenom);
    }

    public LocalDate getDate() {
        return date.get();
    }

    public ObjectProperty<LocalDate> dateProperty() {
        return date;
    }

    public void setDate(LocalDate localdate) {
        this.date.set(localdate);
        //notifyAll();
    }

    public String getHeure() {
        return heure.get();
    }

    public StringProperty heureProperty() {
        return heure;
    }

    public void setHeure(String heure) {
        this.heure.set(heure);
    }
}
