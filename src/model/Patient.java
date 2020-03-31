package model;

import javafx.beans.InvalidationListener;
import javafx.beans.Observable;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.StringProperty;

import javax.persistence.Entity;
import java.util.Date;

@Entity
public class Patient implements Observable {

    private int id;
    private StringProperty nom;
    private StringProperty prenom;
    private ObjectProperty<Date> dateNaissance;
    private StringProperty profession;
    private StringProperty adresse;
    private StringProperty telephone;
    private StringProperty numeroSecuriteSociale;
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

    public Date getDateNaissance() {
        return dateNaissance.get();
    }

    public ObjectProperty<Date> dateNaissanceProperty() {
        return dateNaissance;
    }

    public void setDateNaissance(Date dateNaissance) {
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
