package ca.bcit.comp2522.termproject.teamkoko;

import javafx.scene.image.ImageView;
import javafx.geometry.Rectangle2D;

/**
 * Senna class.
 *
 * @author Jesper Hong
 * @version 1.0
 */
public class Senna extends Player {
    /**
     * Imageview field.
     */
    ImageView imageView;


    /**
     * Constructs a character Senna object.
     *
     * @param width     width of this character in pixel
     * @param height    height of this character in pixel
     * @param pointX    X coordinate of offset in Imageview(Starts from left top)
     * @param pointY    Y coordinate of offset in Imageview(Starts from left top)
     * @param imageView Imageview
     */
    public Senna(final int width, final int height, final int pointX, final int pointY, final ImageView imageView) {
        super(width, height, pointX, pointY);
        this.imageView = imageView;


        this.imageView.setViewport(new Rectangle2D(pointX, pointY, width, height));
        getChildren().addAll(imageView);
    }
}


