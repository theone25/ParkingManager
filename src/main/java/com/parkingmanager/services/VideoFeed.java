package com.parkingmanager.services;

import com.github.sarxos.webcam.Webcam;
import javafx.embed.swing.SwingFXUtils;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class VideoFeed extends Thread{
    Image img;
    ImageView imgview;
    Webcam cam;

    public VideoFeed(ImageView imgView,Webcam cam){
        this.imgview=imgView;
        this.cam=cam;
    }
    @Override
    public void run() {
        while(true){

            try {
                img=SwingFXUtils.toFXImage(cam.getImage(),null);
                imgview.setImage(img);
                Thread.sleep(15);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }


        }
    }
}
