package org.code.marsrover.infrastructure;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import static org.hamcrest.CoreMatchers.is;

@RunWith(JUnit4.class)
public class NasaRemoteClientShould {
    private static final String EXPECTED_RIGHT_RESPONSE = "1 3 N 5 1 E";
    private static final String COMMAND = "5 5 1 2 N LMLMLMLMM 3 3 E MMRMMRMRRM";
    private static final String WRONG_COMMAND = "5 5 1 2 ";
    private static final String EXPECTED_WRONG_RESPONSE = "ERROR";

    private  WebServer webServer;

    @Before
    public void setUp() throws Exception {
        webServer = new WebServer();
    }

    @Test
    public void call_mars_remote_api_and_get_end_rovers_position_response() {
        NasaRemoteClient nasaRemoteClient = new NasaRemoteClient();
        String response = nasaRemoteClient.executeCommand(COMMAND);

        Assert.assertThat(response, is(EXPECTED_RIGHT_RESPONSE));
    }

    @Test
    public void get_error_response_when_command_is_not_valid() {
        NasaRemoteClient nasaRemoteClient = new NasaRemoteClient();
        String response = nasaRemoteClient.executeCommand(WRONG_COMMAND);
        Assert.assertThat(response, is(EXPECTED_WRONG_RESPONSE));
    }

    @After
    public void tearDown() throws Exception {
        webServer.stop();
    }
}
