package org.code.marsrover.application;

import org.code.marsrover.domain.Mars;
import org.code.marsrover.domain.commands.RoverCommand;

import java.util.stream.Collectors;

/**
 * Command that encapsulates the use case for executing the rover commands and getting the end rover coordinates positions.
 */
public class NasaCommand {
    public static final String ERROR_RESPONSE = "ERROR";
    private final Mars mars;

    public NasaCommand(Mars mars) {
        this.mars = mars;
    }

    public String execute() {
        this.mars.getCommands().forEach(RoverCommand::execute);
        String endRoversPosition = getEndRoversPosition();
        return isValidPosition(endRoversPosition) ? endRoversPosition : ERROR_RESPONSE;
    }

    private boolean isValidPosition(String endRoversPosition) {
        return endRoversPosition != null && !endRoversPosition.isEmpty();
    }

    private String getEndRoversPosition() {
        return mars.getRovers().stream()
                .map(rover -> rover.getPosition().toString())
                .collect(Collectors.joining(" "));
    }
}
