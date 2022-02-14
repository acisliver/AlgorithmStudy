package bj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

// https://www.acmicpc.net/problem/1197
// 최소 스패닝 트리
// MST
public class N1197 {
    private static int[] parent;

    public static class Edge{
        int start, end, weight;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int v = Integer.parseInt(st.nextToken());
        int e = Integer.parseInt(st.nextToken());
        parent = new int[v];
        Arrays.fill(parent, -1);
        Edge[] edges = new Edge[e];
        int weight = 0;

        for (int i = 0; i < e; i++) {
            st = new StringTokenizer(br.readLine());
            Edge edge = new Edge();
            edge.start = Integer.parseInt(st.nextToken()) - 1;
            edge.end = Integer.parseInt(st.nextToken()) - 1;
            edge.weight = Integer.parseInt(st.nextToken());
            edges[i] = edge;
        }

        Arrays.sort(edges, Comparator.comparingInt(a -> a.weight));

        for (int i = 0; i < e; i++) {
            Edge edge = edges[i];
            int uSet = find(edge.start);
            int vSet = find(edge.end);

            if (uSet != vSet) {
                weight += edge.weight;
                union(edge.start, edge.end);
            }
        }

        System.out.println(weight);
    }

    public static int find(int a) {
        if (parent[a] == -1)
            return a;
        return find(parent[a]);
    }

    public static void union(int a, int b) {
        int root1 = find(a);
        int root2 = find(b);

        if (root1 != root2) {
            parent[root2] = root1;
        }
    }
}
