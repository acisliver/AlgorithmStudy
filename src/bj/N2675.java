package bj;

import java.util.Scanner;

// https://www.acmicpc.net/problem/2675
// 문자열 반복
public class N2675 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        int n;
        String[] word;
        StringBuilder sb;
        for (int i = 0; i < T; i++) {
            n = sc.nextInt();
            word = sc.next().split("");
            sb = new StringBuilder();
            for (String s : word) {
                for (int j = 0; j < n; j++) {
                    sb.append(s);
                }
            }
            System.out.println(sb);
        }
    }
}
