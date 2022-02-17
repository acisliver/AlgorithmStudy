package bj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// https://www.acmicpc.net/problem/11725
// 트리의 부모 찾기
public class N11725 {
    private static int n;
    private static boolean[][] tree;
    private static int[] parents;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        tree = new boolean[n][n];

        StringTokenizer st;
        for (int i = 0; i < n - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int node1 = Integer.parseInt(st.nextToken()) - 1;
            int node2 = Integer.parseInt(st.nextToken()) - 1;
            tree[node1][node2] = true;
            tree[node2][node1] = true;
        }

        parents = new int[n];

        bfs(0);

        StringBuilder sb = new StringBuilder();

        for (int i = 1; i < parents.length; i++) {
            sb.append(parents[i] + 1).append("\n");
        }
        System.out.println(sb);
    }

    private static void bfs(int startNode) {
        int visited = 1;
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(startNode);

        while (!queue.isEmpty()) {
            int parent = queue.poll();

            for (int i = 0; i < n; i++) {
                if (tree[parent][i] && ((visited & (1 << i)) != (1 << i))) {
                    parents[i] = parent;
                    visited |= 1 << i;
                    queue.offer(i);
                }
            }

        }

    }
}
