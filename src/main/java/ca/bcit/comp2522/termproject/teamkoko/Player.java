package ca.bcit.comp2522.termproject.teamkoko;

abstract public class Player {

    private int pointX;
    private int pointY;
    private boolean arrive;
    private boolean win;

    public Player () {
        this.pointX = 0;
        this.pointY = 0;
        this.arrive = false;
        this.win = false;
    }

    public void move() {

    }

    public int getPointX() {
        return this.pointX;
    }
    public int getPointY() {
        return this.pointY;
    }
    public void setPointX(int newPoint) {
        this.pointX = newPoint;
    }
    public void setPointY(int newPoint) {
        this.pointY = newPoint;
    }
    public boolean isArrive() {
        return arrive;
    }
    public void setArrive(boolean newArrive) {
        this.arrive = newArrive;
    }

    public boolean isWin() {
        return win;
    }

    public void setWin(boolean newWin) {
        this.win = newWin;
    }





}
