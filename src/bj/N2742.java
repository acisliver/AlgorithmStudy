package bj;

import java.util.Scanner;

// https://www.acmicpc.net/problem/2742
// 기찍 N
public class N2742 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for (int i = n; i > 0; i--) {
            System.out.println(i);
        }
    }
}
