module com.parkingmanager {
    exports com.parkingmanager.models;
    requires javafx.controls;
    requires javafx.fxml;
    //requires org.jfxtras.styles.jmetro;
    requires java.sql;
    requires bcrypt;
    requires commons.dbutils;
    requires webcam.capture;
    requires org.apache.logging.log4j;
    requires io.ebean.api;
    requires io.ebean.datasource;
    requires io.ebean.datasource.api;
    requires org.slf4j;
    requires persistence.api;
    requires java.validation;
    requires io.ebean.querybean;
    requires io.ebean.annotation;
    requires io.ebean.migration;
    requires io.ebean.ddlgen;
    requires java.desktop;
    requires javafx.swing;

    opens com.parkingmanager.controllers to javafx.fxml;
    exports com.parkingmanager.controllers;

    opens com.parkingmanager to javafx.fxml;
    exports com.parkingmanager;
}