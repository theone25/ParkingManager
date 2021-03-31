package com.parkingmanager.models;

import com.parkingmanager.dao.DB;
import org.apache.commons.dbutils.ResultSetHandler;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.SQLException;

public class Voiture {

    private int id_voiture;
    private String matricule;
    private boolean ticket_payed;

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

    public boolean getTicket_payed() {
        return ticket_payed;
    }

    public void setTicket_payed(boolean ticket_payed) {
        this.ticket_payed = ticket_payed;
    }

    public static ResultSetHandler<Voiture> RSH(){
        return new BeanHandler<>(Voiture.class);
    }

    public static BeanListHandler<Voiture> BLH(){
        return new BeanListHandler<>(Voiture.class);
    }

    public static Voiture getVoitureById(int id) throws SQLException {

        return DB.QR().query(DB.con(), "SELECT * FROM Voiture WHERE id=?", Voiture.RSH(), id);
    }

    @Override
    public String toString() {
        return "Voiture{" +
                "id_voiture=" + id_voiture +
                ", matricule='" + matricule + '\'' +
                ", ticket_payed=" + ticket_payed +
                '}';
    }
}
