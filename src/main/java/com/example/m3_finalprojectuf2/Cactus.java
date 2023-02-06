package com.example.m3_finalprojectuf2;

import javafx.scene.image.Image;

public class Cactus {
    private double xPos;
    private final Image image;

    public Cactus(double xPos, Image image) {
        this.xPos = xPos;
        this.image = image;
    }

    //Función para reducir la X del la imagen y moverse.
    public void decreaseXPos(int level){
        double coef = switch (level) {
            case 1 -> 0.2;
            case 2 -> 0.5;
            case 3 -> 1;
            case 4 -> 1.5;
            case 5 -> 2.5;
            default -> 0;
        };
        xPos += coef;
    }

    public double getxPos() {
        return xPos;
    }

    public Image getImage() {
        return image;
    }
}
