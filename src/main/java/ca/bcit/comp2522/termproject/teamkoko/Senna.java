package ca.bcit.comp2522.termproject.teamkoko;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.geometry.Rectangle2D;

public class Senna extends Player{
    ImageView imageView;
//    int width = 40;
//    int height = 50;
//    int pointX = 0;
//    int pointY = 0;


    public Senna(int width, int height, int pointX, int pointY, ImageView imageView){
        super(width,height,pointX,pointY);
        this.imageView = imageView;


        this.imageView.setViewport(new Rectangle2D(pointX, pointY, width, height));
        getChildren().addAll(imageView);
    }
}


