package ca.bcit.comp2522.termproject.teamkoko;

import javafx.geometry.Rectangle2D;
import javafx.scene.image.ImageView;

/**
 * one of the characters that player can choose.
 * @author Changwhi Oh
 * @version 1.0.0
 */
public class ChulSoo extends Player {
    private final String name;
    private final String skill;
    ImageView imageView;

    /**
     * A default constructor.
     */
    public ChulSoo(final int width, final int height, final int pointX, final int pointY, final  ImageView imageView) {

        super(width, height, pointX, pointY);
        this.imageView = imageView;
        this.imageView.setViewport(new Rectangle2D(pointX, pointY, width, height));
        getChildren().addAll(imageView);        this.name = "ChulSoo";
        this.skill = "Teleport";
    }

    /**
     * Returns Character's name.
     * @return String
     */
    public String getName() {
        return this.name;
    }

    /**
     * Returns Skill name.
     * @return String
     */
    public String getSkill() {
        return this.skill;
    }

}
