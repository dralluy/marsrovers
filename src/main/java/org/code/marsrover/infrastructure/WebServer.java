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
    private static final int PORT = 8000;
    private static final String CONTEXT = "/mars";
    private static final int OK = 200;

    private HttpServer server;

    public WebServer() throws IOException {
        server = HttpServer.create(new InetSocketAddress(PORT), 0);
        HttpContext context = server.createContext(CONTEXT);
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
        httpExchange.sendResponseHeaders(OK, response.getBytes().length);
        try(OutputStream os = httpExchange.getResponseBody()) {
            os.write(response.getBytes());
        }
    }

    public void stop() {
        server.stop(0);
    }
}
