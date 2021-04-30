package com.parkingmanager;

//import com.parkingmanager.models.Utilisateur;
import com.parkingmanager.models.query.QUtilisateur;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import io.ebean.DB;

import java.io.IOException;
import java.util.List;

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

    public static Scene loadScene(String fxml, double w, double h) throws IOException {

        return new Scene(loadFXML(fxml), w, h);
    }

    public static Scene loadScene(String fxml) throws IOException {

        return new Scene(loadFXML(fxml));
    }

    public static Stage loadStage(Scene scene, String title) throws IOException {
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.setTitle(title);
        return stage;
    }

    private static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml + ".fxml"));
        return fxmlLoader.load();
    }

    public static void main(String[] args) {
        DB.getDefault();
        launch();
    }

}