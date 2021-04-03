package com.parkingmanager.controllers;

import com.parkingmanager.models.Voiture;
import com.parkingmanager.models.query.QVoiture;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

import java.util.List;

public class VehiculesPageController {
    @FXML
    TableView<Voiture> vehiculeTable;

    @FXML
    private void initialize(){
        ObservableList<Voiture> vehicules= FXCollections.observableList(new QVoiture().findList());
        vehiculeTable.setItems(vehicules);
    }
}
