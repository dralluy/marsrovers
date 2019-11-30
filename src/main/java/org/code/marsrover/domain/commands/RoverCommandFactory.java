package org.code.marsrover.domain.commands;

import org.code.marsrover.domain.Rover;

public final class RoverCommandFactory {

    private static final String MOVE = "M";
    private static final String TURN_LEFT = "L";
    private static final String TURN_RIGHT = "R";

    private RoverCommandFactory() {}

    public static RoverCommand createCommand(Rover rover, String command) {
        switch (command) {
            case MOVE: return new RoverMoveCommand(rover);
            case TURN_LEFT: return new RoverTurnLeftCommand(rover);
            case TURN_RIGHT: return new RoverTurnRightCommand(rover);
            default: return new EmptyCommand();
        }
    }
}
