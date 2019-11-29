package org.code.marsrover.infrastructure;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import static org.hamcrest.CoreMatchers.is;

@RunWith(JUnit4.class)
public class NasaControllerShould {
    private static final String EXPECTED_RESPONSE = "1 3 N 5 1 E";
    private static final String COMMAND = "5 5 1 2 N LMLMLMLMM 3 3 E MMRMMRMRRM";

    @Test
    public void expose_and_execute_nasa_commad_when_remotely_sent() {
        NasaController nasaController = new NasaController();

        String response= nasaController.execute();

        Assert.assertThat(response, is(EXPECTED_RESPONSE));
    }
}
