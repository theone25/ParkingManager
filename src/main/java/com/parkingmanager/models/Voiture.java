package com.parkingmanager.models;

import com.parkingmanager.dao.DB;
import io.ebean.Model;
import org.apache.commons.dbutils.ResultSetHandler;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import java.sql.SQLException;
import java.util.List;

@Entity @Table(name = "Voiture")
public class Voiture extends Model {
    @Id
    private int id_voiture;
    @NotNull
    private String matricule;
    @NotNull
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
                ", ticket_payed=" + ticket_payed +
                '}';
    }
}
