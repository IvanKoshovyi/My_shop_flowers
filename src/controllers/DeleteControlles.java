package controllers;

import Database.DatabaseHandler;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class DeleteControlles {

    @FXML
    private Button Cancel;

    @FXML
    private Button DELETE;

    @FXML
    private TextField IDdelete;

    @FXML
    void initialize() {
        DELETE.setOnAction(event -> {
            DatabaseHandler dbHandler = new DatabaseHandler();
            dbHandler.DeleteFlowers(IDdelete.getText());
            Node source = (Node) event.getSource();
            Stage stage = (Stage) source.getScene().getWindow();
            stage.hide();
        });
    }

    @FXML
    void Cancel(ActionEvent event) {
        Node source = (Node) event.getSource();
        Stage stage = (Stage) source.getScene().getWindow();
        stage.hide();
    }

}
