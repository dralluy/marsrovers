package org.code.marsrover.infrastructure;

import org.code.marsrover.application.Command;
import org.code.marsrover.application.NasaCommand;
import org.code.marsrover.domain.MarsBuilder;

public class NasaController {
    private NasaCommand nasaCommand;

    public NasaController(String command) {
        MarsBuilder marsBuilder = new MarsBuilder(command);
        nasaCommand = new NasaCommand(marsBuilder);
    }

    public String execute() {
        return nasaCommand.execute();
    }
}
