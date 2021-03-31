package com.parkingmanager.controllers;

import com.parkingmanager.models.Adresse;

import java.sql.SQLException;
import java.util.List;

public class AdresseController {

    public Adresse getAdresseById(int id) throws SQLException {

        return Adresse.getAdresseById(id);
    }

    public List<Adresse> getAllAdresses() throws SQLException {

        return Adresse.getAllAdresses();
    }
}
