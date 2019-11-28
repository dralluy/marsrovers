package org.code.marsrover;

import org.code.marsrover.application.MarsCommand;
import org.code.marsrover.domain.NasaInfrastructureFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

@RunWith(JUnit4.class)
public class MarsCommandShould {

    private static final String NASA_COMMAND = "5 5 1 2 N LMLMLMLMM 3 3 E MMRMMRMRRM";
    private static final String EXPECTED_ROVERS_POSITION = "1 3 N 5 1 E";

    @Test
    public void get_rovers_end_position_when_executing_a_nasa_command() {
        String nasaCommand = NASA_COMMAND;
        String expectedEndRoversPosition = EXPECTED_ROVERS_POSITION;

        NasaInfrastructureFactory nasaInfrastructureCreator = new NasaInfrastructureFactory(nasaCommand);

        MarsCommand marsCommand = new MarsCommand(nasaInfrastructureCreator);
        marsCommand.executeCommands();

        assertThat(marsCommand.getEndRoversPosition(), is(expectedEndRoversPosition));
    }
}
