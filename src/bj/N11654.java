package bj;

import java.util.Scanner;

// https://www.acmicpc.net/problem/11654
// 아스키 코드
public class N11654 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        char c = str.charAt(0);
        System.out.println((int) c);
    }
}
