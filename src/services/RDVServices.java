package services;

import dto.RDVDto;
import model.RDV;
import org.hibernate.Session;
import util.DBUtil;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;

public class RDVServices {

    public void saveRDV(RDV rdv){
        RDVDto dto = new RDVDto();
        dto.setNom(rdv.getNom());
        dto.setPrenom(rdv.getPrenom());
        String[] heureMinute = rdv.getHeure().split(":");
        int heure = Integer.parseInt(heureMinute[0]);
        int min = Integer.parseInt(heureMinute[1]);
        LocalDateTime date = rdv.getDate().atTime(heure, min);
        dto.setDate(Date.from(date.atZone(ZoneId.systemDefault()).toInstant()));
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
