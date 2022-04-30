package programmers.kakao;

// https://programmers.co.kr/learn/courses/30/lessons/92343
// 양과 늑대
public class Blind2022_5 {
    public static void main(String[] args) {
        Blind2022_5 s = new Blind2022_5();
        System.out.println(s.solution(
                new int[]{0, 0, 1, 1, 1, 0, 1, 0, 1, 0, 1, 1},
                new int[][]{
                        {0, 1}, {1, 2}, {1, 4}, {0, 8}, {8, 7}, {9, 10}, {9, 11}, {4, 3}, {6, 5}, {4, 6}, {8, 9}
                }
        ));

    }



    public int solution(int[] info, int[][] edges) {
        answer = 0;
        bt(0, 1, 0, new boolean[info.length], info, edges);    // 0번 노드로 시작
        return answer;
    }

    static int answer;

    /**
     * 백트래킹
     *
     * @param curNode   현재 방문한 노드
     * @param sheep     모은 양의 수
     * @param wolves    따라온 늑대의 수
     * @param nextNodes 다음으로 갈 수 있는 노드
     * @param info      양과 늑대의 위치
     * @param edges     부모노드와 자식노드 정보
     */
    public void bt(int curNode, int sheep, int wolves, boolean[] nextNodes, int[] info, int[][] edges) {

        // 가지치기
        if (sheep <= wolves) return;

        // 정답 갱신
        answer = Math.max(sheep, answer);

        // 갈 수 있는 노드 탐색 및 추가
        for (int[] edge : edges) {
            if (edge[0] == curNode)
                nextNodes[edge[1]] = true;
        }

        // 이웃한 노드 방문
        for (int i = 0; i < info.length; i++) {
            if (!nextNodes[i]) continue;

            sheep += info[i] ^ 1;
            wolves += info[i];

            nextNodes[i] = false; // 방문할 노드 리스트에서 삭제
            bt(i, sheep, wolves, nextNodes.clone(), info, edges);

            sheep -= info[i] ^ 1;
            wolves -= info[i];
            nextNodes[i] = true;
        }

    }
}
