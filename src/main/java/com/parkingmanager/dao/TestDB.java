package com.parkingmanager.dao;

import java.sql.SQLException;
import java.util.List;

import com.parkingmanager.controllers.UserController;
import com.parkingmanager.models.Utilisateur;
import org.apache.commons.dbutils.DbUtils;

    public class TestDB {

        public static void main(String[] args) {

            try {

                try {

                    UserController user = new UserController();

                    Utilisateur u = user.getUserByEmail("a");

                    System.out.print(u.toString());

                    user.getAllUsers();

                    for(Utilisateur item : user.getAllUsers()) {

                        System.out.println(item);
                    }

                    Utilisateur us = user.getUserById(1);

                    System.out.print(us.toString());

                } finally {
                    DbUtils.close(DB.con());
                }

            }catch (SQLException e){

                e.printStackTrace();
            }

        }
    }