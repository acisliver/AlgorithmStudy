package bj;

import java.util.Scanner;

// https://www.acmicpc.net/problem/5525
// IOIOI
public class N5525 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        String str = sc.next();
        int[] memo = new int[m];

        int count = 0;
        for (int i = 1; i < m - 1; i++) {
            if (str.charAt(i) == 'O' && str.charAt(i + 1) == 'I') {
                memo[i + 1] = memo[i - 1] + 1;
                if (memo[i + 1] >= n && str.charAt(i - 2 * n + 1) == 'I')
                    count++;
            }
        }
        System.out.println(count);
    }
}
