package bj;

import java.util.Arrays;
import java.util.Scanner;

// https://www.acmicpc.net/problem/2750
// 수 정렬하기
public class N2750 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < nums.length; i++) {
            nums[i] = sc.nextInt();
        }
        Arrays.sort(nums);
        for (int num : nums) {
            System.out.println(num);
        }
    }
}
