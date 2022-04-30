package programmers.kakao;

import java.util.Arrays;

// https://programmers.co.kr/learn/courses/30/lessons/92344
// 파괴되지 않은 건물
public class Blind2022_6 {
    public static void main(String[] args) {
        Blind2022_6 s = new Blind2022_6();
        System.out.println(s.solution(
                new int[][]{
                        {5, 5, 5, 5, 5},
                        {5, 5, 5, 5, 5},
                        {5, 5, 5, 5, 5},
                        {5, 5, 5, 5, 5}
                },
                new int[][]{
                        {1, 0, 0, 3, 4, 4},
                        {1, 2, 0, 2, 3, 2},
                        {2, 1, 0, 3, 1, 2},
                        {1, 0, 1, 3, 3, 1}
                }
        ));
    }

    public int solution(int[][] board, int[][] skill) {
        return cal1(board, skill);
    }

    // 정확성
    public int cal1(int[][] board, int[][] skill) {
        for (int[] s : skill) {
            int r1, c1, r2, c2, degree;
            r1 = s[1];
            c1 = s[2];
            r2 = s[3];
            c2 = s[4];
            degree = s[5];


            if (s[0] == 1) {    // 공격
                for (int i = r1; i <= r2; i++) {
                    for (int j = c1; j <= c2; j++) {
                        board[i][j] -= degree;
                    }
//                    System.out.println(Arrays.deepToString(board));
                }
            } else {            // 회복
                for (int i = r1; i <= r2; i++) {
                    for (int j = c1; j <= c2; j++) {
                        board[i][j] += degree;
                    }
//                    System.out.println(Arrays.deepToString(board));
                }
            }
        }

//        System.out.println(Arrays.deepToString(board));
        return count(board);
    }

    public int count(int[][] board) {
        int count = 0;

        for (int[] b : board) {
            for (int i : b) {
                if (i > 0) count++;
            }
        }

        return count;
    }

//    public int[][] getSquare(int[] skill) {
//        int r1, c1, r2, c2;
//        r1 = skill[1];
//        c1 = skill[2];
//        r2 = skill[3];
//        c2 = skill[4];
//        int[][] square = new int[r2 - r1][c2 - c1];
//
//        for (int i = r1; i < r2; i++) {
//            for (int j = c1; j < c2; j++) {
//
//            }
//
//        }
//    }

}
