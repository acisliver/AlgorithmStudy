package bj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

// https://www.acmicpc.net/problem/12100
// 2048 (Easy)
public class N12100 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[][] board = new int[N][N];

        for (int i = 0; i < N; i++) {
             board[i] = Arrays.stream(br.readLine().split(" "))
                     .mapToInt(Integer::parseInt)
                     .toArray();
        }

        solution(N, board);
    }

    private static void solution(int N, int[][] board) {

        recursive(N, board, 0);
    }

    private static void recursive(int N, int[][] board, int i) {
        if (i == 5) {
            return;
        }
        else
            // 위 아래 왼 오
            for (int j = 0; j < 4; j++) {
                recursive(N, moveBoard(board, j), i + 1);
            }
    }

    private static int[][] moveBoard(int[][] board, int direction) {


        return new int[0][];
    }
}
