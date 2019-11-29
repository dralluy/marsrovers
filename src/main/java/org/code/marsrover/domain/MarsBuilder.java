package org.code.marsrover.domain;

import org.code.marsrover.domain.commands.RoverCommand;
import org.code.marsrover.domain.commands.RoverCommandFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MarsBuilder {
    private final static String NASA_PLATEAU_PATTERN = "^(\\d\\s\\d\\s)";
    private final static String NASA_ROVERS_PATTERN = "((\\d\\s\\d\\s[NSWE]\\s)([LRM])*)+";
    private final static String NASA_ROVER_PATTERN = "(\\d\\s\\d\\s[NSWE]\\s)([LRM])*";
    private final String nasaCommand;
    private String plateauCommand = "";
    private List<RoverCommand> commands = new ArrayList<>();
    private Plateau plateau;
    private List<Rover> rovers = new ArrayList<>();

    public MarsBuilder(String nasaCommand) {
        this.nasaCommand = nasaCommand;
        buildMarsComponents(nasaCommand);
    }

    public Plateau getPlateau() {
        return this.plateau;
    }

    private void buildMarsComponents(String nasaCommand) {
        var pattern = Pattern.compile(NASA_PLATEAU_PATTERN);
        var matcher = pattern.matcher(nasaCommand);
        if (matcher.find()) {
            this.plateauCommand = matcher.group();
            var roversCommand = this.nasaCommand.substring(matcher.group().length());
            pattern = Pattern.compile(NASA_ROVERS_PATTERN);
            matcher = pattern.matcher(roversCommand);
            List<String> roverCommands = new ArrayList<>();
            while (matcher.find()) {
                roverCommands.add(matcher.group(0));
            }
            buildPlateau();
            buildRoversAndCommandsFrom(roverCommands);
        }
    }

    private void buildPlateau() {
        Optional<Coordinate> plateauCoordinate = extractPlateauCoordinatesFromCommand();
        plateauCoordinate.ifPresent(coordinate -> this.plateau = new Plateau(coordinate));
    }

    private Optional<Coordinate> extractPlateauCoordinatesFromCommand() {
        if (!this.plateauCommand.isEmpty()) {
            var coordinateSnippet = this.plateauCommand.split("\\s");
            return Optional.of(new Coordinate(Integer.valueOf(coordinateSnippet[0]), Integer.valueOf(coordinateSnippet[1])));
        }
        return Optional.empty();
    }

    private void buildRoversAndCommandsFrom(List<String> roverCommands) {
        this.rovers = roverCommands.stream()
                .map(this::buildRoverFrom)
                .collect(Collectors.toList());
    }

    private Rover buildRoverFrom(String command) {
        Rover rover = null;
        var pattern = Pattern.compile(NASA_ROVER_PATTERN);
        var matcher = pattern.matcher(command);
        if (matcher.find()) {
            var roverPosition = matcher.group(1);
            var position = buildRoverPositionWith(roverPosition);
            rover = new Rover(position, plateau);
            var roverCommands = command.substring(matcher.group(1).length());
            buildCommandsFor(rover, roverCommands);
        }
        return rover;
    }

    private void buildCommandsFor(Rover rover, String roverCommands) {
        Stream<String> commands = roverCommands.codePoints()
                .mapToObj(c -> String.valueOf((char) c));
        this.commands.addAll(commands
                .map(command -> RoverCommandFactory.createCommand(rover, command))
                .collect(Collectors.toList()));

    }

    private Position buildRoverPositionWith(String roverPosition) {
        var roverPostionSplit = roverPosition.split("\\s");
        return new Position(
                new Coordinate(Integer.valueOf(roverPostionSplit[0]), Integer.valueOf(roverPostionSplit[1])),
                Heading.buildFrom(roverPostionSplit[2]));
    }

    public List<RoverCommand> getCommands() {
        return this.commands;
    }

    public List<Rover> getRovers() {
        return rovers;
    }
}
