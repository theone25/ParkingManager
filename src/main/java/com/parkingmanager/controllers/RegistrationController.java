package com.parkingmanager.controllers;

import com.parkingmanager.App;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.stage.Window;

public class RegistrationController extends Application {

    @FXML
    private TextField nameField;

    @FXML
    private TextField emailField;

    @FXML
    private PasswordField passwordField;

    @FXML
    private Button submitButton;

    @FXML
    protected void handleSubmitButtonAction(ActionEvent event) {
        Window owner = submitButton.getScene().getWindow();
        if(nameField.getText().isEmpty()) {
            System.out.println(
                    "Please enter your name");
            return;
        }
        if(emailField.getText().isEmpty()) {
            System.out.println(
                    "Please enter your email id");
            return;
        }
        if(passwordField.getText().isEmpty()) {
            System.out.println(
                    "Please enter a password");
            return;
        }

        System.out.println("Registration Successful!"+
                "Welcome " + nameField.getText());
    }

    @Override
    public void start(Stage primaryStage) throws Exception{

        Parent root = FXMLLoader.load(App.class.getResource("registration.fxml"));
        primaryStage.setTitle("Formulaire d'inscription");
        primaryStage.setScene(new Scene(root, 800, 500));
        primaryStage.show();

    }


    public static void main(String[] args) {
        launch(args);
    }

}
