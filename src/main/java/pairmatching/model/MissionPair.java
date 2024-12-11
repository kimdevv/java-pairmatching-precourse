package pairmatching.model;

import java.util.List;

public class MissionPair {
    private String track;
    private String missionName;
    private List<String> pairNames;

    public MissionPair(String track, String missionName, List<String> pairNames) {
        this.track = track;
        this.missionName = missionName;
        this.pairNames = pairNames;
    }

    public String getTrack() {
        return this.track;
    }

    public String getMissionName() {
        return this.missionName;
    }

    public List<String> getPairNames() {
        return this.pairNames;
    }
}
