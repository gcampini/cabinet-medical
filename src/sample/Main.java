package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import model.Certificat;
import org.hibernate.Session;
import util.DBUtil;

public class Main extends Application {


    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("Hello World");
        primaryStage.setScene(new Scene(root, 300, 275));
        primaryStage.show();
        Session session = DBUtil.getSession();
        session.beginTransaction();
        Certificat c = new Certificat();
        session.save(c);
        session.getTransaction().commit();
        session.close();
    }


    public static void main(String[] args) {
        DBUtil.init();
        Session session = DBUtil.getSession();
        session.beginTransaction();
        Certificat c = new Certificat();
        session.save(c);
        session.getTransaction().commit();
        session.close();
        launch(args);
    }
}
