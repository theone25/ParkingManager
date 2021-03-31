package com.parkingmanager.models;

import com.parkingmanager.dao.DB;
import org.apache.commons.dbutils.ResultSetHandler;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.SQLException;
import java.util.List;

public class Utilisateur {

    private int id;
    private String nom;
    private String prenom;
    private String email;
    private String password;
    private String image;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public static ResultSetHandler<Utilisateur> RSH(){
        return new BeanHandler<>(Utilisateur.class);
    }

    public static BeanListHandler<Utilisateur> BLH(){
        return new BeanListHandler<>(Utilisateur.class);
    }

    public static Utilisateur getUserByEmail(String email) throws SQLException {

        return DB.QR().query(DB.con(), "SELECT * FROM Utilisateur WHERE email=?", Utilisateur.RSH(), email);
    }

    public static List<Utilisateur> getAllUsers() throws SQLException {

        return DB.QR().query(DB.con(), "SELECT * FROM Utilisateur", Utilisateur.BLH());
    }

    @Override
    public String toString() {
        return "Utilisateur{" +
                "id=" + id +
                ", nom='" + nom + '\'' +
                ", prenom='" + prenom + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", image='" + image + '\'' +
                '}';
    }
}
