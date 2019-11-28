package org.code.marsrover;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class NasaCommandGenerator {
    private final String NASA_PLATEAU_PATTERN = "^(\\d\\s\\d\\s)";
    private final String NASA_ROVERS_PATTERN = "((\\d\\s\\d\\s[NSWE]\\s)([LRM])*)+";
    private final String NASA_ROVER_PATTERN = "(\\d\\s\\d\\s[NSWE]\\s)([LRM])*";
    private final String nasaCommand;
    private String plateauCommand = "";
    private List<String> roverCommands = new ArrayList<>();
    private List<RoverCommand> commands = new ArrayList<>();
    private Plateau plateau;
    private List<Rover> rovers;

    public NasaCommandGenerator(String nasaCommand) {
        this.nasaCommand = nasaCommand;
        buildInfraestructureFrom(nasaCommand);
    }

    public Plateau getPlateau() {
        return this.plateau;
    }

    private void buildInfraestructureFrom(String nasaCommand) {
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
            buildPlateauFrom(this.plateauCommand);
            buildRoversAndCommandsFrom(this.roverCommands);
        }
    }

    private void buildPlateauFrom(String plateauCommand) {
        Optional<Coordinate> plateauCoordinate = extractPlateauCoordinatesFromCommand();
        if (plateauCoordinate.isPresent())
            this.plateau = new Plateau(plateauCoordinate.get());
    }

    private Optional<Coordinate> extractPlateauCoordinatesFromCommand() {
        if (!this.plateauCommand.isEmpty()) {
            String[] coordinateSnippet = this.plateauCommand.split("\\s");
            return Optional.of(new Coordinate(Integer.valueOf(coordinateSnippet[0]), Integer.valueOf(coordinateSnippet[1])));
        }
        return Optional.empty();
    }

    private void buildRoversAndCommandsFrom(List<String> roverCommands) {
        this.rovers = roverCommands.stream()
                .map(command -> buildRoverFrom(command))
                .collect(Collectors.toList());
    }

    private Rover buildRoverFrom(String command) {
        Rover rover = null;
        Pattern pattern = Pattern.compile(NASA_ROVER_PATTERN);
        Matcher matcher = pattern.matcher(command);
        if (matcher.find()) {
            String roverPosition = matcher.group(1);
            Position position = buildRoverPositionWith(roverPosition);
            rover = new Rover(position);
            String roverCommands = command.substring(matcher.group(1).length());
            buildCommandsFor(rover, roverCommands);
        }
        return rover;
    }

    private void buildCommandsFor(Rover rover, String roverCommands) {
        Stream<String> commands = roverCommands.codePoints()
                .mapToObj(c -> String.valueOf((char) c));
        this.commands = commands
                .map(command -> RoverCommandFactory.createCommand(rover, command))
                .collect(Collectors.toList());

    }

    private Position buildRoverPositionWith(String roverPosition) {
        String[] roverPostionSplit = roverPosition.split("\\s");
        Position position = new Position(
                new Coordinate(Integer.valueOf(roverPostionSplit[0]), Integer.valueOf(roverPostionSplit[1])),
                Heading.buildFrom(roverPostionSplit[2]));
        return position;
    }

    public List<RoverCommand> getCommands() {
        return this.commands;
    }

    public List<Rover> getRovers() {
        return rovers;
    }
}
