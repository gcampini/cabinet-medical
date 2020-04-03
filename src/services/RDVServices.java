package services;

import dto.RDVDto;
import model.RDV;
import org.hibernate.Session;
import util.DBUtil;

import java.time.ZoneId;
import java.util.Date;
import java.util.List;

public class RDVServices {

    public void saveRDV(RDV rdv){
        RDVDto dto = new RDVDto();
        dto.setNom(rdv.getNom());
        dto.setPrenom(rdv.getPrenom());
        dto.setDate(Date.from(rdv.getDate().atStartOfDay(ZoneId.systemDefault()).toInstant()));
        Session s = DBUtil.getSession();
        s.beginTransaction();
        s.save(dto);
        s.getTransaction().commit();
    }

    public List<RDVDto> getAllRDV(){
        Session s = DBUtil.getSession();
        s.beginTransaction();
        List<RDVDto> rdvs = s.createQuery("FROM RDVDto", RDVDto.class).getResultList();
        s.getTransaction().commit();
        return rdvs;
    }

}
