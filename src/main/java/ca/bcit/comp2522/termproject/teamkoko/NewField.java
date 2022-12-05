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
    public static final int JUMP = 4;
    /**
     * Store an image.
     */
    ImageView ivBoss = new ImageView();

    /**
     * In
     */
    Image sennaImage = new Image(getClass().getResourceAsStream("/char1.png"));
    ImageView ivSenna = new ImageView(sennaImage);
    Senna senna = new Senna(50,60,0,0,ivSenna);


    SoundClipTest music = new SoundClipTest(); //test music

    Stage window;
    Scene scene1, scene2, sceneWin, sceneLose;


    Image bossFront = new Image(getClass().getResourceAsStream("/enemy_front.png"));
    Image bossRear = new Image(getClass().getResourceAsStream("/enemy_rear.png"));

    List<Image> images = List.of(bossFront, bossRear);
    Iterator<Image> imageIterator;


    private boolean isPlayingSong = false;
    /**
     * Store an image.
     */


    int count;

    private void incrementLabel() {
        if (count % 2 == 0) {
            ivBoss.setImage(bossFront);
            isPlayingSong = false;
        } else {
            music.playSong();
            ivBoss.setImage(bossRear);
            isPlayingSong = true;

        }
        count++;
    }





    /**
     * Displays an image that can be moved using the arrow keys.
     *
     * @param primaryStage a Stage
     */
    public void start(Stage primaryStage) {


        ivBoss.setX(280);
        ivBoss.setY(16);

        imageIterator = images.iterator();

        Timeline timeline = new Timeline(
                new KeyFrame(
                        Duration.ZERO,
                        e -> incrementLabel()
                ),
                new KeyFrame(Duration.seconds(5))
        );
        timeline.setCycleCount(images.size());
        timeline.setOnFinished(event -> timeline.playFromStart());

        imageIterator = images.iterator();


        window = primaryStage;

        // label1, button1

        Label label1 = new Label("Welcome to the Squid Game");
        Button button1C = new Button("Game Start");
        Button buttonLoad = new Button("Load");


        button1C.setOnAction(e-> {
            window.setScene(scene2);
            timeline.playFromStart();
            timeline.play();
        });

        // layout1

        VBox layout1 = new VBox(20);
        layout1.getChildren().addAll(label1, button1C, buttonLoad);
        scene1 = new Scene(layout1, 300, 300);


        buttonLoad.setOnAction(e-> {
            try {
                window.setScene(scene2);
                timeline.playFromStart();
                timeline.play();
                SaveData data = (SaveData) ResourceManager.load("1.save");
                ivSenna.setX(data.posX);
                ivSenna.setY(data.posY);
            } catch (Exception exc) {
                System.out.println("Couldn't load save data: " + exc.getMessage());
            }
        });




        // layout win
        VBox layoutWin = new VBox(20);
        Label labelWin = new Label("You Win🙌");
        Button buttonGobackTomain = new Button("Go to main menu");
        layoutWin.getChildren().addAll(labelWin, buttonGobackTomain);
        buttonGobackTomain.setOnAction(e->window.setScene(scene1));
        sceneWin = new Scene(layoutWin, 150, 150);

        // layout lose
        VBox layoutLose = new VBox(20);
        Label labelLose = new Label("You Lose😭");
        Button buttonGobackTomainLose = new Button("Go to main menu");
        layoutLose.getChildren().addAll(labelLose, buttonGobackTomainLose);
        buttonGobackTomainLose.setOnAction(e->window.setScene(scene1));
        sceneLose = new Scene(layoutLose, 150, 150);



        // button 2

        Button button2 = new Button("Go back to Scene 1");
        button2.setOnAction(e->window.setScene(scene1));


        Label buttonSaveInGame = new Label("Push \"S\" to Save the game!");
        Label buttonLoadInGame = new Label("Push \"L\" to Load the game!");
        Label howToPlay = new Label("DEMO version \n Move your character when hearing music,\notherwise, DO NOT MOVE");
        // layout 2
        ImageView iv = new ImageView("field.png");
        Group root2 = new Group(iv, ivBoss);
        ivSenna.setX(280);
        ivSenna.setY(736);
        root2.getChildren().add(senna);
        root2.getChildren().add(buttonSaveInGame);
        root2.getChildren().add(buttonLoadInGame);
        root2.getChildren().add(howToPlay);


        buttonSaveInGame.setLayoutX(35);
        buttonSaveInGame.setLayoutY(700);
        buttonLoadInGame.setLayoutX(35);
        buttonLoadInGame.setLayoutY(650);
        howToPlay.setLayoutX(35);
        howToPlay.setLayoutY(600);
        scene2 = new Scene(root2);
        window.setScene(scene1);
        window.setTitle("Squid Game");
        window.show();

        scene2.setOnKeyPressed(this::processKeyPress);

    }

    /**
     * Modifies the position of the image view when an arrow key is pressed.
     *
     * @param event invoked this method
     */
    public void processKeyPress(final KeyEvent event) {
        if (isPlayingSong) {
            switch (event.getCode()) {
                case UP -> {
                    if (ivSenna.getY() - JUMP >= 0) {
                        ivSenna.setY(ivSenna.getY() - JUMP);
                    }
                }
                case DOWN -> {
                    if (ivSenna.getY() + JUMP <= 760) {
                        ivSenna.setY(ivSenna.getY() + JUMP);
                    }
                }

                case RIGHT -> {
                    if (ivSenna.getX() + JUMP <= 600) {
                        ivSenna.setX(ivSenna.getX() + JUMP);
                    }
                }

                case LEFT -> {
                    if (ivSenna.getX() - JUMP >= 0) {
                        ivSenna.setX(ivSenna.getX() - JUMP);
                    }
                }
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

            if ((ivSenna.getX() > 260.0 && ivSenna.getX() < 300.0) && (ivSenna.getY() > 0.0 && ivSenna.getY() < 67.0)) {
                music.stopSong();
                window.setScene(sceneWin);
                ivSenna.setX(280);
                ivSenna.setY(736);
            }


        } else {
            music.stopSong();
            window.setScene(sceneLose);
        }
    }



    /**
     * Launches the JavaFX application.
     *
     * @param args command line arguments
     */
    public static void main(final String[] args) {

        launch(args);

    }

}
