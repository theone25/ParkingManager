package com.parkingmanager.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class ShowDetailsController {
    @FXML
    private Label detailslabel;


    public String getDetailslabelText() {
        return detailslabel.getText();
    }

    public void setDetailslabelText(String detailslabel) {
        this.detailslabel.setText( detailslabel);
    }
}
