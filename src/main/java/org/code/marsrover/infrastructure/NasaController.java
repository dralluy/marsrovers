package org.code.marsrover.infrastructure;

import org.code.marsrover.application.NasaCommand;
import org.code.marsrover.domain.MarsUniverseBuilder;

public class NasaController {
    private NasaCommand nasaCommand;

    public NasaController(String command) {
        MarsUniverseBuilder marsUniverseBuilder = new MarsUniverseBuilder(command);
        nasaCommand = new NasaCommand(marsUniverseBuilder);
    }

    public String execute() {
        return nasaCommand.execute();
    }
}
