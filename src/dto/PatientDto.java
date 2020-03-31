package dto;


import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;

@Entity
public class PatientDto {

    private int id;
    private String nom;
    private String prenom;
    private Date dateNaissance;
    private String profession;
    private String adresse;
    private String telephone;
    private String numeroSecuriteSociale;
    private DossierDto dossierDto;


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

    @Basic
    public String getNom() {
        return nom;
    }


    public void setNom(String nom) {
        this.nom = nom;
        //notifyAll();
    }

    @Basic
    public String getPrenom() {
        return prenom;
    }


    public void setPrenom(String prenom) {
        this.prenom = prenom;
        //notifyAll();
    }

    @Temporal(TemporalType.TIMESTAMP)
    public Date getDateNaissance() {
        return dateNaissance;
    }


    public void setDateNaissance(Date dateNaissance) {
        this.dateNaissance = dateNaissance;
        //notifyAll();
    }

    @Basic
    public String getProfession() {
        return profession;
    }


    public void setProfession(String profession) {
        this.profession = profession;
        //notifyAll();
    }

    @Basic
    public String getAdresse() {
        return adresse;
    }


    public void setAdresse(String adresse) {
        this.adresse = adresse;
        //notifyAll();
    }

    @Basic
    public String getTelephone() {
        return telephone;
    }


    public void setTelephone(String telephone) {
        this.telephone = telephone;
        //notifyAll();
    }

    @Basic
    public String getNumeroSecuriteSociale() {
        return numeroSecuriteSociale;
    }


    public void setNumeroSecuriteSociale(String numeroSecuriteSociale) {
        this.numeroSecuriteSociale = numeroSecuriteSociale;
        //notifyAll();
    }

    @OneToOne(cascade = CascadeType.ALL)
    @PrimaryKeyJoinColumn
    public DossierDto getDossier() {
        return dossierDto;
    }


    public void setDossier(DossierDto dossier) {
        this.dossierDto = dossier;
        //notifyAll();
    }
}
