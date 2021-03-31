package com.parkingmanager.models;

import com.parkingmanager.dao.DB;
import org.apache.commons.dbutils.ResultSetHandler;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.SQLException;
import java.util.List;

public class Parking {

    private int id_parking;
    private String nom;
    private float tarif_horaire;
    private int capacite;

    public int getId_parking() {
        return id_parking;
    }

    public void setId_parking(int id_parking) {
        this.id_parking = id_parking;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public float getTarif_horaire() {
        return tarif_horaire;
    }

    public void setTarif_horaire(float tarif_horaire) {
        this.tarif_horaire = tarif_horaire;
    }

    public int getCapacite() {
        return capacite;
    }

    public void setCapacite(int capacite) {
        this.capacite = capacite;
    }

    public static ResultSetHandler<Parking> RSH(){
        return new BeanHandler<>(Parking.class);
    }

    public static BeanListHandler<Parking> BLH(){
        return new BeanListHandler<>(Parking.class);
    }

    public static Parking getParkingById(int id) throws SQLException {

        return DB.QR().query(DB.con(), "SELECT * FROM Parking WHERE id_parking=?", Parking.RSH(), id);
    }

    public static List<Parking> getAllParkings() throws SQLException {

        return DB.QR().query(DB.con(), "SELECT * FROM Parking", Parking.BLH());
    }

    @Override
    public String toString() {
        return "Parking{" +
                "id_parking=" + id_parking +
                ", nom='" + nom + '\'' +
                ", tarif_horaire=" + tarif_horaire +
                ", capacite=" + capacite +
                '}';
    }
}
