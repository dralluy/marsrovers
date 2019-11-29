package org.code.marsrover.infrastructure;

import com.sun.net.httpserver.HttpContext;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpServer;
import org.code.marsrover.application.ProcecssNasaCommand;
import org.code.marsrover.domain.MarsBuilder;

import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.URI;

public class WebServer {
    public WebServer() throws IOException {
        HttpServer server = HttpServer.create(new InetSocketAddress(8000), 0);
        HttpContext context = server.createContext("/mars");
        context.setHandler(WebServer::handleRequest);
        server.start();
    }

    private static void handleRequest(HttpExchange httpExchange) throws IOException {
        URI requestURI = httpExchange.getRequestURI();
        String response = processRequest(requestURI);
        processResponse(response, httpExchange);
    }

    private static String processRequest(URI requestURI) {
        String query = requestURI.getQuery();
        String[] querySplit = query.split("=");
        MarsBuilder nasaInfrastructureCreator = new MarsBuilder(querySplit[1]);

        ProcecssNasaCommand procecssNasaCommand = new ProcecssNasaCommand(nasaInfrastructureCreator);

        return procecssNasaCommand.execute();
    }

    private static void processResponse(String response, HttpExchange httpExchange) throws IOException {
        httpExchange.sendResponseHeaders(200, response.getBytes().length);
        try(OutputStream os = httpExchange.getResponseBody()) {
            os.write(response.getBytes());
        }
    }
}
