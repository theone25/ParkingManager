package com.parkingmanager.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class ShowDetailsController {
    @FXML
    private Label detailslabel;


    public Label getDetailslabel() {
        return detailslabel;
    }

    public void setDetailslabel(Label detailslabel) {
        this.detailslabel = detailslabel;
    }
}
