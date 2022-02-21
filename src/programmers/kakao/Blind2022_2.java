package programmers.kakao;

import java.util.Arrays;

// https://programmers.co.kr/learn/courses/30/lessons/92335?language=java
// k진수에서 소수 개수 구하기
public class Blind2022_2 {
    public static void main(String[] args) {
        Blind2022_2 b = new Blind2022_2();
        System.out.println(b.solution(437674, 3));
    }

    public int solution(int n, int k) {
        String converted = convertK(n, k);
        return (int) Arrays.stream(converted.split("0"))
                .filter(c ->
                        !"".equals(c)
                                && isPrime(Long.parseLong(c))
                )
                .count();
    }

    public boolean isPrime(long n) {
        if (n == 1) return false;

        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }

    public String convertK(int n, int k) {
        StringBuilder converted = new StringBuilder();
        long cur = n;

        while (cur != 0) {
            converted.insert(0, cur % k);
            cur /= k;
        }

        return converted.toString();
    }
}
