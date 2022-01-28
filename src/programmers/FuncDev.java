package programmers;

import java.util.ArrayList;
import java.util.Arrays;

// https://programmers.co.kr/learn/courses/30/lessons/42586/
// 기능 개발
public class FuncDev {
    public static void main(String[] args) {
        FuncDev funcDev = new FuncDev();
        System.out.println(Arrays.toString(funcDev.solution(new int[]{93, 30, 55}, new int[]{1, 30, 5})));
    }

    public int[] solution(int[] progresses, int[] speeds) {
        ArrayList<Integer> answer = new ArrayList<>();
        int pointer = 0;
        int len = progresses.length;

        while (pointer < len) {
            int count = 0;
            // speed만큼 progress 증가
            for (int i = pointer; i < len; i++) {
                progresses[i] += speeds[i];
            }
            // 작업이 완료되면
            while (pointer < len && progresses[pointer] >= 100) {
                pointer++;
                count++;
            }
            // 완료된 작업이 있다면
            if (count > 0) {
                answer.add(count);
            }
        }

        return answer.stream()
                .mapToInt(Integer::intValue)
                .toArray();
    }
}
