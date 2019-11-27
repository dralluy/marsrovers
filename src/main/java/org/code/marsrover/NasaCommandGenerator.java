package org.code.marsrover;

public class NasaCommandGenerator {
    private final String nasaCommand;

    public NasaCommandGenerator(String nasaCommand) {
        this.nasaCommand = nasaCommand;
    }

    public Coordinate extractPlateauCoordinatesFromCommand() {
        String[] coordinateSnippet = this.nasaCommand.split("\\s");
        return new Coordinate(Integer.valueOf(coordinateSnippet[0]), Integer.valueOf(coordinateSnippet[1]));
    }

    public Plateau getPlateau() {
        return new Plateau(extractPlateauCoordinatesFromCommand());
    }
}
