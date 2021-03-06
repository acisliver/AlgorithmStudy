package bj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

// https://www.acmicpc.net/problem/14888
// 연산자 끼워넣기
// 완전탐색에 중첩되는 경우는 백트래킹으로 풀이
public class N14888 {

    private static ArrayList<Integer> results;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int[] A = new int[N];

        st = new StringTokenizer(br.readLine()); // 입력 줄바꿈

        for (int i = 0; i < N; i++) {
             A[i] = Integer.parseInt(st.nextToken());
        }

        int[] opNum = new int[4];

        st = new StringTokenizer(br.readLine()); // 입력 줄바꿈

        for (int i = 0; i < 4; i++) {
            opNum[i] = Integer.parseInt(st.nextToken());
        }

        solution(N, A, opNum);

    }

    private static void solution(int N, int[] A, int[] opNum) {
        results = new ArrayList<>();

        recursive(N, 0, A, opNum, A[0]);

        Collections.sort(results);
        System.out.println(results.get(results.size() - 1));
        System.out.println(results.get(0));
    }

    private static void recursive(int N, int i, int[] A, int[] opNum, int result) {
        if (i == N - 1) {
            results.add(result);
        }
        else
            for (int j = 0; j < 4; j++) {
                 if (opNum[j] > 0) {
                     opNum[j] -= 1;
                     recursive(N, i + 1, A, opNum, calculate(j, result, A[i + 1]));
                     opNum[j] += 1;
                 }
            }
    }

    private static int calculate(int j, int result, int operand) {
        switch (j) {
            case 0:
                return result + operand;
            case 1:
                return result - operand;
            case 2:
                return result * operand;
            case 3:
                return result / operand;
        }
        return 0;
    }

}
