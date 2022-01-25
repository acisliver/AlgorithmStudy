package bj;

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

// https://www.acmicpc.net/problem/
// 팰린드롬수
public class N1259 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        int reNum;
        String[] nums;
        while(num != 0) {
            nums = String.valueOf(num).split("");
            Collections.reverse(Arrays.asList(nums));
            reNum = Integer.parseInt(String.join("", nums));
            if (reNum == num)
                System.out.println("yes");
            else
                System.out.println("no");
            num = sc.nextInt();
        }
    }
}
