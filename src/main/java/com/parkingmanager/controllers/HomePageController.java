package com.parkingmanager.controllers;

import com.parkingmanager.models.Utilisateur;
import com.parkingmanager.models.Voiture;
import com.parkingmanager.models.query.QUtilisateur;
import com.parkingmanager.models.query.QVoiture;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.util.Date;
import java.util.List;

public class HomePageController {
    private ObservableList<ObservableList> data;
    @FXML
    TableView tableHome;
    @FXML
    TableColumn colid;
    @FXML
    TableColumn colim;
    @FXML
    TableColumn coldate;


    @FXML
    private void initialize(){
        data = FXCollections.observableArrayList();
        /*List<Utilisateur> listUser= new QUtilisateur().findList();
        colid.setCellValueFactory(new PropertyValueFactory<Utilisateur, Integer>("id"));
        colnom.setCellValueFactory(new PropertyValueFactory<Utilisateur, String>("nom"));
        colpre.setCellValueFactory(new PropertyValueFactory<Utilisateur, String>("prenom"));
        colem.setCellValueFactory(new PropertyValueFactory<Utilisateur, String>("email"));
        ObservableList<Utilisateur> data = FXCollections.<Utilisateur>observableArrayList(listUser);

        tableHome.getItems().setAll(data);*/

        List<Voiture> listVoitures =new QVoiture().findList();
        colid.setCellValueFactory(new PropertyValueFactory<Voiture, Integer>("id_voiture"));
        colim.setCellValueFactory(new PropertyValueFactory<Voiture, String>("matricule"));
        //coldate.setCellValueFactory(new PropertyValueFactory<Voiture, String>("date_entree"));
        //coltik.setCellFactory(new PropertyValueFactory<Voiture,Boolean>("ticket_payed"));
        ObservableList<Voiture> data=FXCollections.<Voiture>observableArrayList(listVoitures);

        tableHome.getItems().setAll(data);
    }

}
