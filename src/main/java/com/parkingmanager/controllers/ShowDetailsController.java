package com.parkingmanager.controllers;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class ShowDetailsController {
    @FXML private void initialize() {

        Platform.runLater(() -> {
        });

    }
    @FXML
    private Label detailslabel;


    public String getDetailslabelText() {
        return detailslabel.getText();
    }

    public void setDetailslabelText(String detailslabel) {
        this.detailslabel.setText( detailslabel);
    }
}
