package bj;

import java.util.Scanner;

// https://www.acmicpc.net/problem/1676
// 팩토리얼 0의 개수
public class N1676 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int count = 0;
        int two = 0;
        int five = 0;
        for (int i = 2; i <= n; i++) {
            int f = i;
            while (f % 10 == 0) {
                count++;
                f /= 10;
            }
            while (f % 5 == 0) {
                five++;
                f /= 5;
            }
            while (f % 2 == 0) {
                two++;
                f /= 2;
            }
        }
        System.out.println(count + Math.min(two, five));
    }
}
