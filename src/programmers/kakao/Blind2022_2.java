package programmers.kakao;

import java.util.Arrays;
import java.util.Stack;

// https://programmers.co.kr/learn/courses/30/lessons/92335?language=java
// k진수에서 소수 개수 구하기
public class Blind2022_2 {
    public static void main(String[] args) {
        Blind2022_2 b = new Blind2022_2();
        System.out.println(b.solution(437674, 3));
    }

    public int solution(int n, int k) {
        int answer = 0;
        String converted = convertK(n, k);
        long[] candidates = Arrays.stream(converted.split("0"))
                .filter(c -> !"".equals(c))
                .mapToLong(Long::parseLong)
                .toArray();

        if (candidates.length == 1) {
            // P & P0
            if (isPrime(candidates[0])) {
                return 1;
            }
        } else {
            // P0
            if (isPrime(candidates[0]))
                answer++;

            // N0P0N && N0P0
            // N은 건너뜀
            for (int i = 1; i < candidates.length; i++) {
                if (isPrime(candidates[i])) {
                    // N0P인 경우
                    if (i == candidates.length - 1) {
                        // N0P0인 경우
                        if (converted.charAt(converted.length() - 1) == '0') {
                            answer++;
                        }
                    } else {    // N0P0N인 경우
                        answer++;
                    }
                    break;
                }
            }

            // 0P
            if (isPrime(candidates[candidates.length - 1]) && converted.charAt(converted.length() - 1) != '0')
                answer++;

        }

        return answer;
    }

    public boolean isPrime(long n) {
        if (n == 1) return false;

        for (int i = 2; i < n / 2; i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }

    public String convertK(int n, int k) {
        StringBuilder converted = new StringBuilder();
        Stack<Integer> stack = new Stack<>();
        int cur = n;
        int remainder;

        while (cur != 0) {
            remainder = cur % k;
            cur /= k;
            stack.push(remainder);
        }

        while (!stack.isEmpty()) {
            converted.append(stack.pop());
        }

        return converted.toString();
    }
}
