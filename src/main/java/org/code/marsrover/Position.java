package org.code.marsrover;

import java.util.Objects;

public class Position {
    private Coordinate coordinate;
    private String heading;

    public Position(Coordinate coordinate, String headingNorth) {

        this.coordinate = coordinate;
        this.heading = headingNorth;
    }

    @Override
    public String toString() {
        return coordinate.toString() + " " + heading;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Position position = (Position) o;
        return Objects.equals(coordinate, position.coordinate) &&
                Objects.equals(heading, position.heading);
    }

    @Override
    public int hashCode() {
        return Objects.hash(coordinate, heading);
    }

    public Position incrementYPosition() {
        return new Position(new Coordinate(this.coordinate.getX(), this.coordinate.getY() +1 ), heading);
    }

    public Position decrementYPosition() {
        return new Position(new Coordinate(this.coordinate.getX(), this.coordinate.getY() - 1), heading);
    }
}
