package org.code.marsrover;

public class RoverDoNothingCommand implements RoverCommand{
    private Rover rover;

    public RoverDoNothingCommand(Rover rover) {
        this.rover = rover;
    }

    @Override
    public void execute() {
    }
}
