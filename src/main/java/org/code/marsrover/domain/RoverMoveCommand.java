package org.code.marsrover.domain;

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
