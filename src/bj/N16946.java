package bj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// 벽 부수고 이동하기 4
// https://www.acmicpc.net/problem/16946
public class N16946 {
    static int[] DI = new int[]{0, 0, 1, -1};
    static int[] DJ = new int[]{1, -1, 0, 0};
    static int count;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[][] map = new int[n][m];
        int[][] zeroMap = new int[n][m];

        for (int i = 0; i < n; i++) {
            map[i] = Arrays.stream(br.readLine().split(""))
                    .mapToInt(Integer::parseInt)
                    .toArray();
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (map[i][j] == 0) {
                    count = 1;
                    boolean[][] visited = new boolean[n][m];
                    visited[i][j] = true;
                    dfs(i, j, visited, map, n, m);
                    zeroMap[i][j] = count;
                }
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (map[i][j] == 1) {
                    for (int k = 0; k < 4; k++) {
                        int nextI = i + DI[k];
                        int nextJ = j + DJ[k];

                        if (nextI < 0 || nextJ < 0 || nextI > n - 1 || nextJ > m - 1) continue;

                        if (zeroMap[nextI][nextJ] == 0) continue;

                        map[i][j] += zeroMap[nextI][nextJ];
                    }
                }
            }
        }


        StringBuilder sb = new StringBuilder();
        for (int[] ints : map) {
            for (int i : ints) {
                sb.append(i);
            }
            sb.append("\n");
        }

        System.out.println(sb);
    }

    private static void dfs(int i, int j, boolean visited[][],int[][] map, int n, int m) {
        if (map[i][j] == 1) {
            return;
        }

        for (int k = 0; k < 4; k++) {
            int nextI = i + DI[k];
            int nextJ = j + DJ[k];

            if (nextI < 0 || nextJ < 0 || nextI > n - 1 || nextJ > m - 1) continue;

            if (visited[nextI][nextJ]) continue;

            if (map[nextI][nextJ] > 0) continue;

            visited[nextI][nextJ] = true;
            count++;
            dfs(nextI, nextJ, visited, map, n, m);
        }
    }


}
