package com.parkingmanager.controllers;

import com.github.sarxos.webcam.Webcam;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.image.ImageView;

public class camerastreamController {
    @FXML
    private ComboBox<String> cameraList;
    Webcam camera;
    @FXML private ImageView cameraStream;


    @FXML
    private void initialize() {
        if (Webcam.getWebcams() != null) {
            for(Webcam cam : Webcam.getWebcams()) {
                cameraList.getItems().add(cam.getName());
            }

        } else {
            System.out.println("No webcam detected");
        }

        EventHandler<ActionEvent> event = new EventHandler<ActionEvent>() {
            public void handle(ActionEvent e)
            {
                camera = Webcam.getWebcamByName(cameraList.getValue());
            }
        };
        cameraList.setOnAction(event);

    }
}
