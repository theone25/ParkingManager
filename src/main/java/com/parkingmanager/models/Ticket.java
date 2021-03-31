package com.parkingmanager.models;

import com.parkingmanager.dao.DB;
import org.apache.commons.dbutils.ResultSetHandler;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.SQLException;
import java.util.Date;
import java.util.List;

public class Ticket {

    private int id_ticket;
    private Date date_entree;
    private Date date_sortie;

    public int getId_ticket() {
        return id_ticket;
    }

    public void setId_ticket(int id_ticket) {
        this.id_ticket = id_ticket;
    }

    public Date getDate_entree() {
        return date_entree;
    }

    public void setDate_entree(Date date_entree) {
        this.date_entree = date_entree;
    }

    public Date getDate_sortie() {
        return date_sortie;
    }

    public void setDate_sortie(Date date_sortie) {
        this.date_sortie = date_sortie;
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

    @Override
    public String toString() {
        return "Ticket{" +
                "id_ticket=" + id_ticket +
                ", date_entree=" + date_entree +
                ", date_sortie=" + date_sortie +
                '}';
    }
}
