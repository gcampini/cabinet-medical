package dto;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Set;

@Entity
public class DossierDto{

    private int id;
    private Boolean validitePatient;
    private String cin;
    private PatientDto patient;
    private Set<ConsultationDto> consultations;



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
        return validitePatient;
    }

    public Boolean validitePatient() {
        return validitePatient;
    }

    public void setValiditePatient(boolean validitePatient) {
        this.validitePatient = validitePatient;
        //notifyAll();
    }

    @Basic
    public String getCin() {
        return cin;
    }


    public void setCin(String cin) {
        this.cin = cin;
        //notifyAll();
    }


    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="patient_fk")
    public PatientDto getPatient() {
        return patient;
    }


    public void setPatient(PatientDto patient) {
        this.patient = patient;
        //notifyAll();
    }

    @OneToMany
    @JoinColumn(name="dossier_fk")
    public Set<ConsultationDto> getConsultations() {
        return consultations;
    }

    public void setConsultations(Set<ConsultationDto> consultations) {
        this.consultations = consultations;
        //notifyAll();
    }
}
