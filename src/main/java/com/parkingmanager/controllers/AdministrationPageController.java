package com.parkingmanager.controllers;

import com.parkingmanager.models.*;
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

    public TextField idplace;
    
    public TextField idParking;
    
    public TextField numPlace;
    
    public Button submitPlaceInsert;

    public Label insertPlaceStatus;

    public Label insertVoitureStatus;

    public TextField idticket;

    public TextField idvoiture_ticket;

    public TextField idplace_ticket;

    public TextField datedentree;

    public Button submitTicketInsert;

    public Label insertTicketStatus;

    public void submitVoitureInsertAction(ActionEvent actionEvent) throws SQLException {

        Voiture voiture = new Voiture();

        voiture.setId_voiture(Integer.parseInt(idVoiture.getText()));

        voiture.setMatricule(matriculeVoiture.getText());

        voiture.setPlace(Integer.parseInt(placeVoiture.getText()));

        voiture.setDate_entree(dateVoiture.getText());

        Voiture place = Voiture.findPlaceTaken(Integer.parseInt(placeVoiture.getText()));

        if(place != null){

            insertVoitureStatus.setTextFill(Color.RED);
            insertVoitureStatus.setFont(new Font(23));

            insertVoitureStatus.setText("Place occupée !");

        }else{

            Voiture.save(voiture);

            insertVoitureStatus.setTextFill(Color.GREEN);
            insertVoitureStatus.setFont(new Font(23));

            insertVoitureStatus.setText("Success !");
        }


    }

    public void submitPlaceInsertAction(ActionEvent actionEvent) throws SQLException {

        Place place = new Place();

        place.setId_place(Integer.parseInt(idplace.getText()));

        place.setId_parking(Integer.parseInt(idParking.getText()));

        place.setNumero(Integer.parseInt(numPlace.getText()));

        Place.save(place);

        insertPlaceStatus.setTextFill(Color.GREEN);
        insertPlaceStatus.setFont(new Font(23));

        insertPlaceStatus.setText("Success !");

    }

    public void submitTicketInsertAction(ActionEvent actionEvent) throws SQLException {

        Ticket ticket = new Ticket();

        ticket.setId_ticket(Integer.parseInt(idticket.getText()));

        ticket.setId_place(Integer.parseInt(idplace_ticket.getText()));

        ticket.setId_voiture(Integer.parseInt(idvoiture_ticket.getText()));

        Ticket.save(ticket);

        insertTicketStatus.setTextFill(Color.GREEN);
        insertTicketStatus.setFont(new Font(23));

        insertTicketStatus.setText("Success !");

    }
}
