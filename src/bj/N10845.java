package bj;

import java.util.Scanner;

// https://www.acmicpc.net/problem/10845
// 큐
public class N10845 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayQueue queue = new ArrayQueue();
        int commands = sc.nextInt();
        String command;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < commands; i++) {
            command = sc.next();
            switch (command) {
                case "push":
                    queue.push(sc.nextInt());
                    break;
                case "pop":
                    sb.append(queue.pop()).append("\n");
                    break;
                case "size":
                    sb.append(queue.size()).append("\n");
                    break;
                case "empty":
                    sb.append(queue.empty()).append("\n");
                    break;
                case "front":
                    sb.append(queue.front()).append("\n");
                    break;
                case  "back":
                    sb.append(queue.back()).append("\n");
            }
        }
        System.out.println(sb);
    }

    public static class ArrayQueue {
        int TOTAL_SIZE = 10000;
        int[] data;
        int front;
        int back;

        ArrayQueue() {
            data = new int[TOTAL_SIZE];
            this.front = -1;
            this.back = -1;
        }

        public int empty() {
            return this.front == this.back ? 1 : 0;
        }

        public boolean full() {
            return this.back == this.TOTAL_SIZE - 1;
        }

        public void push(int data) {
            if (full()) {
                System.out.println("큐 꽉 참");
            }
            this.data[++this.back] = data;
        }

        public int pop() {
            return empty() == 1 ? -1 : this.data[++this.front];
        }

        public int size() {
            return this.back - this.front;
        }

        public int front() {
            return empty() == 1 ? -1 : this.data[front + 1];
        }

        public int back() {
            return empty() == 1 ? -1 : this.data[back];
        }
    }
}
