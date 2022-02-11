package bj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// https://www.acmicpc.net/problem/15666
// N과 M(12)
public class N15666 {
    private static int n, m;
    private static int[] arr;
    private static Set<Integer> set;
    private static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        sb = new StringBuilder();

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        set = new TreeSet<>();
        arr = new int[m];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            set.add(Integer.parseInt(st.nextToken()));
        }

        nm(0);

        System.out.println(sb);
    }

    private static void nm(int depth) {
        if (depth == m) {
            for (int i : arr) {
                sb.append(i).append(" ");
            }
            sb.append("\n");
            return;
        }
        for (Integer integer : set) {
            if (depth > 0 && arr[depth - 1] > integer)
                continue;
            arr[depth] = integer;
            nm(depth + 1);
        }
    }
}
