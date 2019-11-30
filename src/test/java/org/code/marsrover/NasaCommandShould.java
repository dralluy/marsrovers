package org.code.marsrover;

import org.code.marsrover.application.NasaCommand;
import org.code.marsrover.domain.MarsUniverseBuilder;
import org.hamcrest.CoreMatchers;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import static org.junit.Assert.assertThat;

@RunWith(JUnit4.class)
public class NasaCommandShould {
    private static final String NASA_COMMAND = "5 5 1 2 N LMLMLMLMM 3 3 E MMRMMRMRRM";
    private static final String EXPECTED_ROVERS_POSITION = "1 3 N 5 1 E";

    @Test
    public void get_rovers_end_position_when_executing_a_nasa_command() {

        MarsUniverseBuilder nasaInfrastructureCreator = new MarsUniverseBuilder(NASA_COMMAND);

        NasaCommand nasaCommand = new NasaCommand(nasaInfrastructureCreator);

        assertThat(nasaCommand.execute(), CoreMatchers.is(EXPECTED_ROVERS_POSITION));
    }
}
