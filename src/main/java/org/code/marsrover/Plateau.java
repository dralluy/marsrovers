package org.code.marsrover;

public class Plateau {
    private int x;
    private int y;

    public Plateau(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public String getBottomLeftCoordinates() {
        return "0 0";
    }

    public int getXUpperRightCoordinate() {
        return x;
    }

    public int getYUpperRightCoordinate() {
        return y;
    }
}
