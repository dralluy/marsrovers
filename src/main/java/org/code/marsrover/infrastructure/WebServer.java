package org.code.marsrover.infrastructure;

import com.sun.net.httpserver.HttpContext;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpServer;

import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.URI;

public class WebServer {
    private static final int PORT = 8000;
    private static final String CONTEXT = "/mars";
    private static final int OK = 200;
    private static final int UNPROCESSABLE_ENTITY = 422;

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
        return new NasaController(querySplit[1]).execute();
    }

    private static void processResponse(String response, HttpExchange httpExchange) throws IOException {
        httpExchange.sendResponseHeaders(OK, response.getBytes().length);
        if (!responseIsValid(response)) {
            httpExchange.sendResponseHeaders(UNPROCESSABLE_ENTITY, response.getBytes().length);
        }

        try(OutputStream os = httpExchange.getResponseBody()) {
            os.write(response.getBytes());
        }
    }

    private static boolean responseIsValid(String response) {
        return response != null && !response.isEmpty();
    }

    public void stop() {
        server.stop(0);
    }
}
