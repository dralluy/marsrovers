package org.code.marsrover;

public class RoverTurnRightCommand implements RoverCommand {
    private Rover rover;

    public RoverTurnRightCommand(Rover rover) {
        this.rover = rover;
    }

    @Override
    public void execute() {
        this.rover.turnRight();
    }
}