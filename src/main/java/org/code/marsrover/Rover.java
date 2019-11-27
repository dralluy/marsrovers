package org.code.marsrover;

import static org.code.marsrover.Heading.*;

public class Rover {
    private Position position;

    public Rover(Position position) {
        this.position = position;
    }

    public Position getPosition() {
        return this.position;
    }

    public void move(Heading heading) {
        if (NORTH.equals(heading)) {
            this.position = position.incrementYPosition();
        } else if (SOUTH.equals(heading)) {
            this.position = position.decrementYPosition();
        } else if (EAST.equals(heading)) {
            this.position = position.incrementXPosition();
        } else if (WEST.equals(heading)) {
            this.position = position.decrementXPosition();
        }
    }
}
