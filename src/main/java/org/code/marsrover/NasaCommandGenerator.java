package org.code.marsrover;

import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class NasaCommandGenerator {
    private final String nasaCommand;

    public NasaCommandGenerator(String nasaCommand) {
        this.nasaCommand = nasaCommand;
    }

    public Plateau getPlateau() {
        Optional<Coordinate> coordinate = extractPlateauCoordinatesFromCommand();
        return coordinate.isPresent()? new Plateau(coordinate.get()) : null;
    }

    private Optional<Coordinate> extractPlateauCoordinatesFromCommand() {
        Pattern pattern = Pattern.compile("^(\\d\\s\\d)");
        Matcher matcher = pattern.matcher(this.nasaCommand);

        if (matcher.find()) {
            String[] coordinateSnippet = matcher.group().split("\\s");
            return Optional.of(new Coordinate(Integer.valueOf(coordinateSnippet[0]), Integer.valueOf(coordinateSnippet[1])));
        }
        return Optional.empty();
    }
}
