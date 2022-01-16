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
            System.out.println(Arrays.deepToString(office));
        } else {
            i = idx / N;
            j = idx % M;
            switch (office[i][j]) {
                case "5":
                    // 열 "#"으로 변환
                    for (int k = 0; k < N; k++) {
                        // 벽인 경우
                        if (office[k][j].equals("6")) {
                            // 벽이 5보다 아래 있을 경우 변환 종료
                            if (k > i) break;
                            // 벽이 5보다 위에 있을 경우 이전 변환 0으로 복구
                            else {
                                for (int l = 0; l < k; l++) {
                                    office[k][j] = "0";
                                }
                            }
                        }
                        // 빈 공간인 경우
                        if (office[k][j].equals("0")) office[k][j] = "#";
                    }


                    for (int l = 0; l < M; l++) {
                        // 벽인 경우
                        if (office[i][l].equals("6")) {
                            // 벽이 5보다 오른쪽에 있을 경우
                            if (l > j) break;
                            else {
                                for (int k = 0; k < office.length; k++) {
                                    office[i][k] = "0";
                                }
                            }
                        }
                        // 빈 공간일 경우
                        if (office[i][l].equals("0")) office[i][l] = "#";
                    }

                    recursive(N, M, office, idx + 1);
                    break;
            }
            System.out.println(Arrays.deepToString(office));
        }
    }
}
