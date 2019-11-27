package org.code.marsrover;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import static org.code.marsrover.Heading.*;
import static org.hamcrest.core.Is.is;

@RunWith(JUnit4.class)
public class RoverShould {

    @Test
    public void have_a_position_represented_by_a_coordinate_and_a_heading() {
        Coordinate coordinate = new Coordinate(1, 3);
        Position position = new Position(coordinate, NORTH);

        Position expectedPosition = new Position(new Coordinate(1,3), NORTH);
        Rover rover = new Rover(position);

        Assert.assertThat(rover.getPosition().toString(), is(expectedPosition.toString()));
    }

    @Test
    public void increment_y_coordinate_when_moving_north() {
        Coordinate coordinate = new Coordinate(1, 3);
        Position position = new Position(coordinate, NORTH);

        Position expectedPosition = new Position(new Coordinate(1,4), NORTH);

        Rover rover = new Rover(position);
        rover.move(NORTH);

        Assert.assertThat(rover.getPosition().toString(), is(expectedPosition.toString()));
    }

    @Test
    public void decrement_y_coordinate_when_moving_south() {
        Coordinate coordinate = new Coordinate(1, 3);
        Position position = new Position(coordinate, SOUTH);

        Position expectedPosition = new Position(new Coordinate(1,2), SOUTH);

        Rover rover = new Rover(position);
        rover.move(SOUTH);

        Assert.assertThat(rover.getPosition().toString(), is(expectedPosition.toString()));
    }

    @Test
    public void increment_x_coordinate_when_moving_east() {
        Coordinate coordinate = new Coordinate(1, 3);
        Position position = new Position(coordinate, EAST);

        Position expectedPosition = new Position(new Coordinate(2,3), EAST);

        Rover rover = new Rover(position);
        rover.move(EAST);

        Assert.assertThat(rover.getPosition().toString(), is(expectedPosition.toString()));
    }

    @Test
    public void decrement_x_coordinate_when_moving_west() {
        Coordinate coordinate = new Coordinate(1, 3);
        Position position = new Position(coordinate, WEST);

        Position expectedPosition = new Position(new Coordinate(0,3), WEST);

        Rover rover = new Rover(position);
        rover.move(WEST);

        Assert.assertThat(rover.getPosition().toString(), is(expectedPosition.toString()));
    }

    @Test
    public void change_heading_to_south_when_left_command_received_and_heading_west() {
        Coordinate coordinate = new Coordinate(1, 3);
        Position position = new Position(coordinate, WEST);

        Rover rover = new Rover(position);
        rover.turnLeft();

        Assert.assertThat(rover.getPosition().getHeading(), is(SOUTH));
    }
}
