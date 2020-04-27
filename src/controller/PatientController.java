package controller;

import dto.PatientDto;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import org.hibernate.Session;
import util.DBUtil;

import java.net.URL;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.ResourceBundle;
import java.util.stream.Collectors;

public class PatientController implements Initializable {

    private List<PatientDto> patients = new ArrayList<>();

    private PatientDto selectedPatient;

    @FXML
    private ListView<String> list;

    @FXML
    private Text title;

    @FXML
    private Button deleteButton;

    @FXML
    private VBox form;
    @FXML
    public TextField nomField;
    @FXML
    public TextField prenomield;
    @FXML
    public DatePicker dateNaissanceField;
    @FXML
    public TextField professionField;
    @FXML
    public TextField adresseField;
    @FXML
    public TextField telephoneField;
    @FXML
    public TextField secuField;


    public void buildList() {
        patients = getAllPatients();
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
        selectPatient(null);
    }

    @FXML
    public void create() {
        selectedPatient = new PatientDto();
        form.setVisible(true);
        title.setText("Créer un patient");
    }

    @FXML
    public void delete() {
        Session s = DBUtil.getSession();
        s.beginTransaction();
        s.delete(selectedPatient);
        s.getTransaction().commit();
        buildList();
        selectPatient(null);
    }

    private void selectPatient(PatientDto patient) {
        selectedPatient = patient;

        String title = "Aucun patient sélectionné";
        boolean deleteButtonVisisble = false;

        if (patient != null) {
            title = "Patient sélectionné";
            deleteButtonVisisble = true;

            nomField.setText(patient.getNom());
            prenomield.setText(patient.getPrenom());
            telephoneField.setText(patient.getTelephone());
            adresseField.setText(patient.getAdresse());
            secuField.setText(patient.getNumeroSecuriteSociale());
            professionField.setText(patient.getProfession());
            Date date = new java.util.Date(patient.getDateNaissance().getTime());
            dateNaissanceField.setValue(date.toInstant()
                    .atZone(ZoneId.systemDefault())
                    .toLocalDate());

            form.setVisible(true);

        } else {
            form.setVisible(false);
        }

        this.title.setText(title);
        deleteButton.setVisible(deleteButtonVisisble);
    }

    public static List<PatientDto> getAllPatients(){
        Session s = DBUtil.getSession();
        s.beginTransaction();
        List<PatientDto> patients = s.createQuery("FROM PatientDto", PatientDto.class).getResultList();
        s.getTransaction().commit();
        return patients;
    }

    @FXML
    public void save() {
        PatientDto dto = new PatientDto();
        if (selectedPatient != null) dto.setId(selectedPatient.getId());

        dto.setNom(nomField.getText());
        dto.setPrenom(prenomield.getText());
        dto.setAdresse(adresseField.getText());
        dto.setDateNaissance(Date.from(dateNaissanceField.getValue().atStartOfDay().atZone(ZoneId.systemDefault()).toInstant()));
        dto.setNumeroSecuriteSociale(secuField.getText());
        dto.setProfession(professionField.getText());
        dto.setTelephone(telephoneField.getText());

        savePatient(dto);
        selectPatient(null);
        buildList();
    }

    public static void savePatient(PatientDto patient){
        Session s = DBUtil.getSession();
        s.beginTransaction();
        System.out.println(patient.getId());
        if (patient.getId() == 0) s.save(patient);
        else s.update(patient);
        s.getTransaction().commit();
    }

}
