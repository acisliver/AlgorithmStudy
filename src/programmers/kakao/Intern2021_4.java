package programmers.kakao;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.PriorityQueue;

// https://programmers.co.kr/learn/courses/30/lessons/81304?language=java
// 미로 탈출
public class Intern2021_4 {
    public static void main(String[] args) {
        Intern2021_4 s = new Intern2021_4();
        System.out.println(s.solution(4, 1, 4, new int[][]{{1, 2, 1}, {3, 2, 1}, {2, 4, 1}}, new int[]{2, 3}));
    }

    static int INF = 1_000_000;
    static int max;

    public class Node implements Comparable<Node>{
        int node, dis;

        public Node(int node, int dis) {
            this.node = node;
            this.dis = dis;
        }

        @Override
        public int compareTo(Node o) {
            return this.dis - o.dis;
        }
    }

    public int solution(int n, int start, int end, int[][] roads, int[] traps) {
        max = INF;
        int[] reversedNodes = new int[n + 1];

        // 인접리스트 생성
        ArrayList<LinkedList<Node>> miro = new ArrayList<>(n + 1);
        for (int i = 0; i < n + 1; i++) {
            miro.add(new LinkedList<>());
        }

        // 인접리스트 값 채우기
        for (int[] road : roads) {
            int from = road[0];
            int to = road[1];
            int dis = road[2];
            miro.get(from).add(new Node(to, dis));
        }

        // 1. distance를 무한대로 초기화
        PriorityQueue<Node> pq = new PriorityQueue<>();
        int[] distance = new int[n + 1];
        Arrays.fill(distance, INF);
        boolean[] visited = new boolean[n + 1];

        // 2. 시작노드의 거리를 0으로
        pq.offer(new Node(start, 0));
        distance[start] = 0;

        // 3. 시작노드와 인접한 노드들의 dis값 갱신
        miro.get(start)
                .forEach(node -> {
                    pq.offer(new Node(node.node, node.dis));
                    distance[node.node] = node.dis;
                });


        while (!pq.isEmpty()) { // 모든 노드를 방문할 때까지 반복
            // 4. 방문하지 않은 노드 중 dis값이 최소인 정점 찾기
            // 5. 최소인 정점 방문
            Node curNode = pq.poll();

            // 함정인지 체크
            // 함정이면 연결된 노드와 연결이 뒤집어졌음을 체크
            if (isTrap(curNode.node, traps)) {

            }

            // 방문했는지 체크


            // 최소인 정점과 연결된 정점들의 distnace 갱신
            for (Node node : miro.get(curNode.node)) {
                if (distance[curNode.node] + node.dis < distance[node.node]) {
                    distance[node.node] = distance[curNode.node] + node.dis;
                    pq.offer(new Node(node.node, distance[node.node]));
                }
            }
        }

        return max;
    }



    public boolean isTrap(int node, int[] trap) {
        for (int i : trap) {
            if (node == i) return true;
        }
        return false;
    }
}
