package com.example.m3_finalprojectuf2;

import javafx.scene.image.ImageView;

public class Cactus {
    private final int generation_height;
    private final ImageView image;

    public Cactus(int generation_height, ImageView image) {
        this.generation_height = generation_height;
        this.image = image;
    }

    //Función para reducir la X del la imagen y moverse.
    public void decreaseXPos(int level){
        double coef = switch (level) {
            case 1 -> 2.25;
            case 2 -> 2.75;
            case 3 -> 3.5;
            case 4 -> 5;
            case 5 -> 7.5;
            default -> 0;
        };
        image.setX(image.getX() - coef);
    }

    public int getGeneration_height() {
        return generation_height;
    }

    public ImageView image() {
        return image;
    }
}
