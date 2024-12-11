package pairmatching.controller;

import pairmatching.utility.FeatureNumberValidator;
import pairmatching.utility.StringToIntParser;
import pairmatching.view.InputView;

public class PairMatcherController {
    public void run() {
        while (true) {
            int featureNumber = inputFeature();
            if (featureNumber == 0) {
                break;
            }
            divideByFeatureNumber(featureNumber);
        }
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

        }
        if (featureNumber == 2) { // 페어 조회

        }
        if (featureNumber == 3) { // 페어 초기화

        }
    }
}
