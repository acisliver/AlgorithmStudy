package bj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// https://www.acmicpc.net/problem/15654
// N과 M(9)
public class N15663 {
    private static int n, m;
    private static int[] arr;
    private static Map<Integer, Integer> map;
    private static Set<Integer> keys;
    private static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        sb = new StringBuilder();

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new TreeMap<>();
        arr = new int[m];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            int n = Integer.parseInt(st.nextToken());
            map.put(n, map.getOrDefault(n, 0) + 1);
        }
        keys = map.keySet();

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
        for (Integer key : keys) {
            if (map.get(key) > 0) {
                map.put(key, map.get(key) - 1);
                arr[depth] = key;
                nm(depth + 1);
                map.put(key, map.get(key) + 1);
            }
        }
    }
}
