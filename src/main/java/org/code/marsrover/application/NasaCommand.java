package org.code.marsrover.application;

import org.code.marsrover.domain.MarsBuilder;
import org.code.marsrover.domain.commands.RoverCommand;

import java.util.stream.Collectors;

public class NasaCommand implements Command<String> {
    public static final String ERROR_RESPONSE = "ERROR";
    private MarsBuilder marsBuilder;

    public NasaCommand(MarsBuilder marsBuilder) {
        this.marsBuilder = marsBuilder;
    }

    @Override
    public String execute() {
        this.marsBuilder.getCommands().forEach(RoverCommand::execute);
        String endRoversPosition = getEndRoversPosition();
        return isValidPosition(endRoversPosition) ? endRoversPosition : ERROR_RESPONSE;
    }

    private boolean isValidPosition(String endRoversPosition) {
        return endRoversPosition != null && !endRoversPosition.isEmpty();
    }

    private String getEndRoversPosition() {
        return marsBuilder.getRovers().stream()
                .map(rover -> rover.getPosition().toString())
                .collect(Collectors.joining(" "));
    }
}
