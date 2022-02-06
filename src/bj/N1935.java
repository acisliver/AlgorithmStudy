package bj;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

// https://www.acmicpc.net/problem/1935
// 후위 표기식2
public class N1935 {
    private static final ArrayList<String> OPERATOR = new ArrayList<>(Arrays.asList("+", "-", "*", "/"));

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String[] expression = sc.next().split("");
        double[] var = new double[n];
        Stack<Double> stack = new Stack<>();

        for (int i = 0; i < n; i++) {
            var[i] = sc.nextDouble();
        }

        for (String s : expression) {
            if (OPERATOR.contains(s)) {
                double x = stack.pop();
                double y = stack.pop();
                stack.push(operate(x, y, s));
            } else {
                stack.push(var[s.charAt(0) - 'A']);
            }
        }
        System.out.printf("%.2f", stack.pop());
    }

    private static double operate(double x, double y, String s) {
        switch (s) {
            case "+":
                return y + x;
            case "-":
                return y - x;
            case "*":
                return y * x;
            case "/":
                return y / x;
        }
        return 0;
    }
}
