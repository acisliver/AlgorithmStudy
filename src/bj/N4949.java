package bj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

// https://www.acmicpc.net/problem/4949
// 균형잡힌 세상
public class N4949 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        Stack<String> stack;
        String[] letters;
        String answer;
        int idx;
        while (!input.equals(".")) {
            idx = 0;
            stack = new Stack<>();
            letters = input.split("");
            for (String letter : letters) {
                if (letter.equals("(") || letter.equals("[")) {
                    stack.push(letter);
                } else if (letter.equals(")")) {
                    if (stack.empty()) {
                        break;
                    } else {
                        if (stack.peek().equals("("))
                            stack.pop();
                        else {
                            break;
                        }
                    }
                } else if (letter.equals("]")) {
                    if (stack.empty()) {
                        break;
                    } else {
                        if (stack.peek().equals("["))
                            stack.pop();
                        else {
                            break;
                        }
                    }
                }
                idx++;
            }
            if (stack.empty() && idx == letters.length)
                answer = "yes";
            else
                answer = "no";

            System.out.println(answer);
            input = br.readLine();
        }
    }
}
