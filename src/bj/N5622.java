package bj;

import java.util.Scanner;

// https://www.acmicpc.net/problem/5622
// 다이얼
public class N5622 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] word = sc.next().split("");
        String[] dial = new String[] {"ABC", "DEF", "GHI", "JKL", "MNO", "PQRS", "TUV", "WXYZ"};
        int count = 0;
        int idx = 0;
        for (String w : word) {
            for (String d : dial) {
                if (d.contains(w)) count += (3 + idx);
                idx++;
            }
            idx = 0;
        }
        System.out.println(count);
    }
}
