package programmers.kakao;

import java.util.Arrays;

// https://programmers.co.kr/learn/courses/30/lessons/92342?language=java
// 양궁대회
// DFS
public class Blind2022_4 {
    static int diff = 0;
    static int[] answer = new int[]{-1};

    public static void main(String[] args) {
        Blind2022_4 s = new Blind2022_4();
        System.out.println(Arrays.toString(s.solution(9, new int[]{0,0,1,2,0,1,1,1,1,1,1})));
    }
    public int[] solution(int n, int[] apeachInfo) {

        dfs(n, apeachInfo, 0, new int[11], 0);

        return answer;
    }

    /**
     * DFS를 통해 Lion이 최대 차이로 이기는 경우의 수 구하기
     * @param n 총 화살의 수
     * @param apeachInfo 어피치가 과녁을 맞춘 정보
     * @param count 라이언이 현재 쏜 화살의 수
     * @param lionInfo 라이언이 과녁을 맞춘 정보
     * @param index 계산하고 있는 점수
     */
    private void dfs(int n, int[] apeachInfo, int count, int[] lionInfo, int index) {
        if (count == n) {   // 모든 화살을 셋을 때
            if (getDiff(apeachInfo, lionInfo) >= diff) {
                diff = getDiff(apeachInfo, lionInfo);          // 최대 차이 갱신
                answer = lionInfo.clone();  //
            }
            return;
        }

        // (10 - index)점을 얻을지 말지 결정해 dfs
        // 라이언이 가장 큰 점수 차이로 우승할 수 있는 방법이 여러가지일 경우, 가장 낮은 점수를 더 많이 맞힌 경우를 return
        // 점수를 얻지 못할 경우 0점으로 화살을 사용하자
        for (int i = index; i < 11; i++) {
            int lionHit;    // 라이언이 (10 - index)점을 얻기위해 맞춰야하는 화살의 수
            if (i == 10) {  // 마지막 0점을 획득하는 경우 남은 화살을 모두 0점에 쏜다
                lionHit = n - count;
            } else {        // 어피치보다 많이 쏴야하기 때문
                lionHit = apeachInfo[i] + 1;
            }
            if (lionHit + count > n) continue;  // 화살이 더 필요할 경우 해당 경우는 불가능
            lionInfo[i] = lionHit;
            dfs(n, apeachInfo, count + lionHit, lionInfo.clone(), i + 1);
            lionInfo[i] = 0;
        }
    }

    // 라이언이 어피치를 이겼는지 점수 확인
    private int getDiff(int[] apeachInfo, int[] lionInfo) {
        int lionScore = 0;
        int apeachScore = 0;

        for (int i = 0; i <= 10; i++) {
            if (apeachInfo[i] < lionInfo[i]) {
                lionScore += 10 - i;
            } else {
                if (apeachInfo[i] != 0) {
                    apeachScore += 10 - i;
                }
            }
        }

        return lionScore - apeachScore;
    }
}
