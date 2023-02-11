package com.example.m3_finalprojectuf2;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
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

public class TRexApplication extends Application {
    //Coding elements
    public final int YMAX = 1100;
    public CactusController cactusController = new CactusController(YMAX);
    Cactus cactus;
    boolean stop = false;
    public int level = 1;
    private boolean isJumping = false;
    private double jumpVelocity = 0.0;
    private double gravity = 0.6;
    private int score = 0;

    //Graphic elements
    Pane root = new Pane();
    Scene scene = new Scene(root, YMAX, 300);
    ImageView bg = new ImageView(new Image("landscape.jpg",YMAX, 300, false, false));
    ImageView tRex = new ImageView(new Image("tRex.png", 90, 90, false, false));

    @Override
    public void start(Stage stage){
        cactusController.newCactus();
        cactus = cactusController.getCactus();

        stage.setTitle("Chrome T-Rex");
        stage.setScene(scene);

        root.getChildren().add(bg);

        tRex.setX(100);
        tRex.setY(150);
        root.getChildren().add(tRex);

        cactus.image().setX(cactus.getxPos());
        cactus.image().setY(cactus.getGeneration_height());
        root.getChildren().add(cactus.image());

        scene.setOnKeyPressed(event -> {
            if (event.getCode().equals(KeyCode.SPACE) && !isJumping) {
                isJumping = true;
                jumpVelocity = -13.5;
            }
        });

        new AnimationTimer() {
            public void handle(long currentNanoTime) {
                if(!stop){
                    if(tRex.getY() > 150){
                        tRex.setY(150);
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
            if (tRex.getY() >= 300.0) {
                tRex.setY(300.0);
            }
        }

        // Actualizar la posición del obstáculo
        cactus.decreaseXPos(level);
        if(cactus.getxPos() <= -cactus.image().getImage().getWidth()) {
            cactusController.newCactus();
            cactus = cactusController.getCactus();
        }

        // Detectar colisiones
        if (tRex.getBoundsInParent().intersects(cactus.image().getBoundsInParent())) {
            stop = true;
            System.out.println("Game Over! Score: " + score);
        }
    }
    
    public static void main(String[] args) {
        launch();
    }
}