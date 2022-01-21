package bj;

import java.util.Scanner;

// https://www.acmicpc.net/problem/2920
// 음계
public class N2920 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int start = sc.nextInt();
        String result = "";
        // ascending
        if (start == 1) {
            for (int i = 0; i < 7; i++) {
                if (++start != sc.nextInt()) {
                    result = "mixed";
                    break;
                } else {
                    result = "ascending";
                }
            }

        }
        // descending
        else if (start == 8) {
            for (int i = 0; i < 7; i++) {
                if (--start != sc.nextInt()) {
                    result = "mixed";
                    break;
                } else {
                    result = "descending";
                }
            }

        }
        // mixed
        else {
            result = "mixed";
        }

        System.out.println(result);
    }
}
