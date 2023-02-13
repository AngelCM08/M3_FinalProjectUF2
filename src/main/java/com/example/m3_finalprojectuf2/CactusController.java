package com.example.m3_finalprojectuf2;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.util.Random;

public class CactusController {
    Random rd = new Random();
    int cactus_index;
    private final ImageView[] cactuses_img = {
            new ImageView(new Image("cactus1.png", 50, 130, false, false)),
            new ImageView(new Image("cactus2.png", 50, 120, false, false)),
            new ImageView(new Image("cactus3.png", 50, 120, false, false)),
            new ImageView(new Image("cactus4.png", 70, 140, false, false)),
            new ImageView(new Image("cactus5.png", 70, 140, false, false)),
            new ImageView(new Image("cactus6.png", 70, 150, false, false)),
            new ImageView(new Image("med_cactus.png", 120, 130, false, false)),
            new ImageView(new Image("big_cactus.png", 160, 130, false, false))
    };
    public int[] cactus_generation_height = {180, 190, 190, 170, 170, 160, 180, 180};
    public Cactus[] cactus = new Cactus[cactuses_img.length];

    public CactusController() {
        for (int i = 0; i < cactuses_img.length; i++) {
            cactus[i] = new Cactus(cactus_generation_height[i], cactuses_img[i]);
        }
    }

    public Cactus changeImage(int ANCHO_MAX) {
        cactus_index = rd.nextInt(cactus.length);
        cactus[cactus_index].image().setX(ANCHO_MAX);
        return cactus[cactus_index];
    }
}