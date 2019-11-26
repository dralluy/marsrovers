package org.code.marsrover;

public class NasaCommandProccesor {
    private final String plateauUpperLeftCoordinates;

    public NasaCommandProccesor(String nasaCommand) {
        this.plateauUpperLeftCoordinates = nasaCommand;
    }

    public Coordinate generatePlateauCoordinates() {
        String[] coordinateSnippet = this.plateauUpperLeftCoordinates.split("\\s");
        return new Coordinate(Integer.valueOf(coordinateSnippet[0]), Integer.valueOf(coordinateSnippet[1]));
    }
}
