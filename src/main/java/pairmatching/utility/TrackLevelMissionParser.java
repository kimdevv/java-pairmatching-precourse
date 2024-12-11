package pairmatching.utility;

import pairmatching.enumerate.Course;
import pairmatching.enumerate.ExceptionEnum;

public class TrackLevelMissionParser {
    public static void parse(String rawMission) {
        String[] splittedMission = rawMission.split(",", 0);
        validateSplit(splittedMission);
        validateTrack(splittedMission[0]);
        validateLevel(splittedMission[1]);
        validateMission(splittedMission[2]);
    }

    private static void validateSplit(String[] splittedMission) {
        if (splittedMission.length != 3) {
            throw new IllegalArgumentException(ExceptionEnum.INVALID_INPUT.getMessage());
        }
    }

    private static void validateTrack(String track) {
        if (track.equals("백엔드") || track.equals("프론트엔드")) {
            return;
        }
        throw new IllegalArgumentException(ExceptionEnum.INVALID_INPUT.getMessage());
    }

    private static void validateLevel(String level) {
        if (!level.startsWith("레벨")) {
            throw new IllegalArgumentException(ExceptionEnum.INVALID_INPUT.getMessage());
        }
        if (level.length() != 3) {
            throw new IllegalArgumentException(ExceptionEnum.INVALID_INPUT.getMessage());
        }
        if (level.charAt(2) - '0' < 1 || level.charAt(2) - '0' > 5) {
            throw new IllegalArgumentException(ExceptionEnum.INVALID_INPUT.getMessage());
        }
    }

    private static void validateMission(String mission) {
        if (!Course.isRegisteredCourse(mission)) {
            throw new IllegalArgumentException(ExceptionEnum.INVALID_INPUT.getMessage());
        }
    }
}
