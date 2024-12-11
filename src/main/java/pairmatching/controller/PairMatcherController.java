package pairmatching.controller;

import pairmatching.utility.StringToIntParser;
import pairmatching.view.InputView;

public class PairMatcherController {
    public void run() {
        int feature = inputFeature();
    }

    private int inputFeature() {
        String rawFeature = InputView.inputFeature();
        return StringToIntParser.parse(rawFeature);
    }
}
