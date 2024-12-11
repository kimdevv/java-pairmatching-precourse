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
    List<MissionPair> missionPairs;

    public void run() {
        initiateCrewNames();
        resetPairs();
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

    private void resetPairs() {
        initiateLevelPairsList();
        initiateMissionPairs();
    }

    private int inputFeature() {
        while (true) {
            try {
                String rawFeature = InputView.inputFeature();
                if (rawFeature.equals("Q")) {
                    rawFeature = "0";
                }

                int featureNumber = StringToIntParser.parse(rawFeature);
                FeatureNumberValidator.validate(featureNumber);
                return featureNumber;
            } catch (IllegalArgumentException exception) {
                System.out.println(exception.getMessage());
            }
        }
    }

    private void divideByFeatureNumber(int featureNumber) {
        if (featureNumber == 1) { // 페어 매칭
            pairMatching();
        }
        if (featureNumber == 2) { // 페어 조회
            pairCheck();
        }
        if (featureNumber == 3) { // 페어 초기화
            resetPairs();
            OutputView.outputReset();
        }
    }

    private void pairMatching() {
        outputCourseInformation();
        while (true) {
            try {
                TrackLevelMissionDto trackLevelMissionDto = inputTrackLevelMission();
                Course.validateTrackLevelMission(trackLevelMissionDto);
                MissionPair existPair = getExistPair(trackLevelMissionDto);
                if (existPair != null) {
                    askReMatching(existPair);
                }
                for (int i = 0; i <= 3; i++) {
                    if (i == 3) {
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
                    return;
                }
            } catch (IllegalArgumentException exception) {
                System.out.println(exception.getMessage());
            }
        }
    }

    private void askReMatching(MissionPair existPair) {
        String answer = InputView.inputReMatching();
        if (answer.equals("예")) {
            this.missionPairs.remove(existPair);
            return;
        }
        throw new IllegalArgumentException("");
    }

    private void outputCourseInformation() {
        String[] courseNames = CourseNameParser.parse(Course.values());
        OutputView.outputCourseInfo(courseNames);
    }

    private TrackLevelMissionDto inputTrackLevelMission() {
        String rawMission = InputView.inputMission();
        return TrackLevelMissionParser.parse(rawMission.replace(" ", ""));
    }

    private void initiateLevelPairsList() {
        this.levelPairsList = new ArrayList<>();
        for (int i=0; i<=5; i++) {
            this.levelPairsList.add(new LevelPairs(i));
        }
    }

    private void initiateMissionPairs() {
        this.missionPairs = new ArrayList<>();
    }

    private void pairCheck() {
        while (true) {
            try {
                TrackLevelMissionDto trackLevelMissionDto = inputTrackLevelMission();
                MissionPair thePair = getExistPair(trackLevelMissionDto);
                if (thePair == null) {
                    throw new IllegalArgumentException(ExceptionEnum.INVALID_INPUT.getMessage());
                }
                OutputView.outputPairResult(thePair.getPairNames());
                return;
            } catch (IllegalArgumentException exception) {
                System.out.println(exception.getMessage());
            }
        }
    }

    private MissionPair getExistPair(TrackLevelMissionDto trackLevelMissionDto) {
        for (MissionPair missionPair : this.missionPairs) {
            if (missionPair.getTrack().equals(trackLevelMissionDto.track()) &&
                    missionPair.getMissionName().equals(trackLevelMissionDto.courseName())) {
                return missionPair;
            }
        }
        return null;
    }
}
