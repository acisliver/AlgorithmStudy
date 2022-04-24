package programmers.kakao;

import java.util.ArrayList;
import java.util.List;

// https://programmers.co.kr/learn/courses/30/lessons/92343
// 양과 늑대
public class Blind2022_5 {
    public static void main(String[] args) {
        Blind2022_5 s = new Blind2022_5();
        s.solution(
                new int[]{0, 0, 1, 1, 1, 0, 1, 0, 1, 0, 1, 1},
                new int[][]{
                        {0, 1}, {1, 2}, {1, 4}, {0, 8}, {8, 7}, {9, 10}, {9, 11}, {4, 3}, {6, 5}, {4, 6}, {8, 9}
                }
        );
    }

    public int solution(int[] info, int[][] edges) {
        int answer = 0;
        bt(0, 1, 0, info, edges);    // 0번 노드로 시작
        return answer;
    }

    /**
     * 백트래킹
     * @param node 현재 방문한 노드
     * @param sheep 모은 양의 수
     * @param wolves 따라온 늑대의 수
     * @param info 양과 늑대의 위치
     * @param edges 간선
     */
    public void bt(int node, int sheep, int wolves, int[] info, int[][] edges) {

        // 가지치기
        if (sheep <= wolves) return;

        // 탐색 완료


        //
        for (int i = 0; i < info.length; i++) {

        }

    }
}
