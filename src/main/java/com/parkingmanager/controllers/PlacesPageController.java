package com.parkingmanager.controllers;

import com.parkingmanager.App;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.control.Tooltip;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.TilePane;
import javafx.stage.PopupWindow;
import javafx.util.Duration;
import org.w3c.dom.events.MouseEvent;

public class PlacesPageController {
    @FXML
    TilePane placesPane;
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
                Tooltip.install(place,makeBubble(new Tooltip(String.valueOf("ggggggggggggggggggggggggggggggggggggggggggggg"))));
                lb.setText(String.valueOf(i));
                placesPane.getChildren().add(place);
            }catch (Exception e){

            }

        }



    }
}
