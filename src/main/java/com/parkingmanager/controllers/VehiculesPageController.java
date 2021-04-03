package com.parkingmanager.controllers;

import com.parkingmanager.models.Voiture;
import com.parkingmanager.models.query.QVoiture;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

import java.util.List;

public class VehiculesPageController {
    private ObservableList<ObservableList> data;
    @FXML
    TableView vehiculeTable;
    @FXML
    TableColumn colid1;
    @FXML
    TableColumn colim1;
    @FXML
    TableColumn coltik1;
    @FXML
    TextField searchVehicule;

    @FXML
    private void initialize(){

        data = FXCollections.observableArrayList();
        colid1.setCellValueFactory(new PropertyValueFactory<Voiture, Integer>("id_voiture"));
        colim1.setCellValueFactory(new PropertyValueFactory<Voiture, String>("matricule"));
        vehiculeTable.getItems().setAll(FXCollections.<Voiture>observableArrayList(new QVoiture().findList()));
        searchVehicule.textProperty().addListener((obs, oldText, newText) -> {
            if(newText==null || newText.isEmpty()){
                List<Voiture> listVoitures =new QVoiture().findList();
                ObservableList<Voiture> data=FXCollections.<Voiture>observableArrayList(listVoitures);
                vehiculeTable.getItems().setAll(data);
            }
            else{
                List<Voiture> listVoitures =new QVoiture().matricule.contains(newText).findList();
                ObservableList<Voiture> data=FXCollections.<Voiture>observableArrayList(listVoitures);
                vehiculeTable.getItems().setAll(data);
            }
        });


    }
}
