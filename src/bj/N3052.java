package bj;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

// https://www.acmicpc.net/problem/3052
// 나머지
public class N3052 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < 10; i++) {
             set.add(sc.nextInt() % 42);
        }
        System.out.println(set.size());
    }
}
