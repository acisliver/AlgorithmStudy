package bj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

// https://www.acmicpc.net/problem/1002
// 두 원의 교점
public class N1002 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            int[] input = Arrays.stream(br.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            solution(input);
        }
    }

    private static void solution(int[] input) {
        int answer = 0;

        int x1 = input[0];
        int y1 = input[1];
        int r1 = input[2];
        int x2 = input[3];
        int y2 = input[4];
        int r2 = input[5];

        int dX = x1 - x2;
        int dY = y1 - y2;
        int distanceSq = dX * dX + dY + dY;

        int rAdd = r1 + r2;
        int rSub = r1 - r2;

        // 두 원이 두 점에서 만나는 경우
      /*  if (rAdd) answer = 2;
        // 두 원이 외접을 갖는 경우
        else if (rAdd * rAdd == distanceSq) answer = 1;
        // 두 원이 내접을 갖는 경우
        else if () answer = 1;
        // 두 원이 교접을 갖지 않는 경우
        else if () answer = 0;
        // 두 원이 일치하는 경우
        else answer = -1;*/

        System.out.println(answer);
    }
}
