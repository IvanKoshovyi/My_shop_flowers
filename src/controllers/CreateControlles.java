package controllers;

import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;

import Database.Const;
import Database.DatabaseHandler;
import Flowers.Flowers;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

public class CreateControlles {

    private ObservableList<Flowers> flowersData = FXCollections.observableArrayList();
    private ObservableList<Flowers> bouquestData = FXCollections.observableArrayList();
    private ObservableList<Flowers> LengthData = FXCollections.observableArrayList();
    private int SUMA = 0;

    private int acs  = 0;
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button ALLbouquest;

    @FXML
    private TableColumn<Flowers, Integer> BOUQUESTCostColumn;

    @FXML
    private TableColumn<Flowers, LocalDate> BOUQUESTFreshColumn;

    @FXML
    private TableColumn<Flowers, String> BOUQUESTNameColumn;

    @FXML
    private TableColumn<Flowers, String> BOUQUESTStalkLengthColumn;

    @FXML
    private TableView<Flowers> BOUQUESTTable;

    @FXML
    private TableColumn<Flowers, Integer> BOUQUESTidColumn;

    @FXML
    private Label COST;

    @FXML
    private TableColumn<Flowers, Integer> FLOWERSCostColumn;

    @FXML
    private TableColumn<Flowers, LocalDate> FLOWERSFreshColumn;

    @FXML
    private TableColumn<Flowers, String> FLOWERSNameColumn;

    @FXML
    private TableColumn<Flowers, String> FLOWERSStalkLengthColumn;

    @FXML
    private TableView<Flowers> FLOWERSTable;

    @FXML
    private TableColumn<Flowers, Integer> FLOWERSidColumn;

    @FXML
    private TextField IdIN_bouquest;

    @FXML
    private Button LengthBUTTON;

    @FXML
    private TextField LengthTEXT;

    @FXML
    private RadioButton RadioBasket;

    @FXML
    private RadioButton RadioKraft_Paper;

    @FXML
    private RadioButton RadioTape;

    @FXML
    private Button create;

    @FXML
    private Button delete;

    @FXML
    private TextField iddelete_bouquest;

    @FXML
    void initialize() {
        LengthData.clear();
        bouquestData.clear();
        flowersData.clear();
        initData();
        FLOWERSidColumn.setCellValueFactory(new PropertyValueFactory<Flowers, Integer>(Const.ID_FLOWERS));
        FLOWERSNameColumn.setCellValueFactory(new PropertyValueFactory<Flowers, String>(Const.NAME_FLOWERS));
        FLOWERSCostColumn.setCellValueFactory(new PropertyValueFactory<Flowers, Integer>(Const.COST_FLOWERS));
        FLOWERSFreshColumn.setCellValueFactory(new PropertyValueFactory<Flowers, LocalDate>(Const.FRESH_FLOWERS));
        FLOWERSStalkLengthColumn.setCellValueFactory(new PropertyValueFactory<Flowers, String>(Const.STALKLENGTH_FLOWERS));
        FLOWERSTable.setItems(flowersData);

    }
    public void initData(){
        DatabaseHandler.SelectFlowers();
        for (int i = 0; i<DatabaseHandler.getNum();i++) {
            flowersData.add(DatabaseHandler.temp(i));
        }
    }

    @FXML
    void ALLbouquest(ActionEvent event) {
        BOUQUESTidColumn.setCellValueFactory(new PropertyValueFactory<Flowers, Integer>(Const.ID_FLOWERS));
        BOUQUESTNameColumn.setCellValueFactory(new PropertyValueFactory<Flowers, String>(Const.NAME_FLOWERS));
        BOUQUESTCostColumn.setCellValueFactory(new PropertyValueFactory<Flowers, Integer>(Const.COST_FLOWERS));
        BOUQUESTFreshColumn.setCellValueFactory(new PropertyValueFactory<Flowers, LocalDate>(Const.FRESH_FLOWERS));
        BOUQUESTStalkLengthColumn.setCellValueFactory(new PropertyValueFactory<Flowers, String>(Const.STALKLENGTH_FLOWERS));
        BOUQUESTTable.setItems(bouquestData);

    }

    @FXML
    void LengthBUTTON() {
        LengthData.clear();;
        int length = Integer.parseInt(LengthTEXT.getText());
        for(int i = 0; i < bouquestData.size(); i++){
            if(bouquestData.get(i).getStalkLength() == length){
                LengthData.add(bouquestData.get(i));
            }
        }
        BOUQUESTidColumn.setCellValueFactory(new PropertyValueFactory<Flowers, Integer>(Const.ID_FLOWERS));
        BOUQUESTNameColumn.setCellValueFactory(new PropertyValueFactory<Flowers, String>(Const.NAME_FLOWERS));
        BOUQUESTCostColumn.setCellValueFactory(new PropertyValueFactory<Flowers, Integer>(Const.COST_FLOWERS));
        BOUQUESTFreshColumn.setCellValueFactory(new PropertyValueFactory<Flowers, LocalDate>(Const.FRESH_FLOWERS));
        BOUQUESTStalkLengthColumn.setCellValueFactory(new PropertyValueFactory<Flowers, String>(Const.STALKLENGTH_FLOWERS));
        BOUQUESTTable.setItems(LengthData);

    }

    @FXML
    void create() {
        int id = Integer.parseInt(IdIN_bouquest.getText());
        for(int i = 0; i < flowersData.size(); i++){
            if(flowersData.get(i).getIdFlowers() == id){
                bouquestData.add(flowersData.get(i));
                flowersData.remove(i);
            }
        }
        BOUQUESTidColumn.setCellValueFactory(new PropertyValueFactory<Flowers, Integer>(Const.ID_FLOWERS));
        BOUQUESTNameColumn.setCellValueFactory(new PropertyValueFactory<Flowers, String>(Const.NAME_FLOWERS));
        BOUQUESTCostColumn.setCellValueFactory(new PropertyValueFactory<Flowers, Integer>(Const.COST_FLOWERS));
        BOUQUESTFreshColumn.setCellValueFactory(new PropertyValueFactory<Flowers, LocalDate>(Const.FRESH_FLOWERS));
        BOUQUESTStalkLengthColumn.setCellValueFactory(new PropertyValueFactory<Flowers, String>(Const.STALKLENGTH_FLOWERS));
        BOUQUESTTable.setItems(bouquestData);
        SUMA = 0;
        for(int i = 0; i < bouquestData.size(); i++){
            SUMA = SUMA + bouquestData.get(i).getCost();
        }
        SUMA += acs;
        COST.setText("Ціна букета: " + SUMA + " $");
    }

    @FXML
    void delete() {
        int id = Integer.parseInt(iddelete_bouquest.getText());
        for(int i = 0; i < bouquestData.size(); i++){
            if(bouquestData.get(i).getIdFlowers() == id){
                flowersData.add(bouquestData.get(i));
                bouquestData.remove(i);
            }
        }
        FLOWERSidColumn.setCellValueFactory(new PropertyValueFactory<Flowers, Integer>(Const.ID_FLOWERS));
        FLOWERSNameColumn.setCellValueFactory(new PropertyValueFactory<Flowers, String>(Const.NAME_FLOWERS));
        FLOWERSCostColumn.setCellValueFactory(new PropertyValueFactory<Flowers, Integer>(Const.COST_FLOWERS));
        FLOWERSFreshColumn.setCellValueFactory(new PropertyValueFactory<Flowers, LocalDate>(Const.FRESH_FLOWERS));
        FLOWERSStalkLengthColumn.setCellValueFactory(new PropertyValueFactory<Flowers, String>(Const.STALKLENGTH_FLOWERS));
        FLOWERSTable.setItems(flowersData);
        BOUQUESTidColumn.setCellValueFactory(new PropertyValueFactory<Flowers, Integer>(Const.ID_FLOWERS));
        BOUQUESTNameColumn.setCellValueFactory(new PropertyValueFactory<Flowers, String>(Const.NAME_FLOWERS));
        BOUQUESTCostColumn.setCellValueFactory(new PropertyValueFactory<Flowers, Integer>(Const.COST_FLOWERS));
        BOUQUESTFreshColumn.setCellValueFactory(new PropertyValueFactory<Flowers, LocalDate>(Const.FRESH_FLOWERS));
        BOUQUESTStalkLengthColumn.setCellValueFactory(new PropertyValueFactory<Flowers, String>(Const.STALKLENGTH_FLOWERS));
        BOUQUESTTable.setItems(bouquestData);
        SUMA = 0;
        for(int i = 0; i < bouquestData.size(); i++){
            SUMA = SUMA + bouquestData.get(i).getCost();
        }
        SUMA += acs;
        COST.setText("Ціна букета: " + SUMA + " $");
    }

    @FXML
    void AccessoriesUP() {
        acs = 0;
        SUMA = 0;
        for(int i = 0; i < bouquestData.size(); i++){
            SUMA = SUMA + bouquestData.get(i).getCost();
        }
        if(RadioTape.isSelected()){
            acs+= 25;
            SUMA+= 25;
        }
        if(RadioKraft_Paper.isSelected()){
            acs+= 40;
            SUMA+= 40;
        }
        if(RadioBasket.isSelected()){
            acs+= 60;
            SUMA+= 60;
        }
        COST.setText("Ціна букета: " + SUMA + " $");
    }

    @FXML
    void Cancel(ActionEvent event) {
        Node source = (Node) event.getSource();
        Stage stage = (Stage) source.getScene().getWindow();
        stage.hide();
    }



}
