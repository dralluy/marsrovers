package org.code.marsrover;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import static org.hamcrest.core.Is.is;

@RunWith(JUnit4.class)
public class RoverShould {

    private static final String HEADING_NORTH = "N";

    @Test
    public void have_a_position_represented_by_a_coordinate_and_a_heading() {
        Coordinate coordinate = new Coordinate(1, 3);
        Position position = new Position(coordinate, HEADING_NORTH);

        Position expectedPosition = new Position(new Coordinate(1,3), HEADING_NORTH);
        Rover rover = new Rover(position);

        Assert.assertThat(rover.getPosition().toString(), is(expectedPosition.toString()));
    }
}
