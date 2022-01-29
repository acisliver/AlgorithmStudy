package bj;

import java.util.*;

// https://www.acmicpc.net/problem/7662
// 이중 우선순위 큐
public class N7662 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        while (T-- > 0) {
            int command = sc.nextInt();

            // 오름차순
            PriorityQueue<Integer> minQ = new PriorityQueue<>();
            // 내림차순
            PriorityQueue<Integer> maxQ = new PriorityQueue<>(Collections.reverseOrder());
            // 값들이 얼마나 저장되어 있는지 저장
            Map<Integer, Integer> map = new HashMap<>();
            for (int i = 0; i < command; i++) {
                if (sc.next().equals("I")) {
                    int value = sc.nextInt();
                    minQ.offer(value);
                    maxQ.offer(value);
                    map.put(value, map.getOrDefault(value, 0) + 1);
                } else {
                    if (map.isEmpty()) {
                        sc.nextInt();
                        continue;
                    }

                    if (sc.nextInt() == -1) { // 최솟값 삭제
                        poll(minQ, map);
                    } else { // 최댓값 삭제
                        poll(maxQ, map);
                    }
                }
            }
            if (map.isEmpty()) System.out.println("EMPTY");
            else {
                int max = poll(maxQ, map);
                int min;
                if (!map.isEmpty()) {
                    min = poll(minQ, map);
                } else {
                    min = max;
                }
                System.out.printf("%d %d\n", max, min);
            }
        }

    }

    private static int poll(Queue<Integer> q, Map<Integer,Integer> map) {
        int res;
        while(true) {
            res = q.poll();
            int count = map.getOrDefault(res, 0);
            // 없는 값이라면 한번 더 poll
            if (count == 0) continue;

            if (count == 1) map.remove(res);
            else map.put(res, count - 1);
            break;
        }

        return res;
    }
}

