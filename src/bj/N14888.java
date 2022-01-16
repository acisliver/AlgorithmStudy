package bj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// https://www.acmicpc.net/problem/14888
// 연산자 끼워넣기
// 완전탐색에 중첩되는 경우는 백트래킹으로 풀이
public class N14888 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int[] nums = new int[n];

        // 줄바꿈
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
             nums[i] = Integer.parseInt(st.nextToken());
        }

        int[] opNum = new int[4];

        // 줄바꿈
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 4; i++) {
            opNum[i] = Integer.parseInt(st.nextToken());
        }

        String[] operator = numToOperator(n, opNum);
        System.out.println(Arrays.toString(operator));
        
        bruteForce(nums, operator);
    }

    private static int bruteForce(int[] nums, String[] operator) {

        int result = 0;

        int idx = 0;
        for (String op : operator) {
            switch (op) {
                case "+":
                    result += nums[idx] + nums[idx + 1];
                    break;
                case "-":
                    result += nums[idx] - nums[idx + 1];
                    break;
                case "*":
                    result += nums[idx] * nums[idx + 1];
                    break;
                case "/":
                    result += nums[idx] / nums[idx + 1];
                    break;
                default:
                    System.out.println("operator에 다른 케이스 삽입됨");
            }
            idx++;
        }
        
        return result;
    }

    private static String[] numToOperator(int n, int[] opNum) {
        String[] opList = {"+", "-", "*", "/"};
        String[] operator = new String[n - 1];
        int idx = 0;
        int opIdx = 0;
        for (int op : opNum) {
            for (int i = 0; i < op; i++) {
                operator[idx] = opList[opIdx];
                idx++;
            }
            opIdx++;
        }

        return operator;
    }
}
