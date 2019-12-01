package org.code.marsrover.infrastructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;

import static org.code.marsrover.application.NasaCommand.ERROR_RESPONSE;

public class NasaRemoteClient {

    private static final Logger logger = Logger.getLogger("org.code.marsrover.infrastructure");

    private static final String URL_HOST = "http://localhost:8000";
    private static final String CONTEXT = "/mars";
    private static final String QUERY_PARAM = "?command=";
    private static final String HTTP_SPACE_CODE = "%20";
    private static final String SPACE = "\\s";

    public String executeCommand(String nasaCommand) {
        try {
            String formattedCommand = nasaCommand.replaceAll(SPACE, HTTP_SPACE_CODE);
            URL url = new URL(URL_HOST + CONTEXT + QUERY_PARAM + formattedCommand);

            HttpURLConnection connection = makeConnection(url);

            StringBuilder content = extractResponseFrom(connection);

            closeConnection(connection);

            return content.toString();
        } catch (Exception e) {
            logger.log(Level.SEVERE, "Server error");
        }
        return ERROR_RESPONSE;
    }

    private void closeConnection(HttpURLConnection connection) {
        connection.disconnect();
    }

    private StringBuilder extractResponseFrom(HttpURLConnection connection) throws IOException {
        StringBuilder content = new StringBuilder();
        BufferedReader inputReader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
        String inputLine;
        while ((inputLine = inputReader.readLine()) != null) {
            content.append(inputLine);
        }
        inputReader.close();
        return content;
    }

    private HttpURLConnection makeConnection(URL url) throws IOException {
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");
        connection.setDoOutput(true);
        return connection;
    }
}
