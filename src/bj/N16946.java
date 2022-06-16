package bj;

import java.io.*;
import java.util.*;

// 벽 부수고 이동하기 4
// https://www.acmicpc.net/problem/16946
public class N16946 {
    static int[] DI = new int[]{0, 0, 1, -1};
    static int[] DJ = new int[]{1, -1, 0, 0};
    static Map<Integer, Integer> groupSize = new HashMap<>();
    static int[][] map;
    static int[][] group;
    static int groupNum = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        map = new int[n][m];
        group = new int[n][m];

        for (int i = 0; i < n; i++) {
            map[i] = Arrays.stream(br.readLine().split(""))
                    .mapToInt(Integer::parseInt)
                    .toArray();
        }


        // 인접한 0의 개수 세기
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (map[i][j] == 0 && group[i][j] == 0) {
                    groupNum++;
                    groupSize.put(groupNum, bfs(i, j, n, m));
                }
            }
        }

        // 정답 계산 및 출력
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (map[i][j] == 0) sb.append(0);
                else {
                    sb.append(count(i, j, n, m));
                }
            }
            sb.append("\n");
        }

        System.out.println(sb);
    }

    private static int count(int i, int j, int n, int m) {
        int count = 1;
        Set<Integer> groupSet = new HashSet<>();
        for (int k = 0; k < 4; k++) {
            int nextI = i + DI[k];
            int nextJ = j + DJ[k];

            if (nextI < 0 || nextJ < 0 || nextI > n - 1 || nextJ > m - 1) continue;

            if (group[nextI][nextJ] == 0) continue;

            groupSet.add(group[nextI][nextJ]);
        }
        for (Integer integer : groupSet) {
            count += groupSize.get(integer);
        }

        return count % 10;
    }

    private static int bfs(int i, int j, int n, int m) {
        int size = 1;
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[] {i, j});
        group[i][j] = groupNum;

        while(!queue.isEmpty()) {
            int[] cur = queue.poll();

            for (int k = 0; k < 4; k++) {
                int nI = cur[0] + DI[k];
                int nJ = cur[1] + DJ[k];

                if (nI < 0 || nJ < 0 || nI > n - 1 || nJ > m - 1) continue;

                if (group[nI][nJ] > 0) continue;

                if (map[nI][nJ] > 0) continue;

                size++;
                group[nI][nJ] = groupNum;
                queue.offer(new int[] {nI, nJ});
            }
        }
        return size;
    }
}
