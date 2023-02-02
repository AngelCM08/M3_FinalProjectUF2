package com.example.m3_finalprojectuf2;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.io.IOException;

public class TRexApplication extends Application {
    public double t = 1100;
    @Override
    public void start(Stage stage) throws IOException {

        Group root = new Group();
        Scene scene = new Scene(root);
        stage.setTitle("Chrome T-Rex");
        stage.setScene(scene);

        Canvas canvas = new Canvas( 1100, 300 );
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
        Image tRex = new Image("tRex.png", 90, 90, false, false);
        Image bg = new Image("landscape.jpg", 1100, 300, false, false);

        //root.getChildren().addAll(new ImageView(bg));
        final long startNanoTime = System.nanoTime();

        new AnimationTimer()
        {
            public void handle(long currentNanoTime)
            {
                System.out.println(t -= 0.3);

                // Clear the canvas
                gc.clearRect(0, 0, 1100,300);

                // background image clears canvas
                gc.drawImage( cactus1, t, 150);
                gc.drawImage( tRex, 100, 150);
            }
        }.start();

        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}