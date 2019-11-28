package org.code.marsrover;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class NasaCommandGenerator {
    private final String NASA_PLATEAU_PATTERN = "^(\\d\\s\\d\\s)";
    private final String NASA_ROVERS_PATTERN = "((\\d\\s\\d\\s[NSWE]\\s)([LRM])*)+";
    private final String NASA_ROVER_PATTERN = "(\\d\\s\\d\\s[NSWE]\\s)([LRM])*";
    private final String nasaCommand;
    private String plateauCommand = "";
    private List<String> roverCommands = new ArrayList<>();

    public NasaCommandGenerator(String nasaCommand) {
        this.nasaCommand = nasaCommand;
        splitPlateauAndRoversCommands(nasaCommand);
    }

    private void splitPlateauAndRoversCommands(String nasaCommand) {
        Pattern pattern = Pattern.compile(NASA_PLATEAU_PATTERN);
        Matcher matcher = pattern.matcher(nasaCommand);
        if (matcher.find()) {
            this.plateauCommand = matcher.group();
            String roversCommand = this.nasaCommand.substring(matcher.group().length());
            pattern = Pattern.compile(NASA_ROVERS_PATTERN);
            matcher = pattern.matcher(roversCommand);
            while (matcher.find()) {
                this.roverCommands.add(matcher.group(0));
            }
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

    public List<Rover> createRovers() {
        return this.roverCommands.stream()
                .map(command -> buildRoverFrom(command))
                .collect(Collectors.toList());
    }

    private Rover buildRoverFrom(String command) {
        Rover rover = null;
        Pattern pattern = Pattern.compile(NASA_ROVER_PATTERN);
        Matcher matcher = pattern.matcher(command);
        if (matcher.find()) {
            String roverPosition = matcher.group(1);
            String roverCommands = command.substring(matcher.group(1).length());
            Position position = buildRoverPositionWith(roverPosition);
            rover = new Rover(position);
        }
        return rover;
    }

    private Position buildRoverPositionWith(String roverPosition) {
        String[] roverPostionSplit = roverPosition.split("\\s");
        Position position = new Position(
                new Coordinate(Integer.valueOf(roverPostionSplit[0]), Integer.valueOf(roverPostionSplit[1])),
                Heading.buildFrom(roverPostionSplit[2]));
        return position;
    }

    public List<RoverCommand> createCommands() {
        return null;
    }
}
