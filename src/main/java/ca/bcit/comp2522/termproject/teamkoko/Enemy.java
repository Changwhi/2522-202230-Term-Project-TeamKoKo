package ca.bcit.comp2522.termproject.teamkoko;

public class Enemy {
    private int pointX;
    private int pointY;
    private String level1;
    private String level2;
    private String level3;
    private Boolean singASong;
    private int readingSpeed;

    public Enemy() {
        this.pointX = 310;
        this.pointY = 0;
        this.level1 = "";
        this.level2 = "";
        this.level3 = "";
        this.singASong = false;
        this.readingSpeed = 1;
    }

    public int getPointX() {
        return pointX;
    }

    public int getPointY() {
        return pointY;
    }

    public void setPointX(int pointX) {
        this.pointX = pointX;
    }

    public void setPointY(int pointY) {
        this.pointY = pointY;
    }

    public String getLevel1() {
        return level1;
    }

    public String getLevel2() {
        return level2;
    }

    public String getLevel3() {
        return level3;
    }

    public void setLevel1(String level1) {
        this.level1 = level1;
    }

    public void setLevel2(String level2) {
        this.level2 = level2;
    }

    public void setLevel3(String level3) {
        this.level3 = level3;
    }

    public Boolean getSingASong() {
        return singASong;
    }

    public void setSingASong(Boolean singASong) {
        this.singASong = singASong;
    }

    public int getReadingSpeed() {
        return readingSpeed;
    }

    public void setReadingSpeed(int readingSpeed) {
        this.readingSpeed = readingSpeed;
    }

}
