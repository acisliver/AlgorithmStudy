package programmers.kakao;

import java.util.*;
import java.util.stream.Collectors;

// https://programmers.co.kr/learn/courses/30/lessons/42889
// 실패율이 높은 스테이지부터 내림차순
// 실패율이 같은 스테이지라면 작은 번호의 스테이지가 먼저 오도록 정렬
// 스테이지에 도달한 유저가 없다면 실패율 0
// 실패율 = 스테이지에 도달 & 클리어 X / 스테이지에 도달한 수
public class FailRate {
    public static void main(String[] args) {
        System.out.println(solution(5, new int[]{2, 1, 2, 6, 2, 4, 3, 3}));
    }

    public static ArrayList<Integer> solution(int N, int[] stages) {
        ArrayList<Integer> answer = new ArrayList<>();

        // int array to List<Integer>
        // boxed & sorted
        List<Integer> stageList =
                Arrays.stream(stages)
                        .boxed()
                        .sorted()
                        .collect(Collectors.toList());

        System.out.println(stageList);

        int length, failer;
        List<List<Integer>> failRates = new ArrayList<>();
        ArrayList<Integer> rate;
        for (int stage = 1; stage <= N; stage++) {
            length = stages.length;
            failer = 0;
            for (Integer user : stageList) {
                if (user == stage)
                    failer += 1;
                else if (user < stage)
                    length -= 1;
                else break;
            }
            rate = new ArrayList<>();
            // 스테이지에 도달한 유저가 없는 경우 해당 스테이지의 실패율은 0

            rate.add(failer);
            rate.add(length);
            rate.add(stage);
            failRates.add(rate);
        }

        // 실패율이 같다면 낮은 스테이지부터
        failRates.sort((r1, r2) -> {
            int compare = r2.get(0) * r1.get(1) - r1.get(0) * r2.get(1);
            return compare == 0 ? r1.get(2) - r2.get(2) : compare;
        });

        System.out.println(failRates);

        for (List<Integer> failRate : failRates) {
            answer.add(failRate.get(2));
        }

        return answer;
    }
}
