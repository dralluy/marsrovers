package org.code.marsrover;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

import static org.code.marsrover.Heading.*;

public class PositionMovement {
    private static final Map<Heading, Function<Position, Position>> positionMovements;

    static {
        final Map<Heading, Function<Position, Position>> movements = new HashMap<>();
        movements.put(NORTH, Position::incrementYPosition);
        movements.put(SOUTH, Position::decrementYPosition);
        movements.put(EAST, Position::incrementXPosition);
        movements.put(WEST, Position::decrementXPosition);
        positionMovements = Collections.unmodifiableMap(movements);
    }

    public Position applyMovementTo(Position position) {
        return positionMovements.get(position.getHeading()).apply(position);
    }
}
