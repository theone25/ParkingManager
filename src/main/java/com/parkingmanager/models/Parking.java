package com.parkingmanager.models;

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
}
