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
        Plateau plateau = new Plateau();

        Assert.assertThat(plateau.getBottomLeftCoordinates(), CoreMatchers.is("0 0"));
    }
}
