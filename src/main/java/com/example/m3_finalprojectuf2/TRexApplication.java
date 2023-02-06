package com.example.m3_finalprojectuf2;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;

public class TRexApplication extends Application {
    public final double YMAX = 1100;
    @Override
    public void start(Stage stage) throws IOException {
        Group root = new Group();
        Scene scene = new Scene(root);
        stage.setTitle("Chrome T-Rex");
        stage.setScene(scene);

        Canvas canvas = new Canvas( YMAX, 300 );
        root.getChildren().add(canvas);

        GraphicsContext gc = canvas.getGraphicsContext2D();

        Image tRex = new Image("tRex.png", 90, 90, false, false);
        Image bg = new Image("landscape.jpg", YMAX, 300, false, false);

        //root.getChildren().addAll(new ImageView(bg));
        final long startNanoTime = System.nanoTime();
        new AnimationTimer()
        {
            public void handle(long currentNanoTime)
            {
                // Clear the canvas
                gc.clearRect(0, 0, YMAX,300);

                // background image clears canvas
                gc.drawImage( tRex, 100, 150);
            }
        }.start();

        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}