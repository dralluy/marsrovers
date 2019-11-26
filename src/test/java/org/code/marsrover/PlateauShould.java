package org.code.marsrover;

import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class PlateauShould {
    @Test
    public void initialize_plateau_bottom_left_coordinates_to_zero_when_created() {
        Coordinate upperRightCoordinates = new Coordinate(1, 1);
        Coordinate expectedBottomLeftCoordinates = new Coordinate(0,0);

        Plateau plateau = new Plateau(upperRightCoordinates);

        Assert.assertThat(plateau.getBottomLeftCoordinates(), CoreMatchers.is(expectedBottomLeftCoordinates));
    }

    @Test
    public void initialize_plateau_upper_right_coordinates_to_sent_values_when_created() {
        Coordinate upperRightCoordinates = new Coordinate(1, 1);
        Coordinate expectedUpperRightCoordinates = new Coordinate(1,1);

        Plateau plateau = new Plateau(upperRightCoordinates);

        Assert.assertThat(plateau.getUpperRightCoordinates(), CoreMatchers.is(expectedUpperRightCoordinates));
    }
}
