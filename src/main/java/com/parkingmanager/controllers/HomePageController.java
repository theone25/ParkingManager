package com.parkingmanager.controllers;

import com.parkingmanager.models.Utilisateur;
import com.parkingmanager.models.Voiture;
import com.parkingmanager.models.query.QUtilisateur;
import com.parkingmanager.models.query.QVoiture;
import io.ebean.DB;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
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
    Label used,free;



    @FXML
    private void initialize(){
        String freereq="select count(*) as libre from place where libre=true ";
        String usedreq="select count(*) as nonlibre from place where libre=false ";
        free.setText(String.valueOf(DB.sqlQuery(freereq).findOne().getInteger("libre")));
        used.setText(String.valueOf(DB.sqlQuery(usedreq).findOne().getInteger("nonlibre")));

        data = FXCollections.observableArrayList();
        /*List<Utilisateur> listUser= new QUtilisateur().findList();
        colid.setCellValueFactory(new PropertyValueFactory<Utilisateur, Integer>("id"));
        colnom.setCellValueFactory(new PropertyValueFactory<Utilisateur, String>("nom"));
        colpre.setCellValueFactory(new PropertyValueFactory<Utilisateur, String>("prenom"));
        colem.setCellValueFactory(new PropertyValueFactory<Utilisateur, String>("email"));
        ObservableList<Utilisateur> data = FXCollections.<Utilisateur>observableArrayList(listUser);

        tableHome.getItems().setAll(data);*/

        List<Voiture> listVoitures =new QVoiture().orderBy().Date_entree.desc().findList();
        colid.setCellValueFactory(new PropertyValueFactory<Voiture, Integer>("id_voiture"));
        colim.setCellValueFactory(new PropertyValueFactory<Voiture, String>("matricule"));
        coldate.setCellValueFactory(new PropertyValueFactory<Voiture, String>("date_entree"));
        //coltik.setCellFactory(new PropertyValueFactory<Voiture,Boolean>("ticket_payed"));
        ObservableList<Voiture> data=FXCollections.<Voiture>observableArrayList(listVoitures);

        tableHome.getItems().setAll(data);
    }

}
