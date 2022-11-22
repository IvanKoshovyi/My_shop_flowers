package controllers;

import Database.DatabaseHandler;
import Flowers.Iris;
import Flowers.Lily;
import Flowers.Rose;
import Flowers.Tulip;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class UpdateControlles {

    @FXML
    private DatePicker DataFresh;

    @FXML
    private TextField FlowersLength;

    @FXML
    private TextField FlowersCost;

    @FXML
    private Button OK;

    @FXML
    private RadioButton RadioButtonIRIS;

    @FXML
    private RadioButton RadioButtonLILY;

    @FXML
    private RadioButton RadioButtonROSE;

    @FXML
    private RadioButton RadioButtonTYLIP;

    @FXML
    void initialize() {
        OK.setOnAction(event -> {
            DatabaseHandler dbHandler = new DatabaseHandler();
            int cost = Integer.parseInt(FlowersCost.getText());
            int lenght = Integer.parseInt(FlowersLength.getText());
            if (RadioButtonROSE.isSelected()) {
                DatabaseHandler.getFlowers().addLast(new Rose(0, cost, DataFresh.getValue(), lenght));
                dbHandler.signUpFlowers();
                Node source = (Node) event.getSource();
                Stage stage = (Stage) source.getScene().getWindow();
                stage.hide();
            }
            if (RadioButtonTYLIP.isSelected()) {
                DatabaseHandler.getFlowers().addLast(new Tulip(0, cost, DataFresh.getValue(), lenght));
                dbHandler.signUpFlowers();
                Node source = (Node) event.getSource();
                Stage stage = (Stage) source.getScene().getWindow();
                stage.hide();
            }
            if (RadioButtonLILY.isSelected()) {
                DatabaseHandler.getFlowers().addLast(new Lily(0, cost, DataFresh.getValue(), lenght));
                dbHandler.signUpFlowers();
                Node source = (Node) event.getSource();
                Stage stage = (Stage) source.getScene().getWindow();
                stage.hide();
            }
            if (RadioButtonIRIS.isSelected()) {
                DatabaseHandler.getFlowers().addLast(new Iris(0, cost, DataFresh.getValue(), lenght));
                dbHandler.signUpFlowers();
                Node source = (Node) event.getSource();
                Stage stage = (Stage) source.getScene().getWindow();
                stage.hide();
            }

        });
    }

    @FXML
    void Cancel(ActionEvent event) {
        Node source = (Node) event.getSource();
        Stage stage = (Stage) source.getScene().getWindow();
        stage.hide();
    }


}

