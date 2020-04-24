package services;

import dto.ExamenDto;
import dto.RDVDto;
import model.Examen;
import org.hibernate.Session;
import util.DBUtil;

import java.time.ZoneId;
import java.util.Date;
import java.util.List;

public class ExamenServices {

    public void saveExamen(Examen examen){
        ExamenDto dto = new ExamenDto();
        dto.setNom(examen.getNom());
        dto.setPrenom(examen.getPrenom());
        dto.setDate(Date.from(examen.getDate().atStartOfDay(ZoneId.systemDefault()).toInstant()));
        Session s = DBUtil.getSession();
        s.beginTransaction();
        s.save(dto);
        s.getTransaction().commit();
    }

    public List<ExamenDto> getAllExamen(){
        Session s = DBUtil.getSession();
        s.beginTransaction();
        List<ExamenDto> examens = s.createQuery("FROM ExamenDto", ExamenDto.class).getResultList();
        s.getTransaction().commit();
        return examens;
    }

}
