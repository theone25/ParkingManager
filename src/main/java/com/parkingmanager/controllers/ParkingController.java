package com.parkingmanager.controllers;

//import com.parkingmanager.models.Adresse;
import com.parkingmanager.models.Parking;

import java.sql.SQLException;
import java.util.List;

public class ParkingController {

    public Parking getParkingById(int id) throws SQLException {

        return Parking.getParkingById(id);
    }

//    public List<Parking> getAllParkings() throws SQLException {
//
//        return Parking.getAllParkings();
//    }
}
