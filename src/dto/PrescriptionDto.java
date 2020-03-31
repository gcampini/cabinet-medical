package dto;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
public class PrescriptionDto {

    private int id;
    private String nomMedicament;
    private String posologie;
    private String dureeTraitement;
    private ConsultationDto consultation;



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
    public String getNomMedicament() {
        return nomMedicament;
    }


    public void setNomMedicament(String nomMedicament) {
        this.nomMedicament = nomMedicament;
        //notifyAll();
    }

    @Basic
    public String getPosologie() {
        return posologie;
    }


    public void setPosologie(String posologie) {
        this.posologie = posologie;
        //notifyAll();
    }

    @Basic
    public String getDureeTraitement() {
        return dureeTraitement;
    }


    public void setDureeTraitement(String dureeTraitement) {
        this.dureeTraitement = dureeTraitement;
        //notifyAll();
    }

    @ManyToOne( cascade = {CascadeType.PERSIST, CascadeType.MERGE} )
    @JoinColumn(name="dossier_fk", insertable=false, updatable=false)
    public ConsultationDto getConsultation() {
        return consultation;
    }


    public void setConsultation(ConsultationDto consultation) {
        this.consultation = consultation;
        //notifyAll();
    }
}
