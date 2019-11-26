package org.code.marsrover;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import static org.hamcrest.core.Is.is;

@RunWith(JUnit4.class)
public class RoverShould {
    @Test
    public void have_a_position_represented_by_a_coordinate_and_a_heading() {

        Coordinate coordinate = new Coordinate(1, 3);
        String heading = "N";

        Rover rover = new Rover(coordinate, heading);

        Assert.assertThat(rover.getPosition(), is("1 3 N"));
    }
}
