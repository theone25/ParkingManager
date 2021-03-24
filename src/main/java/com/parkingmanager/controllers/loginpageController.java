package com.parkingmanager.controllers;

import java.io.IOException;

import com.parkingmanager.App;
import com.parkingmanager.dao.HelperDB;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;


public class loginpageController {
    @FXML
    private Button loginButton;
    @FXML
    ImageView imageAvatar;

    public Button getLoginButton() {
        return loginButton;
    }

    public void connectClick(){
        try {
            Stage stage = (Stage) loginButton.getScene().getWindow();
            stage.close();

            FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("dashboard" + ".fxml"));
            Scene scene = new Scene(fxmlLoader.load());
            //jMetro.setScene(scene);
            Stage dashboard=new Stage();
            dashboard.setScene(scene);
            dashboard.setTitle("Parking Manager");
            HelperDB db=new HelperDB();
            db.open();
            db.test();
            db.close();



            dashboard.show();

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
