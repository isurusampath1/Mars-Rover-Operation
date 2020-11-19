package com.nasa.rover.operation.dto;

public class Bound {

    private final int upperX;
    private final int upperY;
    private final int lowerX = 0;
    private final int lowerY = 0;

    public Bound(int upperX, int upperY) {
        this.upperX = upperX;
        this.upperY = upperY;
    }

    public int getUpperX() {
        return upperX;
    }

    public int getUpperY() {
        return upperY;
    }

    public int getLowerX() {
        return lowerX;
    }

    public int getLowerY() {
        return lowerY;
    }

    public boolean isValidBound(int x, int y) {
        return x < upperX && y < upperY;
    }
}
