package pairmatching.model;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Crew {
    private List<String> crewNames;
    private List<String> shuffledCrew;

    public Crew(String rawNames) {
        this.crewNames = new ArrayList<>();
        String[] splittedNames = rawNames.split("\n");
        Arrays.stream(splittedNames)
                .forEach(this.crewNames::add);
        shuffleCrew();
    }

    private void shuffleCrew() {
        this.shuffledCrew = Randoms.shuffle(this.crewNames);
    }

    public List<String> getRandomNames() {
        shuffleCrew();
        List<String> names = new ArrayList<>();
        for (int i=0; i<this.shuffledCrew.size()/2; i++) {
            String pairName = this.shuffledCrew.get(i*2).trim() + " : " + this.shuffledCrew.get(i*2+1).trim();
            if(this.shuffledCrew.size()%2 == 1 && i==this.shuffledCrew.size()/2-1) {
                pairName += " : " + this.shuffledCrew.get(i*2+2).trim();
            }
            names.add(pairName);
        }
        return names;
    }
}
