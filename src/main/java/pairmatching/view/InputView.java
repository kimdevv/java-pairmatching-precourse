package pairmatching.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    public static String inputFeature() {
        System.out.println("기능을 선택하세요\n1. 페어 매칭\n2. 페어 조회\n3. 페어 초기화\nQ. 종료");
        return Console.readLine();
    }
}
