package org.code.marsrover.infrastructure;

import org.code.marsrover.application.NasaCommand;
import org.code.marsrover.domain.Mars;

/**
 * Expose NASA command execution for web server
 */
public class NasaController {
    private final NasaCommand nasaCommand;

    public NasaController(String command) {
        Mars mars = new Mars.Builder(command).build();
        nasaCommand = new NasaCommand(mars);
    }

    public String execute() {
        return nasaCommand.execute();
    }
}
