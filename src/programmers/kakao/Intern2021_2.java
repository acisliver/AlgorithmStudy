package programmers.kakao;

import java.util.Arrays;

// https://programmers.co.kr/learn/courses/30/lessons/81302?language=java
// 거리두기 확인
public class Intern2021_2 {
    public static void main(String[] args) {
        Intern2021_2 s = new Intern2021_2();
        System.out.println(Arrays.toString(s.solution(
                new String[][]
                        {
                                {"POOOP", "OXXOX", "OPXPX", "OOXOX", "POXXP"},
                                {"POOPX", "OXPXP", "PXXXO", "OXXXO", "OOOPP"},
                                {"PXOPX", "OXOXP", "OXPOX", "OXXOP", "PXPOX"},
                                {"OOOXX", "XOOOX", "OOOXX", "OXOOX", "OOOOO"},
                                {"PXPXP", "XPXPX", "PXPXP", "XPXPX", "PXPXP"}
                        }
        )));
    }

    public static int[] DX = new int[]{0, 0, 1, -1, 1, -1, 1, -1, 0, 0, 2, -2};
    public static int[] DY = new int[]{1, -1, 0, 0, -1, 1, -1, 1, 2, -2, 0, 0};

    public int[] solution(String[][] places) {
        int[] answer = new int[5];

        for (int i1 = 0; i1 < places.length; i1++) {
            int isOk = 1;
            String[] place = places[i1];
            char[][] matrix = toMatrix(place);
            System.out.println(Arrays.deepToString(matrix));
            for (int i = 0; i < matrix.length; i++) {
                for (int j = 0; j < matrix[i].length; j++) {
                    if (matrix[i][j] == 'P') {
                        for (int k = 0; k < 12; k++) {
                            int row = i + DX[k];
                            int col = j + DY[k];

                            if (row < 0 || col < 0 || row > 4 || col > 4) continue;

                            char man = matrix[row][col];

                            if (man == 'P') {
                                if (k < 4) {        // 맨해튼 거리 1, 바로 옆
                                    isOk = 0;
                                } else if (k < 8) { //맨해튼 거리 2, 대각선
                                    if (matrix[row][j] == 'X' && matrix[i][col] == 'X') {

                                    } else {
                                        isOk = 0;
                                    }
                                }
                                else {              // 맨해튼 거리 2, 2칸 직진
                                    if (i == row) { // 같은 열
                                        if (matrix[i][j + DY[k] / 2] == 'X') {

                                        } else {
                                            isOk = 0;
                                        }
                                    } else {        // 같은 행
                                        if (matrix[i + DX[k] / 2][j] == 'X') {

                                        } else {
                                            isOk = 0;
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }

            answer[i1] = isOk;
        }

        return answer;
    }

    public char[][] toMatrix(String[] array) {
        char[][] matrix = new char[5][5];

        int row = 0;
        for (String s : array) {
            for (int i = 0; i < s.length(); i++) {
                matrix[row][i] = s.charAt(i);
            }
            row++;
        }

        return matrix;
    }
}
