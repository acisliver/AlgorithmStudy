package bj;

import java.util.Scanner;

public class N1009 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        int a, b;
        int result;

        for (int i = 0; i < T; i++) {
            result = 1;
            a = sc.nextInt();
            b = sc.nextInt();
            for (int j = 0; j < b; j++) {
                result = (result * a) % 10;
            }

            if (result == 0) System.out.println(10);
            else System.out.println(result);
        }
    }
}
