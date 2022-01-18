package bj;

import java.util.Scanner;

// https://www.acmicpc.net/problem/2447
// 별 찍기 - 10
public class N2447 {
    private static char[][] stars;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        stars = new char[n][n];
        star(0, 0, n, false);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                 sb.append(stars[i][j]);
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }

    private static void star(int x, int y, int n, boolean isBlank) {

        // 5번째 칸 -> 공백이라면
        if (isBlank) {
            for (int i = x; i < x + n; i++) {
                for (int j = y; j < y + n; j++) {
                    stars[i][j]= ' ';
                }
            }
            return;
        }

        int blockSize = n / 3;
        int count = 0;

        // 중단점
        if (n == 1) {
            stars[x][y] = '*';
            return;
        } else {
            for (int i = x; i < x + n; i += blockSize) {
                for (int j = y; j < y + n; j += blockSize) {
                    count ++;
                    // 공백이 출력되야 할 때
                    if (count == 5)
                        star(i, j, blockSize, true);
                    else
                        star(i, j, blockSize, false);
                }
            }
            return;
        }
    }
}
