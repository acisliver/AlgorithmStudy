package bj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

// https://www.acmicpc.net/problem/1003
// 피보나치 함수
public class N1003 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        int[] answer;

        for (int i = 0; i < T; i++) {
            answer = fibo(Integer.parseInt(br.readLine()));
            System.out.printf("%s %s\n", answer[0], answer[1]);
        }
    }

    private static int[] fibo(int n) {
        if (n == 0) return new int[]{1, 0};
        else if (n == 1) return new int[]{0, 1};


        int count0;
        int count1;
        int[][] fiboArr = new int[n + 1][n + 1];
        fiboArr[0] = new int[]{1, 0};
        fiboArr[1] = new int[]{0, 1};
        for (int i = 2; i <= n; i++) {
            count0 = fiboArr[i - 1][0] + fiboArr[i - 2][0];
            count1 = fiboArr[i - 1][1] + fiboArr[i - 2][1];
            fiboArr[i] = new int[]{count0, count1};
        }
        return fiboArr[n];
    }
}
