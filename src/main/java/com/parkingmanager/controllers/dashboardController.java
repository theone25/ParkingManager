package com.parkingmanager.controllers;

import at.favre.lib.crypto.bcrypt.BCrypt;
import com.parkingmanager.*;

import com.parkingmanager.models.*;
import com.parkingmanager.models.query.QVoiture;
import com.parkingmanager.services.*;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.SnapshotParameters;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TabPane;
import javafx.scene.control.Tooltip;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.image.WritableImage;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class dashboardController {

    public Button button1;
    public Button button2;
    public Button button3;
    public Button button4;
    public Button button5;
    public Button button6;

    private VBox mehz = new VBox();

    private HBox mehz2 = new HBox();

    @FXML Pane mainPane;
    @FXML
    ImageView avatar;
    @FXML
    Label fullname;

    @FXML
    private void initialize() {

        AuthManager auth = AuthManager.getDefaultInstance();
        Utilisateur user = auth.getAuthenticatedUser();

        Rectangle clip = new Rectangle(avatar.getFitWidth(), avatar.getFitHeight());
        clip.setArcWidth(60);
        clip.setArcHeight(60);
        avatar.setClip(clip);

        SnapshotParameters parameters = new SnapshotParameters();
        parameters.setFill(Color.TRANSPARENT);

        if(user==null){
            fullname.setText("USER");
        }else{
            fullname.setText(user.getNom()+" "+user.getPrenom());
        }
        String img = user.getImage();


        if(img != null) {

            if ( user.getImage().contains(App.class.getResource("images/userImages/").toString())) {
                ImageView imageView = new ImageView(new Image(App.class.getResource("images/userImages/" + user.getImage()).toString()));
                WritableImage image = avatar.snapshot(parameters, null);
                avatar.setImage(imageView.getImage());

            }
        }
        else{

            ImageView imageView = new ImageView(new Image(App.class.getResource("images/userImages/noavatar.png").toString()));
            WritableImage image = avatar.snapshot(parameters, null);
            avatar.setImage(imageView.getImage());
        }

        try {
            Pane pane =  FXMLLoader.load(App.class.getResource("views/homePage.fxml"));
            mainPane.getChildren().clear();
            mainPane.getChildren().add(pane);

        } catch (IOException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }

    public void GetCameraStream(){

        try {
            Pane pane =  FXMLLoader.load(App.class.getResource("views/cameraStream.fxml"));
            mainPane.getChildren().clear();
            mainPane.getChildren().add(pane);

        } catch (IOException e) {
            e.printStackTrace();
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
            e.printStackTrace();
        }
    }

    public void init() throws SQLException {

        List<Parking> parking = Parking.getParkings();

        BorderPane borderPane = showParking(parking.get(0).getId_parking());

        mainPane.getChildren().clear();
        mainPane.getChildren().add(borderPane);
        mainPane.getChildren().add(new Label());
    }

    public void setParcs() throws SQLException {

        List<Parking> parking = Parking.getParkings();

        int h=0;

        ArrayList <Label> par = new ArrayList<>(parking.size());

        //HBox pp = new HBox();

        mehz2.getChildren().clear();

        mehz2.setSpacing(200);

        mehz2.alignmentProperty().setValue(Pos.CENTER);

        while(h<parking.size()){

            Label lab = new Label("Parking num :"+(parking.get(h).getId_parking()));

            lab.setFont(new Font(30));

            lab.setTextFill(Color.VIOLET);

            if(h==0){

                Label fi = new Label();

                Font fo = new Font(30);

                fi.setFont(fo);

                fi.setTextFill(Color.VIOLET);

                fi.setText("Choisissez un parking : ");

                mehz2.getChildren().add(fi);
            }

            par.add(lab);

            //pp.getChildren().add(par.get(h));

            mehz2.getChildren().add(par.get(h));

            int finalH = h;

            par.get(h).setOnMouseClicked(event -> {

                try {

                    BorderPane borderPane = showParking(parking.get(finalH).getId_parking());

                    mainPane.getChildren().clear();
                    mainPane.getChildren().add(borderPane);
                    mainPane.getChildren().add(new Label());

                } catch (SQLException throwables) {

                    throwables.printStackTrace();
                }

            });

            h++;
        }
    }

    public void init() throws SQLException {

        List<Parking> parking = Parking.getParkings();

        BorderPane borderPane = showParking(parking.get(0).getId_parking());

        mainPane.getChildren().clear();
        mainPane.getChildren().add(borderPane);
        mainPane.getChildren().add(new Label());
    }

    public void setParcs() throws SQLException {

        List<Parking> parking = Parking.getParkings();

        int h=0;

        ArrayList <Label> par = new ArrayList<>(parking.size());

        //HBox pp = new HBox();

        mehz2.getChildren().clear();

        mehz2.setSpacing(200);

        mehz2.alignmentProperty().setValue(Pos.CENTER);

        while(h<parking.size()){

            Label lab = new Label("Parking num :"+(parking.get(h).getId_parking()));

            lab.setFont(new Font(30));

            lab.setTextFill(Color.VIOLET);

            if(h==0){

                Label fi = new Label();

                Font fo = new Font(30);

                fi.setFont(fo);

                fi.setTextFill(Color.VIOLET);

                fi.setText("Choisissez un parking : ");

                mehz2.getChildren().add(fi);
            }

            par.add(lab);

            //pp.getChildren().add(par.get(h));

            mehz2.getChildren().add(par.get(h));

            int finalH = h;

            par.get(h).setOnMouseClicked(event -> {

                try {

                    BorderPane borderPane = showParking(parking.get(finalH).getId_parking());

                    mainPane.getChildren().clear();
                    mainPane.getChildren().add(borderPane);
                    mainPane.getChildren().add(new Label());

                } catch (SQLException throwables) {

                    throwables.printStackTrace();
                }

            });

            h++;
        }
    }

    public void init() throws SQLException {

        List<Parking> parking = Parking.getParkings();

        BorderPane borderPane = showParking(parking.get(0).getId_parking());

        mainPane.getChildren().clear();
        mainPane.getChildren().add(borderPane);
        mainPane.getChildren().add(new Label());
    }

    public void setParcs() throws SQLException {

        List<Parking> parking = Parking.getParkings();

        int h=0;

        ArrayList <Label> par = new ArrayList<>(parking.size());

        //HBox pp = new HBox();

        mehz2.getChildren().clear();

        mehz2.setSpacing(200);

        mehz2.alignmentProperty().setValue(Pos.CENTER);

        while(h<parking.size()){

            Label lab = new Label("Parking num :"+(parking.get(h).getId_parking()));

            lab.setFont(new Font(30));

            lab.setTextFill(Color.VIOLET);

            if(h==0){

                Label fi = new Label();

                Font fo = new Font(30);

                fi.setFont(fo);

                fi.setTextFill(Color.VIOLET);

                fi.setText("Choisissez un parking : ");

                mehz2.getChildren().add(fi);
            }

            par.add(lab);

            //pp.getChildren().add(par.get(h));

            mehz2.getChildren().add(par.get(h));

            int finalH = h;

            par.get(h).setOnMouseClicked(event -> {

                try {

                    BorderPane borderPane = showParking(parking.get(finalH).getId_parking());

                    mainPane.getChildren().clear();
                    mainPane.getChildren().add(borderPane);
                    mainPane.getChildren().add(new Label());

                } catch (SQLException throwables) {

                    throwables.printStackTrace();
                }

            });

            h++;
        }
    }

    public void init() throws SQLException {

        List<Parking> parking = Parking.getParkings();

        BorderPane borderPane = showParking(parking.get(0).getId_parking());

        mainPane.getChildren().clear();
        mainPane.getChildren().add(borderPane);
        mainPane.getChildren().add(new Label());
    }

    public void setParcs() throws SQLException {

        List<Parking> parking = Parking.getParkings();

        int h=0;

        ArrayList <Label> par = new ArrayList<>(parking.size());

        //HBox pp = new HBox();

        mehz2.getChildren().clear();

        mehz2.setSpacing(200);

        mehz2.alignmentProperty().setValue(Pos.CENTER);

        while(h<parking.size()){

            Label lab = new Label("Parking num :"+(parking.get(h).getId_parking()));

            lab.setFont(new Font(30));

            lab.setTextFill(Color.VIOLET);

            if(h==0){

                Label fi = new Label();

                Font fo = new Font(30);

                fi.setFont(fo);

                fi.setTextFill(Color.VIOLET);

                fi.setText("Choisissez un parking : ");

                mehz2.getChildren().add(fi);
            }

            par.add(lab);

            //pp.getChildren().add(par.get(h));

            mehz2.getChildren().add(par.get(h));

            int finalH = h;

            par.get(h).setOnMouseClicked(event -> {

                try {

                    BorderPane borderPane = showParking(parking.get(finalH).getId_parking());

                    mainPane.getChildren().clear();
                    mainPane.getChildren().add(borderPane);
                    mainPane.getChildren().add(new Label());

                } catch (SQLException throwables) {

                    throwables.printStackTrace();
                }

            });

            h++;
        }
    }

    public BorderPane showParking(int integer) throws SQLException {

        //Pane pane =  FXMLLoader.load(App.class.getResource("views/statistiquesPage.fxml"));
        //File file = new File("C:/Users/DELL/OneDrive/Projects/LP/ParkingManager1/ParkingManager/src/main/resources/com/parkingmanager/images/parc/1.jpg");

        ImageView images[]; //= {iv, iv1, iv2, iv3, iv4, iv5, iv6, iv7 };

        Tooltip tooltip = new Tooltip("salam");

        //Voiture voiture = Voiture.getVoitureById(1);


        List<Voiture> listVoitures = Voiture.getAllVoitures();

        List<Place> place = Place.getPlacesParking(integer);

        int v=0;

        ArrayList <Voiture>remplist = new ArrayList<Voiture>();

        int remplis = 0;
        int vides = 0;

        while(v<place.size()){

            if(Voiture.findPlaceTaken(place.get(v).getId_place()) != null){

                remplist.add(Voiture.findPlaceTaken(place.get(v).getId_place()));
                remplis++;

            }else{
                vides++;
            }
            v++;
        }

        int cap = Parking.getParkingById(integer).getCapacite();

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



        ImageView images30[]; //= {images2, images3, images4, images5, images6, images7, images8, images9, images10};

        //flow.setVgap(8);
        //flow.setHgap(4);




        flow.setPrefWrapLength(300);

        int t = place.size();
        int d = listVoitures.size();

        images30 = new ImageView[t];

        int i=0;

        while(i < remplis) {


            int I = i;

            //flow.getChildren().add(buttons[i]);
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
=======
>>>>>>> e435bbe2913ac0256edb7398887da25cb43303a9
=======
>>>>>>> e435bbe2913ac0256edb7398887da25cb43303a9

            images = new ImageView[d];
            images[i] = new ImageView(new Image(App.class.getResource("images/parc/1.jpg").toString(), 150, 200, false, false));

            images[i].setOnMouseEntered(event -> {

                //tooltip.setText("image num "+ I);
                lab.setText("Id: " + Integer.toString(remplist.get(I).getId_voiture()));
                //tooltip.show(primaryStage);
            });

            images[i].setOnMouseExited(event -> {

                //lab.setVisible(false);
            });

            images[i].setOnMouseClicked(event -> {

                lab2.setText("Matricule: " + remplist.get(I).getMatricule());
                lab2.setFont(new Font(30));
                lab2.setTextFill(Color.RED);

            });

            flow.getChildren().add(images[i]);
            i++;
        }

        int s=0;

        while(s<vides){

<<<<<<< HEAD
<<<<<<< HEAD
=======

            images = new ImageView[d];
            images[i] = new ImageView(new Image(App.class.getResource("images/parc/1.jpg").toString(), 150, 200, false, false));

            images[i].setOnMouseEntered(event -> {

                //tooltip.setText("image num "+ I);
                lab.setText("Id: " + Integer.toString(remplist.get(I).getId_voiture()));
                //tooltip.show(primaryStage);
            });

            images[i].setOnMouseExited(event -> {

                //lab.setVisible(false);
            });

            images[i].setOnMouseClicked(event -> {

                lab2.setText("Matricule: " + remplist.get(I).getMatricule());
                lab2.setFont(new Font(30));
                lab2.setTextFill(Color.RED);

            });

            flow.getChildren().add(images[i]);
            i++;
        }

        int s=0;

        while(s<vides){

>>>>>>> e435bbe2913ac0256edb7398887da25cb43303a9
            images30[s] = new ImageView(new Image(App.class.getResource("images/parc/test.jpg").toString(), 150, 200, false, false));

            images30[s].setOnMouseEntered(event -> {

                lab.setVisible(true);

                //tooltip.setText("image num "+ I);
                //lab.setText("Id: "+Integer.toString(place.get(I).getId_place()));
                //tooltip.show(primaryStage);
            });

            images30[s].setOnMouseExited(event -> {

                //lab.setVisible(false);
            });

=======
            images30[s] = new ImageView(new Image(App.class.getResource("images/parc/test.jpg").toString(), 150, 200, false, false));

            images30[s].setOnMouseEntered(event -> {

                lab.setVisible(true);

                //tooltip.setText("image num "+ I);
                //lab.setText("Id: "+Integer.toString(place.get(I).getId_place()));
                //tooltip.show(primaryStage);
            });

            images30[s].setOnMouseExited(event -> {

                //lab.setVisible(false);
            });

>>>>>>> e435bbe2913ac0256edb7398887da25cb43303a9
=======
            images30[s] = new ImageView(new Image(App.class.getResource("images/parc/test.jpg").toString(), 150, 200, false, false));

            images30[s].setOnMouseEntered(event -> {

                lab.setVisible(true);

                //tooltip.setText("image num "+ I);
                //lab.setText("Id: "+Integer.toString(place.get(I).getId_place()));
                //tooltip.show(primaryStage);
            });

            images30[s].setOnMouseExited(event -> {

                //lab.setVisible(false);
            });

>>>>>>> e435bbe2913ac0256edb7398887da25cb43303a9
            images30[s].setOnMouseClicked(event -> {

//                    lab2.setText("Numéro: "+Integer.toString(place.get(I).getNumero()));
//                    lab2.setFont(new Font(30));
//                    lab2.setTextFill(Color.RED);

            });

            flow.getChildren().add(images30[s]);
            s++;

        }

        flow.getChildren().add(lab);

        BorderPane border = new BorderPane();

        Image image3 = new Image(App.class.getResource("images/parc/tri9.jpg").toString());

        ImageView iv70 = new ImageView(image3);

        ImageView iv80 = new ImageView(image3);

        HBox sti = new HBox();

        mehz = new VBox();

        mehz.getChildren().clear();

        mehz.getChildren().add(mehz2);

        mehz.getChildren().add(iv70);

        Label lab3 = new Label("Nb places occupées : "+remplis);
        Label lab4 = new Label("Nb places libres : "+vides);
        //Label lab5 = new Label("Capacité : "+cap);

        HBox ff = new HBox();


        lab3.setFont(new Font(30));
        lab4.setFont(new Font(30));
        //lab5.setFont(new Font(30));

        lab3.setTextFill(Color.YELLOW);
        lab4.setTextFill(Color.RED);
        //lab5.setTextFill(Color.WHITE);

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

        return border;

//        primaryStage.setScene(scene);
//        primaryStage.show();

        //public static void main(String[] args) {
        //Application.launch(args);
        //}


    }

    public void GetPlacesPage() throws SQLException {


<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
        //init();
        //setParcs();

        //*************************
        try {
            Pane pane =  FXMLLoader.load(App.class.getResource("views/placesPage.fxml"));
            mainPane.getChildren().clear();
            mainPane.getChildren().add(pane);
=======
        init();
        setParcs();
=======
        init();
        setParcs();
=======
        init();
        setParcs();

        //*************************
>>>>>>> e435bbe2913ac0256edb7398887da25cb43303a9

        //*************************
>>>>>>> e435bbe2913ac0256edb7398887da25cb43303a9

        //*************************
>>>>>>> e435bbe2913ac0256edb7398887da25cb43303a9

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
            e.printStackTrace();
        }
    }

    public void GetAdministration(){
        try {
            TabPane pane =  FXMLLoader.load(App.class.getResource("administrationPage.fxml"));
            mainPane.getChildren().clear();
            mainPane.getChildren().add(pane);

        } catch (IOException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }
    public void GetStatistiquesPage() throws SQLException {

        try {
            Pane pane =  FXMLLoader.load(App.class.getResource("views/statistiquesPage.fxml"));
            mainPane.getChildren().clear();
            mainPane.getChildren().add(pane);

        } catch (IOException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }

    }



    public void testfunction(){
        String password = "1234";
        String bcryptHashString = BCrypt.withDefaults().hashToString(12, password.toCharArray());
        // $2a$12$US00g/uMhoSBm.HiuieBjeMtoN69SN.GE25fCpldebzkryUyopws6

        BCrypt.Result result = BCrypt.verifyer().verify(password.toCharArray(), bcryptHashString);
        // result.verified == true
    }
}
