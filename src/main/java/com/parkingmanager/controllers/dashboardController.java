package com.parkingmanager.controllers;

import at.favre.lib.crypto.bcrypt.BCrypt;
import com.parkingmanager.App;
import com.parkingmanager.models.Utilisateur;
import com.parkingmanager.models.Voiture;
import com.parkingmanager.models.query.QVoiture;
import com.parkingmanager.services.*;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Tooltip;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class dashboardController {

    public Button button1;
    public Button button2;
    public Button button3;
    public Button button4;
    public Button button5;
    public Button button6;

    @FXML Pane mainPane;
    @FXML
     ImageView avatar;
    @FXML
    Label fullname;

    @FXML
    private void initialize() {

        AuthManager auth=AuthManager.getDefaultInstance();
        Utilisateur user =auth.getAuthenticatedUser();

        fullname.setText(user.getNom()+" "+user.getPrenom());

        try {
            Pane pane =  FXMLLoader.load(App.class.getResource("views/homePage.fxml"));
            mainPane.getChildren().clear();
            mainPane.getChildren().add(pane);

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public void GetCameraStream(){
        try {
            Pane pane =  FXMLLoader.load(App.class.getResource("views/cameraStream.fxml"));
            mainPane.getChildren().clear();
            mainPane.getChildren().add(pane);

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
    public void GetHomePage(){
        try {
            Pane pane =  FXMLLoader.load(App.class.getResource("views/homePage.fxml"));
            mainPane.getChildren().clear();
            mainPane.getChildren().add(pane);

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
    public void GetPlacesPage(){
        try {
            Pane pane =  FXMLLoader.load(App.class.getResource("views/placesPage.fxml"));
            mainPane.getChildren().clear();
            mainPane.getChildren().add(pane);

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
    public void GetVehiculesPage(){
        try {
            Pane pane =  FXMLLoader.load(App.class.getResource("views/vehiculesPage.fxml"));
            mainPane.getChildren().clear();
            mainPane.getChildren().add(pane);

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
    public void GetStatistiquesPage() throws SQLException {

            //Pane pane =  FXMLLoader.load(App.class.getResource("views/statistiquesPage.fxml"));
            //File file = new File("C:/Users/DELL/OneDrive/Projects/LP/ParkingManager1/ParkingManager/src/main/resources/com/parkingmanager/images/parc/1.jpg");
            Image image = new Image(App.class.getResource("images/parc/1.jpg").toString());
            Image image2 = new Image(App.class.getResource("images/parc/2.jpg").toString());
            ImageView iv = new ImageView(image);
            ImageView iv1 = new ImageView(image2);
            ImageView iv2 = new ImageView(image2);
            ImageView iv3 = new ImageView(image2);
            ImageView iv4 = new ImageView(image2);
            ImageView iv5 = new ImageView(image2);
            ImageView iv6 = new ImageView(image2);
            ImageView iv7 = new ImageView(image2);


//        Button ivb = new Button();
//        Button iv1b = new Button();
//        Button iv2b = new Button();
//        Button iv3b = new Button();
//        Button iv4b = new Button();
//        Button iv5b = new Button();
//        Button iv6b = new Button();
//        Button iv7b = new Button();

            ImageView images[] = {iv, iv1, iv2, iv3, iv4, iv5, iv6, iv7 };



            FlowPane flow = new FlowPane();

            //flow.setVgap(8);
            //flow.setHgap(4);

            flow.setPrefWrapLength(300); // preferred width = 300
            for (int i = 0; i < images.length; i++) {
                //flow.getChildren().add(buttons[i]);

                flow.getChildren().add(images[i]);

            }


            BorderPane border = new BorderPane();

            Image image3 = new Image(App.class.getResource("images/parc/rbi3.jpg").toString());

            ImageView iv70 = new ImageView(image3);

            ImageView iv80 = new ImageView(image3);

            border.setTop(iv70);
            border.setCenter(flow);




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

            iv70.fitWidthProperty().bind(mainPane.widthProperty());
            iv80.fitWidthProperty().bind(mainPane.widthProperty());


//        primaryStage.setScene(scene);
//        primaryStage.show();

            //public static void main(String[] args) {
            //Application.launch(args);
            //}


            mainPane.getChildren().clear();
            mainPane.getChildren().add(border);
            mainPane.getChildren().add(new Label());


    }


        public void testfunction(){
        String password = "1234";
        String bcryptHashString = BCrypt.withDefaults().hashToString(12, password.toCharArray());
        // $2a$12$US00g/uMhoSBm.HiuieBjeMtoN69SN.GE25fCpldebzkryUyopws6

        BCrypt.Result result = BCrypt.verifyer().verify(password.toCharArray(), bcryptHashString);
        // result.verified == true
    }
}
