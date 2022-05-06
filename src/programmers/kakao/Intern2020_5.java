package programmers.kakao;

import java.util.*;

// https://programmers.co.kr/learn/courses/30/lessons/67260?language=java
// 동굴 탐험
public class Intern2020_5 {
    public static void main(String[] args) {
        Intern2020_5 s = new Intern2020_5();
        System.out.println(s.solution(
                9,
                new int[][]{
                        {0, 1}, {0, 3}, {0, 7}, {8, 1}, {3, 6}, {1, 2}, {4, 7}, {7, 5}
                },
                new int[][]{
                        {4, 1},
                        {8, 7},
                        {6, 5}
                }
        ));
    }

    public boolean solution(int n, int[][] path, int[][] order) {

        ArrayList<LinkedList<Integer>> graph = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            graph.add(new LinkedList<>());
        }
        for (int[] ints : path) {
            graph.get(ints[0]).add(ints[1]);
            graph.get(ints[1]).add(ints[0]);
        }

        boolean[] visited = new boolean[n];
        Queue<Integer> queue = new LinkedList<>();
        Stack<Integer> stack = new Stack<>();
        queue.offer(0);

        while (!queue.isEmpty()) {
            int cur = queue.poll();

            if (!canGo(cur, order, visited)) {
                if (stack.contains(cur)) return false;
                queue.offer(cur);
                stack.push(cur);
                continue;
            }

            visited[cur] = true;
            stack = new Stack<>();
            for (Integer integer : graph.get(cur)) {
                if (visited[integer]) continue;
                queue.offer(integer);
            }
        }

        return true;
    }

    public boolean canGo(int cur, int[][] order, boolean[] visited) {
        for (int[] ints : order) {
            if (ints[1] == cur && !visited[ints[0]]) return false;
        }

        return true;
    }
}
