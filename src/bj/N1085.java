package bj;

import java.util.Scanner;

// https://www.acmicpc.net/problem/
// 직사각형에서 탈출
public class N1085 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();
        int y = sc.nextInt();
        int w = sc.nextInt();
        int h = sc.nextInt();

        int xMin = Math.min(x, w - x);
        int yMin = Math.min(y, h - y);

        System.out.println(Math.min(xMin, yMin));
    }
}
