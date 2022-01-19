package bj;

import java.util.Scanner;

// https://www.acmicpc.net/problem/2739
// 구구단
public class N2739 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i < 10; i++) {
             sb.append(String.format("%d * %d = %d", n, i, n * i)).append("\n");
        }
        System.out.println(sb);
    }
}
