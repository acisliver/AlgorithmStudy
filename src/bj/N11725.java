package bj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// https://www.acmicpc.net/problem/11725
// 트리의 부모 찾기
public class N11725 {

    private static ArrayList<LinkedList<Integer>> tree;
    private static int[] parents;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        tree = new ArrayList<>();

        // 인접리스트 초기화
        for (int i = 0; i < n; i++) {
            tree.add(new LinkedList<>());
        }

        StringTokenizer st;
        for (int i = 0; i < n - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int node1 = Integer.parseInt(st.nextToken()) - 1;
            int node2 = Integer.parseInt(st.nextToken()) - 1;
            tree.get(node1).add(node2);
            tree.get(node2).add(node1);
        }

        parents = new int[n];
        Arrays.fill(parents, -1);

        bfs(0);

        StringBuilder sb = new StringBuilder();

        for (int i = 1; i < parents.length; i++) {
            sb.append(parents[i] + 1).append("\n");
        }
        System.out.println(sb);
    }

    private static void bfs(int startNode) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(startNode);

        while (!queue.isEmpty()) {
            int parent = queue.poll();

            for (Integer node : tree.get(parent)) {
                if (parents[node] == -1) {
                    parents[node] = parent;
                    queue.offer(node);
                }
            }
        }
    }
}
