import java.util.Arrays;
import java.util.Scanner;

/**
 * 트리
 * 입력: {정점의 개수} n, {간선의 개수} m, {간선} s, e
 * 그래프가 주어졌을 때 그래프에 트리가 몇개인지 확인하는 문제
 *
 * 주의
 * 테스트케이스에서 확인한 결과 정점 하나만 있어도 트리
 *
 * 솔루션
 * 1. 연결그래프인지 확인한다
 * 2. 연결그래프의 BFS, DFS 탐색 결과를 트리로 사용할 수 있다.
 * 3. BFS 결과 사이클인 경우 트리에서 제외
 */
public class N4803 {
    static int visit[];
    static boolean hasCycle = false;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n, m, s, e, trees;
        int[][] adj_mat;

        int test_case = 1;
        String answer = "";

        while (true) {
            n = sc.nextInt();
            m = sc.nextInt();

            if(n==0 && m==0) break;

            // 해당 정점을 지났는지 확인(0으로 초기화되어있음)
            visit = new int[n];

            // 인접행렬
            adj_mat = new int[n][n];

            // 트리 개수
            trees = 0;

            // 그래프 입력
            for (int i = 0; i < m; i++) {
                s = sc.nextInt() - 1;
                e = sc.nextInt() - 1;

                // 무방향 그래프의 인접행렬의 경우
                // 시작점과 종점의 구분이 없어 두 개의 간선표시 필요
                adj_mat[s][e] = 1;
                adj_mat[e][s] = 1;
            }

            // 각 정정을 루트로 DFS 실행
            for (int i = 0; i < n; i++) {
                hasCycle = false;
                DFS(adj_mat, i, -1);
                if(!hasCycle) trees += 1;
            }

            switch (trees) {
                case 0:
                    answer += "Case " + test_case + ": No trees.\n";
                    break;
                case 1:
                    answer += "Case " + test_case + ": There is one tree.\n";
                    break;
                default:
                    answer += "Case " + test_case + ": A forest of " + trees + " trees.\n";
                    break;
            }

//            System.out.println(Arrays.deepToString(adj_mat));

            test_case += 1;
        }
        System.out.println(answer);
    }

    private static void DFS(int[][] mat, int start, int before) {

        // 시작 정점 체크
        visit[start] = 1;

        // 인접정점 탐색
        for (int i = 0; i < mat.length; i++) {

            // 간선을 발견하고 아직 방문하지 않았다면
            // 해당 인접정점에서 다시 DFS
            if(mat[start][i] == 1){
                if(visit[i] == 0){
                    DFS(mat, i, start);
                }
                else {
                    if (i != before)
                        hasCycle = true;
                }
            }
        }
    }

}
