package org.code.marsrover;

public class RoverCommandFactory {
    public static RoverCommand createCommand(Rover rover, String command) {
        if ("M".equals(command)) {
            return new RoverMoveCommand(rover);
        } else if ("L".equals(command)) {
            return new RoverTurnLeftCommand(rover);
        } else if ("R".equals(command)) {
            return new RoverTurnRightCommand(rover);
        }
        return null;
    }
}
