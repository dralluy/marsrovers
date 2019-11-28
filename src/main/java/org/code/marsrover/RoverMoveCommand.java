package org.code.marsrover;

import org.code.marsrover.domain.Rover;

public class RoverMoveCommand implements RoverCommand{
    private Rover rover;

    public RoverMoveCommand(Rover rover) {
        this.rover = rover;
    }

    @Override
    public void execute() {
        this.rover.move();
    }
}
