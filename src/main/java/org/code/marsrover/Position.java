package org.code.marsrover;

import java.util.Objects;

public class Position {
    private Coordinate coordinate;
    private String headingNorth;

    public Position(Coordinate coordinate, String headingNorth) {

        this.coordinate = coordinate;
        this.headingNorth = headingNorth;
    }

    @Override
    public String toString() {
        return coordinate.toString() + " " + headingNorth;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Position position = (Position) o;
        return Objects.equals(coordinate, position.coordinate) &&
                Objects.equals(headingNorth, position.headingNorth);
    }

    @Override
    public int hashCode() {
        return Objects.hash(coordinate, headingNorth);
    }
}
