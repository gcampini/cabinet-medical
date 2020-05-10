package controller;

import dto.PatientDto;
import dto.RDVDto;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import org.hibernate.Session;
import util.DBUtil;

import java.net.URL;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.*;
import java.util.stream.Collectors;

public class RDVController implements Initializable {


    private List<RDVDto> rdvs = new ArrayList<>();

    private List<PatientDto> patients = new ArrayList<>();

    private RDVDto selectedRDV;

    @FXML
    private ListView<String> list;

    @FXML
    private Text selectedRDVTitle;

    @FXML
    private Button deleteButton;

    @FXML
    private VBox form;
    @FXML
    private ComboBox patientField;
    @FXML
    private DatePicker dateField;
    @FXML
    private TextField timeField;


    public void buildList() {

        rdvs = getAllRDV();

        ObservableList<String> data = FXCollections.observableArrayList(
                rdvs.stream().map(rdv -> rdv.getDate() + " | " + rdv.getPatient().getNom() + " " + rdv.getPatient().getPrenom()).collect(Collectors.toList()
        ));

        list.setItems(data);

        list.setOnMouseClicked(event -> {
            int rdvIndex = list.getSelectionModel().getSelectedIndex();
            if (rdvIndex >= 0) selectRDV(rdvs.get(rdvIndex));
        });
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        buildList();
        patients = PatientController.getAllPatients();
        patientField.setItems(FXCollections.observableArrayList(
                patients.stream().map(p -> p.getNom() + " " + p.getPrenom()).collect(Collectors.toList())));
    }

    @FXML
    public void create() {
        selectedRDV = new RDVDto();
        form.setVisible(true);
        selectedRDVTitle.setText("Créer un RDV");
    }

    @FXML
    public void delete() {
        Session s = DBUtil.getSession();
        s.beginTransaction();
        s.delete(selectedRDV);
        s.getTransaction().commit();
        s.close();
        buildList();
        selectRDV(null);
    }

    private void selectRDV(RDVDto rdv) {
        selectedRDV = rdv;

        String title = "Aucun RDV sélectionné";
        boolean deleteButtonVisisble = false;

        if (rdv != null) {
            title = "RDV sélectionné";
            deleteButtonVisisble = true;

            patientField.getSelectionModel().select(patients.indexOf(rdv.getPatient()));
            Date date = rdv.getDate();
            LocalDateTime ldt = date.toInstant()
                    .atZone(ZoneId.systemDefault())
                    .toLocalDateTime();
            dateField.setValue(ldt.toLocalDate());
            timeField.setText(ldt.getHour() + ":" + ldt.getMinute());
                    form.setVisible(true);

        } else {
            form.setVisible(false);
        }

        selectedRDVTitle.setText(title);
        deleteButton.setVisible(deleteButtonVisisble);
    }

    public static List<RDVDto> getAllRDV(){
        Session s = DBUtil.getSession();
        s.beginTransaction();
        List<RDVDto> rdvs = s.createQuery("FROM RDVDto", RDVDto.class).getResultList();
        s.getTransaction().commit();
        s.close();
        return rdvs;
    }

    @FXML
    public void save() {
        RDVDto dto = new RDVDto();
        if (selectedRDV != null) dto.setId(selectedRDV.getId());
        dto.setPatient(patients.get(patientField.getSelectionModel().getSelectedIndex()));
        String[] heureMinute = timeField.getText().split(":");
        int heure = Integer.parseInt(heureMinute[0]);
        int min = Integer.parseInt(heureMinute[1]);
        LocalDateTime date = dateField.getValue().atTime(heure, min);
        dto.setDate(Date.from(date.atZone(ZoneId.systemDefault()).toInstant()));
        saveRDV(dto);
        selectRDV(null);
        buildList();
    }

    public static void saveRDV(RDVDto rdv){
        Session s = DBUtil.getSession();
        s.beginTransaction();
        System.out.println(rdv.getId());
        if (rdv.getId() == 0) s.save(rdv);
        else s.update(rdv);
        s.getTransaction().commit();
        s.close();
    }

}
