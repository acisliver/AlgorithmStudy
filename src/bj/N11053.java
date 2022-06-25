package bj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

// https://www.acmicpc.net/problem/11053
// 가장 긴 증가하는 부분 수열
public class N11053 {
    static Integer[] DP;
    static int[] array;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        array = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        DP = new Integer[n];
        DP[0] = 1;

        for (int i = 1; i < n; i++) {
            lis(i);
        }

        int max = Arrays.stream(DP).max(Comparator.naturalOrder()).get();

        System.out.println(max);
    }

    static int lis(int n) {

        if (DP[n] == null) {
            DP[n] = 1;

            for (int i = n - 1; i >= 0; i--) {
                if (array[i] < array[n]) {
                    DP[n] = Math.max(DP[n], lis(i) + 1);
                }
            }
        }

        return DP[n];
    }
}
