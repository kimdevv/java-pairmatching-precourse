package pairmatching.utility;

import pairmatching.enumerate.ExceptionEnum;

public class StringToIntParser {
    public static int parse(String rawText) {
        try {
            return Integer.parseInt(rawText);
        } catch (NumberFormatException exception) {
            throw new IllegalArgumentException(ExceptionEnum.INVALID_NUMBER.getMessage());
        }
    }
}
