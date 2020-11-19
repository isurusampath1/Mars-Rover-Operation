package com.nasa.rover.operation;

import com.nasa.rover.operation.dto.Direction;
import com.nasa.rover.operation.service.MarsRover;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

public class AppTest extends TestCase
{
    public AppTest( String testName )
    {
        super( testName );
    }

    public static Test suite()
    {
        return new TestSuite( AppTest.class );
    }


    public void test_rover_for_valid_input_1()
    {
        MarsRover marsRover = new MarsRover(1, 2, Direction.N);
        marsRover.navigate("LMLMLMLMM");

        assertEquals(marsRover.getXCoordinate(), 1);
        assertEquals(marsRover.getYCoordinate(), 3);
        assertEquals(marsRover.getHeadingDirection(), Direction.N.name());
    }

    public void test_rover_for_valid_input_2()
    {
        MarsRover marsRover = new MarsRover(3, 3, Direction.E);
        marsRover.navigate("MMRMMRMRRM");

        assertEquals(marsRover.getXCoordinate(), 5);
        assertEquals(marsRover.getYCoordinate(), 1);
        assertEquals(marsRover.getHeadingDirection(), Direction.E.name());
    }

    public void test_rover_for_valid_input_3()
    {
        MarsRover marsRover = new MarsRover(2, 2, Direction.E);
        marsRover.navigate("MMRMMRM");

        assertEquals(marsRover.getXCoordinate(), 3);
        assertEquals(marsRover.getYCoordinate(), 0);
        assertEquals(marsRover.getHeadingDirection(), Direction.W.name());
    }

    public void test_rover_for_valid_input_4()
    {
        MarsRover marsRover = new MarsRover(3, 4, Direction.S);
        marsRover.navigate("MMRMRM");

        assertEquals(marsRover.getXCoordinate(), 2);
        assertEquals(marsRover.getYCoordinate(), 3);
        assertEquals(marsRover.getHeadingDirection(), Direction.N.name());
    }

    public void test_rover_for_valid_input_5()
    {
        MarsRover marsRover = new MarsRover(4, 2, Direction.W);
        marsRover.navigate("MRMLMLM");

        assertEquals(marsRover.getXCoordinate(), 2);
        assertEquals(marsRover.getYCoordinate(), 2);
        assertEquals(marsRover.getHeadingDirection(), Direction.S.name());
    }
}
