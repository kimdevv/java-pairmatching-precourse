package pairmatching.utility;

import pairmatching.enumerate.ExceptionEnum;

public class FeatureNumberValidator {
    public static void validate(int featureNumber) {
        if (featureNumber < 0 || featureNumber > 3) {
            throw new IllegalArgumentException(ExceptionEnum.INVALID_FEATURE_NUMBER.getMessage());
        }
    }
}
