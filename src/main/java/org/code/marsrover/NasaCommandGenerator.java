package org.code.marsrover;

public class NasaCommandGenerator {
    private final String plateauUpperLeftCoordinates;

    public NasaCommandGenerator(String nasaCommand) {
        this.plateauUpperLeftCoordinates = nasaCommand;
    }

    public Coordinate generatePlateauCoordinates() {
        String[] coordinateSnippet = this.plateauUpperLeftCoordinates.split("\\s");
        return new Coordinate(Integer.valueOf(coordinateSnippet[0]), Integer.valueOf(coordinateSnippet[1]));
    }

    public Plateau getPlateau() {
        return null;
    }
}
