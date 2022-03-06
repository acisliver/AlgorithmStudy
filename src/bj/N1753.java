package bj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

// https://www.acmicpc.net/problem/1753
// 최단경로
public class N1753 {
    static int V, E, START;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());
        START = Integer.parseInt(br.readLine()) - 1;
        int[][] graph = new int[V][V];  // 인접행렬
        for (int[] ints : graph) {
            Arrays.fill(ints, 11);
        }
        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            graph[Integer.parseInt(st.nextToken()) - 1][Integer.parseInt(st.nextToken()) - 1] = Integer.parseInt(st.nextToken());
        }

        // 1. distance를 무한대로 초기화
        int[] distance = new int[V];
        int visited = 0;
        Arrays.fill(distance, 11);

        // 2. 시작노드의 거리를 0으로
        distance[START] = 0;
        visited |= 1 << (START);

        // 3. 시작노드와 인접한 노드들의 distance값 갱신
        for (int i = 0; i < distance.length; i++) {
            if (graph[START][i] != 11) {
                distance[i] = graph[START][i];
            }
        }

        while (Integer.bitCount(visited) < V) { // 모든 노드를 방문할 때까지 반복
            // 4. 방문하지 않은 노드 중 distance 값이 최소인 정점을 찾음
            int minVertex = findMinIdx(distance, visited);
            // 5. 최소인 정점을 방문
            visited |= 1 << (minVertex);
            // 최소인 정점과 연결된 정점들의 distance 갱신
            for (int i = 0; i < distance.length; i++) {
                if ((visited & (1 << i)) == 0) {
                    if (distance[minVertex] + graph[minVertex][i] < distance[i]) {
                        distance[i] = distance[minVertex] + graph[minVertex][i];
                    }
                }

            }
        }

        Arrays.stream(distance)
                .mapToObj(d -> {
                    if (d > 10) return "INF";
                    else return String.valueOf(d);
                })
                .forEach(System.out::println);
    }

    public static int findMinIdx(int[] distance, int visited) {
        int min = Integer.MAX_VALUE;
        int minIdx = 0;
        for (int i = 0; i < distance.length; i++) {
            if ((visited & (1 << i)) == 0 && distance[i] < min) {
                min = distance[i];
                minIdx = i;
            }
        }

        return minIdx;
    }
}
