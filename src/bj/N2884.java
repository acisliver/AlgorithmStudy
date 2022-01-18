package bj;

import java.util.Scanner;

// https://www.acmicpc.net/problem/2884
// 알람 시계
public class N2884 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int h = sc.nextInt();
        int m = sc.nextInt();

        if (m < 45) {
            if (h == 0)
                h = 23;
            else
                h -= 1;
            m += 15;
        } else {
            m -= 45;
        }

        System.out.printf("%d %d", h, m);
    }
}
