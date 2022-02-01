package bj;

import java.util.Scanner;

// https://www.acmicpc.net/problem/11279
// 최대힙
public class N11279 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        StringBuilder sb = new StringBuilder();
        MaxHeap maxHeap = new MaxHeap();
        for (int i = 0; i < n; i++) {
            int a = sc.nextInt();
            if (a == 0) sb.append(maxHeap.removeMax()).append("\n");
            else maxHeap.add(a);
        }
        System.out.println(sb);
    }

    public static class MaxHeap {
        int[] data;
        int size;

        public MaxHeap() {
            data = new int[100001];
            size = 0;
            data[0] = Integer.MAX_VALUE;
        }

        public void add(int value) {
            int pointer = ++size;
            data[pointer] = value;
            while (true) {
                if (data[pointer/2] < data[pointer]) {
                    swap(pointer, pointer/2);
                    pointer /= 2;
                } else {
                    break;
                }
            }
        }

        public int removeMax() {
            if (size == 0) return 0;
            int re = data[1];
            data[1] = data[size--];
            int parent = 1;
            int child;
            while(true) {
                child = parent * 2;
                // 자식 중 최댓값 찾기
                if (child <= size && data[child] < data[child + 1]) {
                    child++;
                }
                if (child > size || data[child] < data[parent]) {
                    break;
                }
                swap(child, parent);
                parent = child;
            }
            return re;
        }

        private void swap(int a, int b) {
            int tmp;
            tmp = data[a];
            data[a] = data[b];
            data[b] = tmp;
        }
    }
}
