package com.example.m3_finalprojectuf2;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.util.Random;

public class CactusController {
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
    Random rd = new Random();

    public CactusController() {
        for (int i = 0; i < cactuses_img.length; i++) {
            cactus[i] = new Cactus(cactus_generation_height[i], cactuses_img[i]);
        }
    }

    //Función para reducir la X del la imagen y moverse.
    public double decreaseXPos(int level){
        return switch (level) {
            case 1 -> 0.5;
            case 2 -> 0.8;
            case 3 -> 1;
            case 4 -> 1.5;
            case 5 -> 2.5;
            default -> 0;
        };
    }

    public double getImageWidth(){
        return cactus[cactus_index].image().getFitWidth();
    }

    public Cactus changeImage() {
        cactus_index = rd.nextInt(8);
        System.out.println(cactus_index);
        return cactus[cactus_index];
    }
}