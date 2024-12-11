package pairmatching.model;

import java.util.ArrayList;
import java.util.List;

public class LevelPairs {
    private int level;
    private List<String> registeredPairs;

    public LevelPairs(int level) {
        this.level = level;
        this.registeredPairs = new ArrayList<>();
    }

    public boolean checkDuplicate(List<String> pairNames) {
        for (String pairName : pairNames) {
            String[] splittedPairName = pairName.split(" : ");
            for (String registerPair : this.registeredPairs) {
                if (isDuplicated(registerPair, splittedPairName)) {
                    return true;
                }
            }
        }
        registerToLevelPairs(pairNames);
        return false;
    }

    private boolean isDuplicated(String registerPair, String[] splittedPairName) {
        if (splittedPairName.length == 3) {
            if (registerPair.contains(splittedPairName[0]) && registerPair.contains(splittedPairName[1])
                    && registerPair.contains(splittedPairName[2])) {
                return true;
            }
        }
        if (registerPair.contains(splittedPairName[0]) && registerPair.contains(splittedPairName[1])) {
            return true;
        }
        return false;
    }

    private void registerToLevelPairs(List<String> pairNames) {
        for (String pairName : pairNames) {
            this.registeredPairs.add(pairName);
        }
    }
}
