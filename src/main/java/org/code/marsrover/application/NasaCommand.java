package org.code.marsrover.application;

import org.code.marsrover.domain.MarsUniverseBuilder;
import org.code.marsrover.domain.commands.RoverCommand;

import java.util.stream.Collectors;

/**
 * Command that encapsulates the use case for executing the rover commands and getting the end rover coordinates positions.
 */
public class NasaCommand {
    private static final String ERROR_RESPONSE = "ERROR";
    private MarsUniverseBuilder marsUniverseBuilder;

    public NasaCommand(MarsUniverseBuilder marsUniverseBuilder) {
        this.marsUniverseBuilder = marsUniverseBuilder;
    }

    public String execute() {
        this.marsUniverseBuilder.getCommands().forEach(RoverCommand::execute);
        String endRoversPosition = getEndRoversPosition();
        return isValidPosition(endRoversPosition) ? endRoversPosition : ERROR_RESPONSE;
    }

    private boolean isValidPosition(String endRoversPosition) {
        return endRoversPosition != null && !endRoversPosition.isEmpty();
    }

    private String getEndRoversPosition() {
        return marsUniverseBuilder.getRovers().stream()
                .map(rover -> rover.getPosition().toString())
                .collect(Collectors.joining(" "));
    }
}
