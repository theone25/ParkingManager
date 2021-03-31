package com.parkingmanager.models;

import com.parkingmanager.dao.DB;
import org.apache.commons.dbutils.ResultSetHandler;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.SQLException;

public class Place {

    private int id_place;
    private int numero;

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

    public static ResultSetHandler<Place> RSH(){
        return new BeanHandler<>(Place.class);
    }

    public static BeanListHandler<Place> BLH(){
        return new BeanListHandler<>(Place.class);
    }

    public static Place getPlaceById(int id) throws SQLException {

        return DB.QR().query(DB.con(), "SELECT * FROM Place WHERE id_place=?", Place.RSH(), id);
    }

    @Override
    public String toString() {
        return "Place{" +
                "id_place=" + id_place +
                ", numero=" + numero +
                '}';
    }
}
