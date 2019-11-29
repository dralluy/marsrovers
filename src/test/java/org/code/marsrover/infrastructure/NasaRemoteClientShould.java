package org.code.marsrover.infrastructure;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.io.IOException;

import static org.hamcrest.CoreMatchers.is;

@RunWith(JUnit4.class)
public class NasaRemoteClientShould {
    private static final String EXPECTED_RESPONSE = "1 3 N 5 1 E";
    private static final String COMMAND = "5 5 1 2 N LMLMLMLMM 3 3 E MMRMMRMRRM";

    private  WebServer webServer;

    @Before
    public void setUp() throws Exception {
        webServer = new WebServer();
    }

    @Test
    public void call_mars_remote_api_and_get_end_rovers_position_response() throws IOException {
        NasaRemoteClient nasaRemoteClient = new NasaRemoteClient();
        String response = nasaRemoteClient.executeCommand(COMMAND);

        Assert.assertThat(response, is(EXPECTED_RESPONSE));
    }

    @After
    public void tearDown() throws Exception {
        webServer.stop();
    }
}
