package programmers.kakao;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

// https://programmers.co.kr/learn/courses/30/lessons/67258
// 보석 쇼핑
public class Intern2020_3 {
    public static void main(String[] args) {

        System.out.println(
                Arrays.toString(
                        new Intern2020_3().solution(
                                new String[]{"ZZZ", "YYY", "NNNN", "YYY", "BBB"}
                        )
                ));
    }

    public int[] solution(String[] gems) {

        int left = 0;
        int right = -1;
        int start = 0;
        int end = 0;
        int min = 100_000;
        Set<String> set = new HashSet<>(Arrays.asList(gems));
        HashMap<String, Integer> map = new HashMap<>();

        while(left < gems.length) {

            if (map.size() == set.size()) { // 모든 보석이 있을 경우
                if (min > right - left) {
                    min = right - left;
                    start = left + 1;
                    end = right + 1;
                }
                map.put(gems[left], map.getOrDefault(gems[left], 0) - 1);
                if (map.get(gems[left]) == 0) {
                    map.remove(gems[left]);
                }
                left++;
            } else {                        // 보석이 더 필요한 경우
                right++;
                if (right >= gems.length) break;
                map.put(gems[right], map.getOrDefault(gems[right], 0) + 1);
            }
        }

        return new int[]{start, end};
    }
}
