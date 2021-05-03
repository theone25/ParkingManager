package com.parkingmanager.models;

import com.parkingmanager.dao.DB;
import com.parkingmanager.models.query.QTicket;
import io.ebean.Model;
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
public class Ticket extends Model {
    @Id
    private int id_ticket;

    @NotNull
    private int id_voiture;

    @NotNull
    private int id_place;

//    @NotNull
//    private String date_entree;


//    @NotNull
//    private Date date_sortie;

    public int getId_ticket() {
        return id_ticket;
    }

    public void setId_ticket(int id_ticket) {
        this.id_ticket = id_ticket;
    }

//    public String getDate_entree() {
//        return date_entree;
//    }

//    public void setDate_entree(String date_entree) {
//        this.date_entree = date_entree;
//    }

//    public Date getDate_sortie() {
//        return date_sortie;
//    }
//
//    public void setDate_sortie(Date date_sortie) {
//        this.date_sortie = date_sortie;
//    }


    public int getId_voiture() {

        return id_voiture;
    }

    public void setId_voiture(int id_voiture) {

        this.id_voiture = id_voiture;
    }

    public int getId_place() {

        return id_place;
    }

    public void setId_place(int id_place) {

        this.id_place = id_place;
    }

    public static ResultSetHandler<Ticket> RSH(){
        return new BeanHandler<>(Ticket.class);
    }

    public static BeanListHandler<Ticket> BLH(){
        return new BeanListHandler<>(Ticket.class);
    }

    public static Ticket getTicketById(int id) throws SQLException {

        return DB.QR().query(DB.con(), "SELECT * FROM Ticket WHERE id_ticket=?", Ticket.RSH(), id);
    }

    public static List<Ticket> getAllTickets() throws SQLException {

        return DB.QR().query(DB.con(), "SELECT * FROM Ticket", Ticket.BLH());
    }

    public static List<Ticket> getTickets() throws SQLException {

        return QTicket.alias().findList();
    }

    public static Ticket save(Ticket ticket) throws SQLException {

        ticket.save();
        return ticket;
    }

    @Override
    public String toString() {
        return "Ticket{" +
                "id_ticket=" + id_ticket +
                "id_place=" + id_place +
                "id_voiture=" + id_voiture +
                '}';
    }
}
