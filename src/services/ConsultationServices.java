package services;

import dto.ConsultationDto;
import dto.RDVDto;
import model.Consultation;
import org.hibernate.Session;
import util.DBUtil;

import java.time.ZoneId;
import java.util.Date;
import java.util.List;

public class ConsultationServices {

    public void saveConsultation(Consultation consultation){
        ConsultationDto dto = new ConsultationDto();
        dto.setNom(consultation.getNom());
        dto.setPrenom(consultation.getPrenom());
        dto.setDate(Date.from(consultation.getDate().atStartOfDay(ZoneId.systemDefault()).toInstant()));
        Session s = DBUtil.getSession();
        s.beginTransaction();
        s.save(dto);
        s.getTransaction().commit();
    }

    public List<ConsultationDto> getAllConsultation(){
        Session s = DBUtil.getSession();
        s.beginTransaction();
        List<ConsultationDto> consultations = s.createQuery("FROM ConsultationDto", ConsultationDto.class).getResultList();
        s.getTransaction().commit();
        return consultations;
    }

}
