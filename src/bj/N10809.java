package bj;

import java.util.Scanner;

// https://www.acmicpc.net/problem/10809
// 알파벳 찾기
public class N10809 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        StringBuilder sb = new StringBuilder();
        for (int i = 'a'; i < 'z' + 1; i++) {
            char c = (char) i;
            if (str.contains(String.valueOf(c))) {
                sb.append(str.indexOf(c)).append(" ");
            } else {
                sb.append(-1).append(" ");
            }
        }
        System.out.println(sb);
    }
}
