package com.example.m3_finalprojectuf2;

import javafx.scene.image.Image;

public class Cactus {
    private double xPos;
    private int generation_height;
    private final Image image;

    public Cactus(double xPos, int generation_height, Image image) {
        this.xPos = xPos;
        this.generation_height = generation_height;
        this.image = image;
    }

    //Función para reducir la X del la imagen y moverse.
    public void decreaseXPos(int level){
        double coef = switch (level) {
            case 1 -> 0.5;
            case 2 -> 0.8;
            case 3 -> 1;
            case 4 -> 1.5;
            case 5 -> 2.5;
            default -> 0;
        };
        xPos -= 1.5;//coef;
    }

    public double getxPos() {
        return xPos;
    }

    public int getGeneration_height() {
        return generation_height;
    }

    public Image getImage() {
        return image;
    }

    @Override
    public String toString() {
        return "Cactus{" +
                "xPos=" + xPos +
                ", generation_height=" + generation_height +
                ", image=" + image.toString() +
                '}';
    }
}
