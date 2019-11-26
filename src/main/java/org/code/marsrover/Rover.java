package org.code.marsrover;

public class Rover {
    private Position position;

    public Rover(Position position) {
        this.position = position;
    }

    public Position getPosition() {
        return this.position;
    }

    public void move(String heading) {
        if ("N".equals(heading)) {
            this.position = position.incrementYPosition();
        }
    }
}
