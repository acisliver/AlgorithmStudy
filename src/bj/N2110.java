package bj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// https://www.acmicpc.net/problem/2110
// 공유기 설치
// 이진 탐색
public class N2110 {
    static int[] home;
    static long min, max;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        home = new int[n];

        for (int i = 0; i < n; i++) {
            home[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(home);

        min = 1;
        max = home[n - 1] - home[0] + 1;

        // mid값보다 작은 거리로 공유기 배치
        while(min < max) {
            long mid = (min + max) >>> 1;

            if (canLocate(mid) < c) {   // 공유기가 남는다면
                max = mid;
            } else {
                min = mid + 1;
            }
        }

        System.out.println(min - 1);
    }

    public static int canLocate(long distance) {
        int count = 1;
        long lastLocated = home[0]; // 첫번째 집은 무조건 공유기 설치

        for (int i = 1; i < home.length; i++) {
            int curLocate = home[i];

            if (curLocate - lastLocated >= distance) {
                count++;
                lastLocated = curLocate;
            }
        }

        return count;
    }
}
