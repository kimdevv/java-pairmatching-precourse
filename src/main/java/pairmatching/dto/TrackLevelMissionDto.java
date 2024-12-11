package pairmatching.dto;

public class TrackLevelMissionDto {
    private static String track;
    private static int level;
    private static String courseName;

    public TrackLevelMissionDto(String track, int level, String courseName) {
        this.track = track;
        this.level = level;
        this.courseName = courseName;
    }

    public String track() {
        return this.track;
    }

    public int level() {
        return this.level;
    }

    public String courseName() {
        return this.courseName();
    }
}
