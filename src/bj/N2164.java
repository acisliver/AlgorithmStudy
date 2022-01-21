package bj;

import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

// https://www.acmicpc.net/problem/2164
// 카드2
public class N2164 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Queue queue = new LinkedList();
        for (int i = 0; i < n; i++) {
             queue.add(i + 1);
        }

        while (queue.size() > 1) {
            queue.poll();
            queue.add(queue.poll());
        }
        System.out.println(queue.peek());
    }
}
