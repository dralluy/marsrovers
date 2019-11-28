package org.code.marsrover.domain;

public class Rover {
    private Position position;
    private Plateau plateau;

    public Rover(Position position, Plateau plateau) {
        this.position = position;
        this.plateau = plateau;
    }

    public Position getPosition() {
        return this.position;
    }

    public void move() {
        Position nextPosition = new PositionMovement().applyMovementTo(this.position);
        if (plateau.isInsideBounds(nextPosition.getCoordinate())) {
            this.position = nextPosition;
        }
    }

    public void turnLeft() {
        this.position = this.position.getHeading().updateHeadingPositionToLeft(this.position);
    }

    public void turnRight() {
        this.position = this.position.getHeading().updateHeadingPositionToRight(this.position);
    }
}
