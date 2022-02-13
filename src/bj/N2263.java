package bj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// https://www.acmicpc.net/problem/2263
// 트리의 순회
public class N2263 {
    private static StringBuilder ANSWER = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        ArrayList<Integer> inOrder = new ArrayList<>();
        ArrayList<Integer> postOrder = new ArrayList<>();

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            inOrder.add(Integer.parseInt(st.nextToken()));
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            postOrder.add(Integer.parseInt(st.nextToken()));
        }

        solution(inOrder, postOrder);

        System.out.println(ANSWER);
    }

    private static void solution(List<Integer> inOrder, List<Integer> postOrder) {
        if (inOrder.size() == 0 || postOrder.size() == 0) {
            return;
        }

        // 루트 노드의 위치를 구한다.
        int root = postOrder.get(postOrder.size() - 1);
        ANSWER.append(root).append(" ");
        int rootIndexOfInOrder = inOrder.indexOf(root);

        // 서브트리로 나눈다.
        List<Integer> leftInSub = inOrder.subList(0, rootIndexOfInOrder);
        List<Integer> rightInSub = inOrder.subList(rootIndexOfInOrder + 1, inOrder.size());
        int border = leftInSub.size();
        List<Integer> leftPostSub = postOrder.subList(0, border);
        List<Integer> rightPostSub = postOrder.subList(border, postOrder.size() - 1);

        // 왼쪽부터 탐색
        solution(leftInSub, leftPostSub);
        solution(rightInSub, rightPostSub);
    }
}
