module com.parkingmanager {
    requires javafx.controls;
    requires javafx.fxml;
    requires org.jfxtras.styles.jmetro;

    opens com.parkingmanager.controllers to javafx.fxml;
    exports com.parkingmanager.controllers;

    opens com.parkingmanager to javafx.fxml;
    exports com.parkingmanager;
}