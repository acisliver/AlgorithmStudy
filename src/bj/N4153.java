package bj;

import java.util.Arrays;
import java.util.Scanner;

// https://www.acmicpc.net/problem/
// 직각삼각형
public class N4153 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] nums = Arrays.stream(sc.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .sorted()
                .toArray();
        while (nums[0] != 0 && nums[1] !=0 && nums[2] !=0) {

            if (nums[0] * nums[0] + nums[1] * nums[1] == nums[2] * nums[2]) System.out.println("right");
            else System.out.println("wrong");

            nums = Arrays.stream(sc.nextLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .sorted()
                    .toArray();
        }
    }
}
