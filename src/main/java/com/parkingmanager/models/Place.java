package com.parkingmanager.models;

import com.parkingmanager.dao.DB;
import com.parkingmanager.models.query.QPlace;
import com.parkingmanager.models.query.QUtilisateur;
import org.apache.commons.dbutils.ResultSetHandler;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import java.sql.SQLException;
import java.util.List;

@Entity
public class Place {
    @Id
    private int id_place;
    @NotNull
    private int numero;

    @NotNull
    private int id_parking;
//
//    @NotNull
//    private int status;

    public int getId_place() {
        return id_place;
    }

    public void setId_place(int id_place) {
        this.id_place = id_place;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public int getId_parking() {

        return id_parking;
    }

    public void setId_parking(int id_parking) {

        this.id_parking = id_parking;
    }

//    public int getStatus() {
//        return status;
//    }
//
//    public void setStatus(int status) {
//        this.status = status;
//    }

    public static ResultSetHandler<Place> RSH(){
        return new BeanHandler<>(Place.class);
    }

    public static BeanListHandler<Place> BLH(){
        return new BeanListHandler<>(Place.class);
    }

    public static Place getPlaceById(int id) throws SQLException {

        return DB.QR().query(DB.con(), "SELECT * FROM Place WHERE id_place=?", Place.RSH(), id);
    }

    public static List<Place> getAllPlaces() throws SQLException {

        return DB.QR().query(DB.con(), "SELECT * FROM Place", Place.BLH());
    }

    public static List<Place> getPlaces() throws SQLException {

        return new QPlace().findList();
    }

    public static Place findOnePlace(int id) throws SQLException {

        return new QPlace()
                .id_place.equalTo(id)
                .findOne();
    }

    @Override
    public String toString() {
        return "Place{" +
                "id_place=" + id_place +
                ", numero=" + numero +
                ", id_parking=" + id_parking +
                '}';
    }
}
