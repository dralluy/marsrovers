package org.code.marsrover.infrastructure;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class NasaRemoteClient {

    public String executeCommand(String nasaCommand) {
        try {
            String formattedCommand = nasaCommand.replaceAll("\\s", "%20");
            String urlString = "http://localhost:8000/mars?command="+formattedCommand;
            URL url = new URL(urlString);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            connection.setDoOutput(true);

            int status = connection.getResponseCode();

            BufferedReader in = new BufferedReader(
                    new InputStreamReader(connection.getInputStream()));
            String inputLine;
            StringBuffer content = new StringBuffer();
            while ((inputLine = in.readLine()) != null) {
                content.append(inputLine);
            }
            in.close();

            connection.disconnect();

            return content.toString();

        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
