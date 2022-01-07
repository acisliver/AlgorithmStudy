package programmers.kakao;

import java.util.ArrayList;
import java.util.Arrays;

// https://programmers.co.kr/learn/courses/30/lessons/42889
// 실패율이 높은 스테이지부터 내림차순
// 실패율이 같은 스테이지라면 작은 번호의 스테이지가 먼저 오도록 정렬
// 스테이지에 도달한 유저가 없다면 실패율 0
// 실패율 = 스테이지에 도달, 클리어 X / 스테이지에 도달한 수
public class FailRate2 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(5, new int[]{2, 1, 2, 4, 2, 4, 3, 3})));
    }

    public static int[] solution(int N, int[] stages) {
        int[] answer = new int[N];
        ArrayList<Float> failOfStage = new ArrayList<>();
        int failN = 0;
        int stageN = 0;

        for (int stage = 1; stage <= N; stage++) {
            for (int j = 0; j < stages.length; j++) {
                if (stages[j] >= stage) stageN++;
                if (stages[j] == stage) failN++;
            }

            if (stageN == 0) failOfStage.add(0F);
            else failOfStage.add((float) failN / stageN);
            failN = 0;
            stageN = 0;
        }
        System.out.println(failOfStage);

        failOfStage.sort((r1, r2) ->  (int) (r1 - r2));

        System.out.println(failOfStage);


        return answer;
    }
}
