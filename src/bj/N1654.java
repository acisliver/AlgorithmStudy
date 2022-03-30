package bj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// https://www.acmicpc.net/problem/1654
// 랜선 자르기
// 이진 탐색
// 이진 탐색을 인덱스가 아닌 랜선의 길이로 탐색
public class N1654 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int k = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());
        int[] lan = new int[k];
        long max = 0;

        for (int i = 0; i < lan.length; i++) {
            lan[i] = Integer.parseInt(br.readLine());
            if (max < lan[i])
                max = lan[i];
        }

        long min = 0;
        long mid;

        while (min < max) {
            mid = (min + max) >>> 1;

            long count = 0;

            // mid값으로 잘랐을 때 총 몇개의 랜선이 만들어지는지
            for (int i = 0; i < lan.length; i++) {
                count += lan[i] / mid;
            }

            if (count < n) {
                max = mid;
            } else {
                min = mid + 1;
            }
        }

        System.out.println(max);
    }
}
