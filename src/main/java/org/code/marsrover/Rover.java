package org.code.marsrover;

public class Rover {
    private Position position;

    public Rover(Position position, Plateau plateau) {
        this.position = position;
    }

    public Position getPosition() {
        return this.position;
    }

    public void move() {
        this.position = new PositionMovement().applyMovementTo(this.position);
    }

    public void turnLeft() {
        this.position = this.position.getHeading().updateHeadingPositionToLeft(this.position);
    }

    public void turnRight() {
        this.position = this.position.getHeading().updateHeadingPositionToRight(this.position);
    }
}
