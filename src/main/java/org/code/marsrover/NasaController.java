package org.code.marsrover;

import java.util.stream.Collectors;

public class NasaController {
    private NasaInfrastructureFactory infrastructureCreator;

    public NasaController(NasaInfrastructureFactory infrastructureCreator) {
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
