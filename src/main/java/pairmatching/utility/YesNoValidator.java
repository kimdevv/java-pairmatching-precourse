package pairmatching.utility;

import pairmatching.enumerate.ExceptionEnum;

public class YesNoValidator {
    public static void validate(String yesNo) {
        if (yesNo.equals("예") || yesNo.equals("아니오")) {
            return;
        }
        throw new IllegalArgumentException(ExceptionEnum.INVALID_INPUT.getMessage());
    }
}
