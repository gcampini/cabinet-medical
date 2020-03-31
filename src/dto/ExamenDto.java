package dto;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
public class ExamenDto {

    private int id;
    private String type;
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
    public String getType() {
        return type;
    }


    public void setType(String type) {
        this.type = type;
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
