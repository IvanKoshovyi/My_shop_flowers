package controllers;

import Command.CreateCommand;
import Command.DeleteCommand;
import Command.UpdateCommand;
import Database.Const;
import Database.DatabaseHandler;
import Flowers.Flowers;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.time.LocalDate;

import Object.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;


public class FlowersShop {
    private ObservableList<Flowers> flowersData = FXCollections.observableArrayList();
    private Comp c = new Comp();
    private User user = new User(new UpdateCommand(c), new DeleteCommand(c) , new CreateCommand(c));
    private static ActionEvent actionEvent;

    public static ActionEvent getActionEvent() {
        return actionEvent;
    }

    public void setActionEvent(ActionEvent actionEvent) {
        FlowersShop.actionEvent = actionEvent;
    }


    @FXML
    private VBox EXIT;
    @FXML
    private TableColumn<Flowers, Integer> CostColumn;

    @FXML
    private TableColumn<Flowers, LocalDate> FreshColumn;

    @FXML
    private TableColumn<Flowers, String> StalkLengthColumn;

    @FXML
    private TableColumn<Flowers, Integer> MemberColumn;

    @FXML
    private TableColumn<Flowers, String> NameColumn;

    @FXML
    private TableView<Flowers> reportTable;
    @FXML
    private Label Number;

    @FXML
    public void initialize(){
        flowersData.clear();
        initData();
        MemberColumn.setCellValueFactory(new PropertyValueFactory<Flowers, Integer>(Const.ID_FLOWERS));
        NameColumn.setCellValueFactory(new PropertyValueFactory<Flowers, String>(Const.NAME_FLOWERS));
        CostColumn.setCellValueFactory(new PropertyValueFactory<Flowers, Integer>(Const.COST_FLOWERS));
        FreshColumn.setCellValueFactory(new PropertyValueFactory<Flowers, LocalDate>(Const.FRESH_FLOWERS));
        StalkLengthColumn.setCellValueFactory(new PropertyValueFactory<Flowers, String>(Const.STALKLENGTH_FLOWERS));
        reportTable.setItems(flowersData);
        Number.setText("Кількість квітів: " + flowersData.size());
    }

    public void initData(){
        DatabaseHandler.SelectFlowers();
        for (int i = 0; i<DatabaseHandler.getNum();i++) {
            flowersData.add(DatabaseHandler.temp(i));
        }
    }

    public void refresh(ActionEvent actionEvent) {
        flowersData.clear();
        initData();
        MemberColumn.setCellValueFactory(new PropertyValueFactory<Flowers, Integer>(Const.ID_FLOWERS));
        NameColumn.setCellValueFactory(new PropertyValueFactory<Flowers, String>(Const.NAME_FLOWERS));
        CostColumn.setCellValueFactory(new PropertyValueFactory<Flowers, Integer>(Const.COST_FLOWERS));
        FreshColumn.setCellValueFactory(new PropertyValueFactory<Flowers, LocalDate>(Const.FRESH_FLOWERS));
        StalkLengthColumn.setCellValueFactory(new PropertyValueFactory<Flowers, String>(Const.STALKLENGTH_FLOWERS));
        reportTable.setItems(flowersData);
        Number.setText("Кількість квітів: " + flowersData.size());
    }


    public void UPDATE(ActionEvent actionEvent){
        setActionEvent(actionEvent);
        user.updateBouquest();
    }
    @FXML
    void DELETE(ActionEvent actionEvent) {
        setActionEvent(actionEvent);
        user.deleteBouquest();
    }
    @FXML
    void CreateBouquest(ActionEvent actionEvent) {
        setActionEvent(actionEvent);
        user.createBouquest();
    }

    @FXML
    void Cancel(ActionEvent event) {
        Stage stage = (Stage) EXIT.getScene().getWindow();
        stage.close();
    }
}
