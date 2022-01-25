package bj;

import java.util.Arrays;
import java.util.Scanner;

// https://www.acmicpc.net/problem/2231
// 분해합
public class N2231 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int[] nums;
        int con;
        int result = 0;
        for (int i = 1; i <= a; i++) {
            con = i;
            nums = Arrays.stream(String.valueOf(i).split(""))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            for (int num : nums) {
                con += num;
            }
            if (con == a)
            {
                result = i;
                break;
            }
        }
        System.out.println(result);
    }
}
