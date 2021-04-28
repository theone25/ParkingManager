package com.parkingmanager.controllers;

import com.parkingmanager.models.*;

import java.sql.SQLException;
import java.util.List;

public class PlaceController {

    public Place getPlaceById(int id) throws SQLException {

        return Place.getPlaceById(id);
    }

    public List<Place> getAllPlaces() throws SQLException {

        return Place.getAllPlaces();
    }
}
