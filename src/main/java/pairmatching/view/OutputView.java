package pairmatching.view;

import java.util.List;

public class OutputView {
    public static void outputPairResult(List<String> pairNames) {
        System.out.println("페어 매칭 결과입니다.");
        for (String pairName : pairNames) {
            System.out.println(pairName);
        }
    }
}
