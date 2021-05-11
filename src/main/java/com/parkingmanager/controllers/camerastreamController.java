package com.parkingmanager.controllers;

import com.github.sarxos.webcam.Webcam;
import com.github.sarxos.webcam.WebcamDevice;
import com.github.sarxos.webcam.WebcamDriver;
import com.parkingmanager.App;
import com.parkingmanager.services.VideoFeed;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import com.parkingmanager.services.opencvvideofeed;

import java.util.List;

public class camerastreamController {
    @FXML public ImageView cameraStream;
    @FXML public Pane camPane;
    public static ImageView camstream=new ImageView();

    @FXML
    private void initialize() {
        camstream.setFitHeight(377);
        camstream.setFitWidth(670);

        VideoFeed vid=new VideoFeed(cameraStream);
        vid.start();

        //cameraStream = App.camStat;
        setImageViewSize();
    }

    protected void setImageViewSize() {

        double height = 576;
        double width = 1024;

        cameraStream.setFitHeight(height);
        cameraStream.setFitWidth(width);
        cameraStream.prefHeight(height);
        cameraStream.prefWidth(width);
        cameraStream.setPreserveRatio(true);

    }
}
