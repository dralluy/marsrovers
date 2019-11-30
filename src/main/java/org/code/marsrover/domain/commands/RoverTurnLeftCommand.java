package org.code.marsrover.domain.commands;

import org.code.marsrover.domain.Rover;

public class RoverTurnLeftCommand implements RoverCommand{
    private final Rover rover;

    public RoverTurnLeftCommand(Rover rover) {
        this.rover = rover;
    }

    @Override
    public void execute() {
        this.rover.turnLeft();
    }
}
