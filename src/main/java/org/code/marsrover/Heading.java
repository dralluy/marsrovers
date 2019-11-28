package org.code.marsrover;

import java.util.Arrays;

public enum Heading {
    NORTH("N"), SOUTH("S"), EAST("E"), WEST("W");

    private String cardinalDirection;

    Heading(String cardinalDirection) {
        this.cardinalDirection = cardinalDirection;
    }

    public String getCardinalDirection() {
        return this.cardinalDirection;
    }

    public static Heading buildFrom(String cardinalDirection) {
        return Arrays.stream(values()).filter(heading -> heading.cardinalDirection.equals(cardinalDirection))
                .findFirst().get();
    }
}
