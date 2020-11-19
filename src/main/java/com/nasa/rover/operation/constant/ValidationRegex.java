package com.nasa.rover.operation.constant;

public class ValidationRegex {

    private ValidationRegex(){

    }

    public static final String NAVIGATION_COMMAND_VALIDATOR_REGEX = "^[LRM]*$";
    public static final String ONLY_DIGIT_REGEX = "[0-9]+";
}
