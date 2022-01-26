package bj;

import java.util.*;

// https://www.acmicpc.net/problem/1966
// 프린터 큐
public class N1966 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        int t = sc.nextInt();

        while (t-- > 0) {

            int n = sc.nextInt();
            int m = sc.nextInt();

            LinkedList<int[]> queue = new LinkedList<>();

            // 큐에 저장
            for (int i = 0; i < n; i++) {
                // { 몇번째, 우선순위 }
                queue.offer(new int[]{i, sc.nextInt()});
            }

            int count = 0;

            while (!queue.isEmpty()) {

                int[] front = queue.poll();
                boolean isMax = true;

                for (int i = 0; i < queue.size(); i++) {
                    if (front[1] < queue.get(i)[1]) {
                        queue.offer(front);
                        isMax = false;
                        for (int k = 0; k < i; k++) {
                            queue.offer(queue.poll());
                        }
                        break;
                    }
                }

                 if(isMax) {
                    count++;
                    if (front[0] == m)
                        break;
                }
            }
            sb.append(count).append("\n");
        }
        System.out.println(sb);
    }
}
