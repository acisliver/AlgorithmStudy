package bj;

import java.util.Scanner;

// https://www.acmicpc.net/problem/10866
// 덱
public class N10866 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayDeque stack = new ArrayDeque();
        int commands = sc.nextInt();
        String command;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < commands; i++) {
            command = sc.next();
            switch (command) {
                case "push_front":
                    stack.push_front(sc.nextInt());
                    break;
                case "push_back":
                    stack.push_back(sc.nextInt());
                    break;
                case "pop_front":
                    sb.append(stack.pop_front()).append("\n");
                    break;
                case "pop_back":
                    sb.append(stack.pop_back()).append("\n");
                    break;
                case "size":
                    sb.append(stack.size()).append("\n");
                    break;
                case "empty":
                    sb.append(stack.empty()).append("\n");
                    break;
                case "front":
                    sb.append(stack.front()).append("\n");
                    break;
                case "back":
                    sb.append(stack.back()).append("\n");
                    break;
            }
        }
        System.out.println(sb);
    }

    public static class ArrayDeque {
        int TOTAL_SIZE = 10000;
        int[] data;
        int front;
        int back;

        ArrayDeque() {
            data = new int[TOTAL_SIZE];
            this.front = 0;
            this.back = 0;
        }

        public int empty() {
            return this.back == this.front ? 1 : 0;
        }


        public int size() {
            return (this.back >= this.front) ? (this.back - this.front) : (this.back + TOTAL_SIZE - this.front);
        }

        public int front() {
            return empty() == 1 ? -1 : this.data[(front + 1) % TOTAL_SIZE];
        }

        public int back() {
            return empty() == 1 ? -1 : this.data[back];
        }

        public void push_front(int data) {
            this.data[front] = data;
            this.front = (this.front - 1 + TOTAL_SIZE) % TOTAL_SIZE;
        }

        public void push_back(int data) {
            this.back = (this.back + 1) % TOTAL_SIZE;
            this.data[back] = data;
        }

        public int pop_front() {
            if (empty() == 1) return -1;
            else {
                this.front = (this.front + 1) % TOTAL_SIZE;
                return this.data[this.front];
            }
        }

        public int pop_back() {
            int result;
            if (empty() == 1) return -1;
            else {
                result = this.data[back];
                this.back = (this.back - 1 + TOTAL_SIZE) % TOTAL_SIZE;
                return result;
            }
        }
    }
}
