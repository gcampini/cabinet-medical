package dto;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;

@Entity
@PrimaryKeyJoinColumn(name="id")
public class CertificatDispenseDto extends CertificatDto {

    private int periode;

    @Basic
    public int getPeriode() {
        return periode;
    }


    public void setPeriode(int periode) {
        this.periode = periode;
        //notifyAll();
    }
}
