package com.parkingmanager.controllers;

import at.favre.lib.crypto.bcrypt.BCrypt;
import com.parkingmanager.App;
import com.parkingmanager.dao.HelperDB;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;

public class dashboardController {

    public Button button1;
    public Button button2;
    public Button button3;
    public Button button4;
    public Button button5;
    public Button button6;

    @FXML Pane mainPane;

    public void GetCameraStream(){
        try {
            Pane cameraStreamPane =  FXMLLoader.load(App.class.getResource("views/cameraStream.fxml"));

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
