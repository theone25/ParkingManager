package com.parkingmanager.dao;

import java.sql.SQLException;

import com.parkingmanager.models.Utilisateur;
import org.apache.commons.dbutils.DbUtils;

    public class TestDB {

        public static void main(String[] args) {

            try {

                try {

                    Utilisateur user = Utilisateur.getUserByEmail("a");

                    System.out.print(user.toString());

                } finally {
                    DbUtils.close(DB.con());
                }

            }catch (SQLException e){

                e.printStackTrace();
            }

        }
    }