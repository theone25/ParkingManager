package com.parkingmanager;

//import com.parkingmanager.models.Utilisateur;
import com.parkingmanager.controllers.camerastreamController;
import com.parkingmanager.models.query.QUtilisateur;
import com.parkingmanager.services.opencvvideofeed;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import io.ebean.DB;
import org.opencv.core.Core;
import org.opencv.dnn.Dnn;
import org.opencv.dnn.Net;
import org.opencv.imgcodecs.Imgcodecs;

import java.io.File;
import java.io.IOException;
import java.util.List;

/**
 * JavaFX App
 */
public class App extends Application {
    //String modelWeights = "C:\\Users\\moham\\Documents\\GitHub\\ParkingManageree\\src\\main\\resources\\com\\parkingmanager\\custom.weights";
    //String modelConfiguration = "C:\\Users\\moham\\Documents\\GitHub\\ParkingManageree\\src\\main\\resources\\com\\parkingmanager\\yolov4.cfg";
    String path = new File("").getAbsolutePath();
    String modelWeights = path+File.separator +"src"+File.separator +"main"+File.separator +"resources"+File.separator +"com"+File.separator +"parkingmanager"+File.separator +"yolov3-obj_final.weights";
    String modelConfiguration = path+File.separator +"src"+File.separator +"main"+File.separator +"resources"+File.separator +"com"+File.separator +"parkingmanager"+File.separator +"yolov3-obj.cfg";
    public static Net net;
    @Override
    public void start(Stage stage) throws IOException {
        //JMetro jMetro = new JMetro(Style.LIGHT);

        Scene scene = new Scene(loadFXML("loginPage"), 600, 400);
        //jMetro.setScene(scene);

        stage.setScene(scene);
        stage.setTitle("Parking Manager");

        stage.show();
        startddn();



    }

    public void startddn(){
        net = Dnn.readNetFromDarknet(modelConfiguration, modelWeights);

        System.out.println("ddn loaded");
        opencvvideofeed vid=new opencvvideofeed();
        vid.start();





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
        System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
        launch();
        camerastreamController.camstream.setFitWidth(670);
        camerastreamController.camstream.setFitHeight(377);

    }

}