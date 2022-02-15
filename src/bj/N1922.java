package bj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

// https://www.acmicpc.net/problem/1922
// 네트워크 연결
// MST - Kruskal
public class N1922 {
    public static int[] parents;

    public static class Edge implements Comparable<Edge>{
        int start, end, weight;

        public Edge(int start, int end, int weight) {
            this.start = start;
            this.end = end;
            this.weight = weight;
        }

        @Override
        public int compareTo(Edge o) {
            return Integer.compare(this.weight, o.weight);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int v = Integer.parseInt(br.readLine());
        int e = Integer.parseInt(br.readLine());
        ArrayList<Edge> edges = new ArrayList<>();
        parents = new int[v];
        Arrays.fill(parents, -1);

        StringTokenizer st;
        for (int i = 0; i < e; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken()) - 1;
            int end = Integer.parseInt(st.nextToken()) - 1;
            int weight = Integer.parseInt(st.nextToken());
            edges.add(new Edge(start, end, weight));
        }

        int answer = 0;
        edges.sort(Edge::compareTo);
        for (Edge edge : edges) {
            int uSet = find(edge.start);
            int vSet = find(edge.end);

            if (uSet != vSet) {
                answer += edge.weight;
                union(edge.start, edge.end);
            }
        }

        System.out.println(answer);
    }

    public static int find(int a) {
        if (parents[a] == -1)
            return a;
        return find(parents[a]);
    }

    public static void union(int a, int b) {
        int root1 = find(a);
        int root2 = find(b);

        if (root1 != root2) {
            parents[root2] = root1;
        }
    }
}
