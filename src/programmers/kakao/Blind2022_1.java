package programmers.kakao;

import java.util.*;

// https://programmers.co.kr/learn/courses/30/lessons/92334
// 신고 결과 받기
public class Blind2022_1 {
    public static void main(String[] args) {
        Blind2022_1 b = new Blind2022_1();
        System.out.println(Arrays.toString(
                b.solution(
                        new String[]{"muzi", "frodo", "apeach", "neo"},
                        new String[]{"muzi frodo", "apeach frodo", "frodo neo", "muzi neo", "apeach muzi"},
                        2
                )));
    }

    public int[] solution(String[] id_list, String[] report, int k) {
        int[] answer = new int[id_list.length];
        Map<String, Set<String>> reportWhoMap = new HashMap<>();    // 누가 누구를 신고했는지 저장
        Map<String, Integer> isOutMap = new HashMap<>();            // 얼마나 신고 당했는지 저장

        // 초기화
        for (String id : id_list) {
            reportWhoMap.put(id, new HashSet<>());
        }

        for (String r : report) {
            String[] input = r.split(" ");
            reportWhoMap.get(input[0]).add(input[1]);
        }

        // 신고다한 횟수 저장
        for (String id : id_list) {
            for (String reportedUser : reportWhoMap.get(id)) {
                isOutMap.put(reportedUser, isOutMap.getOrDefault(reportedUser, 0) + 1);
            }
        }

        // id_list의 순서에 맞게 받아아햘 메일 수 저장
        int idx = 0;
        for (String id : id_list) {
            for (String s : reportWhoMap.get(id)) {
                if (isOutMap.get(s) >= k) {
                    answer[idx] += 1;
                }
            }
            idx++;
        }

        return answer;
    }
}
