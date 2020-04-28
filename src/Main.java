import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.hibernate.Session;
import util.DBUtil;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("Main.fxml"));
        primaryStage.setTitle("on s'en fou");
        primaryStage.setScene(new Scene(root, 1000, 750));
        primaryStage.show();

    }

    public static void main(String[] args) {
        DBUtil.init();
        Session session = DBUtil.getSession();
        session.close();
        launch(args);
    }

}
