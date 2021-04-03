package com.parkingmanager.controllers;

import java.io.IOException;
import java.sql.SQLException;
import java.util.HashMap;

import com.parkingmanager.App;
import com.parkingmanager.dao.TestDB;
import com.parkingmanager.services.AuthManager;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;
import javafx.stage.Stage;


public class loginpageController {
    @FXML
    private Button loginButton;
    @FXML
    ImageView imageAvatar;

    @FXML
    private TextField email;
    @FXML
    private PasswordField password;

    @FXML
    private Text errorBox;

    public Button getLoginButton() {
        return loginButton;
    }

    public void addError(String key, HashMap errors) {
        if (errors.containsKey(key)) {
            errorBox.setText(errorBox.getText() +"\n" + errors.get(key).toString());
        }

    }

    public void shiftFocus(){
        password.requestFocus();
    }

  public void connectClick() {
        AuthManager auth = AuthManager.getDefaultInstance();
        errorBox.setText("");
        try {
            auth.authenticate(email.getText(), password.getText());
            HashMap errors = auth.getErrors();
            if (!errors.isEmpty()) {
                addError("email", errors);
                addError("password", errors);
                return;
            }

            Stage LoginStage = (Stage) loginButton.getScene().getWindow();
            LoginStage.close();

            FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("dashboard" + ".fxml"));
            Scene scene = new Scene(fxmlLoader.load());
            //jMetro.setScene(scene);
            Stage dashboard = new Stage();
            dashboard.setScene(scene);
            dashboard.setTitle("Parking Manager");
            TestDB db = new TestDB();
//            opendb.open();
//            db.test();
//            db.close();


            dashboard.show();

        } catch (IOException | SQLException e) {
            System.out.println(e.getMessage());
        }
    }


    public void registerClick(ActionEvent actionEvent) {
        Parent root;

        try {
            FXMLLoader loader = new FXMLLoader(App.class.getResource("registration.fxml"));
            root=(Parent) loader.load();
            Stage stage = new Stage();
            stage.setTitle("s'inscrire");
            stage.setScene(new Scene(root, 600, 400));
            stage.show();

        }
        catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
