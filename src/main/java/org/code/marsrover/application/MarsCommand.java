package org.code.marsrover.application;

import org.code.marsrover.domain.NasaInfrastructureFactory;
import org.code.marsrover.domain.RoverCommand;

import java.util.stream.Collectors;

public class MarsCommand {
    private NasaInfrastructureFactory infrastructureCreator;

    public MarsCommand(NasaInfrastructureFactory infrastructureCreator) {
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
