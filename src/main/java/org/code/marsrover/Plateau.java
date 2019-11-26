package org.code.marsrover;

public class Plateau {

    private Coordinate bottomLeftCoordinate = new Coordinate(0, 0);
    private Coordinate upperLeftCoordinate;


    public Plateau(int x, int y) {
        upperLeftCoordinate = new Coordinate(x, y);
    }

    public Coordinate getBottomLeftCoordinates() {
        return bottomLeftCoordinate;
    }

    public int getXUpperRightCoordinate() {
        return upperLeftCoordinate.getX();
    }

    public int getYUpperRightCoordinate() {
        return upperLeftCoordinate.getY();
    }
}
