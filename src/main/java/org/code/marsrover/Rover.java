package org.code.marsrover;

public class Rover {
    private Position position;

    public Rover(Position position) {
        this.position = position;
    }

    public Position getPosition() {
        return this.position;
    }

    public void move() {
        switch (this.position.getHeading()) {
            case NORTH:
                this.position = position.incrementYPosition();
                break;
            case SOUTH:
                this.position = position.decrementYPosition();
                break;
            case EAST:
                this.position = position.incrementXPosition();
                break;
            case WEST:
                this.position = position.decrementXPosition();
                break;
        }
    }

    public void turnLeft() {
        this.position = this.position.getHeading().updateHeadingPositionToLeft(this.position);
    }

    public void turnRight() {
        this.position = this.position.getHeading().updateHeadingPositionToRight(this.position);
    }
}
