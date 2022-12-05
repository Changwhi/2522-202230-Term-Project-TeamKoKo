package ca.bcit.comp2522.termproject.teamkoko;


/**
 * Class that allows Save / Load feature.
 *
 * @author Jesper Hong
 * @version 1.0
 */
public class SaveData implements java.io.Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * X position of character.
     */
    public double posX;

    /**
     * Y position of Character.
     */
    public double posY;

    /**
     * Returns whether the character is alive.
     */
    public boolean isAlive;

    /**
     * Return game over.
     */
    public boolean gameOver;


    /**
     * Return X pos.
     * @return X pos as double
     */
    public double getPosX() {
        return posX;
    }

    /**
     * Return Y pos.
     * @return Y pos as double
     */
    public double getPosY() {
        return posY;
    }

    /**
     * Return character status.
     * @return isAlive as boolean
     */
    public boolean getIsAlive() {
        return isAlive;
    }

    /**
     * Return game over status.
     * @return boolean as game over status
     */
    public boolean isGameOver() {
        return gameOver;
    }
}
