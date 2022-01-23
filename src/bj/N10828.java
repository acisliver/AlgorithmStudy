package bj;

import java.util.Scanner;
import java.util.Stack;

// https://www.acmicpc.net/problem/10828
// 스택
public class N10828 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Stack stack = new Stack();
        int commands = sc.nextInt();
        String command;
        for (int i = 0; i < commands; i++) {
            command = sc.next();
            switch (command) {
                case "push":
                    stack.push(sc.nextInt());
                    break;
                case "pop":
                    stack.pop();
                    break;


            }

        }

    }

    public static class Node {
        public Node node;
        private int value;

        public Node() {
        }

        public Node(int value) {
            this.value = value;
        }
    }

    public static class Stack {
        public Node head;
        public int top;

        public Stack() {
            this.head = new Node();
            this.top = -1;
        }

        public void push(int value) {
            Node pushNode = new Node(value);
            this.top++;
        }

        public void pop() {
            this.top--;
        }
    }

}
