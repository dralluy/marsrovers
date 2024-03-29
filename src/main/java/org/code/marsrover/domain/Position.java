package org.code.marsrover.domain;

import java.util.Objects;

public class Position {
    private final Coordinate coordinate;
    private final Heading heading;

    public Position(Coordinate coordinate, Heading heading) {

        this.coordinate = coordinate;
        this.heading = heading;
    }

    public Position incrementYPosition() {
        return new Position(new Coordinate(this.coordinate.getX(), this.coordinate.getY() +1 ), heading);
    }

    public Position decrementYPosition() {
        return new Position(new Coordinate(this.coordinate.getX(), this.coordinate.getY() - 1), heading);
    }

    public Position incrementXPosition() {
        return new Position(new Coordinate(this.coordinate.getX() + 1, this.coordinate.getY()), heading);
    }

    public Position decrementXPosition() {
        return new Position(new Coordinate(this.coordinate.getX() - 1, this.coordinate.getY()), heading);
    }

    public Heading getHeading() {
        return heading;
    }

    public Position changeHeadingTo(Heading heading) {
        return new Position(new Coordinate(this.coordinate.getX() , this.coordinate.getY()), heading);
    }

    public Coordinate getCoordinate() {
        return coordinate;
    }

    @Override
    public String toString() {
        return coordinate.toString() + " " + heading.getCardinalDirection();
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
}
