package com.example.m3_finalprojectuf2;

import javafx.scene.image.ImageView;

public class Cactus {
    private final int generation_height;
    private final ImageView image;

    public Cactus(int generation_height, ImageView image) {
        this.generation_height = generation_height;
        this.image = image;
    }

    public int getGeneration_height() {
        return generation_height;
    }

    public ImageView image() {
        return image;
    }
}
