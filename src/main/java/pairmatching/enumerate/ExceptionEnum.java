package pairmatching.enumerate;

public enum ExceptionEnum {
    INVALID_NUMBER("올바른 숫자 형태가 아닙니다.");

    private final String message;

    ExceptionEnum(String message) {
        this.message = message;
    }

    public String getMessage() {
        return "[ERROR] " + message;
    }
}