package bj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// https://www.acmicpc.net/problem/11657
// 타임머신
// 최단거리 - 벨만포드
public class N11657 {
    static int INF = 100_000_000;
    static int V, E;

    static class Edge {
        int start, end, weight;

        public Edge(int start, int end, int weight) {
            this.start = start;
            this.end = end;
            this.weight = weight;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());

        Edge[] graph = new Edge[E + 1];

        for (int i = 1; i <= E; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            graph[i] = new Edge(start, end, weight);
        }

        bellmanFord(graph);
    }

    static void bellmanFord(Edge[] graph) {
        // 1. 시작 정점 선택 -> 문제에서 1번으로 지정

        // 2. distance 초기화
        long[] distance = new long[V + 1];
        // 자기자신은 0
        // 나머지는 무한대로 초기화
        Arrays.fill(distance, INF);
        distance[1] = 0;

        // 3. 모든 간선 탐색하면서 distance 갱신
        // O(VE)
        // V 만큼 반복 -> 음의 사이클 확인
        for (int i = 1; i <= V; i++) {
            // E 만큼 반복 -> 모든 간선 확인
            for (int j = 1; j <= E; j++) {
                int start = graph[j].start;
                int end = graph[j].end;
                int weight = graph[j].weight;

                // start까지 갈 수 없다면 갱신 X
                if (distance[start] == INF) continue;

                // distance 갱신
                if (distance[end] > distance[start] + weight) {
                    // V번째 반복에서 distance가 갱신된다면
                    // 음의 사이클 존재
                    if (i == V) {
                        System.out.println(-1);
                        return;
                    }
                    distance[end] = distance[start] + weight;
                }
            }

        }

        // 출력
        StringBuilder sb = new StringBuilder();
        for (int i = 2; i < V + 1; i++) {
            if (distance[i] == INF) sb.append(-1).append("\n");
            else sb.append(distance[i]).append("\n");
        }
        System.out.println(sb);
    }
}
