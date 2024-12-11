package pairmatching.model;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Pairs {
    private List<String> crewNames;
    private List<String> shuffledCrew;

    public Pairs(String rawNames) {
        crewNames = new ArrayList<>();
        String[] splittedNames = rawNames.split("\n");
        Arrays.stream(splittedNames)
                .forEach(crewNames::add);
        shuffledCrew = Randoms.shuffle(crewNames);
    }
}
