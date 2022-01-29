package bj;

import java.util.Scanner;

// https://www.acmicpc.net/problem/10952
// A + B - 5
public class N10952 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();

        while(!(a == 0 && b == 0)){
            System.out.println(a + b);
            a = sc.nextInt();
            b = sc.nextInt();
        }

    }
}