package bj;

import java.util.Scanner;

// https://www.acmicpc.net/problem/11726
// 2xn 타일링
// 동적 프로그래밍
public class N11726 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] dp = new int[n + 3];

        dp[0] = 1;
        dp[1] = 2;
        dp[2] = 3;
        for (int i = 2; i < n; i++) {
            dp[i] = (dp[i - 1] + dp[i - 2]) % 10007;
        }
        System.out.println(dp[n - 1]);
    }
}
