package bj;

import java.util.Scanner;

// https://www.acmicpc.net/problem/1629
// 곱셈
// 분할 정복
public class N1629 {
    private static long c;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long a = sc.nextLong();
        long b = sc.nextLong();
        c = sc.nextLong();

        System.out.println((int) pow(a, b));
    }

    private static long pow(long a, long b) {
        if (b == 1)
            return a % c;

        long half = pow(a, b / 2);

        if (b % 2 == 0) {
            return (half * half) % c;
        } else {
            return (half * half % c) * a % c;
        }
    }
}
