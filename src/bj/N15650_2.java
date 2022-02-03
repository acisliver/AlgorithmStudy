package bj;

import java.util.Scanner;

// https://www.acmicpc.net/problem/15650
// N과 M(2)
public class N15650_2 {
    private static int n, m;
    private static int[] arr;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();

        arr = new int[m];

        nm(1, 0);


    }

    private static void nm(int i, int depth) {
        if (depth == m) {
            StringBuilder sb = new StringBuilder();
            for (int a : arr) {
                sb.append(a).append(" ");
            }
            System.out.println(sb);
            return;
        }
        for (int j = i; j <= n; j++) {
            arr[depth] = j;
            nm(j + 1, depth + 1);
        }
    }
}
