package bj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// https://www.acmicpc.net/problem/10816
// 숫자 카드 2
public class N10816 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] card = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < card.length; i++) {
            card[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(card);

        System.out.println(Arrays.toString(card));

        int m = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) {
            sb.append(getCardCount(card, Integer.parseInt(st.nextToken()))).append(" ");
        }

        System.out.println(sb);

    }

    static int getCardCount(int[] arr, int key) {

        return upperbound(arr, key) - lowerbound(arr, key);
    }

    private static int lowerbound(int[] arr, int key) {
        int low = 0;
        int high = arr.length;
        int mid, midVal;

        while(low <= high) {    // low와 high가 같아질때 까지
            mid = (low + high) >>> 1;
            midVal = arr[mid];

            if (key <= midVal) {    // 키가 왼쪽에 있다.
                high = mid;
            } else {                //
                low = mid + 1;
            }
        }

        return low;
    }

    private static int upperbound(int[] arr, int key) {
        int low = 0;
        int high = arr.length;
        int mid, midVal;

        while(low <= high) {
            mid = (low + high) >>> 1;
            midVal = arr[mid];

            if (key < midVal) {     // 탐색할 값의 상힌이 오른쪽에 있다
                high = mid;
            } else {                // 키와 같거나 작으면 상한이 오른쪽에 있다.
                low = mid + 1;
            }
        }

        return low;
    }

    // Arrays.binarySearch
    private static int binarySearch0(long[] a, int fromIndex, int toIndex,
                                     long key) {
        int low = fromIndex;
        int high = toIndex - 1;

        while (low <= high) {
            int mid = (low + high) >>> 1;
            long midVal = a[mid];

            if (midVal < key)
                low = mid + 1;
            else if (midVal > key)
                high = mid - 1;
            else
                return mid; // key found
        }
        return -(low + 1);  // key not found.
    }
}
