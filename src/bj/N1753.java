package bj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.IntStream;

// https://www.acmicpc.net/problem/1753
// 최단경로
public class N1753 {
    static int V, E, START;

    static class Node implements Comparable<Node> {
        int node, weight;

        public Node(int node, int weight) {
            this.node = node;
            this.weight = weight;
        }

        @Override
        public int compareTo(Node node) {
            return this.weight - node.weight;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());
        START = Integer.parseInt(br.readLine()) - 1;

        ArrayList<LinkedList<Node>> graph = new ArrayList<>(V); // 인접리스트
        for (int i = 0; i < V + 1; i++) {
            graph.add(new LinkedList<>());
        }

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken()) - 1;
            int end = Integer.parseInt(st.nextToken()) - 1;
            int weight = Integer.parseInt(st.nextToken());
            graph.get(start).add(new Node(end, weight));
        }

        // 1. distance를 무한대로 초기화
        PriorityQueue<Node> pq = new PriorityQueue<>();
        int[] distance = new int[V];
        Arrays.fill(distance, Integer.MAX_VALUE);
        boolean[] visited = new boolean[V];

        // 2. 시작노드의 거리를 0으로
        pq.offer(new Node(START, 0));
        distance[START] = 0;

        // 3. 시작노드와 인접한 노드들의 distance값 갱신
        graph.get(START)
                .forEach(edge -> pq.offer(new Node(edge.node, edge.weight)));
        for (Node node : graph.get(START)) {
            distance[node.node] = node.weight;
        }

        while (!pq.isEmpty()) { // 모든 노드를 방문할 때까지 반복
            // 4. 방문하지 않은 노드 중 distance 값이 최소인 정점을 찾음
            // 5. 최소인 정점을 방문
            Node curNode = pq.poll();

            // 방문했는지 체크
            if (visited[curNode.node]) continue;
            visited[curNode.node] = true;

            // 최소인 정점과 연결된 정점들의 distance 갱신
            for (Node node : graph.get(curNode.node)) {
                if (distance[curNode.node] + node.weight < distance[node.node]) {
                    distance[node.node] = distance[curNode.node] + node.weight;
                    pq.offer(new Node(node.node, distance[node.node]));
                }
            }
        }

        // 출력
        StringBuilder sb = new StringBuilder();
        Arrays.stream(distance)
                .forEach(v -> {
                    if (v == Integer.MAX_VALUE) {
                        sb.append("INF").append("\n");
                    } else {
                        sb.append(v).append("\n");
                    }
                });
        System.out.println(sb);
    }
}


