package com.nasa.rover.operation.service;

public class RoverNavigation {
    public void navigate (MarsRover marsRover, String navigationString) {
        marsRover.navigate(navigationString);
        marsRover.displayCurrentLocation();
    }
}
