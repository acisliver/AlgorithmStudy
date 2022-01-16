package bj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Objects;
import java.util.StringTokenizer;

// https://www.acmicpc.net/problem/15683
// 감시
public class N15683 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        String[][] office = new String[N][M];

        for (int i = 0; i < N; i++) {
            office[i] = br.readLine().split(" ");
        }

        solution(N, M, office);
    }

    private static void solution(int N, int M, String[][] office) {
        recursive(N, M, office, 0);
    }

    private static void recursive(int N, int M, String[][] office, int idx) {
        int i, j;
        if (N * M == idx) {

        } else {
            i = idx / N;
            j = idx % M;
            switch (office[i][j]) {
                case "5":
                    for (int k = 0; k < N; k++)
                        if (office[k][j].equals("0")) office[k][j] = "#";

                    for (int l = 0; l < M; l++)
                        if (office[i][l].equals("0")) office[i][l] = "#";

            }
            recursive(N, M, office, idx + 1);
        }
        System.out.println(Arrays.deepToString(office));
    }
}
