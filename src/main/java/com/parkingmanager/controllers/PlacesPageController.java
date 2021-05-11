package com.parkingmanager.controllers;

import com.parkingmanager.App;
import com.parkingmanager.models.Parking;
import com.parkingmanager.models.Place;
import com.parkingmanager.models.query.QParking;
import com.parkingmanager.models.query.QPlace;
import io.ebean.DB;
import io.ebean.SqlRow;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.Tooltip;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.TilePane;
import javafx.stage.PopupWindow;
import javafx.util.Duration;

import java.awt.*;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PlacesPageController {
    @FXML
    TilePane placesPane;
    @FXML
    ComboBox<String> parkingList;
    @FXML Label matricule;
    @FXML Label dateentree;
    List<SqlRow> parkplaces;
    private static final String SQUARE_BUBBLE =
            "M24 1h-24v16.981h4v5.019l7-5.019h13z";

    private Tooltip makeBubble(Tooltip tooltip) {
        tooltip.setStyle("-fx-font-size: 16px; -fx-shape: \"" + SQUARE_BUBBLE + "\";");
        tooltip.setAnchorLocation(PopupWindow.AnchorLocation.WINDOW_BOTTOM_LEFT);
        tooltip.setShowDelay(Duration.millis(100));
        return tooltip;
    }

    @FXML
    private void initialize(){
        matricule.setVisible(false);
        dateentree.setVisible(false);
        List<Parking> listparking =new QParking().findList();

        for(Parking park : listparking) {
            parkingList.getItems().add(park.getNom());
        }

        EventHandler<ActionEvent> event = new EventHandler<ActionEvent>() {
            public void handle(ActionEvent e)
            {
                Parking park= new QParking().nom.equalTo(parkingList.getValue()).findOne();
                String reqsql="select * from voiture v right join place p on p.ID_PLACE=v.place where Date_sortie is null and p.ID_PARKING= :id";
                parkplaces= DB.sqlQuery(reqsql).setParameter("id", park.getId_parking()).findList();
                getPlaces();
            }
        };
        parkingList.setOnAction(event);

    }

    public void getPlaces(){
        placesPane.setPrefColumns(2);
        placesPane.setPrefRows(2);
        placesPane.setVgap(10);
        placesPane.setHgap(10);
        placesPane.getChildren().clear();
        for(SqlRow p :parkplaces){
            try {
                AnchorPane place =  FXMLLoader.load(App.class.getResource("views/customViews/slotView.fxml"));
                Label lb= (Label) place.getChildren().get(0);
                lb.setText(String.valueOf(p.getString("ID_PLACE")));
                ImageView imv= (ImageView) ((Pane) place.getChildren().get(1)).getChildren().get(0);
                if(p.getBoolean("libre")==false){
                    imv.setImage(new Image(App.class.getResource("images/parc/1.jpg").toString()));
                }
                else {
                    imv.setImage(new Image(App.class.getResource("images/parc/parkPlace.jpg").toString()));
                }
                place.setOnMouseClicked(e->{
                    matricule.setVisible(true);
                    dateentree.setVisible(true);
                    matricule.setText(p.getString("MATRICULE"));
                    dateentree.setText(p.getString("Date_entree"));
                });
                placesPane.getChildren().add(place);
            }catch (Exception e){

            }
        }
    }
}
