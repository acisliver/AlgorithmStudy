package bj;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * 회전하는 큐
 * 입력: {큐의 길이} n, {뽑고싶은 수의 개수} m, {뽑고싶은 수의 순서} k
 */
public class N1021 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();

        int[] k = new int[m];
        for (int i = 0; i < m; i++) {
             k[i] = sc.nextInt();
        }

        getMin(n, k);
    }

    private static void getMin(int n, int[] k) {
        LinkedList<Integer> queue = new LinkedList<>();
        int min = 0;

        // 큐 초기화(1~n)
        for (int i = 1; i <= n; i++) {
            queue.add(i);
        }

        for (int num : k) {
            while(true){
                if(queue.get(0) == num){
                    queue.remove(0);
                    break;
                }
                else {
                    if(queue.indexOf(num) <= queue.size()/2)
                        queue.add(queue.remove());
                    else
                        queue.addFirst(queue.removeLast());
                    min++;
                }
            }
        }
        System.out.println(min);
    }
}
