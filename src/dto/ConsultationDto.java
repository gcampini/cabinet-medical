package dto;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Entity
public class ConsultationDto {

    private int id;
    private Date date;
    private String observations;
    private DossierDto dossier;
    private Set<PrescriptionDto> prescriptions;
    private Set<CertificatDto> certificats;
    private Set<ExamenDto> examens;


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

    @Column(name = "Consultation_Date")
    @Temporal(TemporalType.TIMESTAMP)
    public Date getDate() {
        return date;
    }


    public void setDate(Date date) {
        this.date = date;
        //notifyAll();
    }

    @Basic
    public String getObservations() {
        return observations;
    }


    public void setObservations(String observations) {
        this.observations = observations;
        //notifyAll();
    }


    @ManyToOne( cascade = {CascadeType.PERSIST, CascadeType.MERGE} )
    @JoinColumn(name="dossier_fk", insertable=false, updatable=false)
    public DossierDto getDossier() {
        return dossier;
    }


    public void setDossier(DossierDto dossier) {
        this.dossier = dossier;
        //notifyAll();
    }

    @OneToMany
    @JoinColumn(name="dossier_fk")
    public Set<PrescriptionDto> getPrescriptions() {
        return prescriptions;
    }

    public void setPrescriptions(Set<PrescriptionDto> prescriptions) {
        this.prescriptions = prescriptions;
        //notifyAll();
    }

    @OneToOne(cascade = CascadeType.ALL)
    @PrimaryKeyJoinColumn
    public Set<CertificatDto> getCertificats() {
        return certificats;
    }

    public void setCertificats(Set<CertificatDto> certificats) {
        this.certificats = certificats;
        //notifyAll();
    }

    @OneToMany
    @JoinColumn(name="dossier_fk")
    public Set<ExamenDto> getExamens() {
        return examens;
    }

    public void setExamens(Set<ExamenDto> examens) {
        this.examens = examens;
        //notifyAll();
    }


}
