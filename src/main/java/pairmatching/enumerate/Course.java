package pairmatching.enumerate;

import pairmatching.dto.TrackLevelMissionDto;

public enum Course {
    RACE(1, "자동차경주"),
    LOTTO(1, "로또"),
    NUMBER_BASEBALL(1, "숫자야구게임"),
    BASKET(2, "장바구니"),
    PAY(2, "결제"),
    SUBWAY(2, "지하철노선도"),
    OPTIMIZING(4, "성능개선"),
    SHARE(4, "배포");

    private int level;
    private String name;

    Course(int level, String name) {
        this.level = level;
        this.name = name;
    }

    public int getLevel() {
        return this.level;
    }

    public String getName() {
        return this.name;
    }

    public static boolean isRegisteredCourse(String name) {
        for (Course course : Course.values()) {
            if (course.getName().equals(name)) {
                return true;
            }
        }
        return false;
    }

    public static void validateTrackLevelMission(TrackLevelMissionDto dto) {
        for (Course course : Course.values()) {
            if (course.getLevel() == dto.level() && course.getName().equals(dto.courseName())) {
                return;
            }
        }
        throw new IllegalArgumentException(ExceptionEnum.INVALID_INPUT.getMessage());
    }
}
