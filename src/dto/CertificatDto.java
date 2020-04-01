package dto;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Inheritance(strategy= InheritanceType.JOINED)
public class CertificatDto {

    private int id;
    private ConsultationDto consultationDto;


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

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="certificat_fk")
    public ConsultationDto getConsultationDto() {
        return consultationDto;
    }

    public void setConsultationDto(ConsultationDto consultationDto) {
        this.consultationDto = consultationDto;
    }


}