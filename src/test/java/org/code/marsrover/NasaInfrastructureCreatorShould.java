package org.code.marsrover;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

@RunWith(JUnit4.class)
public class NasaInfrastructureCreatorShould {

    @Test
    public void create_plateau_with_selected_size_when_nasa_command_contains_plateau_coordinates() {
        String nasaCommand = "4 4 1 2 N";
        Coordinate expectedUpperRightCoordinates = new Coordinate(4,4);
        Coordinate expectedBottomLeftCoordinates = new Coordinate(0,0);

        NasaInfrastructureCreator nasaInfrastructureCreator = new NasaInfrastructureCreator(nasaCommand);
        Plateau plateau = nasaInfrastructureCreator.getPlateau();

        assertThat(plateau.getUpperRightCoordinates(), is(expectedUpperRightCoordinates));
        assertThat(plateau.getBottomLeftCoordinates(), is(expectedBottomLeftCoordinates));
    }

    @Test
    public void not_create_plateau_when_nasa_command_is_empty() {
        String nasaCommand = "";

        NasaInfrastructureCreator nasaInfrastructureCreator = new NasaInfrastructureCreator(nasaCommand);
        Plateau plateau = nasaInfrastructureCreator.getPlateau();

        assertNull(plateau);
    }

    @Test
    public void create_rover_with_selected_position_and_heading_when_nasa_command_contains_rover_data() {
        String nasaCommand = "4 4 1 2 N LM";
        Position expectedRoverPosition = new Position(new Coordinate(1, 2), Heading.NORTH);

        NasaInfrastructureCreator nasaInfrastructureCreator = new NasaInfrastructureCreator(nasaCommand);
        List<Rover> rovers = nasaInfrastructureCreator.getRovers();

        assertNotNull(rovers);
        assertThat(rovers.size(), is(1));
        assertThat(rovers.get(0).getPosition(), is(expectedRoverPosition));
    }

    @Test
    public void create_rover_move_commands_when_nasa_command_contains_M_commands() {
        String nasaCommand = "4 4 1 2 N MM";

        NasaInfrastructureCreator nasaInfrastructureCreator = new NasaInfrastructureCreator(nasaCommand);
        List<RoverCommand> roverCommands = nasaInfrastructureCreator.getCommands();

        assertNotNull(roverCommands);
        assertThat(roverCommands.size(), is(2));
        assertTrue(roverCommands.get(0) instanceof RoverMoveCommand);
    }

    @Test
    public void create_rover_left_commands_when_nasa_command_contains_L_commands() {
        String nasaCommand = "4 4 1 2 N ML";

        NasaInfrastructureCreator nasaInfrastructureCreator = new NasaInfrastructureCreator(nasaCommand);
        List<RoverCommand> roverCommands = nasaInfrastructureCreator.getCommands();

        assertNotNull(roverCommands);
        assertThat(roverCommands.size(), is(2));
        assertTrue(roverCommands.stream().filter(c -> c instanceof RoverTurnLeftCommand).findAny().isPresent());
    }

    @Test
    public void create_rover_turn_rifht_commands_when_nasa_command_contains_R_commands() {
        String nasaCommand = "4 4 1 2 N RL";

        NasaInfrastructureCreator nasaInfrastructureCreator = new NasaInfrastructureCreator(nasaCommand);
        List<RoverCommand> roverCommands = nasaInfrastructureCreator.getCommands();

        assertNotNull(roverCommands);
        assertThat(roverCommands.size(), is(2));
        assertTrue(roverCommands.stream().filter(c -> c instanceof RoverTurnRightCommand).findAny().isPresent());
    }

    @Test
    public void create_rover_do_nothing_commands_when_nasa_command_contains_commands_different_from_RLM() {
        String nasaCommand = "4 4 1 2 N X";

        NasaInfrastructureCreator nasaInfrastructureCreator = new NasaInfrastructureCreator(nasaCommand);
        List<RoverCommand> roverCommands = nasaInfrastructureCreator.getCommands();

        assertNotNull(roverCommands);
        assertThat(roverCommands.size(), is(1));
        assertTrue(roverCommands.stream().filter(c -> c instanceof RoverDoNothingCommand).findAny().isPresent());
    }
}