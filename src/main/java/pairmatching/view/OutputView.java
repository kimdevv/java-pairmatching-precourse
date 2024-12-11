package pairmatching.view;

import java.util.List;

public class OutputView {
    public static void outputPairResult(List<String> pairNames) {
        System.out.println("\n페어 매칭 결과입니다.");
        for (String pairName : pairNames) {
            System.out.println(pairName);
        }
        System.out.println();
    }

    public static void outputReset() {
        System.out.println("초기화 되었습니다.\n");
    }

    public static void outputCourseInfo(String[] courseNames) {
        System.out.println();
        System.out.println("#############################################");
        System.out.println("과정: 백엔드 | 프론트엔드");
        System.out.println("미션:");
        for (int i=1; i<=5; i++) {
            System.out.println("- 레벨" + i + ": " + courseNames[i]);
        }
        System.out.println("#############################################");
    }
}
