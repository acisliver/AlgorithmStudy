package bj;

import java.io.*;
import java.util.Arrays;

// https://www.acmicpc.net/problem/2098
// 외판원 순회
// 비트마스크를 이용한 다이나믹 프로그래밍
public class N2098 {
    private static int N;
    private static int[][] MAP;
    private static int[][] DP;
    private static int INF = 16_000_000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        MAP = new int[N][N];
        DP = new int[N][1 << N];    // i: 현재 위치, j: 지금까지 방문한 도시 비트마스크

        for (int i = 0; i < N; i++) {
            MAP[i] = Arrays.stream(br.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
        }

        // DP 초기화
        for (int i = 0; i < N; i++) {
             Arrays.fill(DP[i], INF);
        }

        // 0번 정점부터 시작
        System.out.println(tsp(0, 1));

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        bw.write(tsp(0, 1) + "\n");
        bw.flush();
        bw.close();
        br.close();
    }

    private static int tsp(int cur, int visited) {

        // 탐색을 완료했다면
        if (visited == (1 << N) - 1) {
            return MAP[cur][0] == 0 ? INF: MAP[cur][0];        // 현재 위치에서 시작정점으로 돌아오는 거리
        }

        // DP값이 존재하는 경우
        if (DP[cur][visited] != INF) {
            return DP[cur][visited];
        }

        for (int next = 1; next < N; next++) {
            // 아직 방문하지 않았고 간선이 있다면
            if ((visited & (1 << next)) != (1 << next) && MAP[cur][next] != 0) {
                /**
                 * cur에서 남은 정점을 방문하는 최소
                 * 1) 현재 방법
                 * 2-1) next를 방문하고  next에서 남은 정점을 방문하는 경우
                 */
                DP[cur][visited] =
                        Math.min(
                                DP[cur][visited],
                                MAP[cur][next] + tsp(next, visited | (1 << next))
                        );
            }
        }

        return DP[cur][visited];
    }
}
