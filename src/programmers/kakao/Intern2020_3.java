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
        int right = 0;
        int start = 0;
        int end = 0;
        int min = 100_000;
        Set<String> set = new HashSet<>(Arrays.asList(gems));

        while(left < gems.length && right < gems.length) {
            HashMap<String, Integer> map = new HashMap<>();

            for (int i = left; i <= right; i++) {
                map.put(gems[i], map.getOrDefault(gems[i], 0) + 1);
            }

            if (map.size() == set.size()) {
                if (min > right - left) {
                    min = right - left;
                    start = left + 1;
                    end = right + 1;
                }
                left++;
            } else {
                right++;
            }
        }

        return new int[]{start, end};
    }

}
