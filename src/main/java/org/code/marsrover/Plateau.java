package org.code.marsrover;

public class Plateau {

    private Coordinate bottomLeftCoordinate = new Coordinate(0, 0);
    private Coordinate upperRightCoordinate;


    public Plateau(int x, int y) {
        upperRightCoordinate = new Coordinate(x, y);
    }

    public Coordinate getBottomLeftCoordinates() {
        return bottomLeftCoordinate;
    }

    public Coordinate getUpperRightCoordinates() {
        return upperRightCoordinate;
    }
}
