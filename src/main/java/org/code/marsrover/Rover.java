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

    public void move() {
        if (NORTH.equals(this.position.getHeading())) {
            this.position = position.incrementYPosition();
        } else if (SOUTH.equals(this.position.getHeading())) {
            this.position = position.decrementYPosition();
        } else if (EAST.equals(this.position.getHeading())) {
            this.position = position.incrementXPosition();
        } else if (WEST.equals(this.position.getHeading())) {
            this.position = position.decrementXPosition();
        }
    }

    public void turnLeft() {
        this.position = this.position.getHeading().updateHeadingPositionToLeft(this.position);
    }

    public void turnRight() {
        this.position = this.position.getHeading().updateHeadingPositionToRight(this.position);
    }
}
