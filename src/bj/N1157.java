package bj;

import java.util.*;

// https://www.acmicpc.net/problem/1157
// 단어 공부
public class N1157 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.next().toUpperCase();
        char[] chars = new char[input.length()];
        for (int i = 0; i < input.length(); i++) {
            chars[i] = input.charAt(i);
        }
        int[] frequency = new int[26];
        int a = 'A';
        for (char c : chars) {
            frequency[(int) c - a] += 1;
        }

        int max = -1;
        char c = ' ';
        int idx = 0;
        for (int i : frequency) {
            if (max < i) {
                c = (char) (a + idx);
                max = i;
            } else if (max > 0 && max == i) {
                c = '?';
            }
            idx++;
        }

        System.out.println(c);

    }
}
