package dto;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;

@Entity
public class RDVDto {

    private int id;
    private PatientDto patient;
    private Date date;

    @Id
    @GeneratedValue(generator="increment")
    @GenericGenerator(name="increment", strategy = "increment")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @ManyToOne( cascade = {CascadeType.PERSIST, CascadeType.MERGE })
    public PatientDto getPatient() {
        return patient;
    }

    public void setPatient(PatientDto patient) {
        this.patient = patient;
    }

    @Basic
    public Date getDate() {
        return date;
    }


    public void setDate(Date date) {
        this.date = date;
    }

}
