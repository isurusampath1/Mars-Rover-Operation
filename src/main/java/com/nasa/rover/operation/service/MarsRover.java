package com.nasa.rover.operation.service;

import com.nasa.rover.operation.dto.Direction;
import com.nasa.rover.operation.exception.OperationException;

public class MarsRover {

    private int x;
    private int y;
    private Direction head;

    public MarsRover(int x, int y, Direction head) {
        this.x = x;
        this.y = y;
        this.head = head;
    }

    public void navigate(String navigationCommandString) {
        for (int i = 0; i < navigationCommandString.length(); i++) {
            if (navigationCommandString.charAt(i) == 'L')
                rotateLeft();
            else if (navigationCommandString.charAt(i) == 'R')
                rotateRight();
            else if (navigationCommandString.charAt(i) == 'M')
                moveRover();
            else {
                throw new OperationException("invalid navigation command");
            }
        }
    }

    public void displayCurrentLocation(){
        System.out.println("X position - " + x);
        System.out.println("Y position - " + y);
        System.out.println("heading into - " + head.name());
    }

    public int getXCoordinate() {
        return x;
    }

    public int getYCoordinate() {
        return y;
    }

    public String getHeadingDirection() {
        return head.name();
    }

    private void rotateLeft() {
        switch (head) {
            case N:
                head = Direction.W;
                break;
            case W:
                head = Direction.S;
                break;
            case S:
                head = Direction.E;
                break;
            case E:
                head = Direction.N;
                break;
            default:
                throw new OperationException("invalid current direction in left rotation");
        }
    }

    private void rotateRight() {
        switch (head) {
            case N:
                head = Direction.E;
                break;
            case E:
                head = Direction.S;
                break;
            case S:
                head = Direction.W;
                break;
            case W:
                head = Direction.N;
                break;
            default:
                throw new OperationException("invalid current direction in right rotation");
        }
    }

    //getting rover positions according to x,y axis
    private void moveRover() {
        if (head == Direction.N)
            y++;
        else if (head == Direction.E)
            x++;
        else if (head == Direction.S)
            y--;
        else if (head == Direction.W)
            x--;
    }
}
