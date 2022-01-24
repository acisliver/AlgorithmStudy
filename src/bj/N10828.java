package bj;

import java.util.Scanner;

// https://www.acmicpc.net/problem/10828
// 스택
public class N10828 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayStack stack = new ArrayStack();
        int commands = sc.nextInt();
        String command;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < commands; i++) {
            command = sc.next();
            switch (command) {
                case "push":
                    stack.push(sc.nextInt());
                    break;
                case "pop":
                    sb.append(stack.pop()).append("\n");
                    break;
                case "size":
                    sb.append(stack.size()).append("\n");
                    break;
                case "empty":
                    sb.append(stack.empty()).append("\n");
                    break;
                case "top":
                    sb.append(stack.top()).append("\n");
                    break;
            }
        }
        System.out.println(sb);
    }

    public static class ArrayStack {
        int TOTAL_SIZE = 10000;
        int[] data;
        int top;

        ArrayStack() {
            data = new int[TOTAL_SIZE];
            this.top = -1;
        }

        public int empty() {
            return this.top == -1 ? 1 : 0;
        }

        public boolean full() {
            return this.top == this.TOTAL_SIZE - 1;
        }

        public void push(int data) {
            if (full()) {
                System.out.println("스택 꽉 참");
            }
            this.data[++this.top] = data;
        }

        public int pop() {
            return empty() == 1 ? -1 : this.data[this.top--];
        }

        public int size() {
            return this.top + 1;
        }

        public int top() {
            return empty() == 1 ? -1 : this.data[top];
        }
    }


}
