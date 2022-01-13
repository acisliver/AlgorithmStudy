package bj;

import java.util.Scanner;

// https://www.acmicpc.net/problem/3344
// N * N 체스 보드에 N개의 퀸이 서로 공격하지 못하게 배치
// 행을 기준으로 재귀 할 예정
public class NQueen {

    private static int[] board;
    private static boolean isPrint;

    public static void main(String[] args) {
        // 입력
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        // 알고리즘
        nQueen(N);
    }

    private static int[] nQueen(int n) {

        // 퀸의 수만큼의 체스보드 생성
        // 1부터 시작
        // 인덱스: 행
        // 값: 열
        board = new int[n + 1];
        isPrint = false;

        return recursive(0, n);
    }

    // board[i] = 0 이면 퀸이 아직 놓이지 않은 행
    // 퀸이 놓이면 board 값은 1 ~ 8
    private static int[] recursive(int i, int n) {
        if (valid(i)) {
            if (i == n) {

                if (!isPrint){
                    // 출력
                    for (int q = 1; q < board.length; q++) {
                        System.out.println(board[q]);
                    }
                    isPrint = true;
                }

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

        int j = 1;

        while (j < i) {
            // 같은 열확인
            if (board[i] == board[j]) return false;

            // 왼쪽 대각선 확인
            if (board[i] == board[j] - i + j) return false;

            // 오른쪽 대각선 확인
            if (board[i] == board[j] + i - j)return false;
            j++;
        }

        return true;
    }

}
