package com.nasa.rover.operation.validator;

import com.nasa.rover.operation.constant.Common;
import com.nasa.rover.operation.constant.ValidationRegex;
import com.nasa.rover.operation.dto.Direction;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;

public class InputValidator {

    private static Pattern pattern = Pattern.compile(ValidationRegex.NAVIGATION_COMMAND_VALIDATOR_REGEX);

    public static boolean isValidBoundInput(String boundInput) {
        boolean isValid = false;

        if (boundInput != null && !boundInput.isEmpty()) {
            List<String> bound = Arrays.asList(boundInput.split(Common.SPACE));
            return bound.size() == 2 && bound.stream().allMatch(val -> val.matches(ValidationRegex.ONLY_DIGIT_REGEX));
        }


        return isValid;
    }

    public static boolean isValidCurrentLocationInput(String locationInput) {
        boolean isValid = false;

        if (locationInput != null && !locationInput.isEmpty()) {
            String[] bound = locationInput.split(Common.SPACE);
            isValid = bound.length == 3 && bound[0].matches(ValidationRegex.ONLY_DIGIT_REGEX)
                    && bound[1].matches(ValidationRegex.ONLY_DIGIT_REGEX)
                    && isValidDirection(bound[2]);
        }

        return isValid;
    }

    public static boolean isValidNavigationString(String command) {
        return command != null && !command.isEmpty() && pattern.matcher(command).matches();
    }

    private static boolean isValidDirection(String test) {
        for (Direction c : Direction.values()) {
            if (c.name().equals(test)) {
                return true;
            }
        }

        return false;
    }
}
