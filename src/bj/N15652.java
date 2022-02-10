package bj;

import java.util.Scanner;

// https://www.acmicpc.net/problem/15652
// N과 M(4)
public class N15652 {
    private static int n, m;
    private static int[] arr;
    private static final StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        arr = new int[m];

        nm(0);
        System.out.println(sb);

    }

    private static void nm(int depth) {

        if (depth == m) {
            for (int i : arr) {
                sb.append(i + 1).append(" ");
            }
            sb.append("\n");
        } else {
            for (int i = 0; i < n; i++) {
                if (depth > 0 && arr[depth - 1] <= i) {
                    arr[depth] = i;
                    nm(depth + 1);
                } else if (depth == 0) {
                    arr[depth] = i;
                    nm(depth + 1);
                }
            }
        }


    }
}
