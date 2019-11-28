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

    public boolean isInsideBounds(Coordinate outsidePlateauCoordinate) {
        return outsidePlateauCoordinate.getX() >= bottomLeftCoordinate.getX() && outsidePlateauCoordinate.getX() <= upperRightCoordinate.getY()
                && outsidePlateauCoordinate.getY() >= bottomLeftCoordinate.getY() && outsidePlateauCoordinate.getY() <= upperRightCoordinate.getY();
    }
}
