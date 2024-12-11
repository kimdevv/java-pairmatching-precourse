package pairmatching.view;

import camp.nextstep.edu.missionutils.Console;
import pairmatching.enumerate.Course;

public class InputView {
    public static String inputFeature() {
        System.out.println("기능을 선택하세요\n1. 페어 매칭\n2. 페어 조회\n3. 페어 초기화\nQ. 종료");
        return Console.readLine();
    }

    public static String inputMission(String[] courseNames) {
        System.out.println("#############################################");
        System.out.println("과정: 백엔드 | 프론트엔드");
        System.out.println("미션:");
        for (int i=1; i<=5; i++) {
            System.out.println("- 레벨" + i + ": " + courseNames[i]);
        }
        System.out.println("#############################################");
        System.out.println("과정, 레벨, 미션을 선택하세요.");
        System.out.println("ex) 백엔드, 레벨1, 자동차경주");
        return Console.readLine();
    }
}
