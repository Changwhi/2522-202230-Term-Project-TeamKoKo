package ca.bcit.comp2522.termproject.teamkoko;

//import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

/**
 * Old version game launcher. We do not use it.
 * @author Jesper and Changwhi Oh
 * @version 1.0.0
 */
public class Field {
    /**
     * Distance in pixels that the character moves when a key is pressed.
     */
    public static final int JUMP = 10;

    // Contains the image of the character
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


//    /**
//     * Launches the JavaFX application.
//     *
//     * @param args command line arguments
//     */
//    public static void main(final String[] args) {
//        SoundClipTest music = new SoundClipTest(); //test music
//        music.playSong(); // test music
//
//        launch(args);
//
//    }

}
