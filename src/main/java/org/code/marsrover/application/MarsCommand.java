package org.code.marsrover.application;

import org.code.marsrover.domain.MarsBuilder;
import org.code.marsrover.domain.commands.RoverCommand;

import java.util.stream.Collectors;

public class MarsCommand {
    private MarsBuilder infrastructureCreator;

    public MarsCommand(MarsBuilder infrastructureCreator) {
        this.infrastructureCreator = infrastructureCreator;
    }

    public void executeCommands() {
        this.infrastructureCreator.getCommands().forEach(RoverCommand::execute);
    }

    public String getEndRoversPosition() {
        return infrastructureCreator.getRovers().stream()
                .map(rover -> rover.getPosition().toString())
                .collect(Collectors.joining(" "));
    }
}
