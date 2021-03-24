package com.parkingmanager.dao;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class HelperDB {

    private final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
    private final String DB_URL = "jdbc:mysql://localhost:3306/parking_manager";

    private static final String USER = "root";
    private static final String PASS = null;

    private Connection conn = null;
    private Statement stmt = null;

    public HelperDB(){
        try {
            Class.forName(JDBC_DRIVER);
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    public void open() {
        try {
            //System.out.println("Connecting to database...");
            conn = DriverManager.getConnection(DB_URL, USER,PASS);
            //System.out.println("Creating statement...");
            stmt = conn.createStatement();
        } catch (SQLException ex) {
            Logger.getLogger(HelperDB.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void close() {
        try {
            stmt.close();
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(HelperDB.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void test() {
        try {
            String sql;
            sql = "SELECT * FROM utilisateur";
            ResultSet rs = stmt.executeQuery(sql); // DML
            // stmt.executeUpdate(sql); // DDL

            //STEP 5: Extract data from result set
            while(rs.next()){
                //Display values
                System.out.print(rs.getString(1));
                System.out.print(rs.getString(2));
            }
            //STEP 6: Clean-up environment
            rs.close();
        } catch (SQLException ex) {
            Logger.getLogger(HelperDB.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
