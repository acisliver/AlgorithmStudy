package bj;

import java.util.Scanner;

// https://www.acmicpc.net/problem/2908
// 상수
public class N2908 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String a = new StringBuilder().append(sc.next()).reverse().toString();
        String b = new StringBuilder().append(sc.next()).reverse().toString();

        if (Integer.parseInt(a) > Integer.parseInt(b)) System.out.println(a);
        else System.out.println(b);
    }
}
