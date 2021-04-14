package com.parkingmanager.controllers;

import com.parkingmanager.App;
import com.parkingmanager.models.Utilisateur;
import com.parkingmanager.services.AuthManager;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.stage.Window;

import java.io.IOException;
import java.sql.SQLException;
import java.util.HashMap;

public class RegistrationController extends Application {

    @FXML
    private TextField nameField;
    @FXML
    private TextField lastNameField;

    @FXML
    private TextField emailField;

    @FXML
    private PasswordField passwordField;

    @FXML
    private Text errorsBox;

    @FXML
    private Button submitButton;

    @FXML
    protected void handleSubmitButtonAction(ActionEvent event) throws SQLException, IOException {
        Stage owner =(Stage) submitButton.getScene().getWindow();
        errorsBox.setText("");
        if (nameField.getText().isEmpty()) {
            errorsBox.setText("Please enter your name");
            return;
        }
        if (lastNameField.getText().isEmpty()) {
            errorsBox.setText(
                    "Please enter your last name");
            return;
        }
        if (emailField.getText().isEmpty()) {
            errorsBox.setText(
                    "Please enter your email");
            return;
        }
        if (passwordField.getText().isEmpty()) {
            errorsBox.setText(
                    "Please enter a password");
            return;

        }

        AuthManager auth = AuthManager.getDefaultInstance();

        Utilisateur user = new Utilisateur();
        user.setNom(nameField.getText());
        user.setPrenom(lastNameField.getText());
        user.setEmail(emailField.getText());
        user.setPassword(passwordField.getText());

        auth.register(user);
        HashMap errors = auth.getErrors();
        if (!errors.isEmpty()) {
            errors.forEach((k, v) -> errorsBox.setText(errorsBox.getText() + "\n" + errors.get(k).toString()));
        }else{
            owner.close();
            //App.loadStage(App.loadScene("loginPage"),"Login").show();
        }


    }

    @Override
    public void start(Stage primaryStage) throws Exception {

        Parent root = FXMLLoader.load(App.class.getResource("registration.fxml"));
        primaryStage.setTitle("Formulaire d'inscription");
        primaryStage.setScene(new Scene(root, 800, 500));
        primaryStage.show();

    }


    public static void main(String[] args) {
        launch(args);
    }

}
