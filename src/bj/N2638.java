package bj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class N2638 {
    private static int n, m;
    private static final int[] DX = {0, 0, -1, 1};
    private static final int[] DY = {-1, 1, 0, 0};
    private static int cheeseCount = 0;
    private static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        int time = 0;

        int[][] cheese = new int[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                cheese[i][j] = Integer.parseInt(st.nextToken());
                if (cheese[i][j] == 1) cheeseCount++;
            }
        }

        while(cheeseCount != 0) {
            time++;
            isOut(cheese);
            melt(cheese);
        }

        System.out.println(time);
    }

    private static void isOut(int[][] cheese) {
        Queue<int[]> queue = new LinkedList<>();
        visited = new boolean[n][m];
        queue.offer(new int[]{0, 0});
        cheese[0][0] = 2;
        while (!queue.isEmpty()) {
            int[] index = queue.poll();
            int curY = index[0];
            int curX = index[1];
            for (int k = 0; k < 4; k++) {
                if (curY + DY[k] < 0 || curY + DY[k] >= n || curX + DX[k] < 0 || curX + DX[k] >= m)
                    continue;

                if (visited[curY + DY[k]][curX + DX[k]] || cheese[curY + DY[k]][curX + DX[k]] == 1)
                    continue;


                cheese[curY + DY[k]][curX + DX[k]] = 2;
                queue.offer(new int[]{curY + DY[k], curX + DX[k]});
                visited[curY + DY[k]][curX + DX[k]] = true;

            }
        }
    }

    private static void melt(int[][] cheese) {
        int meltCount = 0;
        for (int curY = 0; curY < cheese.length; curY++) {
            for (int curX = 0; curX < cheese[0].length; curX++) {
                if (cheese[curY][curX] == 1) {
                    for (int k = 0; k < 4; k++) {
                        if (curY + DY[k] < 0 || curY + DY[k] >= n || curX + DX[k] < 0 || curX + DX[k] >= m) {
                            continue;
                        }

                        if (cheese[curY + DY[k]][curX + DX[k]] == 2) {
                            meltCount++;
                        }
                    }
                    if (meltCount > 1) {
                        cheeseCount--;
                        cheese[curY][curX] = 3;
                    }
                    meltCount = 0;
                }
            }
        }
    }
}
