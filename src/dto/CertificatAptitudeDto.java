package dto;


import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;

@Entity
@PrimaryKeyJoinColumn(name="id")
public class CertificatAptitudeDto extends CertificatDto {

    private Boolean aptitude;

    @Basic
    public boolean getAptitude() {
        return aptitude;
    }


    public void setAptitude(boolean aptitude) {
        this.aptitude = aptitude;
        //notifyAll();
    }
}
