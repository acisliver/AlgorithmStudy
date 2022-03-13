package bj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// https://www.acmicpc.net/problem/11404
// 플로이드
// 최단경로
public class N11404 {
    static int INF = 1_000_000_000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        int[][] distance = new int[n + 1][n + 1];

        // 자기자신은 0
        // 나머지는 무한대로 초기화
        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < n + 1; j++) {
                if (i == j) {
                     distance[i][j] = 0;
                } else {
                    // Integer.MAX_VALUE를 했을 경우 1을 더하면 음수라 오류 발생할지도
                    distance[i][j] = INF;
                }
            }
        }

        // 그래프의 연결관계
        StringTokenizer st;
        while(m-- > 0) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());

            // 방향 그래프
            // start와 end 사이의 간선이 여러 개일 수 있다.
            distance[start][end] = Math.min(distance[start][end], weight);
        }

        // 0 ~ N개의 노드를 거치는 경우 고려
        // 노드 k를 거쳐 가는 경우
        for (int k = 1; k < n + 1; k++) {
            // 노드 i에서 j로 가는 경우
            for (int i = 1; i < n + 1; i++) {
                for (int j = 1; j < n + 1; j++) {
                    // 최소 비용으로 갱신
                    distance[i][j] = Math.min(distance[i][j], distance[i][k] + distance[k][j]);
                }
            }
        }

        // 출력
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i < n  + 1; i++) {
            for (int j = 1; j < n + 1; j++ ) {
                // 연결되지 않은 경우
                if (distance[i][j] >= INF) {
                    sb.append("0").append(" ");
                } else {
                    sb.append(distance[i][j]).append(" ");
                }
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}
