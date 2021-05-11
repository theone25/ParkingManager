package com.parkingmanager.services;

import com.github.sarxos.webcam.Webcam;
import com.parkingmanager.controllers.camerastreamController;
import javafx.embed.swing.SwingFXUtils;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class VideoFeed extends Thread{
    Image img;
    ImageView imgview;

    public VideoFeed(ImageView imgView){
        this.imgview=imgView;
    }
    @Override
    public void run() {
        while(true){
            imgview.setImage( opencvvideofeed.imgview.getImage());
        }
    }
}
