package Object;


import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Modality;
import javafx.stage.Stage;
import controllers.FlowersShop;

import java.io.IOException;
import java.util.Objects;

public class Comp {
    public void update(){
        try {
            ActionEvent actionEvent = FlowersShop.getActionEvent();
            Stage stage = new Stage();
            Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("../fxml/Update.fxml")));
            stage.setTitle("Добавити квітку");
            stage.setResizable(false);
            stage.setScene(new Scene(root,483, 216));
            stage.initModality(Modality.WINDOW_MODAL);
            stage.initOwner(((Node)actionEvent.getSource()).getScene().getWindow());
            stage.show();

        }catch (IOException e){
            e.printStackTrace();
        }
    }
    public void delete(){
        try {
            Stage stage = new Stage();
            ActionEvent actionEvent = FlowersShop.getActionEvent();
            Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("../fxml/Delete.fxml")));
            stage.setTitle("Видалити квітку");
            stage.setResizable(false);
            stage.setScene(new Scene(root, 432, 124));
            stage.initModality(Modality.WINDOW_MODAL);
            stage.initOwner(((Node)actionEvent.getSource()).getScene().getWindow());
            stage.show();

        }catch (IOException e){
            e.printStackTrace();
        }
    }
    public void create(){
        try {
            ActionEvent actionEvent = FlowersShop.getActionEvent();
            Stage stage = new Stage();
            Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("../fxml/Bouquest.fxml")));
            stage.setTitle("Створеня букету");
            stage.setResizable(false);
            stage.setScene(new Scene(root,1217, 670));
            stage.initModality(Modality.WINDOW_MODAL);
            stage.initOwner(((Node)actionEvent.getSource()).getScene().getWindow());
            stage.show();

        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
