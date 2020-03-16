package model;

import javafx.beans.InvalidationListener;
import javafx.beans.Observable;

public class Certificat implements Observable {

    private int id;

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
        notifyAll();
        }
}
