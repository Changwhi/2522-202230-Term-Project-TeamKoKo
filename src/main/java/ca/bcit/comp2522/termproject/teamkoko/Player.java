package ca.bcit.comp2522.termproject.teamkoko;

import javafx.scene.layout.Pane;

/**
 * Abstract class that defines Characters.
 *
 * @author Jesper and Changwhi Oh
 * @version 1.0.0
 */
public abstract class Player extends Pane {

    /**
     * Character image width.
     */
    protected int width;

    /**
     * Character image height.
     */
    protected int height;

    /**
     * Character's status.
     */
    protected boolean arrive;

    /**
     * Character's winning status.
     */
    protected boolean win;

    /**
     * Character's X coordinate.
     */
    int pointX;
    /**
     * Character's Y coordinate.
     */
    int pointY;


    /**
     * Constructs a Player object.
     *
     * @param width  width of this character in pixel
     * @param height height of this character in pixel
     * @param pointX X coordinate of offset in Imageview(Starts from left top)
     * @param pointY Y coordinate of offset in Imageview(Starts from left top)
     */
    public Player(final int width, final int height, final int pointX, final int pointY) {
        this.width = width;
        this.height = height;
        this.pointX = pointX;
        this.pointY = pointY;
        this.arrive = false;
        this.win = false;
    }

    /**
     * moves character to desire location.
     */
    public void move() {
    }

    /**
     * Returns x-coordinate.
     *
     * @return Integer
     */
    public int getPointX() {
        return this.pointX;
    }

    /**
     * Returns Y-coordinate.
     *
     * @return Integer
     */
    public int getPointY() {
        return this.pointY;
    }

    /**
     * Set pointX to the new coordinate.
     *
     * @param newPoint Integer
     */
    public void setPointX(final int newPoint) {
        this.pointX = newPoint;
    }

    /**
     * Set pointY to the new coordinate.
     *
     * @param newPoint Integer
     */
    public void setPointY(final int newPoint) {
        this.pointY = newPoint;
    }

    /**
     * Returns Ture, if character is in a specific position. Otherwise, returns False.
     *
     * @return Boolean
     */
    public boolean isArrive() {
        return arrive;
    }

    /**
     * Sets the newArrive to True, if character arrives at a specific position. Otherwise, sets the variable to False.
     *
     * @param newArrive Boolean
     */
    public void setArrive(final boolean newArrive) {
        this.arrive = newArrive;
    }

    /**
     * Returns True, if player wins. Otherwise, Returns False.
     *
     * @return Boolean
     */
    public boolean isWin() {
        return win;
    }

    /**
     * Set newWin to True, If player wins, Otherwise, Set a variable to False.
     *
     * @param newWin Boolean
     */
    public void setWin(final boolean newWin) {
        this.win = newWin;
    }


}
