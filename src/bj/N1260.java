package bj;

import java.util.*;

// https://www.acmicpc.net/problem/1260
// DFS와 BFS
public class N1260 {
    private static boolean[] visited;
    private static int n, e;
    private static boolean[][] mat;
    private static StringBuilder sb;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        e = sc.nextInt();
        int start = sc.nextInt() - 1;

        mat = new boolean[n][n];

        for (int i = 0; i < e; i++) {
            int v1 = sc.nextInt() - 1;
            int v2 = sc.nextInt() - 1;
            mat[v1][v2] = true;
            mat[v2][v1] = true;
        }

        visited = new boolean[n];
        sb = new StringBuilder();
        dfs(start);
        visited = new boolean[n];
        sb.append("\n");
        bfs(start);

        System.out.println(sb);
    }

    private static void dfs(int start) {
        visited[start] = true;
        sb.append(start + 1).append(" ");
        for (int i = 0; i < n; i++) {
            if (mat[start][i] && !visited[i]) {
                dfs(i);
            }
        }
    }

    private static void bfs(int start) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(start);
        while(!queue.isEmpty()){
            visited[start] = true;
            for (int i = 0; i < visited.length; i++) {
                if (mat[queue.peek()][i] && !visited[i]) {
                    queue.offer(i);
                    visited[i] = true;
                }
            }
            sb.append(queue.poll() + 1).append(" ");
        }
    }
}
