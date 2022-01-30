package bj;

import java.util.Scanner;

// https://www.acmicpc.net/problem/10871
// X보다 작은 수
public class N10871 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int x = sc.nextInt();
        int a;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            a = sc.nextInt();
            if (x > a) {
                sb.append(a).append(" ");
            }
        }
        System.out.println(sb);
    }
}
