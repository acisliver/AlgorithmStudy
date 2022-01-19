package bj;

import java.util.Scanner;

// https://www.acmicpc.net/problem/2557
// 숫자의 개수
public class N2557 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();
        String result = String.valueOf(a * b * c);
        int[] digit = new int[10];
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < result.length(); i++) {
            digit[result.charAt(i) - '0'] += 1;
        }
        for (int i : digit) {
            sb.append(i).append("\n");
        }
        System.out.println(sb);
    }
}
