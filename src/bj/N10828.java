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
        for (int i = 0; i < commands; i++) {
            command = sc.next();
            switch (command) {
                case "push":
                    stack.push(sc.nextInt());
                    break;
                case "pop":
                    System.out.println(stack.pop());
                    break;
                case "size":
                    System.out.println(stack.size());
                    break;
                case "empty":
                    System.out.println(stack.empty());
                    break;
                case "top":
                    System.out.println(stack.top());
                    break;
            }

        }

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
