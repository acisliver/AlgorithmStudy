package bj;

import java.util.Scanner;

// https://www.acmicpc.net/problem/11729
// 하노이 탑 이동 순서
public class N11729 {

    private static StringBuilder sb;
    private static int count;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sb = new StringBuilder();
        count = 0;
        hanoi(n, 1, 3, 2);
        System.out.println(count);
        System.out.println(sb.toString());
    }

    private static void hanoi(int n, int from, int to, int tmp) {
        if (n == 1) {
            count++;
            sb.append(String.format("%d %d\n", from, to));
        } else {

            hanoi(n - 1, from, tmp, to);
            sb.append(String.format("%d %d\n", from, to));
            count++;
            hanoi(n - 1, tmp, to, from);
        }
    }
}
