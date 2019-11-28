package org.code.marsrover;

public class RoverCommandFactory {
    public static RoverCommand createCommand(Rover rover, String command) {
        switch (command) {
            case "M" : return new RoverMoveCommand(rover);
            case "L" : return new RoverTurnLeftCommand(rover);
            case "R" : return new RoverTurnRightCommand(rover);
            default: return null;
        }
    }
}
