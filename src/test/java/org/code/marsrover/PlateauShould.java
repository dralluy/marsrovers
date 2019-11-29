package org.code.marsrover;

import org.code.marsrover.domain.Coordinate;
import org.code.marsrover.domain.Plateau;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import static org.hamcrest.CoreMatchers.is;
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
    public void validate_that_coordinate_is_inside_plateau_bounds() {
        Coordinate upperRightCoordinates = new Coordinate(2, 2);
        Coordinate outsidePlateauCoordinate = new Coordinate(2,2);

        Plateau plateau = new Plateau(upperRightCoordinates);

        assertTrue(plateau.isInsideBounds(outsidePlateauCoordinate));
    }

    @Test
    public void validate_that_coordinate_is_outside_plateau_bounds() {
        Coordinate upperRightCoordinates = new Coordinate(2, 2);
        Coordinate outsidePlateauCoordinate = new Coordinate(2,3);

        Plateau plateau = new Plateau(upperRightCoordinates);

        assertFalse(plateau.isInsideBounds(outsidePlateauCoordinate));
    }
}
