package com.parkingmanager.controllers;

import com.parkingmanager.models.Place;
import com.parkingmanager.models.Utilisateur;
import com.parkingmanager.models.Voiture;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

import java.sql.SQLException;

public class AdministrationPageController {

    public TextField idVoiture;

    public TextField matriculeVoiture;

    public TextField dateVoiture;

    public TextField placeVoiture;

    public Button submitVoitureInsert;

    public Label insertStatus;

    public void submitVoitureInsertAction(ActionEvent actionEvent) throws SQLException {

        Voiture voiture = new Voiture();

        voiture.setId_voiture(Integer.parseInt(idVoiture.getText()));

        voiture.setMatricule(matriculeVoiture.getText());

        voiture.setPlace(Integer.parseInt(placeVoiture.getText()));

        voiture.setDate_entree(dateVoiture.getText());

        Place place = Place.findOnePlace(Integer.parseInt(placeVoiture.getText()));

        if(place != null){

            insertStatus.setTextFill(Color.RED);
            insertStatus.setFont(new Font(23));

            insertStatus.setText("Place occupée !");

        }else{

            Voiture.save(voiture);

            insertStatus.setTextFill(Color.GREEN);
            insertStatus.setFont(new Font(23));

            insertStatus.setText("Success");
        }


    }
}
