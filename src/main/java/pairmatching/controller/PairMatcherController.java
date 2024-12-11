package pairmatching.controller;

import pairmatching.dto.TrackLevelMissionDto;
import pairmatching.enumerate.Course;
import pairmatching.model.Pairs;
import pairmatching.utility.*;
import pairmatching.view.InputView;

public class PairMatcherController {
    Pairs backendPairs;
    Pairs frontendPairs;

    public void run() {
        initiateCrewNames();
        while (true) {
            int featureNumber = inputFeature();
            if (featureNumber == 0) {
                break;
            }
            divideByFeatureNumber(featureNumber);
        }
    }

    private void initiateCrewNames() {
        String backendCrewNames = FileReader.getCrewNamesFromFile("src/main/resources/backend-crew.md");
        String frontendCrewNames = FileReader.getCrewNamesFromFile("src/main/resources/frontend-crew.md");
        backendPairs = new Pairs(backendCrewNames);
        frontendPairs = new Pairs(frontendCrewNames);
    }

    private int inputFeature() {
        String rawFeature = InputView.inputFeature();
        if (rawFeature.equals("Q")) {
            rawFeature = "0";
        }

        int featureNumber = StringToIntParser.parse(rawFeature);
        FeatureNumberValidator.validate(featureNumber);
        return featureNumber;
    }

    private void divideByFeatureNumber(int featureNumber) {
        if (featureNumber == 1) { // 페어 매칭
            pairMatching();
        }
        if (featureNumber == 2) { // 페어 조회

        }
        if (featureNumber == 3) { // 페어 초기화

        }
    }

    private void pairMatching() {
        TrackLevelMissionDto trackLevelMissionDto = inputTrackLevelMission();
    }

    private TrackLevelMissionDto inputTrackLevelMission() {
        String[] courseNames = CourseNameParser.parse(Course.values());
        String rawMission = InputView.inputMission(courseNames);
        return TrackLevelMissionParser.parse(rawMission);

    }
}
