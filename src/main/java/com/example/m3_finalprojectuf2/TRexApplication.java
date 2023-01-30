package com.example.m3_finalprojectuf2;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;

public class TRexApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {

        Group root = new Group();
        Scene scene = new Scene(root);
        stage.setTitle("Chrome T-Rex");
        stage.setScene(scene);

        Canvas canvas = new Canvas( 512, 512 );
        root.getChildren().add(canvas);

        GraphicsContext gc = canvas.getGraphicsContext2D();

        Image cactus1 = new Image("cactus1.jpg");
        Image cactus2 = new Image("cactus2.jpg");
        Image cactus3 = new Image("cactus3.jpg");
        Image cactus4 = new Image("cactus4.jpg");
        Image cactus5 = new Image("cactus5.jpg");
        Image cactus6 = new Image("cactus6.jpg");
        Image med_cactus = new Image("medium_cactus.jpg");
        Image big_cactus1 = new Image("big_cactus.jpg");
        Image tRex = new Image("tRex.png");

        final long startNanoTime = System.nanoTime();

        new AnimationTimer()
        {
            public void handle(long currentNanoTime)
            {
                double t = (currentNanoTime - startNanoTime) / 1000000000.0;

                double x = 232 + 128 * Math.cos(t);
                double y = 232 + 128 * Math.sin(t);

                // Clear the canvas
                gc.clearRect(0, 0, 512,512);

                // background image clears canvas
                gc.drawImage( cactus1, 0, 0 );
                gc.drawImage( tRex, x, y );
                gc.drawImage( cactus3, 196, 196 );
            }
        }.start();

        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}