package org.code.marsrover;

public class Plateau {
    private int x;
    private int y;
    private Coordinate upperLeftCoordinate;

    public Plateau(int x, int y) {
        upperLeftCoordinate = new Coordinate(x, y);
    }

    public String getBottomLeftCoordinates() {
        return "0 0";
    }

    public int getXUpperRightCoordinate() {
        return upperLeftCoordinate.getX();
    }

    public int getYUpperRightCoordinate() {
        return upperLeftCoordinate.getY();
    }
}
