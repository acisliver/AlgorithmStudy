package bj;

import java.util.Scanner;

// https://www.acmicpc.net/problem/15829
// Hashing
public class N15829 {
    private static int M = 1234567891;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String str = sc.next();
        long result = 0;
        long pow = 1;

        for (int i = 0; i < n; i++) {
             result += (str.charAt(i) - 'a' + 1) * pow;
             pow = pow * 31 % M;
        }

        System.out.println(result % M);
    }
}
