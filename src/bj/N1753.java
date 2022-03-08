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
        int node, dis;

        public Node(int node, int dis) {
            this.node = node;
            this.dis = dis;
        }

        @Override
        public int compareTo(Node node) {
            return this.dis - node.dis;
        }
    }

    static class Edge {
        int node, weight;

        public Edge(int node, int weight) {
            this.node = node;
            this.weight = weight;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());
        START = Integer.parseInt(br.readLine()) - 1;

        ArrayList<LinkedList<Edge>> graph = new ArrayList<>(V); // 인접리스트
        IntStream.range(0, V + 1)
                .forEach(i -> graph.add(new LinkedList<>()));

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            graph.get(Integer.parseInt(st.nextToken()) - 1).add(new Edge(Integer.parseInt(st.nextToken()) - 1, Integer.parseInt(st.nextToken())));
        }

        // 1. distance를 무한대로 초기화
        PriorityQueue<Node> pq = new PriorityQueue<>();
        int[] distance = new int[V];
        Arrays.fill(distance, Integer.MAX_VALUE);

        // 2. 시작노드의 거리를 0으로
        pq.offer(new Node(START, 0));
        distance[START] = 0;

        // 3. 시작노드와 인접한 노드들의 distance값 갱신
        graph.get(START)
                .forEach(edge -> pq.offer(new Node(edge.node, edge.weight)));
        for (Edge edge : graph.get(START)) {
            distance[edge.node] = edge.weight;
        }

        while (!pq.isEmpty()) { // 모든 노드를 방문할 때까지 반복
            // 4. 방문하지 않은 노드 중 distance 값이 최소인 정점을 찾음
            // 5. 최소인 정점을 방문
            Node curNode = pq.poll();

            // 최소인 정점과 연결된 정점들의 distance 갱신
            for (Edge edge : graph.get(curNode.node)) {
                if (curNode.dis + edge.weight < distance[edge.node]) {
                    distance[edge.node] = curNode.dis + edge.weight;
                    pq.offer(new Node(edge.node, distance[edge.node]));
                }
            }
        }
        // 출력
        Arrays.stream(distance)
                .mapToObj(d -> {
                    if (d == Integer.MAX_VALUE) return "INF";
                    else return String.valueOf(d);
                })
                .forEach(System.out::println);
    }
}


