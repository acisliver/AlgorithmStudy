package bj;

import java.util.Scanner;

// https://www.acmicpc.net/problem/3344
// N * N 체스 보드에 N개의 퀸이 서로 공격하지 못하게 배치
// 행을 기준으로 재귀 할 예정
public class NQueen {

    private static int[] board;

    public static void main(String[] args) {
        // 입력
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        // 알고리즘
        int[] out = nQueen(N);

        // 출력
        for (int i : out) {
            System.out.println(i);
        }
    }

    private static int[] nQueen(int n) {

        board = new int[n + 1];

        return recursive(0, n);
    }

    // board[i] = 0 이면 퀸이 아직 놓이지 않은 행
    // 퀸이 놓이면 board 값은 1 ~ 8
    // 시작 정점 1
    private static int[] recursive(int i, int n) {
        if (valid(i)) {
            if (i == n) {
                return board;
            }
            for (int m = 1; m <= n; m++) {
                board[i + 1] = m;
                recursive(i + 1, n);
            }
        }
        return null;
    }

    // 가지치기 조건
    private static boolean valid(int i) {
        if (i == 0) return true;

        // 같은 열확인
        for (int j = 1; j < i; j++) {
            if (board[i - 1] == board[j]) return false;
        }
        // 대각선 확인 1


        // 대각선 확인 2

        return true;
    }

}
