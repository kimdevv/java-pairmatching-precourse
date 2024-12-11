package pairmatching.controller;

import pairmatching.dto.TrackLevelMissionDto;
import pairmatching.enumerate.Course;
import pairmatching.enumerate.ExceptionEnum;
import pairmatching.model.Crew;
import pairmatching.model.LevelPairs;
import pairmatching.model.MissionPair;
import pairmatching.utility.*;
import pairmatching.view.InputView;
import pairmatching.view.OutputView;

import java.util.ArrayList;
import java.util.List;

public class PairMatcherController {
    Crew backendCrew;
    Crew frontendCrew;
    List<LevelPairs> levelPairsList;
    List<MissionPair> missionPairs = new ArrayList<>();

    public void run() {
        initiateCrewNames();
        initiateLevelPairsList();
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
        backendCrew = new Crew(backendCrewNames);
        frontendCrew = new Crew(frontendCrewNames);
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
        for (int i=0; i<=3; i++) {
            if (i==3) {
                throw new IllegalArgumentException(ExceptionEnum.INVALID_INPUT.getMessage());
            }
            List<String> pairNames = frontendCrew.getRandomNames();
            if (trackLevelMissionDto.track().equals("백엔드")) {
                pairNames = backendCrew.getRandomNames();
            }
            if (this.levelPairsList.get(trackLevelMissionDto.level()).checkDuplicate(pairNames)) {
                continue;
            }
            MissionPair newPair = new MissionPair(trackLevelMissionDto.track(), trackLevelMissionDto.courseName(), pairNames);
            this.missionPairs.add(newPair);
            OutputView.outputPairResult(newPair.getPairNames());
        }
    }

    private TrackLevelMissionDto inputTrackLevelMission() {
        String[] courseNames = CourseNameParser.parse(Course.values());
        String rawMission = InputView.inputMission(courseNames);
        return TrackLevelMissionParser.parse(rawMission);
    }

    private List<LevelPairs> initiateLevelPairsList() {
        List<LevelPairs> levelPairsList = new ArrayList<>();
        for (int i=0; i<=5; i++) {
            levelPairsList.add(new LevelPairs(i));
        }
        return levelPairsList;
    }
}
