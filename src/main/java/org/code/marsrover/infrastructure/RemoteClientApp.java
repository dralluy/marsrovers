package org.code.marsrover.infrastructure;

public class RemoteClientApp {
    public static void main(String[] args) {
        NasaRemoteClient nasaRemoteClient= new NasaRemoteClient();
        String response = nasaRemoteClient.executeCommand(args[0]);
        System.out.println(response); //For exercise purpose
    }
}
