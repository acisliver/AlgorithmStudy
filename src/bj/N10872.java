package bj;

import java.util.Scanner;

// https://www.acmicpc.net/problem/10872
// 팩토리얼
public class N10872 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println(fac(sc.nextInt()));
    }

    private static int fac(int n) {
        if (n == 0)
            return 1;
        if (n == 1)
            return 1;
        else
            return n * fac(n - 1);
    }
}
