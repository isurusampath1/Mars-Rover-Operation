package com.nasa.rover.operation;

import com.nasa.rover.operation.constant.Common;
import com.nasa.rover.operation.dto.Bound;
import com.nasa.rover.operation.dto.Direction;
import com.nasa.rover.operation.exception.OperationException;
import com.nasa.rover.operation.service.MarsRover;
import com.nasa.rover.operation.validator.InputValidator;

import java.util.Scanner;

public class App 
{
    public static void main( String[] args )
    {
        System.out.println("Rover instructions :");
        Scanner input = new Scanner(System.in);

        String boundInput = input.nextLine().trim();
        if (InputValidator.isValidBoundInput(boundInput)) {
            String[] boundInputArray = boundInput.split(" ");
            final Bound bound = new Bound(Integer.parseInt(boundInputArray[0]),Integer.parseInt(boundInputArray[1]));

            while (!input.hasNext(Common.QUIT)) {
                String currentLocation = input.nextLine().trim();
                if (InputValidator.isValidCurrentLocationInput(currentLocation)) {
                    String[] currentLocationArray = currentLocation.split(Common.SPACE);

                    if (bound.isValidBound(Integer.parseInt(currentLocationArray[0]), Integer.parseInt(currentLocationArray[1]))) {
                        MarsRover marsRover = new MarsRover(Integer.parseInt(currentLocationArray[0]),
                                Integer.parseInt(currentLocationArray[1]),
                                Direction.valueOf(currentLocationArray[2]));

                        String navigationString = input.nextLine().trim();
                        if (InputValidator.isValidNavigationString(navigationString)) {
                            marsRover.navigate(navigationString);
                            marsRover.displayCurrentLocation();
                        } else {
                            throw new OperationException("Invalid navigation command string");
                        }
                    } else {
                        throw new OperationException("Current location exceeds the cound coordinates");
                    }
                } else {
                    throw new OperationException("Invalid current location");
                }
            }
        } else {
            throw new OperationException("Invalid upper bounds");
        }
    }
}
