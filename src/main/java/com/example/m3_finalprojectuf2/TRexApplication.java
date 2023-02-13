package com.example.m3_finalprojectuf2;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

import java.util.Random;

public class TRexApplication extends Application {
    //Coding elements
    public final int ANCHO_MAX = 1100;
    public CactusController cactusController = new CactusController();
    Node[] cactus = new Node[cactusController.cactus.length];
    boolean stop = false;
    public int level = 1;
    private boolean isJumping = false;
    private double jumpVelocity = 0.0;
    private double gravity = 0.1;
    private int score = 0;

    //Graphic elements
    Pane root = new Pane();
    Scene scene = new Scene(root, ANCHO_MAX, 400);
    ImageView bg = new ImageView(new Image("landscape.png", ANCHO_MAX, 400, false, false));
    ImageView tRex = new ImageView(new Image("tRex.png", 90, 90, false, false));

    @Override
    public void start(Stage stage){
        System.out.println(cactusController.cactus[cactusController.cactus_index].image().getFitWidth());
        stage.setTitle("Chrome T-Rex");
        stage.setScene(scene);

        root.getChildren().add(bg);

        tRex.setX(100);
        tRex.setY(220);
        root.getChildren().add(tRex);

        for (int i = 0; i < cactusController.cactus.length; i++) {
            cactus[i] = cactusController.cactus[i].image();
            root.getChildren().add(cactus[i]);
        }
        cactusController.changeImage();

        for (int i = 0; i < cactusController.cactus.length; i++) {
            cactus[cactusController.cactus_index].setLayoutX(ANCHO_MAX);
            cactus[cactusController.cactus_index].setLayoutY(cactusController.cactus[cactusController.cactus_index].getGeneration_height());
        }

        scene.setOnKeyPressed(event -> {
            if (event.getCode().equals(KeyCode.SPACE) && !isJumping) {
                isJumping = true;
                jumpVelocity = -7;
            }
        });

        new AnimationTimer() {
            public void handle(long currentNanoTime) {
                if(!stop){
                    if(tRex.getY() > 220){
                        tRex.setY(220);
                        jumpVelocity = 0.0;
                        isJumping = false;
                    }
                    update();
                }else this.stop();
            }
        }.start();       
        
        stage.show();
    }

    private void update() {
        // Actualizar la posición del jugador
        if (isJumping) {
            jumpVelocity += gravity;
            tRex.setY(tRex.getY() + jumpVelocity);
            if (tRex.getY() >= 400.0) {
                tRex.setY(400.0);
            }
        }

        // Actualizar la posición del obstáculo
        cactus[cactusController.cactus_index].setLayoutX(cactusController.decreaseXPos(level));
        if(cactus[cactusController.cactus_index].getLayoutX() <= -cactusController.getImageWidth()) {
            /*cactus = cactusController.changeImage();
            cactus.image().setX(ANCHO_MAX);
            cactus.image().setY(cactus.getGeneration_height());
            root.getChildren().add(cactus.image());*/
        }

        // Detectar colisiones
        if (tRex.getBoundsInParent().intersects(cactus[cactusController.cactus_index].getBoundsInParent())) {
            stop = true;
            System.out.println("Game Over! Score: " + score);
        }
    }
    
    public static void main(String[] args) {
        launch();
    }
}