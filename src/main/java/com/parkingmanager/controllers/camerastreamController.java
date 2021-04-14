package com.parkingmanager.controllers;

import com.github.sarxos.webcam.Webcam;
import com.github.sarxos.webcam.WebcamDevice;
import com.github.sarxos.webcam.WebcamDriver;
import com.parkingmanager.services.VideoFeed;
import javafx.application.Platform;
import javafx.embed.swing.SwingFXUtils;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javax.imageio.*;

import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.util.List;

public class camerastreamController {
    @FXML
    private ComboBox<String> cameraList;
    Webcam camera;
    @FXML private ImageView cameraStream;
    @FXML private Pane camPane;


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
                // code to show video feed from camera
                setImageViewSize();
                camera.open();

                VideoFeed vid=new VideoFeed(cameraStream,camera);
                vid.start();

            }
        };
        cameraList.setOnAction(event);
    }


    protected void setImageViewSize() {

        double height = camPane.getHeight();
        double width = camPane.getWidth();

        cameraStream.setFitHeight(height);
        cameraStream.setFitWidth(width);
        cameraStream.prefHeight(height);
        cameraStream.prefWidth(width);
        cameraStream.setPreserveRatio(true);

    }



}
