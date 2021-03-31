package com.parkingmanager.models;

public class Place {
    private int id_place;
    private int numero;

    public int getId_place() {
        return id_place;
    }

    public void setId_place(int id_place) {
        this.id_place = id_place;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    @Override
    public String toString() {
        return "Place{" +
                "id_place=" + id_place +
                ", numero=" + numero +
                '}';
    }
}
