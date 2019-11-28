package org.code.marsrover;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.util.stream.Collectors;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

@RunWith(JUnit4.class)
public class NasaControllerShould {
    @Test
    public void get_rovers_end_position_when_executing_a_nasa_command() {
        String nasaCommand = "5 5 1 2 N LMLMLMLMM 3 3 E MMRMMRMRRM";
        String expectedEndRoversPosition = "1 3 N 5 1 E";

        NasaInfrastructureCreator nasaInfrastructureCreator = new NasaInfrastructureCreator(nasaCommand);

        NasaController nasaController = new NasaController(nasaInfrastructureCreator.getCommands());
        nasaController.executeCommands();

        String endRoversPosition = nasaInfrastructureCreator.getRovers().stream()
                .map(rover -> rover.getPosition().toString())
                .collect(Collectors.joining(" "));
        assertThat(endRoversPosition, is(expectedEndRoversPosition));
    }
}
