package ca.bcit.comp2522.termproject.teamkoko;

import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;

public class TimelineFX extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) {
// Create the Text using text object
        Text text = new Text("Hello Hello!");
        VBox root = new VBox(text);
// Setting the text font size
        text.setFont(Font.font(12));
// Creating the Scene using its object
        Scene scene = new Scene(root);
// Adding the Scene to the Stage
        stage.setScene(scene);
// Now Setting the title of the above Stage
        stage.setTitle("This is stage title");
// Displaying the Stage using the show() method
        stage.show();
    }
}