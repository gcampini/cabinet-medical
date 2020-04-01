package dto;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;

@Entity
@PrimaryKeyJoinColumn(name="id")
public class CertificatReposDto extends CertificatDto {

    private int nombreJours;

    @Basic
    public int getNombreJours() {
        return nombreJours;
    }


    public void setNombreJours(int nombreJours) {
        this.nombreJours = nombreJours;
        //notifyAll();
    }
}
