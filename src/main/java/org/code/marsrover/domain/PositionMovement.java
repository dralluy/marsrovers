package org.code.marsrover.domain;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

import static org.code.marsrover.domain.Heading.*;

public class PositionMovement {
    private static final Map<Heading, Function<Position, Position>> positionMovements;

    static {
        positionMovements = Map.of(
                NORTH, Position::incrementYPosition,
                SOUTH, Position::decrementYPosition,
                EAST, Position::incrementXPosition,
                WEST, Position::decrementXPosition);
    }

    public Position applyMovementTo(Position position) {
        return positionMovements.get(position.getHeading()).apply(position);
    }
}
