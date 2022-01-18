package bj;

import java.util.Scanner;

// https://www.acmicpc.net/problem/10870
// 피보나치
public class N10870 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println(fibo(sc.nextInt()));
    }

    private static int fibo(int n) {
        if (n == 0)
            return 0;
        if (n == 1)
            return 1;
        else
            return fibo(n - 1) + fibo(n - 2);
    }
}
