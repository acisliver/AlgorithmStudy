package bj;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// https://www.acmicpc.net/problem/3344
public class N3344 {
    public static void main(String[] args) throws IOException {
        // 입력
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        solution(N);
    }

    private static void solution(int n) {
        StringBuilder sb = new StringBuilder();

        // 이 경우 홀수들, 짝수들 순으로 배치하면 된다.
        if (n % 6 != 2 && n % 6 != 3) {

            // 홀수
            for (int i = 1; i <= n / 2; i++) {
                sb.append(2 * i - 1).append("\n");
            }

            // 마지막 수
            if (n % 2 == 1) {
                sb.append(n).append("\n");
            }

            // 짝수
            for (int i = 1; i <= n / 2; i++) {
                sb.append(2 * i).append("\n");
            }
        } else if (n % 6 == 2) {

            // 짝수
            for (int i = 1; i <= n / 2; i++) {
                sb.append(2 * i).append("\n");
            }

            // 1과 3의 자리를 바꾸어서
            sb.append(3).append("\n");
            sb.append(1).append("\n");

            //
            for (int i = n / 2 + 2; i < n - 1; i++) {
                sb.append(2 * (i - n / 2 + 1) + 1).append("\n"); // 2x+1
            }

            // 5를 홀수 가장 마지막에에
            sb.append(5).append("\n");

        } else if (n % 6 == 3) {
            for (int i = 2; i <= n / 2; i++) {
                sb.append(2 * i).append("\n");
            }
            sb.append(2).append("\n");

            for (int i = n / 2; i < n - 2; i++) {
                sb.append((i - n / 2 + 2) * 2 + 1).append("\n");
            }
            sb.append(1).append("\n");
            sb.append(3).append("\n");
        }
        System.out.println(sb);
    }
}
