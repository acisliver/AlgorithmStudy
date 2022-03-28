package bj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// https://www.acmicpc.net/problem/10815
// 숫자 카드
public class N10815 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] card = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < card.length; i++) {
            card[i] = Integer.parseInt(st.nextToken());
        }

        int m = Integer.parseInt(br.readLine());
        int[] nums = new int[m];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < nums.length; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }

        int[] answer = new int[m];

        Arrays.sort(card);

        for (int i = 0; i < nums.length; i++) {
            if (binarySearch(card, nums[i]) > -1)
                answer[i] = 1;
        }

        StringBuilder sb = new StringBuilder();
        for (int i : answer) {
            sb.append(i).append(" ");
        }
        System.out.println(sb);

    }

    static int binarySearch(int[] arr, int key) {
        int left = 0;
        int right = arr.length - 1;
        int mid;

        while (left <= right) {
            mid = (left + right) >>> 1;
            int midVal = arr[mid];

            if (midVal < key)
                left = mid + 1;
            else if(midVal > key)
                right = mid - 1;
            else
                return mid;
        }

        // 탐색 실패
        return -1;
    }
}
