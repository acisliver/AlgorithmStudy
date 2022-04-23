package programmers.kakao;

import java.util.Arrays;

// https://programmers.co.kr/learn/courses/30/lessons/92342?language=java
// 양궁대회
// DFS
public class Blind2022_4 {
    static int lionScore = 0;
    static int[] answer = new int[]{-1};

    public static void main(String[] args) {
        Blind2022_4 s = new Blind2022_4();
        System.out.println(Arrays.toString(s.solution(1, new int[]{1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0})));
    }
    public int[] solution(int n, int[] apeachInfo) {

        dfs(n, apeachInfo, 0, 0, new int[11], 0);

        return answer;
    }

    /**
     * DFS를 통해 Lion이 최대 차이로 이기는 경우의 수 구하기
     * @param n 총 화살의 수
     * @param apeachInfo 어피치가 과녁을 맞춘 정보
     * @param count 라이언이 현재 쏜 화살의 수
     * @param score 현재 계산된 라이언의 최대 점수
     * @param lionInfo 라이언이 과녁을 맞춘 정보
     * @param index 계산하고 있는 점수
     */
    private void dfs(int n, int[] apeachInfo, int count, int score, int[] lionInfo, int index) {
        if (count == n) {   // 모든 화살을 셋을 때
            if (isLionWin(apeachInfo, lionInfo) && lionScore < score) {
                lionScore = score;          // 최댓값 갱신
                answer = lionInfo.clone();  //
            }
            return;
        }

        // (10 - index)점을 얻을지 말지 결정해 dfs
        for (int i = index; i < 11; i++) {
            int lionHit;    // 라이언이 (10 - index)점을 얻기위해 맞춰야하는 화살의 수
            if (i == 10) {
                lionHit = n - count;
            } else {
                lionHit = apeachInfo[i] + 1;
            }
            if (lionHit + count > n) continue;
            lionInfo[i] = lionHit;
            dfs(n, apeachInfo, count + lionHit, score + 10 - i, lionInfo, i + 1);
            lionInfo[i] = 0;
        }
    }

    // 라이언이 어피치를 이겼는지 점수 확인
    private boolean isLionWin(int[] apeachInfo, int[] lionInfo) {
        int lionScore = 0;
        int apeachScore = 0;

        for (int i = 0; i < 11; i++) {
            if (apeachInfo[i] < lionInfo[i]) {
                lionScore += 10 - i;
            } else {
                if (apeachInfo[i] != 0) {
                    apeachScore += 10 - i;
                }
            }
        }

        return lionScore > apeachScore;
    }
}
