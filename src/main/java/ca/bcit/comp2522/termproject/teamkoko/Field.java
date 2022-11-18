package ca.bcit.comp2522.termproject.teamkoko;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;


import java.io.*;
import java.net.URL;
import javax.sound.sampled.*;
import javax.swing.*;


public class Field extends Application{



    /**
     * Distance in pixels that the alien moves when a key is pressed.
     */
    public static final int JUMP = 10;

    // Contains the image of the alien
    private ImageView imageView;

    /**
     * Displays an image that can be moved using the arrow keys.
     *
     * @param primaryStage a Stage
     */
    public void start(final Stage primaryStage) {

        Image alien = new Image("char1.png", true);
        imageView = new ImageView(alien);

        ImageView iv = new ImageView("field.png");
//        final int player = 1000;
        imageView.setX(280);
        imageView.setY(736);

        Group root = new Group(iv);
        root.getChildren().add(imageView);

        final int appWidth = 640;
        final int appHeight = 800;
        Scene scene = new Scene(root, appWidth, appHeight, Color.BLACK);

        // Register the key listener here
        scene.setOnKeyPressed(this::processKeyPress);

        primaryStage.setTitle("AlienDirection");
        primaryStage.setScene(scene);

        primaryStage.show();



    }





    /**
     * Modifies the position of the image view when an arrow key is pressed.
     *
     * @param event invoked this method
     */
    public void processKeyPress(final KeyEvent event) {
        switch (event.getCode()) {
            case UP -> imageView.setY(imageView.getY() - JUMP);
            case DOWN -> imageView.setY(imageView.getY() + JUMP);
            case RIGHT -> imageView.setX(imageView.getX() + JUMP);
            case LEFT -> imageView.setX(imageView.getX() - JUMP);
            default -> {
            } // Does nothing if it's not an arrow key
        }
    }




    /**
     * Launches the JavaFX application.
     *
     * @param args command line arguments
     */
    public static void main(final String[] args) {
        SoundClipTest music = new SoundClipTest();
        music.playSong();


        launch(args);

    }

}
