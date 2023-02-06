package com.example.m3_finalprojectuf2;

import javafx.scene.image.Image;

public class CactusController {
    public final double YMAX = 1100;
    public Cactus[] cactus = new Cactus[8];

    public CactusController() {
        Image cactus1 = new Image("cactus1.jpg");
        Image cactus2 = new Image("cactus2.jpg");
        Image cactus3 = new Image("cactus3.jpg");
        Image cactus4 = new Image("cactus4.jpg");
        Image cactus5 = new Image("cactus5.jpg");
        Image cactus6 = new Image("cactus6.jpg");
        Image med_cactus = new Image("medium_cactus.jpg");
        Image big_cactus = new Image("big_cactus.jpg");

        cactus[0] = new Cactus(YMAX, cactus1);
        cactus[1] = new Cactus(YMAX, cactus2);
        cactus[2] = new Cactus(YMAX, cactus3);
        cactus[3] = new Cactus(YMAX, cactus4);
        cactus[4] = new Cactus(YMAX, cactus5);
        cactus[5] = new Cactus(YMAX, cactus6);
        cactus[6] = new Cactus(YMAX, med_cactus);
        cactus[7] = new Cactus(YMAX, big_cactus);
    }
}