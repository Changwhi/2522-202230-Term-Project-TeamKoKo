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
import java.util.Random;

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
    final Random generator = new Random();
    private boolean isPlayingSong = false;

    ImageView ivBoss = new ImageView();


    Image sennaImage = new Image(getClass().getResourceAsStream("/enemy_rear.png"));
    ImageView ivSenna = new ImageView(sennaImage);
    Senna senna = new Senna(40,50,0,0,ivSenna);

    ChulSoo chulSoo = new ChulSoo(40,50,0,0);


    SoundClipTest music = new SoundClipTest(); //test music




    static Pane root = new Pane();

    //Test
    Stage window;
    Scene scene1, scene2, scene3,sceneWin,sceneLose;


    Image bossFront = new Image(getClass().getResourceAsStream("/enemy_front.png"));
    Image bossRear = new Image(getClass().getResourceAsStream("/enemy_rear.png"));

    List<Image> images = List.of(bossFront, bossRear);
    Iterator<Image> imageIterator;


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
//        timeline.playFromStart();
//        timeline.play();



        window = primaryStage;

        // label1, button1

        Label label1 = new Label("Choose your character");
        Button button1C = new Button("Senna");
        Button button2C = new Button("Chuulsoo");
        Button button3C = new Button("YoungHee");


        button1C.setOnAction(e-> {
            window.setScene(scene2);
            timeline.playFromStart();
            timeline.play();
        });



        button2C.setOnAction(e->window.setScene(scene3));


        // layout1

        VBox layout1 = new VBox(20);
        layout1.getChildren().addAll(label1, button1C,button2C, button3C);
        scene1 = new Scene(layout1, 300, 300);

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
        buttonGobackTomain.setOnAction(e->window.setScene(scene1));
        sceneLose = new Scene(layoutLose, 150, 150);



        // button 2

        Button button2 = new Button("Go back to Scene 1");
        button2.setOnAction(e->window.setScene(scene1));

        // layout 2

        // Layout 2 - Senna
        ImageView iv = new ImageView("field.png");
        Group root2 = new Group(iv, ivBoss);
        ivSenna.setX(280);
        ivSenna.setY(736);
        root2.getChildren().add(senna);

        // Layout 2 - Chul Soo
        ImageView iv2 = new ImageView("field.png");
        ImageView ivBossForChulsoo = new ImageView();
        ivBossForChulsoo.setImage(bossFront);
        Group root3 = new Group(iv2, ivBossForChulsoo);
        chulSoo.setChulsuX(280);
        chulSoo.setChulsuY(736);
        root3.getChildren().add(chulSoo);

        // Layout 2 - YoungHee



        scene2 = new Scene(root2);
        //when choosing Chulsu
        scene3 = new Scene(root3);


        window.setScene(scene1);
        window.setTitle("Title Here");
        window.show();


//        SetOnKeyPressed chulsooKey = new SetOnKeyPressed(chulSoo.getIvChulSu());



        scene2.setOnKeyPressed(this::processKeyPress);
        scene3.setOnKeyPressed(this::processKeyPress);

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


//    private boolean isBlock(final KeyEvent event) {
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
            System.out.println(ivSenna.getX());
            System.out.println(ivSenna.getY());

//            if (ivSenna.getX() == 280.0 && ivSenna.getY() == 16.0) { origianl
//                44 67
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


//        if (event.getCode()){
//
//        }
//    }


    /**
     * Launches the JavaFX application.
     *
     * @param args command line arguments
     */
    public static void main(final String[] args) {

        launch(args);

    }

}
