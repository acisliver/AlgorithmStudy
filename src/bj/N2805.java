package bj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.util.stream.IntStream;

// https://www.acmicpc.net/problem/2805
// 나무 자르기
// 이진 탐색
public class N2805 {
    private static int[] Trees;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        Trees = new int[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < Trees.length; i++) {
            Trees[i] = Integer.parseInt(st.nextToken());
        }

        System.out.println(trimTrees(15));

    }

    private static int trimTrees(int height) {
        return Arrays.stream(Trees)
                .map(t -> Math.max(t - height, 0))
                .reduce(Integer::sum).getAsInt();
    }
}
