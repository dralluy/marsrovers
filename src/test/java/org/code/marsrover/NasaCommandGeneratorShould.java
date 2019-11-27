package org.code.marsrover;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

@RunWith(JUnit4.class)
public class NasaCommandGeneratorShould {

    @Test
    public void create_plateau_with_selected_size_when_nasa_command_contains_plateau_coordinates() {
        String nasaCommand = "4 4";
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
}