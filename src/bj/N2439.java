package bj;

import java.util.Scanner;

// https://www.acmicpc.net/problem/2439
// 별 찍기 - 2
public class N2439 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        StringBuilder sb = new StringBuilder();

        for (int i = 1; i <= n; i++) {
            for (int j = 0; j < n - i; j++) {
                 sb.append(" ");
            }
            for (int j = 0; j < i; j++) {
                 sb.append("*");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}
