package bj;

import java.io.IOException;
import java.util.Scanner;

// https://www.acmicpc.net/problem/1927
// 최소 힙
public class N1927 {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] heap = new int[100001];
        int size = 0;
        for (int i = 0; i < n; i++) {
            int v = sc.nextInt();
            if (v == 0) {
                if (size == 0) {
                    System.out.println(0);
                } else {
                    System.out.println(removeMin(heap, size));
                    size--;
                }
            } else {
                size++;
                add(heap, size, v);
            }
        }

    }

    public static void add(int[] heap, int size, int value) {
        int tmp;
        int s = size;
        heap[size] = value;
        while(true) {
            if (heap[s/2] > value) {
                tmp = heap[s/2];
                heap[s/2] = value;
                heap[s] = tmp;
                s /= 2;
            } else {
                break;
            }
        }
    }

    public static int removeMin(int[] heap, int size) {
        int re = heap[1];
        heap[1] = heap[size];
        heap[size] = 0;
        int parent = 1;
        int child;
        int tmp;
        while(true) {
            child = parent * 2;
            // 자식 중 최솟값 찾기
            if (child + 1 <= size - 1 && heap[child] > heap[child + 1]) {
                child++;
            }
            // child 값이 힙을 넘어가거나 자식의 값이 부모의 값보다 클 때
            if (child > size - 1 || heap[child] > heap[parent]) {
                break;
            }
            // 자식과 부모의 값을 바꾸어줌
            tmp = heap[parent];
            heap[parent] = heap[child];
            heap[child] = tmp;
            parent = child;
        }

        return re;
    }
}