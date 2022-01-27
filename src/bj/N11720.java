package bj;

import java.util.Scanner;

// https://www.acmicpc.net/problem/11720
// 숫자의 합
public class N11720 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String[] str = sc.next().split("");
        int answer = 0;
        for (String s : str) {
            answer += Integer.parseInt(s);
        }
        System.out.println(answer);
    }
}
