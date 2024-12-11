package pairmatching;

import pairmatching.controller.PairMatcherController;

public class Application {
    public static void main(String[] args) {
        PairMatcherController controller = new PairMatcherController();
        controller.run();
    }
}
