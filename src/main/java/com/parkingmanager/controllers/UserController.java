package com.parkingmanager.controllers;

import com.parkingmanager.models.Utilisateur;

import java.sql.SQLException;

public class UserController {

    public Utilisateur getUserByEmail(String email) throws SQLException {

        return Utilisateur.getUserByEmail(email);
    }
}
