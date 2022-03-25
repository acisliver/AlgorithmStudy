package bj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;

// https://www.acmicpc.net/problem/1932
// 정수 삼각형
// 동적프로그래밍
public class N1932 {
    public static int N;
    public static int[][] dp, triangle;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        triangle = new int[N][];
        for (int i = 0; i < N; i++) {
            triangle[i] = Arrays.stream(br.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
        }

        dp = new int[N][N];

        // dp -1로 초기화
        for (int i = 0; i < N; i++) {
            Arrays.fill(dp[i], -1);
        }

        // dp의 마지막 행 삼각형의 마지막 행의 값으로 초기화
        for (int i = 0; i < N; i++) {
            dp[N - 1][i] = triangle[N - 1][i];
        }

        System.out.println(find(0, 0));
    }

    // 아래서부터 위로 탐색
    public static int find(int depth, int idx) {

        // 마지막 행까지 탐색했다면 리턴
        if (depth == N - 1) return dp[depth][idx];

        // 아직 탐색하지 않은 행이라면
        if (dp[depth][idx] == -1) {
            // 다음행의 왼쪽과 오른쪽 값 중 큰 값과 더해줌
            dp[depth][idx] = Math.max(find(depth + 1, idx), find(depth + 1, idx + 1)) + triangle[depth][idx];
        }

        return dp[depth][idx];
    }
}
