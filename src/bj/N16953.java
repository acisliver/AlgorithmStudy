package bj;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

// https://www.acmicpc.net/problem/16953
// A -> B
// BFS
public class N16953 {
    private static long answer;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();

        bfs(a, b);

        System.out.println(answer);
    }

    private static void bfs(int a, int b) {
        Queue<long[]> queue = new LinkedList<>();
        queue.offer(new long[] {a, 1});

        while(!queue.isEmpty()) {
            long[] cur = queue.poll();
            if (cur[0] == b) {
                answer = cur[1];
                return;
            }
            if (cur[0] * 2 <= b) {
                queue.offer(new long[]{cur[0] * 2, cur[1] + 1});
            }
            if(cur[0] * 10 + 1 <= b) {
                queue.offer(new long[]{cur[0] * 10 + 1, cur[1] + 1});
            }
        }

        answer = -1;
    }

}
