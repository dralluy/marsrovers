package org.code.marsrover;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.util.stream.Collectors;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

@RunWith(JUnit4.class)
public class NasaControllerShould {

    private static final String NASA_COMMAND = "5 5 1 2 N LMLMLMLMM 3 3 E MMRMMRMRRM";
    private static final String EXPECTED_ROVERS_POSITION = "1 3 N 5 1 E";

    @Test
    public void get_rovers_end_position_when_executing_a_nasa_command() {
        String nasaCommand = NASA_COMMAND;
        String expectedEndRoversPosition = EXPECTED_ROVERS_POSITION;

        NasaInfrastructureCreator nasaInfrastructureCreator = new NasaInfrastructureCreator(nasaCommand);

        NasaController nasaController = new NasaController(nasaInfrastructureCreator);
        nasaController.executeCommands();

        assertThat(nasaController.getEndRoversPosition(), is(expectedEndRoversPosition));
    }
}
