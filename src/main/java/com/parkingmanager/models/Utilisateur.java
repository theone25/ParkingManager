package com.parkingmanager.models;

import com.parkingmanager.dao.DB;
import com.parkingmanager.models.query.QUtilisateur;
import io.ebean.Model;
import org.apache.commons.dbutils.ResultSetHandler;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.SQLException;
import java.util.List;
import javax.persistence.*;
import javax.validation.constraints.*;

@Entity
public class Utilisateur extends Model {

    @Id
    private int id;
    @NotNull
    private String nom;
    @NotNull
    private String prenom;
    @NotNull
    private String email;
    @NotNull
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

    public static ResultSetHandler<Utilisateur> RSH() {
        return new BeanHandler<>(Utilisateur.class);
    }

    public static BeanListHandler<Utilisateur> BLH() {
        return new BeanListHandler<>(Utilisateur.class);
    }

    public static Utilisateur getUserById(int id) throws SQLException {
        return new QUtilisateur().id.eq(id).findOne();
        // return DB.QR().query(DB.con(), "SELECT * FROM Utilisateur WHERE id=?", Utilisateur.RSH(), id);
    }

    public static Utilisateur getUserByEmail(String email) {
        return new QUtilisateur()
                .email.equalTo(email)
                .findOne();
        // return DB.QR().query(DB.con(), "SELECT * FROM utilisateur WHERE email=?", Utilisateur.RSH(), email);
    }

    public static List<Utilisateur> getAllUsers() throws SQLException {

        return DB.QR().query(DB.con(), "SELECT * FROM utilisateur", Utilisateur.BLH());
    }

    public static Utilisateur save(Utilisateur user) throws SQLException {
        user.save();
        return user;
        //String q = "INSERT INTO utilisateur(nom,prenom,email,password) values (?,?,?,?)";
       // return DB.QR().insert(DB.con(), q, Utilisateur.RSH(), user.getNom(), user.getPrenom(), user.getEmail(), user.getPassword());
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
