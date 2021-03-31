package com.parkingmanager.models;

import org.javalite.activejdbc.Model;

public class Adresse extends Model {
    private int id_adresse;
    private String ville;
    private String adresse;
    private String pays;

    public int getId_adresse() {
        return id_adresse;
    }

    public void setId_adresse(int id_adresse) {
        this.id_adresse = id_adresse;
    }

    public String getVille() {
        return ville;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getPays() {
        return pays;
    }

    public void setPays(String pays) {
        this.pays = pays;
    }

    @Override
    public String toString() {
        return "Adresse{" +
                "id_adresse=" + id_adresse +
                ", ville='" + ville + '\'' +
                ", adresse='" + adresse + '\'' +
                ", pays='" + pays + '\'' +
                '}';
    }
}
