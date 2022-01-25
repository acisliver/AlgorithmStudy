package bj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// https://www.acmicpc.net/problem/15683
// 감시
public class N15683 {
    private static int MIN;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        String[][] office = new String[N][M];
        MIN = N * M;

        for (int i = 0; i < N; i++) {
            office[i] = br.readLine().split(" ");
        }

        solution(N, M, office);
    }

    private static void solution(int N, int M, String[][] office) {
        recursive(N, M, office, 0);
        System.out.println(MIN);
    }

    private static void recursive(int N, int M, String[][] office, int idx) {
        int i, j;
        String[][] beforeOffice;
        if (N * M == idx) {
            //for (int k = 0; k < office.length; k++) {
            //    System.out.println(Arrays.toString(office[k]));
            //}
            MIN = Math.min(MIN, countBlindSpot(office));
            /// System.out.println(MIN);
        } else {
            i = idx / M;
            j = idx % M;
            switch (office[i][j]) {
                case "5":
                    up(office, i, j);
                    down(office, i, j, N);
                    left(office, i, j);
                    right(office, i, j, M);

                    recursive(N, M, office, idx + 1);
                    break;
                case "4":
                    beforeOffice = deepClone(office);
                    up(office, i, j);
                    left(office, i, j);
                    right(office, i, j, M);
                    recursive(N, M, office, idx + 1);
                    office = beforeOffice;

                    beforeOffice = deepClone(office);
                    up(office, i, j);
                    right(office, i, j, M);
                    down(office, i, j, N);
                    recursive(N, M, office, idx + 1);
                    office = beforeOffice;

                    beforeOffice = deepClone(office);
                    up(office, i, j);
                    left(office, i, j);
                    down(office, i, j, N);
                    recursive(N, M, office, idx + 1);
                    office = beforeOffice;

                    down(office, i, j, N);
                    left(office, i, j);
                    right(office, i, j, M);
                    recursive(N, M, office, idx + 1);
                    break;
                case "3":
                    beforeOffice = deepClone(office);
                    up(office, i, j);
                    left(office, i, j);
                    recursive(N, M, office, idx + 1);
                    office = beforeOffice;

                    beforeOffice = deepClone(office);
                    up(office, i, j);
                    right(office, i, j, M);
                    recursive(N, M, office, idx + 1);
                    office = beforeOffice;

                    beforeOffice = deepClone(office);
                    down(office, i, j, N);
                    left(office, i, j);
                    recursive(N, M, office, idx + 1);
                    office = beforeOffice;

                    down(office, i, j, N);
                    right(office, i, j, M);
                    recursive(N, M, office, idx + 1);
                    break;
                case "2":
                    beforeOffice = deepClone(office);
                    up(office, i, j);
                    down(office, i, j, N);
                    recursive(N, M, office, idx + 1);
                    office = beforeOffice;

                    left(office, i, j);
                    right(office, i, j, M);
                    recursive(N, M, office, idx + 1);
                    break;
                case "1":
                    beforeOffice = deepClone(office);
                    up(office, i, j);
                    recursive(N, M, office, idx + 1);
                    office = beforeOffice;

                    beforeOffice = deepClone(office);
                    down(office, i, j, N);
                    recursive(N, M, office, idx + 1);
                    office = beforeOffice;

                    beforeOffice = deepClone(office);
                    left(office, i, j);
                    recursive(N, M, office, idx + 1);
                    office = beforeOffice;

                    beforeOffice = deepClone(office);
                    right(office, i, j, M);
                    recursive(N, M, office, idx + 1);
                    office = beforeOffice;
                    break;
                default:
                    recursive(N, M, office, idx + 1);
            }

        }
    }

    private static void up(String[][] office, int i, int j) {
        for (int k = i - 1; k >= 0; k--) {
            if (office[k][j].equals("6"))
                break;
            else if (office[k][j].equals("0"))
                office[k][j] = "#";
            else
                continue;
        }
        // System.out.println("up");
    }

    private static void down(String[][] office, int i, int j, int N) {
        for (int k = i + 1; k < N; k++) {
            if (office[k][j].equals("6"))
                break;
            else if (office[k][j].equals("0"))
                office[k][j] = "#";
            else
                continue;
        }
        // System.out.println("down");
    }

    private static void left(String[][] office, int i, int j) {
        for (int k = j; k >= 0; k--) {
            if (office[i][k].equals("6"))
                break;
            else if (office[i][k].equals("0"))
                office[i][k] = "#";
            else
                continue;
        }
        // System.out.println("left");
    }

    private static void right(String[][] office, int i, int j, int M) {
        for (int k = j; k < M; k++) {
            if (office[i][k].equals("6"))
                break;
            else if (office[i][k].equals("0"))
                office[i][k] = "#";
            else
                continue;
        }
        // System.out.println("right");
    }

    private static int countBlindSpot(String[][] office) {
        int count = 0;
        for (int i = 0; i < office.length; i++) {
            for (int j = 0; j < office[0].length; j++)
                if (office[i][j].equals("0")) count++;
        }

        return count;
    }

    private static String[][] deepClone(String[][] array) {
        String[][] newArray = new String[array.length][array[0].length];
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[0].length; j++) {
                newArray[i][j] = array[i][j];
            }
        }
        return newArray;
    }
}
