package bj;

import java.util.Scanner;

// https://www.acmicpc.net/problem/10951
// A + B - 4
public class N10951 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while(sc.hasNext()) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            System.out.println(a + b);
        }
        sc.close();
    }
}
