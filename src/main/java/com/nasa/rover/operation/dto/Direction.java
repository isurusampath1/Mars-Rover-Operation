package com.nasa.rover.operation.dto;

public enum Direction {
    N(1), E(2), S(3), W(4);

    public final int directionValue;

    private Direction(int directionValue) {
        this.directionValue = directionValue;
    }
}
