package com.parkingmanager.controllers;

import com.parkingmanager.App;
import com.parkingmanager.models.Utilisateur;
import com.parkingmanager.services.*;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.Tooltip;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.stage.Window;

import java.io.File;
import java.io.IOException;
import java.net.URL;
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
            App.loadStage(App.loadScene("loginPage"),"Login").show();
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

    public void actionImage(ActionEvent actionEvent) throws SQLException, IOException {


        final FileChooser fileChooser = new FileChooser();

        final Button openButton = new Button("Choose Background Image");

            File file = fileChooser.showOpenDialog(new Stage());

            if (file != null) {
                // openFile(file);

                // where my problem is
                Image image1 = new Image(file.toURI().toString());

                String cwd = System. getProperty("user.dir");

                String er = new File(cwd).toURI().relativize(file.toURI()).getPath();

                String path = er;

                URL baseURL = App.class.getResource("");

                String base = baseURL.toString();
                String relative = new File(base).toURI().relativize(new File(path).toURI()).getPath();

                System.out.println("er = "+er);
                System.out.println("relative = "+relative);
                System.out.println("baseURL = "+baseURL);

                String filename = file.getName();

                System.out.println("lAST File, file name is = "+filename);

                AuthManager auth = AuthManager.getDefaultInstance();

                Utilisateur user2 = new Utilisateur();

                user2.setNom(nameField.getText());
                user2.setPrenom(lastNameField.getText());
                user2.setEmail(emailField.getText());
                user2.setPassword(passwordField.getText());
                user2.setImage(filename);


                Stage owner =(Stage) submitButton.getScene().getWindow();

                auth.register(user2);

                HashMap errors = auth.getErrors();

                if (!errors.isEmpty()) {
                    errors.forEach((k, v) -> errorsBox.setText(errorsBox.getText() + "\n" + errors.get(k).toString()));
                }else{
                    owner.close();
                    App.loadStage(App.loadScene("loginPage"),"Login").show();
                }

                System.out.println(er);

                //System.out.println(file.toURI().toString());
                // what I tried to do
                // Image image1 = new Image(file);

                ImageView ip = new ImageView(image1);

                //Tooltip tooltip = new Tooltip();
                //tooltip.setText(file.toURI().toString());
                //tooltip.show(stage);

                //BackgroundSize backgroundSize = new BackgroundSize(100, 100, true, true, true, false);
                //BackgroundImage backgroundImage = new BackgroundImage(image1, BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, backgroundSize);
            }
    }


}
