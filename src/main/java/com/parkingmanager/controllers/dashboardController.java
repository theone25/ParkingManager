package com.parkingmanager.controllers;

import at.favre.lib.crypto.bcrypt.BCrypt;
import com.parkingmanager.App;
import com.parkingmanager.models.Parking;
import com.parkingmanager.models.Place;
import com.parkingmanager.models.Utilisateur;
import com.parkingmanager.models.Voiture;
import com.parkingmanager.models.query.QVoiture;
import com.parkingmanager.services.*;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
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

        AuthManager auth = AuthManager.getDefaultInstance();
        Utilisateur user = auth.getAuthenticatedUser();

        fullname.setText(user.getNom()+" "+user.getPrenom());

        String img = user.getImage();

        System.out.println("img = "+img);

        if(img != null) {

            if ( user.getImage().contains(App.class.getResource("images/userImages/").toString())) {
                ImageView imageView = new ImageView(new Image(App.class.getResource("images/userImages/" + user.getImage()).toString()));

                avatar.setImage(imageView.getImage());
            }
        }
        else{

            ImageView imageView = new ImageView(new Image(App.class.getResource("images/userImages/noavatar.png").toString()));

            avatar.setImage(imageView.getImage());
        }

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

            ImageView images[]; //= {iv, iv1, iv2, iv3, iv4, iv5, iv6, iv7 };

            Tooltip tooltip = new Tooltip("salam");

        //Voiture voiture = Voiture.getVoitureById(1);

        List<Voiture> listVoitures = Voiture.getAllVoitures();

        List<Place> place = Place.getPlaces();

        int j=0;

//        while(j < place.size()) {
//
//            System.out.println(place.get(j).toString());
//            j++;
//        }

            FlowPane flow = new FlowPane();

            Label lab = new Label("Veuillez pointer sur les voitures");

            lab.setFont(new Font(30));
            lab.setTextFill(Color.YELLOW);

            Label lab2 = new Label("Cliquez pour plus de détails");

            lab2.setFont(new Font(30));
            lab2.setTextFill(Color.RED);


            ImageView images2 = new ImageView(new Image(App.class.getResource("images/parc/test.jpg").toString()));
            ImageView images3 = new ImageView(new Image(App.class.getResource("images/parc/test.jpg").toString()));
            ImageView images4 = new ImageView(new Image(App.class.getResource("images/parc/test.jpg").toString()));
            ImageView images5 = new ImageView(new Image(App.class.getResource("images/parc/test.jpg").toString()));
            ImageView images6 = new ImageView(new Image(App.class.getResource("images/parc/test.jpg").toString()));
            ImageView images7 = new ImageView(new Image(App.class.getResource("images/parc/test.jpg").toString()));
            ImageView images8 = new ImageView(new Image(App.class.getResource("images/parc/test.jpg").toString()));
            ImageView images9 = new ImageView(new Image(App.class.getResource("images/parc/test.jpg").toString()));
            ImageView images10 = new ImageView(new Image(App.class.getResource("images/parc/test.jpg").toString()));

            ImageView images30[]; //= {images2, images3, images4, images5, images6, images7, images8, images9, images10};

            //flow.setVgap(8);
            //flow.setHgap(4);

        int s = 0;

            flow.setPrefWrapLength(300);

            int t = place.size();
            int d = listVoitures.size();

            images30 = new ImageView[t];

            int i=0;

            while(i < t) {
                //flow.getChildren().add(buttons[i]);

                int I = i;

                images30[s] = new ImageView(new Image(App.class.getResource("images/parc/test.jpg").toString()));

                if(i<d) {

                    images = new ImageView[d];
                    images[i] = new ImageView(new Image(App.class.getResource("images/parc/1.jpg").toString()));

                    images[i].setOnMouseEntered(event -> {

                        //tooltip.setText("image num "+ I);
                        lab.setText("Id: "+Integer.toString(listVoitures.get(I).getId_voiture()));
                        //tooltip.show(primaryStage);
                    });

                    images[i].setOnMouseExited(event -> {

                        //lab.setVisible(false);
                    });

                    images[i].setOnMouseClicked(event -> {

                        lab2.setText("Matricule: "+listVoitures.get(I).getMatricule());
                        lab2.setFont(new Font(30));
                        lab2.setTextFill(Color.RED);

                    });

                    flow.getChildren().add(images[i]);

                }else{

                    images30[s].setOnMouseEntered(event -> {

                        lab.setVisible(true);

                        //tooltip.setText("image num "+ I);
                        lab.setText("Id: "+Integer.toString(place.get(I).getId_place()));
                        //tooltip.show(primaryStage);
                    });

                    images30[s].setOnMouseExited(event -> {

                        //lab.setVisible(false);
                    });

                    images30[s].setOnMouseClicked(event -> {

                        lab2.setText("Numéro: "+Integer.toString(place.get(I).getNumero()));
                        lab2.setFont(new Font(30));
                        lab2.setTextFill(Color.RED);

                    });

                    flow.getChildren().add(images30[s]);
                    s++;
                }
                i++;

            }

            flow.getChildren().add(lab);

            BorderPane border = new BorderPane();

            Image image3 = new Image(App.class.getResource("images/parc/tri9.jpg").toString());

            ImageView iv70 = new ImageView(image3);

            ImageView iv80 = new ImageView(image3);

            HBox sti = new HBox();

            VBox mehz = new VBox();

            mehz.getChildren().add(iv70);

            Label lab3 = new Label("Nb places occupées : "+d);
            Label lab4 = new Label("Nb places libres : "+(t-d));

            HBox ff = new HBox();


            lab3.setFont(new Font(30));
            lab4.setFont(new Font(30));
            lab3.setTextFill(Color.YELLOW);
            lab4.setTextFill(Color.RED);

            ff.setSpacing(200);

            ff.alignmentProperty().setValue(Pos.CENTER);

            ff.getChildren().add(lab3);
            ff.getChildren().add(lab4);

            mehz.getChildren().add(ff);

            border.setTop(mehz);


            border.setCenter(flow);

            lab.setTextFill(Color.YELLOW);
            lab.setFont(new Font(30));
            sti.getChildren().add(lab);
            sti.getChildren().add(lab2);
            sti.setSpacing(50);

            HBox hBox = new HBox();

            hBox.getChildren().add(sti);

            hBox.alignmentProperty().setValue(Pos.CENTER);

            border.setBottom(hBox);
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
