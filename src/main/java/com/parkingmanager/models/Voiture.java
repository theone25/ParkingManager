package com.parkingmanager.models;

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

    public boolean isTicket_payed() {
        return ticket_payed;
    }

    public void setTicket_payed(boolean ticket_payed) {
        this.ticket_payed = ticket_payed;
    }
}
