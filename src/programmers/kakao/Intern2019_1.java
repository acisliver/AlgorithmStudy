package programmers.kakao;

import java.util.Stack;

// https://programmers.co.kr/learn/courses/30/lessons/64061?language=java
// 크레인 인형 뽑기 게임
public class Intern2019_1 {
    public static void main(String[] args) {
        System.out.println(new Intern2019_1().solution(
                new int[][] {
                        {0,0,0,0,0},
                        {0,0,1,0,3},
                        {0,2,5,0,1},
                        {4,2,4,4,2},
                        {3,5,1,3,1}
                },
                new int[]{1,5,3,5,1,2,1,4}
        ));
    }

    public int solution(int[][] board, int[] moves) {
        int answer = 0;

        Stack<Integer> stack = new Stack<>();

        for (int move : moves) {
            for (int i = 0; i < board.length; i++) {
                int cur = board[i][move - 1];

                if (cur == 0) continue;

                board[i][move - 1] = 0;
                if (stack.isEmpty()) {
                    stack.push(cur);
                }
                else {
                    int top = stack.peek();
                    if (top == cur) {
                        stack.pop();
                        answer += 2;
                    } else {
                        stack.push(cur);
                    }
                }
                break;
            }
        }

        return answer;
    }
}
