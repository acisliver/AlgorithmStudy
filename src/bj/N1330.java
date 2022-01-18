package bj;

import java.util.Scanner;

// https://www.acmicpc.net/problem/1330
// 두 수 비교하기
public class N1330 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        String result;
        if (a > b)
            result = ">";
        else if (a < b)
            result = "<";
        else
            result = "==";
        System.out.println(result);
    }
}
