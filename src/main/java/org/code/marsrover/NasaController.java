package org.code.marsrover;

import java.util.List;

public class NasaController {
    private List<RoverCommand> rovers;

    public NasaController(List<RoverCommand> roverCommand) {
        this.rovers = roverCommand;
    }

    public void executeCommands() {
        this.rovers.forEach(RoverCommand::execute);
    }
}
