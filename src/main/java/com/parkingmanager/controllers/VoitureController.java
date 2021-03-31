package com.parkingmanager.controllers;

import com.parkingmanager.models.Voiture;

import java.sql.SQLException;
import java.util.List;

public class VoitureController {

    public Voiture getVoitureById(int id) throws SQLException {

        return Voiture.getVoitureById(id);
    }

    public List<Voiture> getAllVoitures() throws SQLException {

        return Voiture.getAllVoitures();
    }
}
