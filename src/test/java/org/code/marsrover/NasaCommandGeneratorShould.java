package org.code.marsrover;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

@RunWith(JUnit4.class)
public class NasaCommandGeneratorShould {

    @Test
    public void create_plateau_with_selected_size_when_nasa_command_contains_plateau_coordinates() {
        String nasaCommand = "4 4 1 2 N";
        Coordinate expectedUpperRightCoordinates = new Coordinate(4,4);
        Coordinate expectedBottomLeftCoordinates = new Coordinate(0,0);

        NasaCommandGenerator nasaCommandGenerator = new NasaCommandGenerator(nasaCommand);
        Plateau plateau = nasaCommandGenerator.getPlateau();

        assertThat(plateau.getUpperRightCoordinates(), is(expectedUpperRightCoordinates));
        assertThat(plateau.getBottomLeftCoordinates(), is(expectedBottomLeftCoordinates));
    }

    @Test
    public void not_create_plateau_when_nasa_command_is_empty() {
        String nasaCommand = "";

        NasaCommandGenerator nasaCommandGenerator = new NasaCommandGenerator(nasaCommand);
        Plateau plateau = nasaCommandGenerator.getPlateau();

        assertNull(plateau);
    }

    @Test
    public void create_rover_with_selected_position_and_heading_when_nasa_command_contains_rover_data() {
        String nasaCommand = "4 4 1 2 N LM";
        Position expectedRoverPosition = new Position(new Coordinate(1, 2), Heading.NORTH);

        NasaCommandGenerator nasaCommandGenerator = new NasaCommandGenerator(nasaCommand);
        List<Rover> rovers = nasaCommandGenerator.getRovers();

        assertNotNull(rovers);
        assertThat(rovers.size(), is(1));
        assertThat(rovers.get(0).getPosition(), is(expectedRoverPosition));
    }

    @Test
    public void create_rover_move_commands_when_nasa_command_contains_M_commands() {
        String nasaCommand = "4 4 1 2 N MM";

        NasaCommandGenerator nasaCommandGenerator = new NasaCommandGenerator(nasaCommand);
        List<RoverCommand> roverCommands = nasaCommandGenerator.getCommands();

        assertNotNull(roverCommands);
        assertThat(roverCommands.size(), is(2));
        assertTrue(roverCommands.get(0) instanceof RoverMoveCommand);
    }

    @Test
    public void create_rover_left_commands_when_nasa_command_contains_L_commands() {
        String nasaCommand = "4 4 1 2 N ML";

        NasaCommandGenerator nasaCommandGenerator = new NasaCommandGenerator(nasaCommand);
        List<RoverCommand> roverCommands = nasaCommandGenerator.getCommands();

        assertNotNull(roverCommands);
        assertThat(roverCommands.size(), is(2));
        assertTrue(roverCommands.stream().filter(c -> c instanceof RoverTurnLeftCommand).findAny().isPresent());
    }
}