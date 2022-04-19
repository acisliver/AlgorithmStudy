package bj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// https://www.acmicpc.net/problem/2110
// 공유기 설치
// 이진 탐색
public class N2110 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        int[] home = new int[n];
        boolean[] router = new boolean[n];

        for (int i = 0; i < n; i++) {
            home[i] = Integer.parseInt(br.readLine());
        }

        // 양 끝집은 라우터 배치
        router[0] = true;
        router[n - 1] = true;
        c -= 2;


    }
}
