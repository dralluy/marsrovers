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
        if (this.position.getHeading().equals(WEST)) {
            this.position.changeHeadingTo(NORTH);
        } else if (this.position.getHeading().equals(NORTH)) {
            this.position.changeHeadingTo(EAST);
        } else if (this.position.getHeading().equals(EAST)) {
            this.position.changeHeadingTo(SOUTH);
        } else if (this.position.getHeading().equals(SOUTH)) {
            this.position.changeHeadingTo(WEST);
        }
    }
}
