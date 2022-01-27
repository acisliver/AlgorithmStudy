package bj;

import java.util.Scanner;

// https://www.acmicpc.net/problem/10950
// A + B - 3
public class N10950 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-- > 0) {
            System.out.println(sc.nextInt() + sc.nextInt());
        }
    }
}
