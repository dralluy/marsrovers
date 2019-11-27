package org.code.marsrover;

public enum Heading {
    NORTH("N"), SOUTH("S"), EAST("E"), WEST("W");

    private String cardinalDirection;

    Heading(String cardinalDirection) {
        this.cardinalDirection = cardinalDirection;
    }

    public String getCardinalDirection() {
        return this.cardinalDirection;
    }
}
