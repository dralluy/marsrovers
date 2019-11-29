package org.code.marsrover.application;

import org.code.marsrover.domain.MarsBuilder;
import org.code.marsrover.domain.commands.RoverCommand;

import java.util.stream.Collectors;

public class ProcecssNasaCommand {
    public static final String ERROR_RESPONSE = "ERROR";
    private MarsBuilder infrastructureCreator;

    public ProcecssNasaCommand(MarsBuilder infrastructureCreator) {
        this.infrastructureCreator = infrastructureCreator;
    }

    public String execute() {
        this.infrastructureCreator.getCommands().forEach(RoverCommand::execute);
        String endRoversPosition = getEndRoversPosition();
        return isValidPosition(endRoversPosition) ? endRoversPosition : ERROR_RESPONSE;
    }

    private boolean isValidPosition(String endRoversPosition) {
        return endRoversPosition != null && !endRoversPosition.isEmpty();
    }

    private String getEndRoversPosition() {
        return infrastructureCreator.getRovers().stream()
                .map(rover -> rover.getPosition().toString())
                .collect(Collectors.joining(" "));
    }
}
