package pairmatching.model;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Crew {
    private List<String> crewNames;
    private List<String> shuffledCrew;

    public Crew(String rawNames) {
        crewNames = new ArrayList<>();
        String[] splittedNames = rawNames.split("\n");
        Arrays.stream(splittedNames)
                .forEach(crewNames::add);
        shuffleCrew();
    }

    private void shuffleCrew() {
        shuffledCrew = Randoms.shuffle(this.crewNames);
    }

    public List<String> getRandomNames() {
        shuffleCrew();
        List<String> names = new ArrayList<>();
        for (int i=0; i<shuffledCrew.size()/2; i++) {
            String pairName = shuffledCrew.get(i*2) + " : " + shuffledCrew.get(i*2+1);
            if(shuffledCrew.size()%2 == 1 && i==shuffledCrew.size()/2-1) {
                pairName += " : " + shuffledCrew.get(i*2+2);
            }
            names.add(pairName);
        }
        return names;
    }
}
