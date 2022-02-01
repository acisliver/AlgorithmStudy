package bj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;

/**
 * 섬의 개수 구하기
 */
public class N4963 {

    private static int[][] island;
    private static int count;

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        int w, h;

        while (true) {
            w = sc.nextInt();
            h = sc.nextInt();

            if (w == 0 && h == 0) break;

            island = new int[h][w];

            for (int i = 0; i < h; i++) {
                for (int j = 0; j < w; j++) {
                    island[i][j] = sc.nextInt();
                }
            }
            getIsland(island);
            System.out.println(count);
        }
    }

    private static void getIsland(int[][] island) {
        // island[][] 만큼의 방문 확인용 배열 생성
        boolean[][] visit = new boolean[island.length][island[0].length];

        count = 0;

        // 인접 땅 탐색
        for (int i = 0; i < island.length; i++) {
            for (int j = 0; j < island[0].length; j++) {
                if (!visit[i][j] && island[i][j] == 1) {
                    count++;
                    DFS(i, j, visit);
                }
            }

        }
    }

    private static void DFS(int i, int j, boolean[][] visit) {
        // 방문 칸 표시
        visit[i][j] = true;

        for (int k = -1; k < 2; k++) {
            for (int l = -1; l < 2; l++) {
                try {
                    if (island[i + k][j + l] == 1 && !visit[(i + k)][(j + l)])
                        DFS(i + k, j + l, visit);
                } catch (ArrayIndexOutOfBoundsException ignored) {
                }
            }

        }
    }
}
