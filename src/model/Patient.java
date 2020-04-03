package model;

import javafx.beans.InvalidationListener;
import javafx.beans.Observable;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

import java.time.LocalDate;

public class Patient implements Observable {

    private int id;
    private StringProperty nom;
    private StringProperty prenom;
    private ObjectProperty<LocalDate> dateNaissance;
    private StringProperty profession;
    private StringProperty adresse;
    private StringProperty telephone;
    private StringProperty numeroSecuriteSociale;

    public Patient() {
        this.nom = new SimpleStringProperty("");
        this.prenom = new SimpleStringProperty("");
        this.dateNaissance = new SimpleObjectProperty<LocalDate>(LocalDate.now());
        this.profession = new SimpleStringProperty("");
        this.adresse = new SimpleStringProperty("");
        this.telephone = new SimpleStringProperty("");
        this.numeroSecuriteSociale = new SimpleStringProperty("");

    }

    private ObjectProperty<Dossier> dossier;

    @Override
    public void addListener(InvalidationListener invalidationListener) {
        return;
    }

    @Override
    public void removeListener(InvalidationListener invalidationListener) {
        return;
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
        //notifyAll();
    }

    public String getPrenom() {
        return prenom.get();
    }

    public StringProperty prenomProperty() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom.set(prenom);
        //notifyAll();
    }

    public LocalDate getDateNaissance() {
        return dateNaissance.get();
    }

    public ObjectProperty<LocalDate> dateNaissanceProperty() {
        return dateNaissance;
    }

    public void setDateNaissance(LocalDate dateNaissance) {
        this.dateNaissance.set(dateNaissance);
        //notifyAll();
    }

    public String getProfession() {
        return profession.get();
    }

    public StringProperty professionProperty() {
        return profession;
    }

    public void setProfession(String profession) {
        this.profession.set(profession);
        //notifyAll();
    }

    public String getAdresse() {
        return adresse.get();
    }

    public StringProperty adresseProperty() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse.set(adresse);
        //notifyAll();
    }

    public String getTelephone() {
        return telephone.get();
    }

    public StringProperty telephoneProperty() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone.set(telephone);
        //notifyAll();
    }

    public String getNumeroSecuriteSociale() {
        return numeroSecuriteSociale.get();
    }

    public StringProperty numeroSecuriteSocialeProperty() {
        return numeroSecuriteSociale;
    }

    public void setNumeroSecuriteSociale(String numeroSecuriteSociale) {
        this.numeroSecuriteSociale.set(numeroSecuriteSociale);
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
}
