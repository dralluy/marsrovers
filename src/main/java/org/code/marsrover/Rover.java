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

    public void turnLeft() {
        if (this.position.getHeading().equals(WEST)) {
            this.position.changeHeadingTo(SOUTH);
        } else if (this.position.getHeading().equals(NORTH)) {
            this.position.changeHeadingTo(WEST);
        } else if (this.position.getHeading().equals(EAST)) {
            this.position.changeHeadingTo(NORTH);
        } else if (this.position.getHeading().equals(SOUTH)) {
            this.position.changeHeadingTo(EAST);
        }
    }
}
