package bj;

import java.util.Scanner;

// https://www.acmicpc.net/problem/10818
// 최소, 최대
public class N10818 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            int a = sc.nextInt();
            if (max < a) max = a;
            if (min > a) min = a;
        }
        System.out.printf("%d %d", min, max);
    }
}
