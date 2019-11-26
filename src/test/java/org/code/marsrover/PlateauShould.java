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
        Plateau plateau = new Plateau(0,0);

        Assert.assertThat(plateau.getBottomLeftCoordinates().getX(), CoreMatchers.is(0));
        Assert.assertThat(plateau.getBottomLeftCoordinates().getY(), CoreMatchers.is(0));
    }

    @Test
    public void initialize_plateau_upper_right_coordinates_to_sent_values_when_created() {
        int x = 1;
        int y = 1;
        Plateau plateau = new Plateau(x, y);

        Assert.assertThat(plateau.getXUpperRightCoordinate(), CoreMatchers.is(1));
        Assert.assertThat(plateau.getYUpperRightCoordinate(), CoreMatchers.is(1));
    }
}
