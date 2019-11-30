package org.code.marsrover.domain;

import org.code.marsrover.domain.commands.RoverCommand;
import org.code.marsrover.domain.commands.RoverCommandFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

/**
 * Container for all the infrastructure needed in Mars.
 * Creates the Plateau, Rovers and RoverCommands from NASA command
 */
public class MarsUniverseBuilder {
    private final static String NASA_PLATEAU_PATTERN = "^(\\d\\s\\d\\s)";
    private final static String NASA_ROVERS_PATTERN = "((\\d\\s\\d\\s[NSWE]\\s)([LRM])*)+";
    private final static String NASA_ROVER_PATTERN = "(\\d\\s\\d\\s[NSWE]\\s)([LRM])*";
    private List<RoverCommand> commands = new ArrayList<>();
    private Plateau plateau;
    private List<Rover> rovers = new ArrayList<>();

    public MarsUniverseBuilder(String nasaCommand) {
        buildMarsComponents(nasaCommand);
    }

    public Plateau getPlateau() {
        return this.plateau;
    }

    public List<RoverCommand> getCommands() {
        return this.commands;
    }

    public List<Rover> getRovers() {
        return rovers;
    }

    private void buildMarsComponents(String nasaCommand) {
        var pattern = Pattern.compile(NASA_PLATEAU_PATTERN);
        var matcher = pattern.matcher(nasaCommand);
        if (matcher.find()) {
            buildPlateau(matcher.group());
            buildRoversAndCommandsFrom(extractRoverComnadsFrom(nasaCommand, matcher.group().length()));
        }
    }

    private void buildPlateau(String plateauCommand) {
        Optional<Coordinate> plateauCoordinate = extractPlateauCoordinatesFromCommand(plateauCommand);
        plateauCoordinate.ifPresent(coordinate -> this.plateau = new Plateau(coordinate));
    }

    private void buildRoversAndCommandsFrom(List<String> roverCommands) {
        this.rovers = roverCommands.stream()
                .map(this::buildRoverFrom)
                .collect(Collectors.toList());
    }

    private List<String> extractRoverComnadsFrom(String nasaCommand, int roverCommandsPosition) {
        var roversCommand = nasaCommand.substring(roverCommandsPosition);
        var pattern = Pattern.compile(NASA_ROVERS_PATTERN);
        var matcher = pattern.matcher(roversCommand);
        List<String> roverCommands = new ArrayList<>();
        while (matcher.find()) {
            roverCommands.add(matcher.group(0));
        }
        return roverCommands;
    }

    private Optional<Coordinate> extractPlateauCoordinatesFromCommand(String plateauCommand) {
        if (!plateauCommand.isEmpty()) {
            var coordinateSnippet = plateauCommand.split("\\s");
            return Optional.of(new Coordinate(Integer.valueOf(coordinateSnippet[0]), Integer.valueOf(coordinateSnippet[1])));
        }
        return Optional.empty();
    }

    private Rover buildRoverFrom(String command) {
        Rover rover = null;
        var pattern = Pattern.compile(NASA_ROVER_PATTERN);
        var matcher = pattern.matcher(command);
        if (matcher.find()) {
            var roverPosition = matcher.group(1);
            var position = buildRoverPositionWith(roverPosition);
            var roverCommands = command.substring(matcher.group(1).length());
            rover = new Rover(position, this.plateau);
            buildCommandsFor(rover, roverCommands);
        }
        return rover;
    }

    private void buildCommandsFor(Rover rover, String roverCommands) {
        var commandsStream = roverCommands.codePoints()
                .mapToObj(singleCommand -> String.valueOf((char) singleCommand));
        this.commands.addAll(commandsStream
                .map(command -> RoverCommandFactory.createCommand(rover, command))
                .collect(Collectors.toList()));

    }

    private Position buildRoverPositionWith(String roverPosition) {
        var roverPositionSplit = roverPosition.split("\\s");
        return new Position(
                new Coordinate(Integer.valueOf(roverPositionSplit[0]), Integer.valueOf(roverPositionSplit[1])),
                                Heading.buildFrom(roverPositionSplit[2]));
    }
}
