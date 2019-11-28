package org.code.marsrover;

import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class NasaCommandGenerator {
    private final String NASA_PLATEAU_PATTERN = "^(\\d\\s\\d\\s)";
    private final String NASA_ROVERS_PATTERN = "((\\d\\s\\d\\s[NSWE]\\s)([LRM])*)+";
    private final String nasaCommand;
    private String plateauCommand = "";
    private String roversCommand = "";

    public NasaCommandGenerator(String nasaCommand) {
        this.nasaCommand = nasaCommand;
        splitPlateauAndRoversCommands(nasaCommand);
    }

    private void splitPlateauAndRoversCommands(String nasaCommand) {
        Pattern pattern = Pattern.compile(NASA_PLATEAU_PATTERN);
        Matcher matcher = pattern.matcher(nasaCommand);
        if (matcher.find()) {
            this.plateauCommand = matcher.group();
            this.roversCommand = this.nasaCommand.substring(matcher.group().length());
        }
    }

    public Plateau getPlateau() {
        Optional<Coordinate> coordinate = extractPlateauCoordinatesFromCommand();
        return coordinate.isPresent()? new Plateau(coordinate.get()) : null;

    }

    private Optional<Coordinate> extractPlateauCoordinatesFromCommand() {
        if (!this.plateauCommand.isEmpty()) {
            String[] coordinateSnippet = this.plateauCommand.split("\\s");
            return Optional.of(new Coordinate(Integer.valueOf(coordinateSnippet[0]), Integer.valueOf(coordinateSnippet[1])));
        }
        return Optional.empty();
    }

    public Rover getRover() {
        return null;
    }
}
