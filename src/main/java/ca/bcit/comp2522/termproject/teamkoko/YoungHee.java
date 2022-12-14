package ca.bcit.comp2522.termproject.teamkoko;

import javafx.geometry.Rectangle2D;
import javafx.scene.image.ImageView;

/**
 * One of the character that player can choose.
 * @author Changwhi Oh
 * @version 1.0.0
 */
public class YoungHee extends Player {
    /**
     * To store an image.
     */
    ImageView imageView;

    private final String name;
    private final String skill;

    /**
     *  A default constructor.
     * @param width an integer, an image size
     * @param height an integer, an image size
     * @param pointX an integer, X-coordinate starting point
     * @param pointY an integer, Y-coordinate starting point
     * @param imageView a character image
     */
    public YoungHee(final int width, final int height, final int pointX, final int pointY, final ImageView imageView) {
        super(width, height, pointX, pointY);
        this.imageView = imageView;
        this.imageView.setViewport(new Rectangle2D(pointX, pointY, width, height));
        getChildren().addAll(imageView);
        this.name = "YoungHee";
        this.skill = "Jump";
    }

    /**
     * Returns character's name.
     * @return String
     */
    public String getName() {
        return this.name;
    }

    /**
     * Returns skill name.
     * @return String
     */
    public String getSkill() {
        return this.skill;
    }
}
