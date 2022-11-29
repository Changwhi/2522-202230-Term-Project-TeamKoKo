package ca.bcit.comp2522.termproject.teamkoko;




/**
 * Class that allows Save / Load feature
 *
 * @author Jesper Hong
 * @version 1.0
 */
public class SaveData implements java.io.Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * X position of character
     */
    public double posX;

    /**
     * Y position of Character.
     */
    public double posY;

    /**
     * Returns whether the character is alive
     */
    public boolean isAlive;

    /**
     * Return game over
     */
    public boolean gameOver;

}
