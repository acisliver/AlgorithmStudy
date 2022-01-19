package bj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// https://www.acmicpc.net/problem/2562
// 최댓값
public class N2562 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] input = new int[9];
        for (int i = 0; i < 9; i++) {
             input[i] = Integer.parseInt(br.readLine());
        }
        int max = 0;
        int idx = 1;
        int where = 0;
        for (int i : input) {
            if (max < i) {
                max = i;
                where = idx;
            }
            idx++;
        }
        System.out.println(max + "\n" + where);
    }
}
