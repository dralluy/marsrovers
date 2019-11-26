package org.code.marsrover;

public class Plateau {

    private Coordinate bottomLeftCoordinate = new Coordinate(0, 0);
    private Coordinate upperRightCoordinate;

    public Plateau(Coordinate upperRightCoordinates) {
        this.upperRightCoordinate = upperRightCoordinates;
    }

    public Coordinate getBottomLeftCoordinates() {
        return bottomLeftCoordinate;
    }

    public Coordinate getUpperRightCoordinates() {
        return upperRightCoordinate;
    }
}
