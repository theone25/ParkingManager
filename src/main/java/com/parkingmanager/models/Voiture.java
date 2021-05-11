package com.parkingmanager.models;

import com.parkingmanager.models.query.QUtilisateur;
import com.parkingmanager.models.query.QVoiture;
import io.ebean.DB;
import io.ebean.Model;
import org.apache.commons.dbutils.ResultSetHandler;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import java.sql.SQLException;
import java.util.List;

@Entity
public class Voiture extends Model {
    @Id
    private int id_voiture;
    @NotNull
    private String matricule;
    @NotNull
    //private boolean ticket_payed;
    @NotNull
    private int place;

    public String Date_entree;

    private String Date_sortie;

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

    public String getDate_entree() {

        return Date_entree;
    }

    public void setDate_entree(String date_entree) {

        Date_entree = date_entree;
    }

    public static Voiture save(Voiture voiture) throws SQLException {

        voiture.save();
        return voiture;
    }

//    public boolean getTicket_payed() {
//        return ticket_payed;
//    }
//
//    public void setTicket_payed(boolean ticket_payed) {
//        this.ticket_payed = ticket_payed;
//    }


    public int getPlace() {

        return place;
    }

    public void setPlace(int place) {

        this.place = place;
    }

    public static ResultSetHandler<Voiture> RSH(){
        return new BeanHandler<>(Voiture.class);
    }

    public static BeanListHandler<Voiture> BLH(){
        return new BeanListHandler<>(Voiture.class);
    }

    public static Voiture getVoitureById(int id) throws SQLException {
        return new QVoiture().id_voiture.eq(id).findOne();
        // return DB.QR().query(DB.con(), "SELECT * FROM Utilisateur WHERE id=?", Utilisateur.RSH(), id);
    }
//    public static Voiture getVoitureById(int id) throws SQLException {
//
//        return DB.QR().query(DB.con(), "SELECT * FROM Voiture WHERE id_voiture=?", Voiture.RSH(), id);
//    }
//
    public static Voiture findPlaceTaken(int i) throws SQLException {

        return DB.find(Voiture.class)
                .select("*")
                .where()
                .eq("place", i)
                .findOne();
    }

    public static List<Voiture> getAllVoitures() throws SQLException {

        return new QVoiture().findList();
    }

    @Override
    public String toString() {
        return "Voiture{" +
                "id_voiture=" + id_voiture +
                ", matricule='" + matricule +
                ", place='" + place + '\'' +

                '}';
    }
}
