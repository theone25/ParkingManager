package com.parkingmanager.models;

import com.parkingmanager.dao.DB;
import org.apache.commons.dbutils.ResultSetHandler;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

@Entity
public class Voiture {
    @Id
    private int id_voiture;
    @NotNull
    private String matricule;
    @NotNull
    private String date_entree;

    public int getId_voiture() {
        return id_voiture;
    }

    public void setId_voiture(int id_voiture) {
        this.id_voiture = id_voiture;
    }

    public String getMatricule() {
        return matricule;
    }

    public void setMatricule(String matricule) {
        this.matricule = matricule;
    }

//    public boolean getTicket_payed() {
//        return ticket_payed;
//    }

//    public void setTicket_payed(boolean ticket_payed) {
//        this.ticket_payed = ticket_payed;
//    }


    public String getDate_entree() {
        return date_entree;
    }

    public void setDate_entree(String date_entree) {
        this.date_entree = date_entree;
    }

    public static ResultSetHandler<Voiture> RSH(){
        return new BeanHandler<>(Voiture.class);
    }

    public static BeanListHandler<Voiture> BLH(){
        return new BeanListHandler<>(Voiture.class);
    }

    public static Voiture getVoitureById(int id) throws SQLException {

        return DB.QR().query(DB.con(), "SELECT * FROM Voiture WHERE id_voiture=?", Voiture.RSH(), id);
    }

    public static List<Voiture> getAllVoitures() throws SQLException {

        return DB.QR().query(DB.con(), "SELECT * FROM Voiture", Voiture.BLH());
    }

    @Override
    public String toString() {
        return "Voiture{" +
                "id_voiture=" + id_voiture +
                ", matricule='" + matricule + '\'' +
                ", Date_entree=" + date_entree +
                '}';
    }
}
