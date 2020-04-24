package services;

import dto.PrescriptionDto;
import model.Prescription;
import org.hibernate.Session;
import util.DBUtil;

import java.util.List;

public class PrescriptionServices {

    public void savePrescription(Prescription prescription){
        PrescriptionDto dto = new PrescriptionDto();
        dto.setNomMedicament(prescription.getNomMedicament());
        dto.setPosologie(prescription.getPosologie());
        dto.setDureeTraitement(prescription.getDureeTraitement());
        dto.setConsultation(prescription.getConsultation());
        Session s = DBUtil.getSession();
        s.beginTransaction();
        s.save(dto);
        s.getTransaction().commit();
    }

    public List<PrescriptionDto> getAllPrescription(){
        Session s = DBUtil.getSession();
        s.beginTransaction();
        List<PrescriptionDto> prescriptions = s.createQuery("FROM PrescriptionDto", PrescriptionDto.class).getResultList();
        s.getTransaction().commit();
        return prescriptions;
    }
}
