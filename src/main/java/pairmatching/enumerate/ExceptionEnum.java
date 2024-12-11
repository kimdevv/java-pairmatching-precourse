package pairmatching.enumerate;

public enum ExceptionEnum {
    INVALID_NUMBER("올바른 숫자 형태가 아닙니다."),
    INVALID_FEATURE_NUMBER("기능은 1, 2, 3, Q만 입력 가능합니다."),
    INVALID_INPUT("올바르지 않은 입력값입니다.");

    private final String message;

    ExceptionEnum(String message) {
        this.message = message;
    }

    public String getMessage() {
        return "[ERROR] " + message;
    }
}