package com.parkingmanager.controllers;

import com.parkingmanager.models.Utilisateur;

import java.sql.SQLException;
import java.util.List;

public class UserController {

    public Utilisateur getUserByEmail(String email) throws SQLException {

        return Utilisateur.getUserByEmail(email);
    }

    public List<Utilisateur> getAllUsers() throws SQLException {

        return Utilisateur.getAllUsers();
    }
}
