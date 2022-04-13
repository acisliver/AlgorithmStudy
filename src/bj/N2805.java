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

        int max = 0;
        int min = 0;

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < Trees.length; i++) {
            int tree = Integer.parseInt(st.nextToken());
            max = Math.max(tree, max);
            Trees[i] = tree;
        }

        while(min < max) {
            int mid = (max + min) >>> 1;
            long sum = trimTrees(mid);
//            System.out.printf("자르는 위치: %d, 나무 총합: %d\n", mid, sum);

            if (sum < m) {          // 너무 많이 자른 경우
                max = mid;
            } else {   // 더 잘라야 하는 경우
                min = mid + 1;
            }
        }

        System.out.println(min - 1);
    }

    /**
     * @param height 자를 나무의 높이
     * @return height만큼 자른 나무들의 총 합
     */
    private static long trimTrees(int height) {
        return Arrays.stream(Trees)
                .map(t -> Math.max(t - height, 0))
                .mapToLong(Long::new)
                .reduce(Long::sum).getAsLong();
    }
}
