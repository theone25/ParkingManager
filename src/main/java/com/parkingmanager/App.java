package com.parkingmanager;

//import com.parkingmanager.services.AuthManager;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.Background;
import javafx.stage.Stage;
//import jfxtras.styles.jmetro.JMetro;
//import jfxtras.styles.jmetro.Style;

import java.io.IOException;

/**
 * JavaFX App
 */
public class App extends Application {

    @Override
    public void start(Stage stage) throws IOException {
        //JMetro jMetro = new JMetro(Style.LIGHT);

        Scene scene = new Scene(loadFXML("loginPage"), 600, 400);
        //jMetro.setScene(scene);

        stage.setScene(scene);
        stage.setTitle("Parking Manager");

        stage.show();


    }


    private static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml + ".fxml"));
        return fxmlLoader.load();
    }

    public static void main(String[] args) {
        launch();
    }

}