package bj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

// https://www.acmicpc.net/problem/4386
// 별자리 만들기
public class N4386 {
    public static int[] parents;

    public static class Point {
        int num;
        double x, y;

        public Point(int num, double x, double y) {
            this.num = num;
            this.x = x;
            this.y = y;
        }
    }

    public static class Edge implements Comparable<Edge> {
        int start, end;
        double weight;

        public Edge(int start, int end, double weight) {
            this.start = start;
            this.end = end;
            this.weight = weight;
        }

        @Override
        public int compareTo(Edge o) {
            return (int) (this.weight - o.weight);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int v = Integer.parseInt(br.readLine());
        Point[] points = new Point[v];
        parents = new int[v];
        Arrays.fill(parents, -1);
        StringTokenizer st;
        for (int i = 0; i < v; i++) {
            st = new StringTokenizer(br.readLine());
            points[i] = new Point(i, Double.parseDouble(st.nextToken()), Double.parseDouble(st.nextToken()));
        }

        // 간선 구하기
        ArrayList<Edge> edges = new ArrayList<>();
        for (int i = 0; i < v; i++) {
            for (int j = i + 1; j < v; j++) {
                double weight = Math.sqrt(Math.pow(points[i].x - points[j].x, 2) + Math.pow(points[i].y - points[j].y, 2));
                edges.add(new Edge(points[i].num, points[j].num, weight));
            }
        }

        edges.sort(Edge::compareTo);

        double answer = 0;

        for (Edge edge : edges) {
            int uSet = find(edge.start);
            int vSet = find(edge.end);

            if (uSet != vSet) {
                answer += edge.weight;
                union(edge.start, edge.end);
            }
        }

        System.out.printf("%.2f", answer);
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
