package bj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// https://www.acmicpc.net/problem/1991
// 트리 순회
public class N1991 {

    public static Node[] nodeList;
    public static StringBuilder sb;

    public static class Node {
        int left;
        int right;

        public Node(int left, int right) {
            this.left = left;
            this.right = right;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        nodeList = new Node[n + 1];

        while(n-- > 0) {
            st = new StringTokenizer(br.readLine(), " ");
            int data = st.nextToken().charAt(0) - 'A';
            int left = st.nextToken().charAt(0) - 'A';
            int right = st.nextToken().charAt(0) - 'A';
            nodeList[data] = new Node(left, right);
        }

        sb = new StringBuilder();
        preorder(0);
        sb.append("\n");
        inorder(0);
        sb.append("\n");
        postorder(0);

        System.out.println(sb);
    }

    private static void preorder(int root) {
        if (root != '.' - 'A') {
            sb.append((char) (root + 'A'));
            preorder(nodeList[root].left);
            preorder(nodeList[root].right);
        }
    }

    private static void inorder(int root) {
        if (root != '.' - 'A') {
            inorder(nodeList[root].left);
            sb.append((char) (root + 'A'));
            inorder(nodeList[root].right);
        }
    }

    private static void postorder(int root) {
        if (root != '.' - 'A') {
            postorder(nodeList[root].left);
            postorder(nodeList[root].right);
            sb.append((char) (root + 'A'));
        }
    }
}
