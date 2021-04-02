package com.parkingmanager.dao;


import org.apache.commons.dbutils.DbUtils;
import org.apache.commons.dbutils.QueryRunner;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DB {

    private static String driver = "com.mysql.cj.jdbc.Driver";
    private static String url = "jdbc:mysql://localhost:3306/parking_manager";
    private static String user = "root";
    private static String password = null;

    public static Connection con() throws SQLException {

        DbUtils.loadDriver(driver);

        return (Connection) DriverManager.getConnection(url, user, password);
    }

    public static QueryRunner QR(){

        return new QueryRunner();
    }
}

