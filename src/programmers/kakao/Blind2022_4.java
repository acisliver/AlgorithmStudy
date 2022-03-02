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
    public int[] solution(int n, int[] info) {

        dfs(n, info, 0, 0, new int[11], 0);

        return answer;
    }

    private void dfs(int n, int[] info, int count, int score, int[] lionInfo, int index) {
        if (count == n) {
            if (isScore(info, lionInfo) && lionScore < score) {
                lionScore = score;
                answer = lionInfo.clone();
            }
            return;
        }
        for (int i = index; i < 11; i++) {
            int lionHit;
            if (i == 10) {
                lionHit = n - count;
            } else {
                lionHit = info[i] + 1;
            }
            if (lionHit + count > n) continue;
            lionInfo[i] = lionHit;
            dfs(n, info, count + lionHit, score + 10 - i, lionInfo, i + 1);
            lionInfo[i] = 0;
        }
    }

    private boolean isScore(int[] apeachInfo, int[] lionInfo) {
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
