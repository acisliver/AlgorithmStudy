package bj;

import java.util.Scanner;

// https://www.acmicpc.net/problem/11050
// 이항 계수 1
public class N11050 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int answer = 1;

        for (int i = 0; i < k; i++) {
            answer *= n - i;
        }

        System.out.println(answer);
        for (int i = 1; i <= k; i++) {
            answer /= i;

        }
        System.out.println(answer);
    }
}
