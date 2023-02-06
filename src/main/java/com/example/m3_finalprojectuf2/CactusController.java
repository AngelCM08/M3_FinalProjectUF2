package com.example.m3_finalprojectuf2;

import javafx.scene.image.Image;

import java.util.Random;

public class CactusController {
    public Cactus cactus;
    public Image[] cactus_img = {
                new Image("cactus1.jpg", 50, 130, false, false),
                new Image("cactus2.jpg", 50, 120, false, false),
                new Image("cactus3.jpg", 50, 120, false, false),
                new Image("cactus4.jpg", 70, 140, false, false),
                new Image("cactus5.jpg", 70, 140, false, false),
                new Image("cactus6.jpg", 70, 150, false, false),
                new Image("med_cactus.jpg", 120, 130, false, false),
                new Image("big_cactus.jpg", 160, 130, false, false)
    };
    public int[] cactus_generation_height = {110,120,120,100,100,90,110,110};

    public CactusController() {

    }

    public void newCactus(double YMAX){
        Random rd = new Random();
        int cactus_num = rd.nextInt(8);
        cactus = new Cactus(YMAX, cactus_generation_height[cactus_num] ,cactus_img[cactus_num]);
    }
}