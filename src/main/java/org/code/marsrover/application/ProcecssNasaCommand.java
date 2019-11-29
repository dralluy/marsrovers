package org.code.marsrover.application;

import org.code.marsrover.domain.MarsBuilder;
import org.code.marsrover.domain.commands.RoverCommand;

import java.util.stream.Collectors;

public class ProcecssNasaCommand {
    private MarsBuilder infrastructureCreator;

    public ProcecssNasaCommand(MarsBuilder infrastructureCreator) {
        this.infrastructureCreator = infrastructureCreator;
    }

    public String execute() {
        this.infrastructureCreator.getCommands().forEach(RoverCommand::execute);
        return getEndRoversPosition();
    }

    private String getEndRoversPosition() {
        return infrastructureCreator.getRovers().stream()
                .map(rover -> rover.getPosition().toString())
                .collect(Collectors.joining(" "));
    }
}
