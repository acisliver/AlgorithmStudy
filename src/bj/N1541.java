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
        String input = br.readLine();
        String[] operator = input.split("[0-9]+");
        operator = Arrays.copyOfRange(operator, 1, operator.length);
        int[] operand = Arrays.stream(input.split("[\\D]"))
                .mapToInt(Integer::parseInt)
                .toArray();

        int tmp = operand[0];
        ArrayList<Integer> arrayList = new ArrayList<>();
        for (int i = 0; i < operator.length; i++) {
            if (operator[i].equals("+")) {
                tmp += operand[i + 1];
            } else {
                arrayList.add(tmp);
                tmp = operand[i + 1];
            }
        }
        arrayList.add(tmp);
        System.out.println(arrayList.stream()
                .reduce(arrayList.remove(0), (a, b) -> a - b));
    }
}
