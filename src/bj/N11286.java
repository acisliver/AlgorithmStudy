package bj;

import java.util.*;

// https://www.acmicpc.net/problem/11286
// 절댓값 힙
public class N11286 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        PriorityQueue<Integer> pQ = new PriorityQueue<>((o1, o2) -> {
            int com = Math.abs(o1) - Math.abs((o2));
            if (com == 0)
                return o1 - o2;
            else {
                return com;
            }
        });

        for (int i = 0; i < n; i++) {
            int command = sc.nextInt();
            if (command == 0) {
                if (pQ.isEmpty()) System.out.println(0);
                else
                    System.out.println(pQ.poll());
            } else {
                pQ.add(command);
            }
        }
    }
}
