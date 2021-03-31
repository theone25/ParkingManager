package com.parkingmanager.controllers;

import com.parkingmanager.models.Ticket;

import java.sql.SQLException;
import java.util.List;

public class TicketController {

    public Ticket getTicketById(int id) throws SQLException {

        return Ticket.getTicketById(id);
    }

    public List<Ticket> getAllTickets() throws SQLException {

        return Ticket.getAllTickets();
    }
}
