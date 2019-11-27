package org.code.marsrover;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

@RunWith(JUnit4.class)
public class PlateauShould {
    @Test
    public void initialize_plateau_bottom_left_coordinates_to_zero_when_created() {
        Coordinate upperRightCoordinates = new Coordinate(1, 1);
        Coordinate expectedBottomLeftCoordinates = new Coordinate(0,0);

        Plateau plateau = new Plateau(upperRightCoordinates);

        assertThat(plateau.getBottomLeftCoordinates(), is(expectedBottomLeftCoordinates));
    }

    @Test
    public void initialize_plateau_upper_right_coordinates_to_passed_values_when_created() {
        Coordinate upperRightCoordinates = new Coordinate(1, 1);
        Coordinate expectedUpperRightCoordinates = new Coordinate(1,1);

        Plateau plateau = new Plateau(upperRightCoordinates);

        assertThat(plateau.getUpperRightCoordinates(), is(expectedUpperRightCoordinates));
    }

    @Test
    public void initialize_plateau_coordinates_using_nasa_command_values_when_created() {
        String nasaCommand = "4 4";
        Coordinate upperRightCoordinate = new NasaCommandGenerator(nasaCommand).extractPlateauCoordinatesFromCommand().get();
        Coordinate expectedUpperRightCoordinates = new Coordinate(4,4);

        Plateau plateau = new Plateau(upperRightCoordinate);

        assertThat(plateau.getUpperRightCoordinates(), is(expectedUpperRightCoordinates));
    }
}
