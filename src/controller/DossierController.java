package controller;

import dto.DossierDto;
import dto.PatientDto;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import org.hibernate.Session;
import util.DBUtil;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.stream.Collectors;

public class DossierController implements Initializable {

    private List<PatientDto> patients = new ArrayList<>();

    private PatientDto selectedPatient;
    private DossierDto selectedDossier;

    @FXML
    private ListView<String> list;

    @FXML
    private Button createDossierButton;

    @FXML
    private Button startConsultationButton;

    public void buildList() {
        patients = PatientController.getAllPatients();
        ObservableList<String> data = FXCollections.observableArrayList(
                patients.stream().map(p -> p.getNom() + " " + p.getPrenom()).collect(Collectors.toList()
                ));

        list.setItems(data);

        list.setOnMouseClicked(event -> {
            int index = list.getSelectionModel().getSelectedIndex();
            selectPatient(patients.get(index));
        });
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        buildList();
    }

    @FXML
    public void createDossier() {
        System.out.println("la question");
        DossierDto dossier = new DossierDto();
        dossier.setPatient(selectedPatient);
        dossier.setValiditePatient(true);
        saveDossier(dossier);
        selectPatient(selectedPatient);
    }

    @FXML
    public void startConsultation() {
    }

    public void selectPatient(PatientDto dto) {
        selectedPatient = dto;
        createDossierButton.setVisible(false);
        startConsultationButton.setVisible(false);
        selectedDossier = getDossier(dto);
        if (selectedDossier == null) {
            createDossierButton.setVisible(true);
        } else {
            startConsultationButton.setVisible(true);
        }
    }

    public static DossierDto getDossier(PatientDto dto) {
        Session s = DBUtil.getSession();
        s.beginTransaction();
        DossierDto dossier;
        try {
            dossier = s.createQuery("FROM DossierDto where patient_fk=" + dto.getId(), DossierDto.class).getSingleResult();
        } catch (Exception e) {
            dossier = null;
        }
        s.getTransaction().commit();
        s.close();
        return dossier;
    }

    public static List<DossierDto> getAllDossiers(){
        Session s = DBUtil.getSession();
        s.beginTransaction();
        List<DossierDto> dossiers = s.createQuery("FROM DossierDto", DossierDto.class).getResultList();
        s.getTransaction().commit();
        s.close();
        return dossiers;
    }

    public static void saveDossier(DossierDto dossier){
        Session s = DBUtil.getSession();
        s.beginTransaction();
        if (dossier.getId() == 0) s.save(dossier);
        else s.update(dossier);
        s.getTransaction().commit();
        s.close();
    }

}
