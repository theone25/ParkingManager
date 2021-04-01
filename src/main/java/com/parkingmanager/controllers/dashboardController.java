package com.parkingmanager.controllers;

import at.favre.lib.crypto.bcrypt.BCrypt;
import com.parkingmanager.App;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;

import java.io.IOException;

public class dashboardController {

    public Button button1;
    public Button button2;
    public Button button3;
    public Button button4;
    public Button button5;
    public Button button6;

    @FXML Pane mainPane;

    @FXML
    private void initialize() {
        try {
            Pane cameraStreamPane =  FXMLLoader.load(App.class.getResource("views/homePage.fxml"));
            mainPane.getChildren().clear();
            mainPane.getChildren().add(cameraStreamPane);

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public void GetCameraStream(){
        try {
            Pane cameraStreamPane =  FXMLLoader.load(App.class.getResource("views/cameraStream.fxml"));
            mainPane.getChildren().clear();
            mainPane.getChildren().add(cameraStreamPane);

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
    public void GetHomePage(){
        try {
            Pane cameraStreamPane =  FXMLLoader.load(App.class.getResource("views/homePage.fxml"));
            mainPane.getChildren().clear();
            mainPane.getChildren().add(cameraStreamPane);

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
    public void GetPlacesPage(){
        try {
            Pane cameraStreamPane =  FXMLLoader.load(App.class.getResource("views/placesPage.fxml"));
            mainPane.getChildren().clear();
            mainPane.getChildren().add(cameraStreamPane);

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }



    public void testfunction(){
        String password = "1234";
        String bcryptHashString = BCrypt.withDefaults().hashToString(12, password.toCharArray());
        // $2a$12$US00g/uMhoSBm.HiuieBjeMtoN69SN.GE25fCpldebzkryUyopws6

        BCrypt.Result result = BCrypt.verifyer().verify(password.toCharArray(), bcryptHashString);
        // result.verified == true
    }
}
