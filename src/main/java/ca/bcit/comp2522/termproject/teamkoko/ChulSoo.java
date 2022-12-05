package ca.bcit.comp2522.termproject.teamkoko;

import javafx.geometry.Rectangle2D;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

/**
 * one of the characters that player can choose.
 *
 * @author Changwhi Oh
 * @version 1.0.0
 */
public class ChulSoo extends Player {
    /**
     * ImageView field.
     */
    ImageView imageView;


    /**
     * Image of Chulsoo character.
     */
    Image chulSooImage;

    /**
     * ImageView for ChulSoo character.
     */
    ImageView ivChulSu;

    private final String name;
    private final String skill;



    /**
     * Constructs Chulsoo object.
     *
     * @param width  width as int
     * @param height height as int
     * @param pointX x coordinate as int
     * @param pointY y coordinate as int
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
     *
     * @return String
     */
    public String getName() {
        return this.name;
    }

    /**
     * Returns Skill name.
     *
     * @return String
     */
    public String getSkill() {
        return this.skill;
    }

    /**
     * Setter for ivChulsoo's posX.
     * @param setNewPoint  X position as double
     */
    public void setChulsuX(final double setNewPoint) {
        this.ivChulSu.setX(setNewPoint);
    }


    /**
     * Setter for ivChulsoo's posY.
     * @param setNewPoint  Y position as double
     */
    public void setChulsuY(final double setNewPoint) {
        this.ivChulSu.setY(setNewPoint);
    }

    /**
     * Gets ivChulsoo.
     * @return ivChulsoo as ImageView
     */
    public ImageView getIvChulSu() {
        return ivChulSu;
    }

}
