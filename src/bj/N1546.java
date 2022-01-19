package bj;

import java.util.Scanner;

// https://www.acmicpc.net/problem/1546
// 평균
public class N1546 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        double[] scores = new double[n];
        double max = 0;
        double answer = 0;
        for (int i = 0; i < n; i++) {
            scores[i] = sc.nextInt();
        }
        for (double score : scores) {
            if (max < score) {
                max = score;
            }
        }
        for (double score : scores) {
            answer += score / max * 100;
        }
        System.out.println(answer / n);
    }
}
