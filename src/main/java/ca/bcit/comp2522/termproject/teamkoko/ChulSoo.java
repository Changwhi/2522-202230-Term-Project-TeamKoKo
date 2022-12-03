package ca.bcit.comp2522.termproject.teamkoko;

import javafx.geometry.Rectangle2D;
import javafx.scene.image.Image;
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


    Image chulSooImage;

    ImageView ivChulSu;


    /**
     * A default constructor.
     */
    public ChulSoo(final int width, final int height, final int pointX, final int pointY) {
        super(width, height, pointX, pointY);
        this.chulSooImage = new Image(getClass().getResourceAsStream("/chulsu.png"));
        this.ivChulSu = new ImageView(chulSooImage);

        this.ivChulSu.setViewport(new Rectangle2D(pointX, pointY, width, height));

        getChildren().addAll(ivChulSu);
        this.name = "ChulSoo";
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

    public void setChulsuX (double setNewPoint) {
        this.ivChulSu.setX(setNewPoint);
    }


    public void setChulsuY (double setNewPoint) {
        this.ivChulSu.setY(setNewPoint);
    }

    public ImageView getIvChulSu() {
        return ivChulSu;
    }

}
