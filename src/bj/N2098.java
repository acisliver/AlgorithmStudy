package bj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

// https://www.acmicpc.net/problem/2098
// 외판원 순회
public class N2098 {
    private static int N;
    private static int[][] WEIGHTS;
    private static int MIN = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        WEIGHTS = new int[N][];

        for (int i = 0; i < N; i++) {
            WEIGHTS[i] = Arrays.stream(br.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
        }

        // 0번 정점부터 시작
        tsp(0, 0, 0);
        System.out.println(MIN);
    }

    private static void tsp(int at, int weight, int visited) {
        // 탐색을 완료했다면
        if (visited == (1 << N) - 1) {
            if (MIN > weight) {
                MIN = weight;
                return;
            }
        }
        for (int next = 1; next < N; next++) {
            // 아직 방문하지 않았고 간선이 있다면
            if ((visited & (1 << next)) != (1 << next) && WEIGHTS[at][next] != 0) {
                // 가지치기 조건
                if (weight + WEIGHTS[at][next] < MIN) {
                    visited |= 1 << next;
                    tsp(next, weight + WEIGHTS[at][next], visited);
                    visited &= ~(1 << next);
                }
            }
        }
        if ((visited == (1 << N) - 2) && WEIGHTS[at][0] != 0) {
            if (weight + WEIGHTS[at][0] < MIN) {
                visited |= 1;
                tsp(0, weight + WEIGHTS[at][0], visited);
            }
        }

    }
}
