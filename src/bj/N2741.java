package bj;

import java.util.Scanner;

// https://www.acmicpc.net/problem/2741
// N 찍기
public class N2741 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for (int i = 1; i < n + 1; i++) {
            System.out.println(i);
        }
    }
}
