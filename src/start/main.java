package start;

import Database.DatabaseHandler;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.util.Objects;

public class main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("../fxml/main.fxml")));
        primaryStage.setTitle("Квіти");
        primaryStage.setMinHeight(600);
        primaryStage.setMinWidth(600);
        primaryStage.setScene(new Scene(root, 600,600));
        primaryStage.show();
        DatabaseHandler.SelectFlowers();
    }

    public static void main(String[] args) { launch(args);}
}
