package com.example.m3_finalprojectuf2;

import javafx.animation.AnimationTimer;
import javafx.animation.PauseTransition;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.Label;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.util.Random;

public class TRexApplication extends Application {
    //Coding elements
    public final int ANCHO_MAX = 1100;
    public CactusController cactusController = new CactusController();
    Cactus cactus;
    boolean stop = false;
    boolean levelUp = false;
    public int level = 1;
    private boolean isJumping = false;
    private double jumpVelocity = 0.0;
    private double gravity = 0.1;
    private int score = 0;

    //Graphic elements
    Pane root = new Pane();
    Scene scene = new Scene(root, ANCHO_MAX, 400);
    ImageView bg = new ImageView(new Image("landscape.png", ANCHO_MAX, 400, false, false));
    Text scoreText = new Text("Score: 0");
    ImageView tRex = new ImageView(new Image("tRex.png", 90, 90, false, false));
    Label levelUpLabel = new Label("Level difficulty up!");
    Label finalScore = new Label();

    @Override
    public void start(Stage stage){
        stage.setTitle("Chrome T-Rex");
        stage.setScene(scene);

        root.getChildren().add(bg);

        scoreText.setLayoutX(10);
        scoreText.setLayoutY(30);
        root.getChildren().add(scoreText);

        tRex.setX(100);
        tRex.setY(220);
        root.getChildren().add(tRex);

        cactus = cactusController.changeImage(ANCHO_MAX);
        cactus.image().setX(ANCHO_MAX);
        cactus.image().setY(cactus.getGeneration_height());
        root.getChildren().add(cactus.image());

        levelUpLabel.setStyle("-fx-font-size: 24; -fx-text-fill: white; -fx-font-weight: bold;");
        levelUpLabel.setEffect(new DropShadow(10, Color.BLACK));
        levelUpLabel.setLayoutX(450);
        root.getChildren().add(levelUpLabel);

        finalScore.setStyle("-fx-font-size: 24; -fx-text-fill: white; -fx-font-weight: bold;");
        finalScore.setEffect(new DropShadow(10, Color.BLACK));
        finalScore.setLayoutX(450);
        finalScore.setLayoutY(190);
        root.getChildren().add(finalScore);
        finalScore.setVisible(false);

        scene.setOnKeyPressed(event -> {
            if (event.getCode().equals(KeyCode.SPACE) && !isJumping) {
                isJumping = true;
                jumpVelocity = -7;
            }
        });

        PauseTransition pause = new PauseTransition(Duration.seconds(2));
        pause.setOnFinished(event -> {
            root.getChildren().remove(levelUpLabel);
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
                    checkScore();
                    if(levelUp) {
                        pause.play();
                        levelUp = false;
                    }
                }else {
                    finalScore.setText("Final Score: "+score);
                    finalScore.setVisible(true);
                    this.stop();
                }
            }
        }.start();

        stage.show();
    }

    private void checkScore() {
        scoreText.setText("Score: " + score);
        if(score < 500 && level != 1) {
            level = 1;
        }else if(score < 1000 && level != 2) {
            level = 2;
            levelUp = true;
        }else if(score < 1750 && level != 3) {
            level = 3;
            levelUp = true;
        }else if(score < 3000 && level != 4) {
            level = 4;
            levelUp = true;
        }else if(score < 5000 && level != 5) {
            level = 5;
            levelUp = true;
        }
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
        cactus.decreaseXPos(level);
        if(cactus.image().getX() <= -cactus.image().getImage().getWidth()) {
            root.getChildren().remove(cactus.image());
            cactus = cactusController.changeImage(ANCHO_MAX);
            cactus.image().setX(ANCHO_MAX);
            cactus.image().setY(cactus.getGeneration_height());
            root.getChildren().add(cactus.image());

            score += 100;
        }

        // Detectar colisiones
        if (tRex.getBoundsInParent().intersects(cactus.image().getBoundsInParent())) {
            stop = true;
        }
    }

    public static void main(String[] args) {
        launch();
    }
}