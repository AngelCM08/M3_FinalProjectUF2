package com.example.m3_finalprojectuf2;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class TRexController {
    @FXML
    private Label welcomeText;

    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Welcome to JavaFX Application!");
    }
}