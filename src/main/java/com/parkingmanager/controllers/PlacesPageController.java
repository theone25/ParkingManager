package com.parkingmanager.controllers;

import com.parkingmanager.App;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.TilePane;
import org.w3c.dom.events.MouseEvent;

public class PlacesPageController {
    @FXML
    TilePane placesPane;

    @FXML
    public void hoverPlace(AnchorPane place ,MouseEvent event)
    {
        place.setStyle("-fx-background-color: #121212");
    }

    @FXML
    private void initialize(){
        placesPane.setPrefColumns(2);
        placesPane.setPrefRows(2);
        placesPane.setVgap(10);
        placesPane.setHgap(10);
        for (int i = 0; i < 10; i++) {
            try {
                AnchorPane place =  FXMLLoader.load(App.class.getResource("views/customViews/slotView.fxml"));
                place.setOnMouseEntered(event -> {
                    place.setStyle("-fx-background-color: #121212");
                });
                place.setOnMouseExited(event -> {
                    place.setStyle("-fx-background-color: green");
                });
                Label lb= (Label) place.getChildren().get(0);
                lb.setText(String.valueOf(i));
                placesPane.getChildren().add(place);
            }catch (Exception e){

            }

        }



    }
}
