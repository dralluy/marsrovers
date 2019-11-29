package org.code.marsrover.infrastructure;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import static org.hamcrest.CoreMatchers.is;

@RunWith(JUnit4.class)
public class NasaRemoteClientShould {
    private static final String EXPECTED_RESPONSE = "1 3 N 5 1 E";

    @Test
    public void call_mars_remote_api_and_get_end_rovers_position_response() {
        WebServer webServer = new WebServer();
        String nasaCommand = "5 5 1 2 N LMLMLMLMM 3 3 E MMRMMRMRRM";

        NasaRemoteClient nasaRemoteClient = new NasaRemoteClient();
        String response = nasaRemoteClient.executeCommand(nasaCommand);

        Assert.assertThat(response, is(EXPECTED_RESPONSE));
    }
}
