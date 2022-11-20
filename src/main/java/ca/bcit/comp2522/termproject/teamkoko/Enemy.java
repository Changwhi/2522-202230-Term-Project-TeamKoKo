package ca.bcit.comp2522.termproject.teamkoko;

/**
 * Enemy class.
 * @author Jesper
 * @version 1.0.0
 */
public class Enemy {
    private int pointX;
    private int pointY;
    private String level1;
    private String level2;
    private String level3;
    private Boolean singASong;
    private int readingSpeed;

    /**
     * A default constructor.
     */
    public Enemy() {
        this.pointX = 310;
        this.pointY = 0;
        this.level1 = "";
        this.level2 = "";
        this.level3 = "";
        this.singASong = false;
        this.readingSpeed = 1;
    }

    /**
     * Returns X-coordinate.
     * @return Integer
     */
    public int getPointX() {
        return pointX;
    }
    /**
     * Returns Y-coordinate.
     * @return Integer
     */
    public int getPointY() {
        return pointY;
    }

    /**
     * Set pointX to new position.
     * @param pointX Integer
     */
    public void setPointX(final int pointX) {
        this.pointX = pointX;
    }

    /**
     * Set pointY to new position.
     * @param pointY Integer
     */
    public void setPointY(final int pointY) {
        this.pointY = pointY;
    }

    /**
     * Returns the name of the phases.
     * @return String
     */
    public String getLevel1() {
        return level1;
    }
    /**
     * Returns the name of the phases.
     * @return String
     */
    public String getLevel2() {
        return level2;
    }
    /**
     * Returns the name of the phases.
     * @return String
     */
    public String getLevel3() {
        return level3;
    }

    /**
     * Set the new name of the phases.
     * @param level1 String
     */
    public void setLevel1(final String level1) {
        this.level1 = level1;
    }
    /**
     * Set the new name of the phases.
     * @param level2 String
     */
    public void setLevel2(final String level2) {
        this.level2 = level2;
    }
    /**
     * Set the new name of the phases.
     * @param level3 String
     */
    public void setLevel3(final String level3) {
        this.level3 = level3;
    }

    /**
     * Returns True, if song is playing during the game.
     * @return Boolean
     */
    public Boolean getSingASong() {
        return singASong;
    }

    /**
     * Sets singASong to True, if music is playing. Otherwise, sets a variable False.
     * @param singASong Boolean
     */
    public void setSingASong(final Boolean singASong) {
        this.singASong = singASong;
    }

    /**
     * Returns the playing speed of the music.
     * @return Integer
     */
    public int getReadingSpeed() {
        return readingSpeed;
    }

    /**
     * Set a readingSpeed to a new playing speed of the music.
     * @param readingSpeed Integer
     */
    public void setReadingSpeed(final int readingSpeed) {
        this.readingSpeed = readingSpeed;
    }

}
