package bj;

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;
import java.util.Stack;

// https://www.acmicpc.net/problem/15650
// N과 M(2)
public class N15650 {
    private static int n, m;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        nm(0, 0);
    }

    private static void nm(int i, int visited) {

        if (Integer.bitCount(visited) == m) {
            print(visited);
            return;
        }
        for (int j = i; j < n; j++) {
            visited |= 1 << (j + 1);
            nm(j + 1, visited);
            visited &= ~(1 << (j + 1));
        }
    }

    private static void print(int visited) {
        StringBuilder sb = new StringBuilder();
        String[] arr = Integer.toBinaryString(visited).split("");
        Collections.reverse(Arrays.asList(arr));
        for (int i = 0; i < arr.length; i++) {
            if (arr[i].equals("1")) {
                sb.append(i).append(" ");
            }
        }
        System.out.println(sb);
    }
}
