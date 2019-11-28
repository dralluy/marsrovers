package org.code.marsrover;

import java.util.Arrays;

public enum Heading {
    NORTH("N") {
        @Override
        public Position updateHeadingPositionToLeft(Position position) {
            return position.changeHeadingTo(WEST);
        }

        @Override
        public Position updateHeadingPositionToRight(Position position) {
            return position.changeHeadingTo(EAST);
        }
    },
    SOUTH("S") {
        @Override
        public Position updateHeadingPositionToLeft(Position position) {
            return position.changeHeadingTo(EAST);
        }

        @Override
        public Position updateHeadingPositionToRight(Position position) {
            return position.changeHeadingTo(WEST);
        }
    },
    EAST("E") {
        @Override
        public Position updateHeadingPositionToLeft(Position position) {
            return position.changeHeadingTo(NORTH);
        }

        @Override
        public Position updateHeadingPositionToRight(Position position) {
            return position.changeHeadingTo(SOUTH);
        }
    },
    WEST("W") {
        @Override
        public Position updateHeadingPositionToLeft(Position position) {
            return position.changeHeadingTo(SOUTH);
        }

        @Override
        public Position updateHeadingPositionToRight(Position position) {
            return position.changeHeadingTo(NORTH);
        }
    };

    private String cardinalDirection;

    Heading(String cardinalDirection) {
        this.cardinalDirection = cardinalDirection;
    }

    public String getCardinalDirection() {
        return this.cardinalDirection;
    }

    public abstract Position updateHeadingPositionToLeft(Position position);
    public abstract Position updateHeadingPositionToRight(Position position);

    public static Heading buildFrom(String cardinalDirection) {
        return Arrays.stream(values()).filter(heading -> heading.cardinalDirection.equals(cardinalDirection))
                .findFirst().get();
    }
}
