package com.example.m3_finalprojectuf2;

import javafx.scene.image.Image;

import java.util.Random;

public class CactusController {
    private int cactus_index;
    private final Image[] cactuses_img = {
                new Image("cactus1.jpg", 50, 130, false, false),
                new Image("cactus2.jpg", 50, 120, false, false),
                new Image("cactus3.jpg", 50, 120, false, false),
                new Image("cactus4.jpg", 70, 140, false, false),
                new Image("cactus5.jpg", 70, 140, false, false),
                new Image("cactus6.jpg", 70, 150, false, false),
                new Image("med_cactus.jpg", 120, 130, false, false),
                new Image("big_cactus.jpg", 160, 130, false, false)
    };
    public int[] cactus_generation_height = {110, 120, 120, 100, 100, 90, 110, 110};
    public Cactus[] cactus = new Cactus[cactuses_img.length];

    public CactusController(int YMAX) {
        for (int i = 0; i < cactuses_img.length; i++) {
            cactus[i] = new Cactus(YMAX, cactus_generation_height[i], cactuses_img[i]);
            System.out.println(cactus[i].toString());
        }
    }

    public void newCactus(){
        Random rd = new Random();
        cactus_index = rd.nextInt(8);
    }

    public Cactus getCactus(){
        return cactus[cactus_index];
    }
}