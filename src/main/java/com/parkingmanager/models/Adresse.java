package com.parkingmanager.models;

import com.parkingmanager.dao.DB;
import io.ebean.Model;
import org.apache.commons.dbutils.ResultSetHandler;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import java.sql.SQLException;
import java.util.List;

@Entity @Table(name = "Adresse")
public class Adresse  extends Model {
    @Id
    private int id_adresse;
    @NotNull
    private String ville;
    @NotNull
    private String adresse;
    @NotNull
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

    public static ResultSetHandler<Adresse> RSH(){
        return new BeanHandler<>(Adresse.class);
    }

    public static BeanListHandler<Adresse> BLH(){
        return new BeanListHandler<>(Adresse.class);
    }

    public static Adresse getAdresseById(int id) throws SQLException {

        return DB.QR().query(DB.con(), "SELECT * FROM Adresse WHERE id_adresse=?", Adresse.RSH(), id);
    }

    public static List<Adresse> getAllAdresses() throws SQLException {

        return DB.QR().query(DB.con(), "SELECT * FROM Adresse", Adresse.BLH());
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
