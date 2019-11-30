package org.code.marsrover.domain.commands;

import org.code.marsrover.domain.Rover;

public class RoverTurnRightCommand implements RoverCommand {
    private final Rover rover;

    public RoverTurnRightCommand(Rover rover) {
        this.rover = rover;
    }

    @Override
    public void execute() {
        this.rover.turnRight();
    }
}
