package bj;

import java.util.Scanner;

// https://www.acmicpc.net/problem/15829
// Hashing
public class N15829 {
    private static int M = 1234567891;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String str = sc.next();
        char[] chars = new char[str.length()];
        int result = 0;
        for (int i = 0; i < str.length(); i++) {
             chars[i] = str.charAt(i);
        }

        int idx = 0;
        for (char c : chars) {
            result += (c - 'a' + 1) * square(idx);
            if (result >= M) result -= M;
            idx++;
        }
        System.out.println(result);
    }

    public static int square(int n) {
        int result = 1;
        for (int i = 0; i < n; i++) {
            result *= 31;
        }
        return result;
    }
}
