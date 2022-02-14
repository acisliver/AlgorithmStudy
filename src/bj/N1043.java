package bj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// https://www.acmicpc.net/problem/1043
// 거짓말
// 유니온 파인드
public class N1043 {
    private static int[] parents;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        parents = new int[n];
        Arrays.fill(parents, -1);

        st = new StringTokenizer(br.readLine());
        int trueN = Integer.parseInt(st.nextToken());
        boolean[] trueMan = new boolean[n];

        for (int i = 0; i < trueN; i++) {
            int people = Integer.parseInt(st.nextToken()) - 1;
            trueMan[people] = true;
        }

        int[][] party = new int[m][];

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int v = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken()) - 1;
            party[i] = new int[v];
            party[i][0] = a;
            for (int j = 1; j < v; j++) {
                int b = Integer.parseInt(st.nextToken()) - 1;
                union(a, b);
                party[i][j] = b;
            }
        }


        boolean[] visited = new boolean[n];
        // 누가 진실을 알고 있는 사람과 같은 파티를 가는지
        for (int i = 0; i < n; i++) {
            if (trueMan[i] && !visited[i]) {    // 진실을 알고 있으며, 아직 탐색되지 않은 경우
                int root = find(i);             // 진실을 알고 있는 사람의 집합의 루트를 구함
                for (int j = 0; j < n; j++) {
                    if (find(j) == root) {      // 진실을 알고있는 사람의 집합인 경우
                        trueMan[j] = true;
                        visited[j] = true;
                    }
                }
            }

        }

        int answer = m;
        for (int i = 0; i < m; i++) {
            for (int person : party[i]) {
                if (trueMan[person]) {
                    answer--;
                    break;
                }
            }
        }

        System.out.println(answer);
    }

    // a 노드의 부모를 찾음
    public static int find(int a) {
        // 루트
        if (parents[a] == -1) {
            return a;
        }
        return find(parents[a]);
    }

    // a 노드 집합과 b 노드집합을 같은 집합으로 만듦
    public static void union(int a, int b) {
        int root1 = find(a);
        int root2 = find(b);
        if (root1 != root2) {       // 트리의 사이클을 없애기 위해
            parents[find(a)] = b;   // find(a)의 루트를 b로 만듦
        }
    }
}
