package org.code.marsrover.domain;

public class RoverTurnLeftCommand implements RoverCommand{
    private Rover rover;

    public RoverTurnLeftCommand(Rover rover) {
        this.rover = rover;
    }

    @Override
    public void execute() {
        this.rover.turnLeft();
    }
}
