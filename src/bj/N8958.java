package bj;

import java.util.Scanner;

// https://www.acmicpc.net/problem/8958
// OX퀴즈
public class N8958 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-- > 0) {
            String[] ox = sc.next().split("");
            int answer = 0;
            int o = 1;
            for (String s : ox) {
                if (s.equals("O")) {
                    answer += o;
                    o++;
                } else {
                    o = 1;
                }
            }
            System.out.println(answer);
        }
    }
}
