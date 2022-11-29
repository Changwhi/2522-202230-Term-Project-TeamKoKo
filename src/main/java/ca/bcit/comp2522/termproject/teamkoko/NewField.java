package ca.bcit.comp2522.termproject.teamkoko;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.util.Iterator;
import java.util.List;

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

    ImageView ivBoss = new ImageView();


    Image sennaImage = new Image(getClass().getResourceAsStream("/enemy_rear.png"));
    ImageView ivSenna = new ImageView(sennaImage);
    Senna senna = new Senna(40,50,0,0,ivSenna);
    static Pane root = new Pane();

    //Test
    Stage window;
    Scene scene1, scene2;


    Image bossFront = new Image(getClass().getResourceAsStream("/enemy_front.png"));
    Image bossRear = new Image(getClass().getResourceAsStream("/enemy_rear.png"));

    List<Image> images = List.of(bossFront, bossRear);
    Iterator<Image> imageIterator;


    int count;

    private void incrementLabel() {
        if (count % 2 == 0) {
            ivBoss.setImage(bossFront);
        } else {
            ivBoss.setImage(bossRear);
        }
        count++;
    }





    /**
     * Displays an image that can be moved using the arrow keys.
     *
     * @param primaryStage a Stage
     */
    public void start(Stage primaryStage) {


        ivBoss.setX(240);
        ivBoss.setY(30);

        imageIterator = images.iterator();

        Timeline timeline = new Timeline(
                new KeyFrame(
                        Duration.ZERO,
                        e -> incrementLabel()
                ),
                new KeyFrame(Duration.seconds(4))
        );
        timeline.setCycleCount(images.size());
        timeline.setOnFinished(event -> timeline.playFromStart());


        imageIterator = images.iterator();
        timeline.playFromStart();
        timeline.play();



        window = primaryStage;

        // label1, button1

        Label label1 = new Label("JAVA FX Label");
        Button button1 = new Button("Start");
        button1.setOnAction(e->window.setScene(scene2));

        // layout1

        VBox layout1 = new VBox(20);
        layout1.getChildren().addAll(label1, button1);
        scene1 = new Scene(layout1, 300, 300);

        // button 2

        Button button2 = new Button("Go back to Scene 1");
        button2.setOnAction(e->window.setScene(scene1));

        // layout 2

        ImageView iv = new ImageView("field.png");
        Group root2 = new Group(iv, ivBoss);
        ivSenna.setX(280);
        ivSenna.setY(736);
        root2.getChildren().add(senna);

        scene2 = new Scene(root2);

        window.setScene(scene1);
        window.setTitle("Title Here");
        window.show();





        scene2.setOnKeyPressed(this::processKeyPress);


//        //Display map
//        ivSenna.setX(280);
//        ivSenna.setY(736);
//
//        root.setPrefSize(640, 800);
//        root.getChildren().addAll(senna);
//
//
//
//
//        ImageView iv = new ImageView("field.png");
////
//        Group root2 = new Group(iv);
//        root2.getChildren().add(senna);
//
//
//        Scene scene = new Scene(root2);
//
//        // Register the key listener here
//        scene.setOnKeyPressed(this::processKeyPress);
//
//        primaryStage.setTitle("AlienDirection");
//        primaryStage.setScene(scene);
//        primaryStage.hide();


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
            case S -> {
                SaveData data = new SaveData();
                data.posX = ivSenna.getX();
                data.posY = ivSenna.getY();
                try {
                    ResourceManager.save(data, "1.save");
                } catch (Exception exc) {
                    System.out.println("Couldn't save: " + exc.getMessage());
                }
            }
            case L -> {
                try {
                    SaveData data = (SaveData) ResourceManager.load("1.save");
                    ivSenna.setX(data.posX);
                    ivSenna.setY(data.posY);
                } catch (Exception exc) {
                    System.out.println("Couldn't load save data: " + exc.getMessage());
                }
            }
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
