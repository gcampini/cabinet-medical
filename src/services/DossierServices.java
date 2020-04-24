package services;

import dto.DossierDto;
import dto.RDVDto;
import model.Dossier;
import org.hibernate.Session;
import util.DBUtil;

import java.time.ZoneId;
import java.util.Date;
import java.util.List;

public class DossierServices {

    public void saveDosser(Dossier dossier){
        DossierDto dto = new DossierDto();
        dto.setNom(rdv.getNom());
        dto.setPrenom(rdv.getPrenom());
        dto.setDate(Date.from(rdv.getDate().atStartOfDay(ZoneId.systemDefault()).toInstant()));
        Session s = DBUtil.getSession();
        s.beginTransaction();
        s.save(dto);
        s.getTransaction().commit();
    }

    public List<DossierDto> getAllDossier(){
        Session s = DBUtil.getSession();
        s.beginTransaction();
        List<DossierDto> dossiers = s.createQuery("FROM DossierDto", DossierDto.class).getResultList();
        s.getTransaction().commit();
        return dossiers;
    }

}
