package bj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// https://www.acmicpc.net/problem/1927
// 최소 힙
public class N1927 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {

        }
    }
    public class Node {
        public int value;
        public Node left;
        public Node right;

        public Node() {

        }
    }

    public class MinHeap {
        public Node root;

        public MinHeap() {
            this.root = new Node();
        }

        public boolean add(int value) {

            return false;
        }
    }
}