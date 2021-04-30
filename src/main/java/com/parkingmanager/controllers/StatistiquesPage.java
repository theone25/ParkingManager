package com.parkingmanager.controllers;

import com.parkingmanager.App;
import com.parkingmanager.models.Utilisateur;
import com.parkingmanager.models.Voiture;
import com.parkingmanager.models.query.QVoiture;
import com.parkingmanager.*;
import io.ebean.DB;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TabPane;
import javafx.scene.control.Tooltip;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import java.io.File;
import java.util.List;

public class StatistiquesPage extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {

        //List<Voiture> listVoitures = new QVoiture().findList();

        Utilisateur voiture = new Utilisateur();

        Utilisateur existedUser = Utilisateur.getUserByEmail("t@gmail.com");


//        int j=0;
//        while(listVoitures.get(j)!=null) {
            System.out.println(existedUser.toString());
//            j++;
//        }
        //ObservableList<Voiture> data= FXCollections.<Voiture>observableArrayList(listVoitures);

        //File file = new File("C:/Users/DELL/OneDrive/Projects/LP/ParkingManager1/ParkingManager/src/main/resources/com/parkingmanager/images/parc/1.jpg");



        FlowPane flow = new FlowPane();

        Label lab = new Label();


        for (int i = 0; i < 10; i++) {
            //flow.getChildren().add(buttons[i]);

            int I = i;



        }

        BorderPane border = new BorderPane();

        Image image3 = new Image(App.class.getResource("images/parc/rbi3.jpg").toString());

        ImageView iv7 = new ImageView(image3);


        ImageView iv8 = new ImageView(image3);

        border.setTop(iv7);
        border.setCenter(flow);

        lab.setTextFill(Color.YELLOW);
        lab.setFont(new Font(30));

        border.setBottom(lab);
        //border.setLeft(new Label("alikom"));

        Color color = Color.web("#585858");

        BackgroundFill fill = new BackgroundFill(color, new CornerRadii(1), new Insets(0,0,0,0));

        border.setBackground(new Background(fill));

//        FlowPane flow1 = new FlowPane(Orientation.VERTICAL);
//        flow1.setColumnHalignment(HPos.LEFT); // align labels on left
//        flow1.setPrefWrapLength(200); // preferred height = 200
//        for (int i = 0; i < titles.size(); i++) {
//            flow1.getChildren().add(new Label(titles[i]);
//        }
            //Text text = new Text(10, 40, "Hello World!");
            //text.setFont(new Font(40));
            Scene scene = new Scene(border, 1200, 800);



//        primaryStage.setScene(scene);
//        primaryStage.show();

        //public static void main(String[] args) {
            //Application.launch(args);
        //}


    }

    public static void main(String[] args) {
        launch();
    }
}
