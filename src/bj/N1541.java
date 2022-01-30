package bj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

// https://www.acmicpc.net/problem/1541
// 잃어버린 괄호
public class N1541 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split("-");
        int result;
        int tmp;
        for (int i = 0; i < input.length; i++) {
            tmp = 0;
            int[] operand = Arrays.stream(input[i].split("\\+"))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            for (int o : operand) {
                tmp += o;
            }
            input[i] = String.valueOf(tmp);
        }
        int[] nums = Arrays.stream(input)
                .mapToInt(Integer::parseInt)
                .toArray();
        result = nums[0];
        for (int i = 1; i < nums.length; i++) {
            result -= nums[i];
        }
        System.out.println(result);
    }
}
