package bj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// https://www.acmicpc.net/problem/1149
// RGB 거리
public class N1149 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        int[][] m = new int[n][3];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 3; j++) {
                m[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 1; i < m.length; i++) {
            for (int j = 0; j < 3; j++) {
                if (j == 0) {
                    m[i][j] = Math.min(m[i - 1][j + 1], m[i - 1][j + 2]) + m[i][j];
                } else if (j == 1) {
                    m[i][j] = Math.min(m[i - 1][j - 1], m[i - 1][j + 1]) + m[i][j];
                } else {
                    m[i][j] = Math.min(m[i - 1][j - 2], m[i - 1][j - 1]) + m[i][j];
                }
            }
        }

        System.out.println(Arrays.stream(m[n - 1]).min().getAsInt());
    }


}
