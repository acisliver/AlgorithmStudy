package bj;

import java.math.BigInteger;
import java.util.Scanner;

// https://www.acmicpc.net/problem/2407
// 조합
public class N2407 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        BigInteger n = new BigInteger(String.valueOf(sc.nextInt()));
        BigInteger m = new BigInteger(String.valueOf(sc.nextInt()));
        BigInteger answer = BigInteger.ONE;

        for (int i = 0; i < m.intValue(); i++) {
            answer = answer.multiply(BigInteger.valueOf(n.intValue() - i)).divide(BigInteger.valueOf(i + 1));
        }

        System.out.println(answer);
    }
}
