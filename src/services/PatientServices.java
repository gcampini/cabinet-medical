package services;

import dto.PatientDto;
import model.Patient;
import org.hibernate.Session;
import util.DBUtil;

import java.time.ZoneId;
import java.util.Date;
import java.util.List;

public class PatientServices {

    public void savePatient(Patient patient){
        PatientDto patientDto = new PatientDto();
        patientDto.setNom(patient.getNom());
        patientDto.setPrenom(patient.getPrenom());
        patientDto.setDateNaissance(Date.from(patient.getDateNaissance().atStartOfDay(ZoneId.systemDefault()).toInstant()));
        patientDto.setProfession(patient.getNom());
        patientDto.setAdresse(patient.getNom());
        patientDto.setTelephone(patient.getNom());
        patientDto.setNumeroSecuriteSociale(patient.getNom());
        Session s = DBUtil.getSession();
        s.beginTransaction();
        s.save(patientDto);
        s.getTransaction().commit();
    }

    public List<PatientDto> getAllPatient(){
        Session s = DBUtil.getSession();
        s.beginTransaction();
        List<PatientDto> patients = s.createQuery("FROM PatientDto", PatientDto.class).getResultList();
        s.getTransaction().commit();
        return patients;
    }
}
