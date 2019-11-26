package org.code.marsrover;

public class Rover {
    private Coordinate coordinate;
    private String heading;
    private Position position;

    public Rover(Position position) {
        this.position = position;
    }

    public Position getPosition() {
        return this.position;
    }
}
