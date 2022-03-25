package bj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// https://www.acmicpc.net/problem/5052
// 전화번호 목록
public class N5052 {
    static class TrieNode{
        // 자식 노드 맵
        private Map<Character, TrieNode> childNode = new HashMap<>();
        private boolean isLastChar;

        public Map<Character, TrieNode> getChildNode() {
            return childNode;
        }

        public boolean isLastChar() {
            return isLastChar;
        }

        public void setLastChar(boolean lastChar) {
            isLastChar = lastChar;
        }
    }

    static class Trie {
        // 루트 노드
        private TrieNode rootNode;

        public Trie() {
            this.rootNode = new TrieNode();
        }

        // 삽입
        public TrieNode insert(String number) {
            TrieNode curNode = this.rootNode;

            for (int i = 0; i < number.length(); i++) {
                curNode = curNode.getChildNode().computeIfAbsent(number.charAt(i), c -> new TrieNode());
            }
            curNode.setLastChar(true);

            return curNode;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        ArrayList<TrieNode> lastNums;
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < t; i++) {
            Trie trie = new Trie();
            int n = Integer.parseInt(br.readLine());
            lastNums = new ArrayList<>(n);

            for (int j = 0; j < n; j++) {
                TrieNode lastNode = trie.insert(br.readLine());
                lastNums.add(lastNode);
            }

            boolean isConsisted = true;
            for (TrieNode lastNum : lastNums) {
                if (lastNum.getChildNode().isEmpty()) continue;
                isConsisted = false;
            }

            sb.append(isConsisted ? "YES" : "NO").append("\n");
        }

        System.out.println(sb);
    }
}
