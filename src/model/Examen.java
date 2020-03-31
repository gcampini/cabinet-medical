package model;

import javafx.beans.InvalidationListener;
import javafx.beans.Observable;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.StringProperty;

import javax.persistence.Entity;

@Entity
public class Examen implements Observable {

    private int id;
    private StringProperty type;
    private ObjectProperty<Consultation> consultation;

    @Override
    public void addListener(InvalidationListener invalidationListener) {

    }

    @Override
    public void removeListener(InvalidationListener invalidationListener) {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
        //notifyAll();
    }

    public String getType() {
        return type.get();
    }

    public StringProperty typeProperty() {
        return type;
    }

    public void setType(String type) {
        this.type.set(type);
        //notifyAll();
    }

    public Consultation getConsultation() {
        return consultation.get();
    }

    public ObjectProperty<Consultation> consultationProperty() {
        return consultation;
    }

    public void setConsultation(Consultation consultation) {
        this.consultation.set(consultation);
        //notifyAll();
    }
}
