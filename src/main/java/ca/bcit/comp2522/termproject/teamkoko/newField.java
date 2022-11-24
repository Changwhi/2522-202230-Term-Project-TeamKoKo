package ca.bcit.comp2522.termproject.teamkoko;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

/**
 * Filed that can move around and play game.
 * @author Jesper and Changwhi Oh
 * @version 1.0.0
 */
public class NewField extends Application {
    /**
     * Distance in pixels that the character moves when a key is pressed.
     */
    public static final int JUMP = 10;


    Image sennaImage = new Image(getClass().getResourceAsStream("/enemy_rear.png"));
    ImageView ivSenna = new ImageView(sennaImage);
    Senna senna = new Senna(40,50,0,0,ivSenna);
    static Pane root = new Pane();


    /**
     * Displays an image that can be moved using the arrow keys.
     *
     * @param primaryStage a Stage
     */
    public void start(Stage primaryStage) {

        ivSenna.setX(280);
        ivSenna.setY(736);

        root.setPrefSize(640, 800);
        root.getChildren().addAll(senna);




        ImageView iv = new ImageView("field.png");
//
        Group root2 = new Group(iv);
        root2.getChildren().add(senna);


        Scene scene = new Scene(root2);

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
            case UP -> ivSenna.setY(ivSenna.getY() - JUMP);
            case DOWN -> ivSenna.setY(ivSenna.getY() + JUMP);
            case RIGHT -> ivSenna.setX(ivSenna.getX() + JUMP);
            case LEFT -> ivSenna.setX(ivSenna.getX() - JUMP);
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
        SoundClipTest music = new SoundClipTest(); //test music
        music.playSong(); // test music

        launch(args);

    }

}
